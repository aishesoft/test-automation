@web @hotels @regression
Feature: Hotels.com search feature

  Background:
    Given Hotels.com homepage is launched

    @hotels_1
    Scenario Outline: Verify room count dropdown
       When I select <select_rooms> from select_rooms room dropdown
       Then I verify <number_of_room_dropdown> number_of_room_dropdown is displayed

     Examples:
      |select_rooms | number_of_room_dropdown |
      |  1          | 1                       |
      |  2          | 2                       |
      |  3          | 3                       |
      |  4          | 4                       |
      |  5          | 5                       |
      |  6          | 6                       |
      |  7          | 7                       |
      |  8          | 8                       |
      |  9          | 0                       |

    @hotels_2
    Scenario: List of all of hotel within 10 miles radius of airport or downtown
      Given I am on default locations search result screen
       When I select Landmark and set the max radius
       Then I verify system displays all hotels within 2 miles radius of Landmark
        And I verify Hilton Hotel is within radius

    @hotels_3
    Scenario Outline: Verify user can only view the result by selected property class
      Given I am on default locations search result screen
       When I select property <star> star class
       Then I verify system displays only selected <star> hotels on search result

      Examples:
        | star |
        | 5    |
        | 4    |
        | 3    |

    @hotels_4
    Scenario: Verify today's deal price value
       Given I am on default locations search result screen
        Then I verify todays deal is less than USD200