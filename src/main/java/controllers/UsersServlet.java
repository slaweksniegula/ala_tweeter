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

import static utils.ServletUtils.FOLLOWED_USERS;
import static utils.ServletUtils.NOT_FOLLOWED_USERS;

@WebServlet( name = "UsersServlet", urlPatterns = {"/users"})
public class UsersServlet extends HttpServlet {

    private UserManagementService service;

    @Override
    public void init() throws ServletException {
        service= new UserManagementServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentUser = ServletUtils.getCurrentUserLoginFromSession(req);
        if (currentUser==null){
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }


        req.setAttribute(FOLLOWED_USERS, service.getFollowedUsers(currentUser));
        req.setAttribute(NOT_FOLLOWED_USERS, service.getNotFollowedUsers(currentUser));
        req.getRequestDispatcher("/users.jsp").forward(req, resp);
    }

}
