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

    /**
     * retourner les numéros et libellés des articles dont le stock est inférieur à 10
     *
     */
    public List findNameQuantityInf10() {
        String sql = "SELECT LIBELLE from PRODUITS where STOCK < 10";//Ecrire votre requete ici
        List result = jdbcTemplate.queryForList(sql);
        return result;

    }

    /**
     * retourner les noms et adresses des fournisseurs qui proposent des articles
     * pour lesquels le délai d'approvisionnement est supérieur à 20 jours
     */
    public List findFourDelaiSup20(){
        String sql = "";//Ecrire votre requete ici

        List result = jdbcTemplate.queryForList(sql);
        return result;
    }
}
