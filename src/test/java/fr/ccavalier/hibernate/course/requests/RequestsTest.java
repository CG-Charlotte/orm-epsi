package fr.ccavalier.hibernate.course.requests;

import fr.ccavalier.hibernate.course.requests.Requests;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by charlotte on 20/02/17.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={DatabaseConfiguration.class})
public class RequestsTest {

    @Autowired
    Requests requests;

    @Test
    public void test_findNameQuantityInf10(){
        List<Map<String, Object>> values  = requests.findNameQuantityInf10();
        Assert.assertEquals(2, values.size());
        values.forEach(v -> {
            Assert.assertEquals(2, v.keySet().size());
            Assert.assertTrue(v.containsKey("LIBELLE"));
        });

        Assert.assertEquals(
                Stream.of("Fraises", "Bananes").collect(Collectors.toSet()),
                values.stream().map(v -> v.get("LIBELLE")).collect(Collectors.toSet()));
    }

    @Test
    public void test_findFourDelaiSup20(){
        List<Map<String, Object>> values  = requests.findFourDelaiSup20();
        Assert.assertEquals(1, values.size());

        values.forEach(v -> {
            Assert.assertEquals(2, v.keySet().size());
            Assert.assertEquals(Stream.of("NOM", "VILLE").collect(Collectors.toSet()), v.keySet());
        });

        Assert.assertEquals(
                values.stream().collect(Collectors.toSet()),
                Stream.of(
                        new HashMap<String, Object>() {{put("NOM", "Sodebo"); put("VILLE", "Paris");}}
                    ).collect(Collectors.toSet()));
    }

    @Test
    @Transactional
    public void test_delete(){
        requests.deleteFraises();
        List<Map<String, Object>> values = requests.queryForList("Select * from PRODUITS where LIBELLE ='Fraises'");
        Assert.assertTrue(values.isEmpty());
    }

}
