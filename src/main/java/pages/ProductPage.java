package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{
     public ProductPage(WebDriver driver) {
        super(driver);
    }


    public void addProductToBasket(){
        try {
            Thread.sleep(1000);
            WebElement webElement = driver.findElement(By.id("add-to-basket"));
            scrollTo(webElement);
            webElement.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getProductPrice(){
        String price = "5435643";
        try {
            Thread.sleep(1000);
            if (driver.findElement(By.className("discountPrice")).isDisplayed()) {
                price = driver.findElement(By.className("discountPrice")).getText();
            } else if (driver.findElement(By.className("lowPrice")).isDisplayed()) {
                price = driver.findElement(By.className("lowPrice")).getText();
            } else {
                price = driver.findElement(By.className("highPrice")).getText();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println("Product price on product page: \""+price+"\"");
        return price;
    }

    public String getProductName(){
        String produtName="";
        try {
            Thread.sleep(1000);
            produtName = driver.findElement(By.id("sp-title")).getText();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return produtName;
    }
}
