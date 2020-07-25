package SBL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SBLLoginPage {

  private WebDriver driver;
  private WebDriverWait wait;

  public SBLLoginPage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public SBLLoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void authorize(String email, String password) {
    driver.findElement(By.xpath("//input[@name=\"loginName\"]")).sendKeys(email);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();
  }

}
