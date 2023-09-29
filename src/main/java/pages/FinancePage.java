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

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public List<String> getInterestedFinancePageStockSymbols(){
        List<WebElement> interestedSubSectionElements = driver.findElements(By.className("tOzDHb"));
        List<String> stockSymbols = new ArrayList<>();
        for (WebElement element : interestedSubSectionElements) {
            stockSymbols.add(element.findElement(By.className("COaKTb")).getText());
        }
        return stockSymbols;
    }
    public void enterSearchTerms(String searchTerms){
        driver.findElement(By.cssSelector(".Ax4B8.ZAGvjd")).sendKeys(searchTerms);
    }

    public void clickMore(){
        driver.findElement(By.className("VfPpkd-vQzf8d")).click();
    }

    public List<WebElement> getTableList(){
        return driver.findElements(By.cssSelector(".SxcTic.h6lQV"));
    }
}
