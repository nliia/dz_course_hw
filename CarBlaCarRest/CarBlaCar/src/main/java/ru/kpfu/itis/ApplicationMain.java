package ru.kpfu.itis;

import com.mongodb.*;
import ru.kpfu.itis.dao.UsersDao;
import ru.kpfu.itis.dao.impl.mongo.UsersDaoMongoImpl;
import ru.kpfu.itis.model.User;

import java.util.Set;

public class ApplicationMain {

    public static void main(String[] args) {
        //Создание подключения
        Mongo m = new MongoClient( "localhost" , 27017 );
        DB db = m.getDB( "mydb" );

        //Получение списка коллекций
        Set<String> colls = db.getCollectionNames();
        for (String s : colls) {
            System.out.println(s);
        }

        //Получение коллекции
        DBCollection coll = db.getCollection("testCollection");

        //Добавление данных
        BasicDBObject doc = new BasicDBObject();
        doc.put("name", "MongoDB");
        doc.put("type", "database");
        doc.put("count", 1);
        BasicDBObject info = new BasicDBObject();
        info.put("x", 202);
        info.put("y", 422);
        doc.put("info", info);
        coll.insert(doc);

        //Поиск первого элемента коллекции
        DBObject myDoc = coll.findOne();
        System.out.println(myDoc);

        //Добавление нескольких объектов
        for (int i=0; i<100; i++){
            coll.insert(new BasicDBObject().append("i",i));
        }

        //Подсчет объектов в коллекции
        System.out.println(coll.getCount());

        //Использование курсора для доступа ко всем элементам
        DBCursor cursor = coll.find();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        //Получение одного объекта используя объект-запрос
        BasicDBObject query = new BasicDBObject();
        query.put("i", 79);
        cursor = coll.find(query);
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        //примеры с использованием оператора $
        query = new BasicDBObject();
        query.put("j", new BasicDBObject("$ne",3));
        query.put("k", new BasicDBObject("$gt", 10));
        cursor = coll.find(query);
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }

        //Получение множества объектов используя запросы
        query = new BasicDBObject();
        query.put("i", new BasicDBObject("$gt",50).append("$ne", 3));
        cursor = coll.find(query);
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

        //Удаление объекта
        coll.remove(new BasicDBObject("i",new BasicDBObject("$exists",true)));

        System.out.println("просмотр коллекции");
        DBCursor objects = coll.find();
        while (objects.hasNext()){
            System.out.println(objects.next());
        }
        coll.drop();
    }

    public static void testMongoDao(){
        UsersDao userDao = new UsersDaoMongoImpl();
        userDao.save(mockUser());

        User user = userDao.findByNickname("Groot");
        System.out.println("I'm " + user.getNickname());
    }

    private static User mockUser(){
        User user = new User();
        user.setNickname("Groot");
        user.setEmail("groot@gmail.com");

        return user;
    }
}
