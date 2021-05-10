package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasketPage extends BasePage{

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice(){
        String productPrice = "20395943";
        try {
            Thread.sleep(1000);
            productPrice=driver.findElement(By.className("new-price")).getText();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println("Product price on basket page: \""+productPrice+"\"");
        return productPrice;
    }

    public void increaseQuantityAndVerify(){
        try {
            WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select"));
            Select select=new Select(element);
            select.selectByIndex(1);
            if(select.getFirstSelectedOption().getText().equals("2")){
                System.out.println("\tIncrease amount: SUCCEED");
            }
            else{
                System.out.println("\tIncrease amount: FAILED");
            }
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeProductAndVerify(){
        try {
            WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a/i"));
            element.click();
            element=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/h2"));
            if(element.getText().equals("Sepetinizde ürün bulunmamaktadır.")){
                System.out.println("\tRemove product from basket: SUCCEED");
            }
            else{
                System.out.println("\tRemove product from basket: FAILED");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
