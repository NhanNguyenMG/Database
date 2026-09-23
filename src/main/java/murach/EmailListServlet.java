package murach;

import murach.business.User;
import murach.data.UserDB;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        User user = new User(email, firstName, lastName);
        String message = "";
        try{
            if(UserDB.emailExists(email)){
                message = "Email already exists!";
            } else {
                UserDB.insert(user);
                message = "Email added!";
            }
            } catch (SQLException e){
            message = "Error: " + e.getMessage();
        }

        req.setAttribute("user", user);
        req.setAttribute("message", message);
        req.getRequestDispatcher("emailList.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("emailList.jsp").forward(req, resp);
    }

}
