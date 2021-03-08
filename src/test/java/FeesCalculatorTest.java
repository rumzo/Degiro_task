import org.testng.annotations.Test;
import pages.CalculatorPage;

public class FeesCalculatorTest extends BaseTest{

    @Test
    public void verifyProductCostsInformation(){

        CalculatorPage.goToDegiroFeesCalculator();
        CalculatorPage.fillForm();
        CalculatorPage.verifyMessage("Big amount", "These costs are not charged by DEGIRO but by the provider of the products and are included in the price. Regardless of which provider you use to invest, you will always pay these costs.");
    }


}
