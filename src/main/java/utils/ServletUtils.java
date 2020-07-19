package utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUtils {

    public static final String LOGIN = "login";
    public static final String NAME = "name";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String ERRORS = "errors";
    public static final String REMEMBER = "remember";
    public static final String COOKIE_CHECKED = "on";
    public static final String ERROR_LOGIN_HEADER = "Login error";
    public static final String ERROR_EMAIL_HEADER = "Email error";
    public static final String ERROR_LOGIN_REG_MESSAGE = "Typed login is already used";
    public static final String ERROR_EMAIL_REG_MESSAGE = "Typed email is already used";
    public static final String ERROR_LOGIN_MESSAGE = "Login or password is invalid";
    public static final String NOT_FOLLOWED_USERS = "notFollowedUsers";
    public static final String FOLLOWED_USERS = "followedUsers";
    public static final String USER_LOGIN_TO_UNFOLLOW = "userLoginToUnfollow";
    public static final String USER_LOGIN_TO_FOLLOW = "userLoginToFollow";

    public static void redirectUserToLoginPageIfNotLoggedIn(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletUtils.isUserLoggedIn(req) != true) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
    }

    public static boolean isUserLoggedIn(HttpServletRequest req) {
        return getCurrentUserLoginFromSession(req) != null;
    }

    public static String getCurrentUserLoginFromSession(HttpServletRequest req) {
        return (String) req.getSession().getAttribute(LOGIN);
    }

}
