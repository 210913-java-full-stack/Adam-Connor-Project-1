package servlets.Admin;

import Models.Admin;
import Repos.AdminRepo;
import utils.ConnectionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    Connection conn = ConnectionManager.getConnection();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet is Reached");

        String username = req.getParameter("Username");
        String password = req.getParameter("Password");

        PrintWriter out = resp.getWriter();
        out.println("Welcome " + username);


//        Admin admin = new Admin();
//        admin.setUsername(username);
//        admin.setPassword(password);
//
//        AdminRepo adminrepo = new AdminRepo(conn);
//
//        PrintWriter out = resp.getWriter();
//
//        try {
//            if (adminrepo.authenticate(admin) == null) {
//                out.println("This account does not exist");
//            } else {
//                admin = adminrepo.authenticate(admin);
//                out.println("Welcome " + admin.getFirst_name() + " " + admin.getLast_name());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    }
}