import dao.UserDao;
import dao.imp.AppUserDao;
import model.AppUser;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        UserDao userDao = new AppUserDao();
        AppUser user1 = new AppUser();
        user1.setName("a");
        user1.setLogin("a");
        user1.setLastName("a");
        user1.setPassword("1234");
        user1.setEmail("a@a");
        user1.setDateOfRegistration(new Date());
        AppUser user2 = new AppUser();
        user2.setName("b");
        user2.setLogin("b");
        user2.setLastName("b");
        user2.setPassword("4567");
        user2.setEmail("b@b");
        user2.setDateOfRegistration(new Date());
        userDao.saveUser(user1);
        userDao.saveUser(user2);
        userDao.follow("a", "b");
        //       userDao.stopFollowing("a", "b");
        AppUser a = userDao.getUserByLogin("a");
        AppUser b = userDao.getUserByLogin("b");


        System.out.println(a.getFollowedByUser().toString());
        System.out.println();
        System.out.println(userDao.getFollowers(b.getLogin()).toString());


    }
}
