# Appium Java Test

## Installation steps

Make sure you have the following tools on your machine

```
Android Studio
JDK
Any IDE of your choice (ex. Eclipse - Neon)
Android SDK
Appium for Windows
```


After installing all of these, run android studio and navigate to AVD Manager, then download a new emulator, choose `Nexus 5X API 28`, and wait for the download to finish.
Make sure the emulator is working by booting it up.

Run appium desktop and start a new server with default configurations, then click on `Start Inspector Session`, a new window will popup

Click on `Desired Capabilities` and add the following JSON snippet
```JSON
{
  "platformName": "Android",
  "platformVersion": "9",
  "deviceName": "Nexus_5X_API_28",
  "automationName": "uiautomator2",
  "app": "PATH_TO_YOUR_APK\\selendroid-test-app-0.17.0.apk"
}
```
NOTE: Replace the path with the application path on you OS.

then click on `Start Session`, and wait for the emulator to load and open the application, you can observe the logs on the appium logger session.

Now appium is ready, go to Eclipse and load the project there

When project is loaded with all the dependencies there, go the test file
right click on that file, go to `Run As` and choose `TestNG Test`, the tests should be running and you can see the emulator performing the automated tests.

After running the tests, check the Eclipse `console`, you should see it all passing.

```
PASSED: ButtonTest
PASSED: DisplayTextViewTest
PASSED: ENButtonTest
PASSED: TextFieldTest
PASSED: UserRegistrationTest
PASSED: WebViewTest
```


## Performed Tests

### 1 - Click on a simple button
First of all, a warning popup modal should appear, the test will handle it and press OK
Then the application main screen will be shown

### 2 - Click on `Display Text View`
When clicking this button, an new TextView should be rendered in the app, this test is responsible for testing if the text view is rendered correctly

### 3 - EN Button Test
This EN button, when clicked, it opens a popup modal with two button, YES (to exit the app), NO (to remain in the app), this test, clicks on the `NO` button

### 4 - Text Field Test
This test is responsible on inputing some text to the text field, what we are sending here is the text `Testing TextField`

### 5 - User Registration Test
This test is responsible for entering the user registration form and filling all the fields, checking a checkbox, choosing from a dropdown list then submitting a user.
After that the test returns to the main screen of the app.

### 6 - Webview Test
This is responsible for entering the webview test view and then choosing from the dropdown menu, then exit the view.

After that, the app should exit when performing the `CloseApp()` function.
