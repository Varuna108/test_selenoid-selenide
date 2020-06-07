package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.GooglePage;

import java.net.MalformedURLException;
import java.net.URL;


@Tag("google")
class GoogleSearchTests {

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        final DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("enableVNC", true);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://autotest.su:4444/wd/hub"), caps);
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }


    @Test
    @Description("Positive test with PageObject")
    void successfulSearchWithPO() {
        GooglePage googlePage = new GooglePage();

        googlePage.openUrl();

//        googlePage.typeSearch("lepra");
//
//        googlePage.verifySearchHasResult("Lepra");
    }
}