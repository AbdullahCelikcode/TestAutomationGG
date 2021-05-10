package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage{
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public void goToAnotherPage(String pageNumber) {
        try {
            Thread.sleep(1000);
            WebElement element = driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li["+pageNumber+"]/a"));
            scrollTo(element);
            element.click();
            WebElement element_currentPage=driver.findElement(By.className("current"));
            //System.out.println(element_currentPage.getText());
            if(element_currentPage.getText().equals(pageNumber)){
                System.out.println("\tSecond page opened : SUCCEED");
            }
            else{
                System.out.println("\tSecond page opened : FAIL");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void pickRandomProduct(){
        try {
            Thread.sleep(1000);
            List<WebElement> list_products = driver.findElements(By.className("product-link"));
            list_products.get((int) (Math.random() * list_products.size())).click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
