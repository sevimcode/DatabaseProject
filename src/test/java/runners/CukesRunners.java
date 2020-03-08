package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



    @RunWith(Cucumber.class)
    @CucumberOptions(  // features and glue specifications have to be here

            features = "src/test/resources/features",
            glue = "step_definitions",
            plugin = "html:target/cucumber-reports",
            dryRun = false,
            tags = "@database"

    )

    public class CukesRunners{
}
