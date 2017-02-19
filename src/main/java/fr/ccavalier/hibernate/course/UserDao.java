package fr.ccavalier.hibernate.course;
//[imports] { autofold
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    }

}
