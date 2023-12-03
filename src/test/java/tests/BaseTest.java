package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.Attach.*;
import static java.lang.String.format;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = System.getProperty("base url", "https://afisha.yandex.ru");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("version", "100.0");
        String webDriver = System.getProperty("webDriver","https://user1:1234@selenoid.autotests.cloud/");
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", java.util.Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener(){SelenideLogger.addListener("AllureSelenide", new AllureSelenide());}

    @AfterEach
    void addAttachments() {
        screenshotAs("Last screenshot");
        pageSource();
        addVideo();
        closeWebDriver();
    }
}