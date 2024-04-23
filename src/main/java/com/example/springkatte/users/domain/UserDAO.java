package com.example.springkatte.users.domain;
import com.example.springkatte.users.Interface.InterfaceUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDAO implements InterfaceUserDAO {



    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static int id = -1;

    private static final String MEMBER_ROLE = "user";

    /**
     * Adds a new user to the database
     *
     * @param user
     * @return the new user
     */
    @Override
    public User addUser(User user){
        String sql = "INSERT INTO user (name,email,password,role) VALUES (?,?,?,?)";
        String role = MEMBER_ROLE.equals(user.getRole()) ? MEMBER_ROLE : "Admin";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), role);
        return user;
    }


    /**
     * Removes a user from the database
     *
     * @param id
     * @return
     */
    @Override
    public User removeUser(int id) {
        User userRemoved = getUserById(id);

        if (userRemoved != null) {
            String sql = "DELETE FROM user WHERE id = ?";
            int rowsAffected = jdbcTemplate.update(sql, id);

            if (rowsAffected > 0) {
                return userRemoved;
            } else {
                throw new RuntimeException("Failed to remove user with id: " + id);
            }
        } else {
            throw new RuntimeException("User with the id: " + id + " does not exist!");
        }
    }



    /**
     * Gives a list of all users
     *
     * @return a list of all users from the database
     */
    @Override
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


    /**
     * Gives a specific user by using its id
     *
     * @param id
     * @return the user with the given id
     */
    @Override
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

    @Override
    public User getUserIdByUsername(String name) {
        String sql = "SELECT * FROM user WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("role")
        ), name);
    }


    /**
     * Updates a user in the database
     *
     * @param id
     * @param user
     * @return the updated user
     */
    @Override
    public User editUserDetails(int id, User user) {
        String sql = "UPDATE user SET name=COALESCE(?, name), email=COALESCE(?, email), password=COALESCE(?, password), role=COALESCE(?, role) WHERE id=?";
        String role = MEMBER_ROLE.equals(user.getRole()) ? MEMBER_ROLE : "2".equals(user.getRole()) ? "Admin" : MEMBER_ROLE;
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), role, id);
        return user;
    }

    /**
     * Checks if everything matches before logging in
     *
     * @param user
     * @return true of false
     */
    @Override
    public boolean logincheck(User user){
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        User u = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("role")
        ), user.getEmail(), user.getPassword());
        if(u != null){
            id = u.getId();
        }

        return u != null;
    }
}
