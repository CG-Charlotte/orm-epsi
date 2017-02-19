package fr.ccavalier.hibernate.course;

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
 * Created by charlotte on 19/02/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-context.xml")
public class UsersDaoTest {

    private EmbeddedDatabase db;

    UsersDao usersDao;

    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.DERBY)
                .addScript("create-db.sql")
                .addScript("insert-data.sql")
                .build();

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
        usersDao = new UsersDao();
        usersDao.setNamedParameterJdbcTemplate(template);
    }

    @Test
    public void testFindAll(){
        List<User> users = usersDao.findAll();
        Assert.assertNotNull(users);
        Assert.assertEquals(3, users.size());
    }
}
