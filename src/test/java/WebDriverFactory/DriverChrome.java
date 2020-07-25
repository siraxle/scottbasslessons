package WebDriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverChrome implements Driver {
  private static final Logger logger = LogManager.getLogger(DriverChrome.class);
  @Override
  public WebDriver createDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addExtensions(new File("C:\\Selenium\\lfedlgnabjompjngkpddclhgcmeklana.crx"));
    DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver(desiredCapabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    logger.info("Driver: {}", driver);
    return driver;
  }

}
