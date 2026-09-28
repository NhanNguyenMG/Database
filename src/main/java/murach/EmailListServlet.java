package murach;

import murach.business.User;
import murach.data.UserDB;
import murach.util.MailUtilGmail;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        User user = new User(email, firstName, lastName);
        String message = "";

        if (UserDB.emailExists(email)) {
            message = "Email already exists!";
        } else {
            UserDB.insert(user);
            message = "Email added!";

            // Send email
            String to = email;
            String from = "email_list@murach.com";
            String subject = "Welcome to our email list";
            String body = "Dear " + firstName + ",\n\n"
                    + "Thanks for joining our email list.";
            boolean bodyIsHtml = false;
            try {
                MailUtilGmail.sendMail(to, from, subject, body, bodyIsHtml);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
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
