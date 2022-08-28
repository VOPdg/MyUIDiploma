import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("ABO")
@Owner("Veronika Pdg")
public class OrderStepsTest extends TestBase {

    @Test
    void checkAbilityToMakeOrder() {
        startPage.openPage().checkOrderItem();
    }

    @Test
    void opportunityToGoToOrderPage() {
        startPage.openPage().startOrder();
        orderPage.checkOrderPage();
    }

    @Test
    void checkAvailableZone() {
        startPage.openPage().startOrder();
        orderPage.chooseTicket("VBB-Umweltkarte");
        orderPage.checkZone("Berlin ABC");
    }

    @Test
    void checkTheZipCity() {
        startPage.openPage().startOrder();
        orderPage.chooseTicket("VBB-Umweltkarte");
        orderPage.checkZone("Berlin ABC");
        orderPage.personalDataStep();

        persDataOrderPage.setTitle("Herr");
        persDataOrderPage.setName("Andy", "Rgjf");
        persDataOrderPage.setBirthday("01.02.2000");
        persDataOrderPage.checkZip("30159");
    }

    @Test
    void makeOrderTest() throws InterruptedException {
        startPage.openPage().startOrder();
        orderPage.chooseTicket("VBB-Umweltkarte");
        orderPage.checkZone("Berlin ABC");
        orderPage.personalDataStep();

        persDataOrderPage.setTitle("Herr");
        persDataOrderPage.setName("Andy", "Rgjf");
        persDataOrderPage.setBirthday("01.02.2000");
        persDataOrderPage.setZip("30159");
        persDataOrderPage.setStreet("he");
        persDataOrderPage.setHouse("4");
        persDataOrderPage.clickNextButton();
        bankDataOrderPage.setIban("DE46500105175963927676");
        bankDataOrderPage.clickNextButton();
        bankDataOrderPage.checkNextStep();
    }
}


