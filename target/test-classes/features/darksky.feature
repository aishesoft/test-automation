@darksky @regression @web
  Feature: DarkSky homepage feature

    Background:
      Given DarkSky homepage is launched

    @dstest_1
      Scenario: Verify invalid signup error message on DarkSky
      Given I am on the DarkSky Register page
       When I click on Register button
       Then I verify error message 'Please fill out this field'

    @dstest_2
    Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
      Then I verify current temp is not greater or less then temps from daily timeline

    @dstest_3
    Scenario: Verify Today's timeline temperature value equals to min and max temperatures
       When I expand today's timeline
       Then I verify lowest and highest temp is displayed correctly

    @dstest_4
    Scenario: Verify timeline is displayed in correct format
      Then I verify timeline is displayed with two hours incremented
