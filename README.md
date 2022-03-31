
Due to incompatibility between appium and winappdriver, a few changes need to be done to run desktop platform (Calculator APP):

1. In pom.xml mark appium dependency as comment:
              <dependency>
              <groupId>com.experitest</groupId>
              <artifactId>appium</artifactId>
              <version>4.1.2</version>-->
              </dependency>

2. In pom.xml uncomment io.appium dependency:
             <dependency>
             <groupId>io.appium</groupId>
             <artifactId>java-client</artifactId>
             <version>7.2.0</version>
             </dependency>

3. In CartPage, LoginPage, MainPage and MenuMain class (Under pageObjects - SwagLabs packages) mark as comment:
   PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);

4. In MobileActions class (under extension package) mark as comment the following actions:
	 mobileDriver.tap(fingers, elem, duration); (Line 17)
	 mobileDriver.swipe(startX, startyY,endx, endY, duration); (Line 24)
     mobileDriver.pinch(elem); (Line 38)
	 elem.sendKeys(text); (Line 45)

5. In CommonOps Class (under utilities package) make sure io.appium import is added:
    import io.appium.java_client.windows.WindowsDriver;

6. In CommonOps Class (under utilities package) uncomment:
    A. initDesktop method - public static void initDesktop
    B. In startSession method -
	        else if (Platform.equalsIgnoreCase("desktop"))
            initDesktop();


To run web platform - no changes needed

To run api platform - no changes needed

To run Mobile Platform after running Desktop platform - undo all changes described above
