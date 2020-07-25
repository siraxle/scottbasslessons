package WebDriverFactory;

public class DriverChromeFactory implements DriverFactory {

  @Override
  public Driver createDriver() {
    return new DriverChrome();
  }

}
