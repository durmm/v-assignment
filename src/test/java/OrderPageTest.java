import landingPage.LandingPage;
import landingPage.OrderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class OrderPageTest {

    private WebDriver driver;

    @BeforeTest
    public void prepareDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", path + "/webdrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }

    @Test
    public void compareProductsTotals() {
        LandingPage landingPage = new LandingPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        landingPage.scrollToItemsSection();
        landingPage.hoverOnItem(1);
        landingPage.clickAddItem(1);
        landingPage.clickContinue();
        landingPage.hoverOnItem(2);
        landingPage.clickAddItem(2);
        landingPage.clickCheckout();
        assertEquals(orderPage.getProductsTotal(),orderPage.getTotal());
    }
}
