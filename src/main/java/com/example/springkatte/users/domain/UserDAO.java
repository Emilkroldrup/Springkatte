package com.example.springkatte.users.domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class UserDAO {
@Autowired
private JdbcTemplate jdbcTemplate;
public static int id = -1;

private static final String MEMBER_ROLE = "user";

public User addUser(User user){
    String sql = "INSERT INTO user (name,email,password,role) VALUES (?,?,?,?)";
    String role = MEMBER_ROLE.equals(user.getRole()) ? MEMBER_ROLE : "Admin";
    jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), role);
    return user;
}

public User removeUser(int id){
    String sql = "DELETE FROM user WHERE id = ?";
    jdbcTemplate.update(sql, id);
    return new User();
}

public List<User> getAllUsers() {
    String sql = "SELECT * FROM user";
    return jdbcTemplate.query(sql, (rs, rowNum) -> new User(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("role")
    ));
}

public User getUserById(int id) {
    String sql = "SELECT * FROM user WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new User(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("role")
    ), id);
}

    public User editUserDetails(int id, User user) {
        String sql = "UPDATE user SET name=COALESCE(?, name), email=COALESCE(?, email), password=COALESCE(?, password), role=COALESCE(?, role) WHERE id=?";
        String role = MEMBER_ROLE.equals(user.getRole()) ? MEMBER_ROLE : "2".equals(user.getRole()) ? "Admin" : MEMBER_ROLE;
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), role, id);
        return user;
    }

    public boolean logincheck(User user){
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        User u = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("role")
        ), user.getEmail(), user.getPassword());
        return u != null;
    }
}
