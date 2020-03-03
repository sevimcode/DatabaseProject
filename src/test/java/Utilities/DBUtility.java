package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtility{

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    public static void createConnection() throws SQLException {

        switch(Config.getProperty ("dbtype")){
            case "oracle":
                connection = DriverManager.getConnection (Config.getProperty ("url"),
                        Config.getProperty ("oracleusername"),
                        Config.getProperty ("oraclepassword"));

                break;
            case "mysql" :
                //create mysql connection here
                break;
            default:
                connection = null;
        }
    }

    public static List<Map<Object,Object>> executeQuery ( String query) throws SQLException {

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery (query);
        ResultSetMetaData metaData = resultSet.getMetaData ();
        int metaDataColumnNumber = metaData.getColumnCount ();

        List<Map<Object,Object>> data = new ArrayList<> ();

        while(resultSet.next ()){
            Map<Object,Object> map = new HashMap<> ();
            for (int i = 1 ; i<=metaDataColumnNumber ; i++){

                map.put (metaData.getColumnName (i),resultSet.getObject (i)); // key is the column name we are storing values

            }
            data.add (map);
        }
        return data;
    }

    public static void close() throws SQLException {
        if ( connection!=null){
            connection.close();}
        if (statement!=null){
            statement.close();}
        if (resultSet!=null){
            resultSet.close();}
    }


}









