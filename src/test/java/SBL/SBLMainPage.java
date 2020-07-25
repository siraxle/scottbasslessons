package SBL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SBLMainPage {

  private WebDriver driver;
  private WebDriverWait wait;

  public SBLMainPage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public void getSBLMainPage() {
    driver.get("https://scottsbasslessons.com/");
  }

  public void switchToMainPage() {
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(0));
  }

  public void closeModalWindow() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class=\"ub-emb-iframe-wrapper ub-emb-visible\"]")));
    driver.findElement(By.xpath("(//button[@class=\"ub-emb-close\"])[1]")).sendKeys(Keys.ESCAPE);
  }

  public void openNavigationMenu() {
    driver.findElement(By.xpath("//button[@aria-label=\"Open navigation\"]")).click();
  }

  public SBLLoginPage loginInSBLclick(){
    driver.findElement(By.xpath("(//a[contains(text(), 'Login')])[2]")).click();
    return new SBLLoginPage(driver);
  }


}
