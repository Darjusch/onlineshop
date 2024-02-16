**_ Product Catalog _**

Scenario - list products

GIVEN I’m an app user

WHEN I entered 3

AND I selected ‘Product Catalog’ in main menu

THEN I see list of products printed to console // Create some products

Technical notes:

Product has next fields:

int id

String productName

String categoryName

double price

Scenario - navigate back to menu

GIVEN I’m an app user

AND I navigated to Product Catalog menu

WHEN I enter ‘menu’ in console

THEN I navigated back to the main menu // When writing menu go back to main so basically ;return;

Scenario - add product to cart

GIVEN I’m an app user

AND I entered 3

AND I selected ‘Product Catalog’ in main menu

AND I see product list

AND I see message ‘Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu’

WHEN I entered any product id

THEN I see the message ‘Product <PRODUCT_NAME> has been added to your cart. If you want to add a new product - enter the product id. If you want to proceed with checkout - enter word ‘checkout’ to console’

AND I see product list again

Scenario - add product to cart - error handling

GIVEN I’m an app user

AND I entered 3

AND I selected ‘Product Catalog’ in main menu

AND I see product list

AND I see message ‘Enter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu’

WHEN I entered any random number that doesn't match with product id

THEN I see the message ‘Please, enter product ID if you want to add product to cart. Or enter ‘checkout’ if you want to proceed with checkout. Or enter ‘menu’ if you want to navigate back to the main menu.’

AND I see product list again
