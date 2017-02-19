package fr.ccavalier.hibernate.course;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ccavalie on 31/01/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-context.xml")
public class UserDaoTest {

    private EmbeddedDatabase db;

    UserDao userDao;

    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.DERBY)
                .addScript("create-db.sql")
                .addScript("insert-data.sql")
                .build();

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        userDao = new UserDao();
        userDao.setNamedParameterJdbcTemplate(template);
    }

    @Test
    public void testFindByname() {

        User user = userDao.findByFirstName("Jean");

        Assert.assertNotNull(user);
        Assert.assertEquals(1, user.getId().intValue());
        Assert.assertEquals("Jean", user.getFirstName());
        Assert.assertEquals("Perpignan", user.getCity());

    }



    @Test
    public void testAddUser(){

        User user = new User();
        user.setFirstName("Lara");
        user.setLastName("Croft");
        user.setCity("Southampton");
        userDao.add(user);

        User userFromDb = userDao.findByFirstName("Lara");
        Assert.assertEquals(user.lastName, userFromDb.lastName);
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}
