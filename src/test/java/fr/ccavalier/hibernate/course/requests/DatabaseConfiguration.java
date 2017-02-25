package fr.ccavalier.hibernate.course.requests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by fteychene on 25/02/17.
 */
@Configuration
@ComponentScan("fr.ccavalier.hibernate.course.requests")
public class DatabaseConfiguration {
    @Bean
    public DataSource datasource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.DERBY)
                .addScripts("requests/products-db.sql", "requests/products-data.sql")
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
