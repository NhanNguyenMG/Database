package murach.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SQLUtil {

    public static String getHtmlTable(ResultSet results) throws SQLException {
        StringBuilder htmlTable = new StringBuilder();
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Mở thẻ table
        htmlTable.append("<table>");

        // 1. Tạo dòng tiêu đề (Header row) dựa trên tên cột
        htmlTable.append("<tr>");
        for (int i = 1; i <= columnCount; i++) {
            htmlTable.append("<th>");
            htmlTable.append(metaData.getColumnName(i));
            htmlTable.append("</th>");
        }
        htmlTable.append("</tr>");

        // 2. Duyệt qua từng dòng dữ liệu trong bảng
        while (results.next()) {
            htmlTable.append("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                htmlTable.append("<td>");
                htmlTable.append(results.getString(i));
                htmlTable.append("</td>");
            }
            htmlTable.append("</tr>");
        }

        // Đóng thẻ table
        htmlTable.append("</table>");

        return htmlTable.toString();
    }
}