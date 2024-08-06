# TA POM Framework using Java, Appium, Testng, uiautomator2


To setup the environment for test execution setup the following:

Appium version 2.11.2 with uiautomator2 plugin\
node.JS v20.16.0 (npm as well)\
JDK 21 (make sure to add JAVA_HOME to env variables)\
Android studio with android emulator (make sure to add ANDROID_HOME to env variables)\
Maven


# Running the tests

To run the tests make sure you have set up your environment(you can use tools like appium-doctor for diagnosis)\
Make sure Appium is running alongside with the android emulator, setup the config.properties file with emulator and appium settings\
choose which class to run in testng.xml and run "mvn test"

