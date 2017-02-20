package fr.ccavalier.hibernate.course;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by charlotte on 20/02/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-context.xml")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class RequestsTest {
    private EmbeddedDatabase db;


    Requests requests;

    @Before
    public void setUp() {
        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.DERBY)
                .addScript("products-db.sql")
                .addScript("products-data.sql")
                .build();

        JdbcTemplate template = new JdbcTemplate(db);
        requests = new Requests();
        requests.setJdbcTemplate(template);
    }

    @Test
    public void test_findNameQuantityInf10(){
        List<Map<String, Object>> values  = requests.findNameQuantityInf10();
        List<String> libelles = new ArrayList<String>();
        for(Map<String, Object> value : values){
            Assert.assertTrue(value.containsKey("LIBELLE"));
            Assert.assertEquals(1, value.size());
            libelles.add((String)value.get("LIBELLE"));
        }
        Assert.assertEquals(2, libelles.size());
        Assert.assertTrue(libelles.contains("Bananes"));
        Assert.assertTrue(libelles.contains("Fraises"));
    }


    @Test
    public void test_findFourDelaiSup20(){
        List<Map<String, Object>> values  = requests.findFourDelaiSup20();
        List<String> libelles = new ArrayList<String>();
        for(Map<String, Object> value : values){
            Assert.assertTrue(value.containsKey("NOM"));
            Assert.assertEquals(1, value.size());
            libelles.add((String)value.get("NOM"));
        }
        Assert.assertEquals(1, libelles.size());
        Assert.assertTrue(libelles.contains("Sodebo"));
    }

    @After
    public void tearDown() {
        db.shutdown();
    }

}
