Feature: Homepage side menu

  Background:
    Given User on home page
  Scenario: Verification of All Teachers side menu
    When User should be able to click Teachers
    When User should be able see All Teachers
    When User should be able to click All Teachers
    Then User should be able to navigate to All Teachers page

  Scenario: Verification of Add Teachers side menu
    When User should be able to click Teachers
    When User should be able see Add Teacher
    When User should be able to click Add Teacher
    Then User should be able to navigate to Add Teacher page

  Scenario: Verification of All Students side menu
    When User should be able to click Students
    When User should be able see All Students
    When User should be able to click All Students
    Then User should be able to navigate to All Students page

  Scenario: Verification of homepage side menu
    When User should be able to click Students
    When User should be able see Add Student
    When User should be able to click Add Student
    Then User should be able to navigate to Add Student page

