package UI;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

public class BaseTest {

//    @BeforeSuite
//    static void setupAllureReports() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(true)
//        );
//    }

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Selenide.open("http://localhost/login");
    }

    @AfterSuite
    public void cleanUp() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }


}

