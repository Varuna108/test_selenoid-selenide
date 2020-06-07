package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.CustomWebDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static helpers.AttachmentsHelper.*;

public class TestBase {

//    @BeforeEach
//    void setUp() throws MalformedURLException {
//        final DesiredCapabilities caps = DesiredCapabilities.chrome();
//        caps.setCapability("enableVNC", true);
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://autotest.su:4444/wd/hub"), caps);
//        WebDriverRunner.setWebDriver(driver);
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
//        Configuration.browser = CustomWebDriver.class.getName();
//    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
        System.setProperty("selenoid_url", "autotest.su");

        Configuration.browser = CustomWebDriver.class.getName();
    }



    @AfterEach
    void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachBrowserConsoleLogs();
        attachVideo();
        closeWebDriver();
    }
}

