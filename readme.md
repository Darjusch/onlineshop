## The ID number should be automatically incremented for each new user (static counter field should be a part of DefaultUser class)

Scenario - new user sign up - unique email successful validation

GIVEN I’m an app user
AND I see main menu in console

WHEN I entered 1

AND I selected ‘Sign Up’ in main menu

THEN registration process is started

AND I asked to enter my first name

AND I asked to enter my last name

AND I asked to enter my password

AND I asked to enter my email

AND I enter unique email

AND application successfully registered me

AND I see notification that ‘new user is created’

AND I navigated back to main menu

AND instead of ‘Sign In’ I see ‘Sign Out’ label

---

Scenario - new user sign up - unique email unsuccessful validation

GIVEN I’m an app user
AND I see main menu in console

WHEN I entered 1

AND I selected ‘Sign Up’ in main menu

THEN registration process is started

AND I asked to enter my first name

AND I asked to enter my last name

AND I asked to enter my password

AND I asked to enter my email

AND I enter NOT unique email

AND application doesn’t register me

AND I see notification that ‘This email is already used by another user. Please, use another email’

AND I navigated back to main menu

---

Scenario - new user sign up - empty email unsuccessful validation

GIVEN I’m an app user
AND I see main menu in console

WHEN I entered 1

AND I selected ‘Sign Up’ in main menu

THEN registration process is started

AND I asked to enter my first name

AND I asked to enter my last name

AND I asked to enter my password

AND I asked to enter my email

AND I enter empty email

AND application doesn’t register me

AND I see notification that ‘You have to input email to register. Please, try one more time’

AND I navigated back to main menu
