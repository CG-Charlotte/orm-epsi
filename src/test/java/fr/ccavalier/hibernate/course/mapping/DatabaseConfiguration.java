package fr.ccavalier.hibernate.course.mapping;

/**
 * Created by fteychene on 25/02/17.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by fteychene on 25/02/17.
 */
@Configuration
@ComponentScan("fr.ccavalier.hibernate.course.mapping")
public class DatabaseConfiguration {

    @Bean
    public DataSource datasource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.DERBY)
                .addScripts("mapping/create-db.sql", "mapping/insert-data.sql")
                .build();
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}

