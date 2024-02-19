Scenario - setting - error handling - not logged in

GIVEN I’m an app user

WHEN I entered 5

AND I selected ‘Settings’ in main menu

THEN I see message ‘Please, log in or create new account to change your account settings’

**_ Customer List _**

Scenario - print list of customers to console

GIVEN I’m an app user

WHEN I entered 6

AND I selected ‘Customer List’ in main menu

THEN I see list of customers

AND I navigated back to the main menu

Technical note:

We shouldn’t print Customer password
