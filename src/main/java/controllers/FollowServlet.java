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

import static utils.ServletUtils.USER_LOGIN_TO_FOLLOW;

@WebServlet(name = "FollowServlet", urlPatterns = {"/follow"})
public class FollowServlet extends HttpServlet {

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

        String userToFollow = req.getParameter(USER_LOGIN_TO_FOLLOW);
        service.follow(ServletUtils.getCurrentUserLoginFromSession(req), userToFollow);
        req.getRequestDispatcher("users").forward(req, resp);
    }
}