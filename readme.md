Scenario - setting - navigate back to the main menu

GIVEN I’m an app user

AND I’m logged in

AND I entered 5

AND I selected ‘Settings’ in main menu

AND I see list of options to change settings

WHEN I enter ‘menu’

THEN I navigated back to the main menu

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
