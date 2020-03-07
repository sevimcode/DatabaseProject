package step_definitions;

import Utilities.Config;
import Utilities.DBUtility;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CybertekTrainingDB{


    public static void main( String[] args ) throws SQLException {

//        DBUtility.createConnection ();
//        List<Map<Object, Object>> data = DBUtility.executeQuery ("select * from " + Config.getProperty ("departmentQuery"));
//        DBUtility.close ();
//        DBUtility.verifyCreatedName (data, Config.getProperty ("firstNameQuery"),Config.getProperty ("lastNameQuery"));



        Driver.getDriver ().get (Config.getProperty ("urlWebsite"));
        List<WebElement> links = Driver.getDriver ().findElements(By.className ("sidebar-menu"));

        System.out.println(links.size());

        for (int i = 0; i<links.size(); i++)

        {

            System.out.println(links.get(i).getText ());

        }







    }
}