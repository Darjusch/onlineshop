**_ Settings _**

Scenario - change password

GIVEN I’m an app user

AND I’m logged in

AND I entered 5

AND I selected ‘Settings’ in main menu

AND I see list of options to change settings

AND I select option number 1 ‘Change Password’

AND I enter 1 in console

AND I am asked to enter new password

WHEN I entered new password

THEN I see message ‘Your password has been successfully changed’

## AND I navigated to main menu

Scenario - change email

GIVEN I’m an app user

AND I’m logged in

AND I entered 5

AND I selected ‘Settings’ in main menu

AND I see list of options to change settings

AND I select option number 2 ‘Change Email’

AND I enter 2 in console

AND I am asked to enter new email

WHEN I entered new email

THEN I see message ‘Your email has been successfully changed’

AND I navigated to main menu

Scenario - setting - error handling - not valid option

GIVEN I’m an app user

AND I’m logged in

AND I entered 5

AND I selected ‘Settings’ in main menu

AND I see list of options to change settings

WHEN I enter any number beside 1 and 2

THEN I see the message ‘Only 1, 2 is allowed. Try one more time’

AND I see settings menu again

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
