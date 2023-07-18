package DAO;

import DB.models.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface UserDao  {

    @SqlQuery("SELECT id, username, password, name, email, role FROM users")
    @RegisterBeanMapper(User.class)
    List<User> getListOfUsers();

    @SqlQuery("SELECT id, username, password, name, email, role FROM users WHERE id=:id")
    @RegisterBeanMapper(User.class)
    User getUserInfo(int id);

    @SqlUpdate("INSERT INTO users (username, password, name, email, role) VALUES (:userName, :userPassword, :name, :userEmail, :userRole)")
    void insert(@BindBean User user);

    @SqlUpdate("UPDATE 'users' SET 'username' = :username, 'password' = :password, 'name'= :name, 'email' = :email, 'role' = :role WHERE id = :id")
    void update(@BindBean User user);

    @SqlUpdate("DELETE FROM 'users' WHERE id = :id")
    void delete(@Bind("id") int id);

}
