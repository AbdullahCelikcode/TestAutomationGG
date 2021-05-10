package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public void login(String eMail,String password){
        
    }

    public void search(String word){
        try {
            Thread.sleep(1000);
            WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div[1]/div[2]/form/div/div[1]/div[2]/input"));
            scrollTo(webElement);
            webElement.sendKeys(word);

            WebElement webElement2 = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div[1]/div[2]/form/div/div[2]/button"));
            scrollTo(webElement2);
            webElement2.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void goToBasket() {
        try {
            Thread.sleep(1000);
            WebElement webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/a"));
            scrollTo(webElement);
            webElement.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object scrollTo(WebElement element){
        String jsStmt = String.format("window.scrollTo(%d, %d);", element.getLocation().x, element.getLocation().y);
        return true ? getJSExecutor().executeScript(jsStmt, "") : getJSExecutor().executeAsyncScript(jsStmt, "");
    }

    protected JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) driver;
    }
}
