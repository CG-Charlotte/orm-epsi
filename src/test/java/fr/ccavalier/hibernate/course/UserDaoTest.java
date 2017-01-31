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
                .setType(EmbeddedDatabaseType.H2)
                .addScript("create-db.sql")
                .addScript("insert-data.sql")
                .build();
    }

    @Test
    public void testFindByname() {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        UserDao userDao = new UserDao();
        userDao.setNamedParameterJdbcTemplate(template);

        User user = userDao.findByName("mkyong");

        Assert.assertNotNull(user);
        Assert.assertEquals(1, user.getId().intValue());
        Assert.assertEquals("mkyong", user.getName());
        Assert.assertEquals("mkyong@gmail.com", user.getEmail());

    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}
