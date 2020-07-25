package SBL;

import WebDriverFactory.Driver;
import WebDriverFactory.DriverChromeFactory;
import WebDriverFactory.DriverFactory;
import WebDriverFactory.DriverFireFoxFactory;
import org.openqa.selenium.WebDriver;

public class BaseClass {

  static WebDriver getDriver(String browserName) {
    DriverFactory webDriverFactory = createDriverByName(browserName);
    Driver driver = webDriverFactory.createDriver();
    WebDriver webDriver = driver.createDriver();
    return  webDriver;
  }

  static DriverFactory createDriverByName(String browserName) {
    if (browserName.equalsIgnoreCase("chrome")) {
      return new DriverChromeFactory();
    } else if (browserName.equalsIgnoreCase("fireFox")){
      return new DriverFireFoxFactory();
    } else {
      throw new RuntimeException(browserName + " is unknown browser name");
    }
  }

}
