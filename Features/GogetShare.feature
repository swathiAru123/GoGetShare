Feature: GoGetShare application functionality verification

Scenario: Verify HomePage Functionality
Given Launch GoGetShare Application
And Login to GoGetShare Application
Then Verify Location and Datepicker box functionality
Then Verify list of available cars are displaying in home page
And Verify availability bars are displaying in home page

Scenario: Verify search screen functionality
Given Launch GoGetShare Application
And Login to GoGetShare Application
And Verify search screen is displaying on tapping Location field
And Verify dynamic list and current location are fetched on entering location "A"
And Verify error message "No Results Found" displaying on entering special char "++}(--#^$"

Scenario: Verify Start time and end time functionality
Given Launch GoGetShare Application
And Login to GoGetShare Application
And Verify dynamic list and current location are fetched on entering location "Chatswood, NSW"
Then Choose Start time as "Yesterday" and End time as "1 00 PM"
And Verify error message "Please Select future date" displays on entering past date range

Scenario: Verify Pod Details page
Given Launch GoGetShare Application
And Login to GoGetShare Application
And Verify dynamic list and current location are fetched on entering location "Chatswood, NSW"
Then Choose Start time as "Today" and End time as "4 00 PM"
Then Choose car "Jez the Van"
And Verify user is navigated to Pod details page by verifying page title "Pod details page"
And Verify car details in Pod Details page
