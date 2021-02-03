package landingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public double getProductsTotal() {

        double productsTotal = 0.00;
        String price;

        List<WebElement> products = driver.findElements(By.xpath("//table[@id='cart_summary']//tbody//tr"));

        for (int i = 0; i < products.size(); i++) {
            WebElement productTotal = products.get(i).findElement(By.xpath(".//td[@class='cart_total']//span"));

            price = productTotal.getText().substring(1);
            double productPrice = Double.parseDouble(price);

            productsTotal = productsTotal + productPrice;

        }

        return productsTotal;
    }

    public double getTotal() {
        String productsTotal = driver.findElement(By.id("total_product")).getText().substring(1);

        return Double.parseDouble(productsTotal);
    }
}
