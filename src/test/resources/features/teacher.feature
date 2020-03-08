Feature: Teacher feature
Scenario: Creating teacher and verifying on UI and DB
  When User on home page
  When Click Teachers
  When Click Add Teacher
  When User should be able to fill out the Teacher form
  Then User should be able to submit the Teacher form
  When Click Teachers
  When Click All Teacher
  Then Teacher should be displayed on the teacher grid
  When User should be able to click list toggle button on All Teachers
  Then Teacher should be created on the database


  Scenario: Updating teacher and verifying on UI and DB
    When User on home page
    When Click Teachers
    When Click All Teachers
    And Click first teacher
    When Get ID from teacher profile page
    And Click Teachers
    And Click All Teachers
    And Click edit button on the first teacher
    When Update teacher subject and submit
    Then Teacher should be updated on the profile page
    Then  Teacher should be updated on the database


  Scenario: Deleting teacher and verifying on UI and DB
    When User on home page
    When Click Teachers
    When Click All Teachers
    When Click first teacher
    When Get ID from teacher profile page
    When Click Teachers
    When Click All Teachers
    And  Click delete button on the first teacher
    When Click delete button on the teacher alert box
    When Click teacher list toggle button
    Then Teacher should NOT be found on list
    Then  Teacher should be deleted on the database

