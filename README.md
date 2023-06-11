# Skip scenarios

This file explains why some scenarios are skipped and how to reproduce the defect.

## Reason for skipping

Some scenarios are skipped because the web page gives an error "Oops! Looks like something went wrong. Please try again, if the issue persists please contact support." on Chrome version 114.0.5735.110.  .

This error prevents the user from completing the booking process and verifying the details.

Okay, here is the optimized instructions and the defect report:

# Mail Travel Automation Project

This project contains the automation test cases for the Mail Travel website using Cucumber, TestNG and Selenium.

## Prerequisites

To execute the test cases, you will need to have the following prerequisites:

- Java JDK 8 or higher installed and configured in your system environment variables
- Maven installed and configured in your system environment variables
- Cucumber for Java and TestNG plugins installed in your IDE (e.g. Eclipse or IntelliJ IDEA)
- Chrome browser installed and updated to the latest version

## Execution Steps

To execute the test cases, follow these steps:

1. Extract the project from the zip file that you downloaded
2. Open the project in your IDE as a Maven project and wait for Maven to download the dependencies
3. Go to the src/test/java folder and locate the TestRunner class
4. Right-click on the TestRunner class and select Run As -> TestNG Test
5. Wait for the test execution to finish and check the results in the console or the TestNG view

## Defect Report

### Summary

Error message displayed when booking online after selecting the date and number of passengers

### Description

When a user tries to book online a holiday package without entering any details such as passenger name, email, phone number etc., an error message is displayed on the web page.

### Steps to reproduce

To reproduce the defect, follow these steps:

1. Open a browser and navigate to "https://www.mailtravel.co.uk/"
2. Accept all cookies
3. Enter "India" in the search bar and click on the search button
4. Select holiday package
5. Click on the book online button
6. Select any number of passengers from the dropdown
7. Select any departure date from the calendar
8. Click on the book online button again
9. Observe the error message on the web page

### Expected result

On the page user should be able to : Expand the Date, Departure & Passengers section.
• Verify the details populated are valid.
• In Accommodation section select the Number required as 1 for 2 people
• Click on the ‘SELECT YOUR ROOMS AND CONTINUE’

### Actual result

An error message is displayed on the web page saying "Oops! Looks like something went wrong. Please try again, if the issue persists please contact support".


### Status

Reported to ..., waiting for fix.
- Screenshot: ![error](src2.png)
- Status: Reported to ..., waiting for fix.
