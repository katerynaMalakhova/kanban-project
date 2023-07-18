package utils;

import DAO.UserDao;
import models.User;
import org.apache.commons.compress.compressors.zstandard.ZstdUtils;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import java.util.List;

public class UserReader extends DBReader{

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

//    public static void main(String[] args) {
//        List<User> users = getListOfUsers();
//        System.out.println(users.stream().toArray());
//    }
}
