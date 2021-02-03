package landingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    private WebDriver driver;
    private Actions action;
    private WebDriverWait wait;
    private JavascriptExecutor jsExec;

    private By items = By.className("product-container");
    private By addButtons = By.xpath("//a[@title='Add to cart']");
    private By popup = By.id("layer_cart");
    private By continueButton = By.xpath("//div[@class='button-container']//span[@title='Continue shopping']");
    private By checkoutButton = By.xpath("//div[@class='button-container']//a[@title='Proceed to checkout']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 50);
        jsExec = (JavascriptExecutor) driver;
    }

    public void scrollToItemsSection() {
        jsExec.executeScript("document.getElementById('homefeatured').scrollIntoView(true)");
    }

    public void hoverOnItem(int itemIndex) {
        action.moveToElement(driver.findElements(items).get(itemIndex)).build().perform();
    }

    public void clickAddItem(int buttonIndex) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(addButtons).get(buttonIndex))).click();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(popup)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(continueButton))).click();
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(popup)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(checkoutButton))).click();
    }

}
