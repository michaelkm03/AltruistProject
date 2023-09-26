package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FinanceConstants;

import java.util.ArrayList;
import java.util.List;

public class FinancePage implements FinanceConstants {
    private final WebDriver driver;
    public FinancePage(WebDriver driver){
        this.driver = driver;
    }
    public String getPageTitle(){
        return driver.getTitle();
    }

    public List<String> getInterestedFinancePageStockSymbols(){
        List<WebElement> interestedSubSectionElements = driver.findElements(By.className("tOzDHb"));
        List<String> stockSymbols = new ArrayList<>();
        for (WebElement element : interestedSubSectionElements) {
            stockSymbols.add(element.findElement(By.className("COaKTb")).getText());
        }
        return stockSymbols;
    }
}
