package DB.readers;

import DB.DAO.UserDao;
import DB.models.User;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import java.util.List;

public class UserReader extends DBReader {

    public static List<User> getListOfUsers(){
        return init()
                .withExtension(UserDao.class, UserDao::getListOfUsers);
    };

    public static User getUserInfo(User user){
        return init().onDemand(UserDao.class).getUserInfo(user.getId());
    };

    public static void insert(@BindBean User user){
        init().onDemand(UserDao.class).insert(user);
    }

    public static void update(@BindBean User user){
        init().onDemand(UserDao.class).update(user);
    };

    public static void delete(@Bind("id") int id){
        init().onDemand(UserDao.class).delete(id);
    };

}
