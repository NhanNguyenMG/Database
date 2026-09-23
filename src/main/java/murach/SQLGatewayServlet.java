package murach;

import murach.data.SQLGatewayDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SQLGatewayServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sqlGateway.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sqlStatement = req.getParameter("sqlStatement");
        String sqlResult;

        try {
            sqlResult = SQLGatewayDB.execute(sqlStatement);
        } catch(SQLException e){
            sqlResult = "<p>Error executing the SQL statement: <br>" + e.getMessage();
        }
        req.setAttribute("sqlStatement", sqlStatement);
        req.setAttribute("sqlResult", sqlResult);
        req.getRequestDispatcher("sqlGateway.jsp").forward(req, resp);
}
}
