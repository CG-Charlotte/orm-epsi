package fr.ccavalier.hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by charlotte on 20/02/17.
 */
@Repository
public class Requests {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = namedParameterJdbcTemplate;
    }

    public List findNameQuantityInf10() {
        String sql = "SELECT LIBELLE from PRODUITS where STOCK < 10";//Ecrire votre requete ici
        List result = jdbcTemplate.queryForList(sql);
        return result;

    }

    public List findFourDelaiSup20(){
        String sql = "SELECT DISTINCT NOM " +
                "FROM FOURNISSEURS F JOIN ACHETER A ON F.id=A.ID_FOUR " +
                "WHERE DELAI>20";

        List result = jdbcTemplate.queryForList(sql);
        return result;
    }
}
