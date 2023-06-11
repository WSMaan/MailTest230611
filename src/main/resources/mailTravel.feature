Feature: Mail Travel Booking

  @booking
  Scenario: Book a tour to India with valid inputs
    Given I open a browser and navigate to "https://www.mailtravel.co.uk/"
    When I accept all cookies
    And I enter "India" in the search bar and click on the search button
    When I select holiday package
    And I click on the book online button
    Then I should see an error message "Please select your departure date"
    When I select two passenger from the dropdown
    And I select a departure date from the calendar
    Then I should see the tour price
    And I click on the book online button again
#  @skip_booking
#    Then I should see the details populated are valid
#    And I click on the 'SELECT YOUR ROOMS AND CONTINUE'
#    And I fill the 'Passenger details' with <name>
#    Then I should see the Confirm Details
#    And I should see the Book Now button is enabled
