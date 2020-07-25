package SBL;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeSelected;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SBLCrowler extends BaseClass {

  public static void main(String[] args) throws InterruptedException {
    //инициализация драйвера
    WebDriver driver = getDriver("chrome");

    SBLMainPage sblMainPage = new SBLMainPage(driver);
    //driver.get("https://scottsbasslessons.com/");
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(0));
    WebDriverWait wait = new WebDriverWait(driver, 3);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class=\"ub-emb-iframe-wrapper ub-emb-visible\"]")));
    driver.findElement(By.xpath("(//button[@class=\"ub-emb-close\"])[1]")).sendKeys(Keys.ESCAPE);

    //авторизация
    driver.findElement(By.xpath("//button[@aria-label=\"Open navigation\"]")).click();
    driver.findElement(By.xpath("(//a[contains(text(), 'Login')])[2]")).click();
    driver.findElement(By.xpath("//input[@name=\"loginName\"]")).sendKeys("sir.axle@yandex.ru");
    driver.findElement(By.id("password")).sendKeys("blues2000");
    driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();

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
    
  }

}
