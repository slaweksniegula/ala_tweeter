package controllers;

import services.UserManagementService;
import services.impl.UserManagementServiceImp;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.ServletUtils.USER_LOGIN_TO_UNFOLLOW;

@WebServlet(name = "UnFollowServlet", urlPatterns = {"/unfollow"})
public class UnfollowServlet extends HttpServlet {

    private UserManagementService service;

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletUtils.redirectUserToLoginPageIfNotLoggedIn(req, resp);

        service.stopFollowing(ServletUtils.getCurrentUserLoginFromSession(req), req.getParameter(USER_LOGIN_TO_UNFOLLOW));
        req.getRequestDispatcher("users").forward(req, resp);
    }
}
