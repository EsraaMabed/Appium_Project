# MobileProject
This is a practice for Mobile tetsing using Appium
for an E-commerce website (Swag Labs) for online purchasing 

#Description
-The project implement modular design by using the Page Object Model design pattern.
-Automated test execution report generated.
-Externalizing test data using jsonFile.
-Attaching a screenshot to the report .
-Documenting your code is worth a bonus point.

#Testng
TestNg Annotation are used to organize the run of testcases


#App usud throw our project

1.Android studio for launching Android emulator version(11)
(https://developer.android.com/studio)
2.Intialization appium server by Node_Js Cmd
(http://nodejs.org/)
3.Appium Inspector for inspect elements on the desired Website
(https://github.com/appium/appium-inspector/releases)
4.APK File for Website
(https://github.com/saucelabs/sample-app-mobile/releases/download/2.2.0/Android.SauceLabs.Mobile.Sample.app.2.2.0.apk)


  #Test Cases
  
 TC001 :Login with Valid Email and password and validate that login is performed successfully
TC002 :Login with invalid email or password
TC003: Add Any Item to the cart and validate that Title and price of the Item at Home page equals the item and price at the cart
TC004: Validate Removing Items from the cart and validate that the cart is empty
TC005: Online Ordering and complete the flow from adding element to cart till the checkout, Also Validate the price and success purchase.
