package lk.ijse.absd.servlets.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/authenticate")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(PrintWriter out = resp.getWriter()){

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(username);
            System.out.println(password);

            if (username == null || password == null){
                resp.sendError(401);
                return;
            }

            if (username.equals("admin") && password.equals("admin")){
                resp.setStatus(200);
                req.getSession();
            }else{
                resp.sendError(401);
            }

        }

    }
}
