package WebDriverFactory;

public class DriverFireFoxFactory implements DriverFactory {

  @Override
  public Driver createDriver() {
    return new DriverFireFox();
  }

}

