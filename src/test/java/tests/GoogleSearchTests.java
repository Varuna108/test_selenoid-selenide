package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.GooglePage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


@Tag("google")
class GoogleSearchTests {

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = "chrome";
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");
        browser.setVersion("66");
        browser.setCapability("enableVNC", true);
        RemoteWebDriver driver = new RemoteWebDriver(URI.create("http://autotest.su:4444/wd/hub").toURL(), browser);
        setWebDriver(driver);
        driver.manage().window().setSize(new Dimension(1920, 1080));
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