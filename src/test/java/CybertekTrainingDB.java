import Utilities.DBUtility;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CybertekTrainingDB{


    public static void main( String[] args ) throws SQLException {

        DBUtility.createConnection ();
        List<Map<Object, Object>> data = DBUtility.executeQuery ("select * from teacher");
        DBUtility.close ();

    }
}