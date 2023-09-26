import org.testng.Assert;
import org.testng.annotations.Test;
import utils.FinanceConstants;
import java.util.ArrayList;
import java.util.List;

public class FinancePageTest extends BaseTest implements FinanceConstants {

    @Test
    public void testAssertFinancePageLoads(){
        var pageTitle = financePage.getPageTitle();
        Assert.assertNotNull(pageTitle);
    }

    @Test
    public void testAssertFinancePageTitleIsCorrect(){
        var pageTitle = financePage.getPageTitle();
        Assert.assertEquals(pageTitle, PAGETITLE);
    }

    @Test
    public void testCompareFinancePageStockSymbols(){
        var pageStockSymbols = financePage.getInterestedFinancePageStockSymbols();
        List<String> foundOnBoth = new ArrayList<>();
        List<String> foundOnlyOnGoogle = new ArrayList<>();
        for (String symbol : pageStockSymbols) {
            if (EXPECTEDSTOCKSYMBOLS.contains(symbol)){
                foundOnBoth.add(symbol);
            } else {
                foundOnlyOnGoogle.add(symbol);
            }
        }
        System.out.println("Found on Both Google Finance Page and in our expected list");
        System.out.println(foundOnBoth);
        System.out.println("==========================================================");
        System.out.println("Found ONLY on Google Finance");
        System.out.println(foundOnlyOnGoogle);
    }
}
