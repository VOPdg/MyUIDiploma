package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.BankDataOrderPage;
import pages.OrderPage;
import pages.PersDataOrderPage;
import pages.StartPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.sleep;

public class TestBase {
    StartPage startPage = new StartPage();
    OrderPage orderPage = new OrderPage();
    PersDataOrderPage persDataOrderPage = new PersDataOrderPage();
    BankDataOrderPage bankDataOrderPage = new BankDataOrderPage();

    @BeforeAll
    static void beforeAll() {
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        Configuration.baseUrl = System.getProperty("baseUrl", "https://abo.bvg.de/de/");
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.pageLoadTimeout = 80000;
        Configuration.browserVersion = System.getProperty("version", "99");

        if (config.remote()) {
            //password and user for remote browser
            String user = config.user();
            String password = config.password();
            String remoteUrl = config.remoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = "https://" + user + ":" + password + "@" + remoteUrl;
        }
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}