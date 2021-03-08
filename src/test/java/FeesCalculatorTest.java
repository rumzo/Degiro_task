import org.testng.annotations.Test;
import pages.CalculatorPage;

public class FeesCalculatorTest extends BaseTest{

    @Test
    public void verifyFeesCalculcator(){
        CalculatorPage.goToFeesCalculator();
        CalculatorPage.fillForm();
        CalculatorPage.verifyMessage();



    }



}
