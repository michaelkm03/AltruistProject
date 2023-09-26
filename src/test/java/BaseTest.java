import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.FinancePage;
public class BaseTest {

    private WebDriver driver;
    protected FinancePage financePage;

    @BeforeMethod
    public void setUp(){
        // we could pass url as parameter if we wanted to test new page (e.g, google.com/flights"
        String url = "https://www.google.com/finance";
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        financePage = new FinancePage(driver);
        // we can initialize more pages here when needed (e.g, flightsPage if we wanted to test google.com/flights)
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
