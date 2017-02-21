package fr.ccavalier.hibernate.course;
//[imports] { autofold
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//}
/**
 * Created by ccavalie on 31/01/2017.
 */
@Repository
public class UserDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public User findByFirstName(String name) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);

        String sql = "SELECT * from USERS where first_name='"+name+"'";//Ecrire votre requete ici

        User result = namedParameterJdbcTemplate.queryForObject(
                sql,
                params,
                new UserMapper());

        //new BeanPropertyRowMapper(Customer.class));
        
        String getMedias = "Select * from media_users as asso, media as m" +
                "  where asso.id_user =:id_user and asso.id_media = m.id";
        
        params.clear();
        params.put("id_user", result.getId());

        List<Map<String, Object>> asso_media = namedParameterJdbcTemplate.queryForList(getMedias, params);

        result.setContacts(UserMapper.mapContacts(asso_media));
        return result;

    }



    public void add(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        String sql = "INSERT into users(first_name, last_name, address) values ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getCity()+"')";
        int value = namedParameterJdbcTemplate.update(sql, params);
        
    }
    

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setCity(rs.getString("address"));
            return user;
        }

        public static List<User.Media> mapContacts(List<Map<String, Object>> asso_media) {
            List<User.Media> mediaList = new ArrayList<User.Media>();
            for(Map<String, Object> tuple : asso_media){
                User.Media media = new User.Media();
                media.setType((String)tuple.get("type"));
                media.setValue((String)tuple.get("contact"));
                mediaList.add(media);
            }
            return mediaList;
        }
    }

}
