import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCases{

    protected static WebDriver driver;
    public static final String URL="https://www.gittigidiyor.com";
    static String productPriceOnProductPage="vcbknkn";

    @BeforeAll
    public static void openWindow(){
        System.setProperty("webdriver.chrome.driver", "/home/mint/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    @Order(1)
    public void login(){
        System.out.println("TESTCASE: Login");
    }

    @Test
    @Order(2)
    public void searchProduct(){
        System.out.println("TESTCASE: SearchProduct");
        BasePage basePage =new BasePage(driver);
        basePage.search("bilgisayar");
    }

    @Test
    @Order(3)
    public void openSecondPage(){
        System.out.println("TESTCASE: OpenSecondPage");
        SearchResultsPage searchResultsPage=new SearchResultsPage(driver);
        searchResultsPage.goToAnotherPage("2");
    }

    @Test
    @Order(4)
    public void pickRandomProduct(){
        System.out.println("TESTCASE: PickRandomProduct");
        SearchResultsPage searchResultsPage=new SearchResultsPage(driver);
        ProductPage productPage=new ProductPage(driver);
        searchResultsPage.pickRandomProduct();
        productPriceOnProductPage=productPage.getProductPrice();
    }

    @Test
    @Order(5)
    public void addProductToBasketAndGoToBasket(){
        System.out.println("TESTCASE: AddProductToBasket");
        ProductPage productPage=new ProductPage(driver);
        BasePage basePage=new BasePage(driver);
        productPage.addProductToBasket();
        basePage.goToBasket();
    }

    @Test
    @Order(6)
    public void comparePrices(){
        System.out.println("TESTCASE: ComparePrices");
        BasketPage basketPage=new BasketPage(driver);
        String productPriceOnBasket=basketPage.getProductPrice();
        System.out.println("\tProductPriceOnProductPage:\""+this.productPriceOnProductPage+"\"\n\tProductPriceOnBasket:\""+productPriceOnBasket+"\"");
        if(productPriceOnBasket.equals(this.productPriceOnProductPage)){
            System.out.println("\tPrices are EQUAL");
        }
        else{
            System.out.println("\tPrices are NOT EQUAL");
        }
    }

    @Test
    @Order(7)
    public void increaseQuantityAndVerify(){
        System.out.println("TESTCASE: IncreaseQuantityAndVerify");
        BasketPage basketPage=new BasketPage(driver);
        basketPage.increaseQuantityAndVerify();
    }

    @Test
    @Order(8)
    public void removeProductAndVerify(){
        System.out.println("TESTCASE: RemoveProduct");
        BasketPage basketPage=new BasketPage(driver);
        basketPage.removeProductAndVerify();
    }

    @AfterAll
    public static void closeWindow(){
        driver.quit();
    }

}
