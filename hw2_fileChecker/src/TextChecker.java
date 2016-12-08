import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Liia on 04.10.2016.
 */
public class TextChecker {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("src\\dz_hw2.txt"); // адрес к файлу с текстом для проверки
        Scanner sc = new Scanner(reader);
        String text = sc.nextLine();
        Scanner scConsole = new Scanner(System.in);
        System.out.println("Write the word you want count and replace");
        String string = scConsole.nextLine();
        System.out.println("Write the word you want to have instead of the first one you wrote");
        String replace = scConsole.nextLine();

        int count = numberOfWords(string, text); //подсчет слов

        System.out.println("Number of this word:" + count);

        replaceWords(string, replace, text); // замена слова в файле


        if(textChecker(text)) {                 //проверка на наличие нескольких пробелов и заглавную букву после точки
            System.out.println("Matches");
        }else{
            System.out.print("Doesn't match");
        }
    }

    public static int numberOfWords(String string, String text){
        int count = 0;
        Pattern p = Pattern.compile("\\b" + string + "\\b", Pattern.UNICODE_CASE|Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        while(m.find()) count++;
        return count;
    }

    public static void replaceWords(String string, String replace, String text){
        text = text.replaceAll(string, replace);

        try(FileWriter writer = new FileWriter("src\\dz_hw2.txt", false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

    public static boolean textChecker(String text){

        Pattern p2 = Pattern.compile("([A-Z].*[.]\\s?)*");
        Matcher m2 = p2.matcher(text);
        boolean flag = m2.matches();
        if(flag){
            Pattern p = Pattern.compile("\\s{2,}");
            Matcher m = p.matcher(text);
            if(m.find()){
                flag = false;
            }
        }
        return flag;
    }
}
