package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utility.ErrorHandler;

/**
 *
 * @author sushant saini
 */
public class CommonDAO extends Dao {

    public int getLastInsertID() {
        try {
            String query = "select last_insert_id()";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            int result = 0;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return 0;
        }
    }
}
