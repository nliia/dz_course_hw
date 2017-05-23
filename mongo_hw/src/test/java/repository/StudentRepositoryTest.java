package repository;

import config.PersistenceTestConfig;
import model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static repository.fixture.TestConstants.UserConstants.USER_NAME;
import static repository.fixture.TestData.standardUser;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class})
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindAll() throws SQLException {
        Student newUser = standardUser();
        studentRepository.save(newUser);
        Iterable<Student> userList = studentRepository.findAll();
        assertNotNull(userList);
        assertTrue(userList.iterator().hasNext());
        for(Student user: userList) {
            assertNotNull(user);
            assertNotNull(user.getId());
        }
        studentRepository.deleteAll();
    }

    @Test
    public void testCRUD(){
        Student user = standardUser();
        studentRepository.save(user);
        user = studentRepository.findOne(user.getId());
        assertEquals(user.getName(), USER_NAME);
        assertEquals(user.getId(), standardUser().getId());
        user.setName("Саша");
        studentRepository.save(user);
        assertEquals(studentRepository.findOne(user.getId()).getName(), "Саша");
        studentRepository.delete(user);
        assertNull(studentRepository.findOne(user.getId()));
    }

}
