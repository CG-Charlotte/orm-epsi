package fr.ccavalier.hibernate.course.requests;

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
    public Requests(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * retourner les numéros et libellés des articles dont le stock est inférieur à 10
     *
     */
    public List findNameQuantityInf10() {
        String sql = "SELECT LIBELLE, ID FROM PRODUITS WHERE STOCK < 10";//Ecrire votre requete ici
        List result = jdbcTemplate.queryForList(sql);
        return result;

    }

    /**
     * retourner les noms et adresses des fournisseurs qui proposent des articles
     * pour lesquels le délai d'approvisionnement est supérieur à 20 jours
     */
    public List findFourDelaiSup20(){
        String sql = "SELECT f.nom, f.ville from fournisseurs f where f.id IN (SELECT a.id_four from acheter a WHERE a.delai > 20)";//Ecrire votre requete ici
        List result = jdbcTemplate.queryForList(sql);
        return result;
    }

    /**
     * Supprimer les fraises de la table des produits
     */
    public void deleteFraises(){
        String sql = "DELETE FROM acheter WHERE ID_PROD=(SELECT id from produits where libelle = 'Fraises')";//Ecrire votre requete ici
        jdbcTemplate.execute(sql);
        String sql2 = "DELETE from produits where libelle = 'Fraises'";//Ecrire votre requete ici
        jdbcTemplate.execute(sql2);
    }

    public List queryForList(String sql){
        return jdbcTemplate.queryForList(sql);
    }

}
