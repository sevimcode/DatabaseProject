package step_definitions;

import Utilities.Config;
import Utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

public class HomePage_StepDefs{

    HomePage homePage = new HomePage ();
    AllTeachersPage allTeachersPage = new AllTeachersPage ();
    AllStudentsPage allStudentsPage = new AllStudentsPage ();




    @Given("User on home page")
    public void user_on_home_page() {
        Driver.getDriver ().get (Config.getProperty ("urlWebsite"));
    }

    @When("User should be able to click Teachers")
    public void user_should_be_able_to_click_Teachers() {
       homePage.teachers.click ();
    }

    @When("User should be able see All Teachers")
    public void user_should_be_able_see_All_Teachers() {
        Assert.assertTrue (homePage.allTeachers.isDisplayed ());
    }

    @When("User should be able to click All Teachers")
    public void user_should_be_able_to_click_All_Teachers() {
        homePage.allTeachers.click ();

    }

    @When("User should be able see Add Teacher")
    public void user_should_be_able_see_Add_Teacher() {
        Assert.assertTrue (homePage.addTeacher.isDisplayed ());
    }

    @When("User should be able to click Add Teacher")
    public void user_should_be_able_to_click_Add_Teacher() {
        homePage.addTeacher.click ();

    }

    @When("User should be able to click Students")
    public void user_should_be_able_to_click_Students() {
       homePage.students.click ();
    }

    @When("User should be able see All Students")
    public void user_should_be_able_see_All_Students() {
        Assert.assertTrue (homePage.allStudents.isDisplayed ());
    }

    @When("User should be able to click All Students")
    public void user_should_be_able_to_click_All_Students() {
        homePage.allStudents.click ();
    }

    @When("User should be able see Add Student")
    public void user_should_be_able_see_Add_Students() {
        Assert.assertTrue (homePage.addStudent.isDisplayed ());
    }

    @When("User should be able to click Add Student")
    public void user_should_be_able_to_click_Add_Students() {
        homePage.addStudent.click ();
    }

    @Then("User should be able to navigate to All Teachers page")
    public void userShouldBeAbleToNavigateToAllTeachersPage() {
        Assert.assertEquals (Driver.getDriver ().getCurrentUrl (),"http://cybertektraining.com/all-teachers.html");
    }

    @Then("User should be able to navigate to Add Teacher page")
    public void userShouldBeAbleToNavigateToAddTeacherPage() {
        Assert.assertEquals (Driver.getDriver ().getCurrentUrl (),"http://cybertektraining.com/add-teacher.html");

    }

    @Then("User should be able to navigate to All Students page")
    public void userShouldBeAbleToNavigateToAllStudentsPage() {
        Assert.assertEquals (Driver.getDriver ().getCurrentUrl (),"http://cybertektraining.com/all-students.html");
    }

    @Then("User should be able to navigate to Add Student page")
    public void userShouldBeAbleToNavigateToAddStudentPage() {
        Assert.assertEquals (Driver.getDriver ().getCurrentUrl (),"http://cybertektraining.com/add-student.html");
    }




   }