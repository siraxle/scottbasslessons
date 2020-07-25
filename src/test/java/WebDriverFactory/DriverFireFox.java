package WebDriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFireFox implements Driver {
  private static final Logger logger = LogManager.getLogger(DriverFireFox.class);
  @Override
  public WebDriver createDriver() {
    System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    logger.info("Driver: {}", driver);
    return driver;
  }
}
