package SBL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeSelected;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SBLCrowler extends BaseClass {
  static WebDriver driver = getDriver("chrome");
  static WebDriverWait wait = new WebDriverWait(driver, 3);

  public static void main(String[] args) throws InterruptedException {
    SBLMainPage sblMainPage = new SBLMainPage(driver, wait);
    sblMainPage.getSBLMainPage();
    sblMainPage.switchToMainPage();
    sblMainPage.closeModalWindow();
    sblMainPage.openNavigationMenu();
    sblMainPage.loginInSBLclick();
    SBLLoginPage sblLoginPage = new SBLLoginPage(driver);
    sblLoginPage.authorize("sir.axle@yandex.ru", "blues2000");
    //переход на страницу с курсами и сбор информации о курсах
    driver.findElement(By.xpath("(//a[contains(text(), 'Courses')])[1]")).click();
    List<WebElement> coursesNames = new ArrayList<WebElement>();
    int coursesSize = -1;
    while (coursesSize < coursesNames.size()) {
      coursesSize = coursesNames.size();
      ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 5000)");
      By loadMoreButton = By.xpath("//a[contains(text(), 'Load More')]");
      try {
        //Thread.sleep(3000);
        wait.until(visibilityOfElementLocated(loadMoreButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(loadMoreButton)).build().perform();
        wait.until(elementToBeSelected(loadMoreButton));
        driver.findElement(By.xpath("//a[contains(text(), 'Load More')]")).click();
      } catch (Exception ex) {
        System.out.println("course list is over");
      }
      coursesNames = driver.findElements(By.xpath("//div[@class=\"activity-summary\"]"));
    }

    System.out.println(coursesNames.size());

    for (int i = 0; i < coursesNames.size(); i++) {
      System.out.println(coursesNames.get(i).findElement(By.xpath(".//h2")).getText());
    }

    driver.close();
    driver.quit();

  }

}
