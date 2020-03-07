package step_definitions;

import Utilities.Driver;
import Utilities.TemporaryStorage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks{


    @Before   // berfore junit it runs before every test but before in cucumber before runs before scenario
    public void setup(){

        TemporaryStorage.clearData (); // it is coming from util to clear up the previous data

        // anything that you want to run before every scenario

    }

    @After   // after in junit it runs after every test but after in cucumber before runs after scenario
    public void tearDown( Scenario scenario ){ // takes Scenario object
        System.out.println (scenario.getName ());  // it prints the scenario name
        System.out.println (scenario.getStatus ()); // prints PASSES or FAILED
        if (scenario.isFailed ()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver ()).getScreenshotAs (OutputType.BYTES);
            scenario.embed (screenshot, "image/png");
        }
    }





}
