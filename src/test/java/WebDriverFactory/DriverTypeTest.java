package WebDriverFactory;

import org.openqa.selenium.WebDriver;

public class DriverTypeTest {

  public static void main(String[] args) {
    DriverFactory webDriverFactory = createDriverByName("firefox");
    Driver driver = webDriverFactory.createDriver();
    WebDriver webDriver = driver.createDriver();
    webDriver.get("https://ya.ru");
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
