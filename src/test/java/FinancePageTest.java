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

    @Test //Added extra test here that was not in the prompt
    public void testAssertFinancePageTitleIsCorrect(){
        var pageTitle = financePage.getPageTitle();
        Assert.assertEquals(pageTitle, PAGETITLE);
    }

    @Test
    public void testCompareFinancePageStockSymbols(){
        var stockSymbolsOnGoogle = financePage.getInterestedFinancePageStockSymbols();
        System.out.println("LISTS");
        System.out.println("our list ------ " + EXPECTEDSTOCKSYMBOLS);
        System.out.println("google list --- " + stockSymbolsOnGoogle);
        List<String> foundOnlyOnGoogle = new ArrayList<>();
        List<String> foundOnlyInExpectedStockSymbols = new ArrayList<>();
        for (String symbol : stockSymbolsOnGoogle) {
            if (!EXPECTEDSTOCKSYMBOLS.contains(symbol)){
                foundOnlyOnGoogle.add(symbol);
            }
        }
        for (String symbol : EXPECTEDSTOCKSYMBOLS) {
            if (!stockSymbolsOnGoogle.contains(symbol)){
                foundOnlyInExpectedStockSymbols.add(symbol);
            }
        }
        System.out.println("Found only on Google Finance");
        System.out.println(foundOnlyOnGoogle);
        System.out.println("==========================================================");
        System.out.println("Found only in expected list");
        System.out.println(foundOnlyInExpectedStockSymbols);
    }
}
