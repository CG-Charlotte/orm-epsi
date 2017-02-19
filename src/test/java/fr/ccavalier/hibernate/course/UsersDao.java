package fr.ccavalier.hibernate.course;
//[imports] { autofold
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//

/**
 * Created by charlotte on 19/02/17.
 */
public class UsersDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * get all users from database
     * @return List<User> All Users
     */
    public List<User> findAll() {

        Map<String, Object> params = new HashMap<String, Object>();

        String sql = "Select * from users";

        List<User> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());

        return result;

    }
}
