@web @regression @login
Feature: Facebook Login feature

  Background:
    Given I am on Facebook home page

  @login_1
  Scenario Outline: Verify invalid emails are not accepted for Facebook sign up section
  When Enter <firstname> into First name field
   And Enter <lastname> into Last name field
   And Enter <e-mail> into Email address field
   And Click on password field
   And Click on red exclamation icon
  Then Verify incorrect email was entered message

    Examples:
    |firstname |lastname |e-mail   |
    |Ali       |Seed     |test     |
    |Bob       |Treakki  |тест;.&  |
    |Marina    |Debish   |_@c@#$   |


  @login_2
  Scenario Outline: Verify the list of invalid emails upon login to account
  When Enter <email> into email field
   And Enter <password> into password field
   And Click on Login button
  Then Verifying invalid login information message on the page

   Examples:
      |email                          |password   |
      |*test@gmail.com                 |test1234*  |
      |* #@%^%#$@#$@#.com             |1234*      |
      |@example.com                   |tes        |
      |Joe Smith <email@example.com>  |GO*(TEST[] |
      |email.example.com              |test1234*  |
      |* email@example@example.com    |test1234*  |
      |.email@example.com             |test1234*  |
      |email.@example.com             |test1234*  |
      |email..email@example.com       |test1234*  |
      |あいうえお@example.com           |test1234*  |
      |email@example.com (Joe Smith)  |test1234*  |
      |email@example                  |test1234*  |
      |email@-example.com             |test1234*  |
      |email@example.web              |test1234*  |
      |email@111.222.333.44444        |test1234*  |
      |email@example..com             |test1234*  |
      |Abc..123@example.com           |test1234*  |

  @login_3
  Scenario: Select the current month from month dropdown
    When Click on month drop down
     And Select current month from drop down
    Then Verify the correct month is selected


  @login_4
  Scenario: Find out if dropdown contains duplicates, if yes fail the test and print the duplicate values
    When Click on drop down and find out if it contains duplicates
