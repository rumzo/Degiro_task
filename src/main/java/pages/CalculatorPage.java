package pages;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;


public class CalculatorPage extends BasePage {

    private static final By PRODUCT_TYPE_DROP_DOWN = By.id("productType");
    private static final By ALLOW_COOKIES_BUTTON = By.cssSelector("#CybotCookiebotDialogBodyButtonAccept");
    private static final By EXCHANGE_DROP_DOWN = By.cssSelector("#selectionWithin2");
    private static final By AMOUNT_PER_TRANSACTION_FIELD = By.id("amountPerTransactions");
    private static final By TRANSACTIONS_PER_YEAR_FIELD = By.id("transactionsAYear");
    private static final By AVG_YEARLY_AMOUNT_INVESTED_FIELD = By.id("averageAmountInvestedDuringYear");
    private static final By ADD_BUTTON = By.id("submitdata");
    private static final By TOTAL_COSTS_FIELD = By.xpath("//div[@class='col-12 col-lg-5 push-lg-7 roboto-reg-16 mb-4 hidden-md-down']//div[@class='transaction-data pt-2']//div[@class='pull-right green roboto-med-20']/p[@class='transaction-val bold']");
    private static final By INFORMATION_HINT_MESSAGE_PRODUCT_COSTS = By.cssSelector(".transaction-data .pull-left span[data-content*='These costs']");


    public static void goToDegiroFeesCalculator() {
        Browser.driver.get("https://www.degiro.co.uk/fees/calculator");
    }

    public static void fillForm()  {

       WebElement allowCookies = Browser.driver.findElement(ALLOW_COOKIES_BUTTON);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        allowCookies.click();

        WebElement productType = Browser.driver.findElement(PRODUCT_TYPE_DROP_DOWN);

        Select productDropDown = new Select(productType);
        productDropDown.selectByVisibleText("ETFs/ Trackers");

        WebElement exchange = Browser.driver.findElement(EXCHANGE_DROP_DOWN);
        Select exchangeDropDown = new Select(exchange);
        exchangeDropDown.selectByVisibleText("United Kingdom");

        Browser.driver.findElement(AMOUNT_PER_TRANSACTION_FIELD).sendKeys("2");
        Browser.driver.findElement(TRANSACTIONS_PER_YEAR_FIELD).sendKeys("2");
        Browser.driver.findElement(AVG_YEARLY_AMOUNT_INVESTED_FIELD).sendKeys("2");
        Browser.driver.findElement(ADD_BUTTON).click();
    }

    public static void verifyMessage(String higherThanFive, String lowerThanFive) {
        String actualPrice = Browser.driver.findElement(TOTAL_COSTS_FIELD).getText().replaceAll("£", " ");
        double price = Double.parseDouble(actualPrice);

        if (price > 5){
            System.out.println(higherThanFive);

        } else {
            System.out.println(lowerThanFive);
        }

    }
}


