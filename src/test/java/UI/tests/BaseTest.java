package UI.tests;

import DB.models.Comment;
import DB.models.Task;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static utils.EnvProperties.*;

public class BaseTest {
    protected final static String USER_NAME = "user" + Math.random();
    protected final static String USER_PASSWORD = "password";
    protected final static String PROJECT_NAME = "project" + Math.random();
    protected final static Task TASK = new Task("ProjectName", "Description", "admin", "2", "12/12/2023", "01/12/2023", 20, 30, 3);
    protected final static String TASK_TITLE = "task" + Math.random();
    protected final static String COMMENT_TEXT = "comment" + Math.random();
    protected final static Comment COMMENT = new Comment(USER_NAME, COMMENT_TEXT);
    protected final static String PROJECT_ID = "new" + Math.random();
    protected final static int PROJECT_LIMIT = 6;
    @BeforeSuite
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
        );
    }

//    @BeforeMethod
//    public void setUp() {
//        Configuration.browser = BROWSER;
//        Configuration.headless = Boolean.parseBoolean(HEADLESS);
//        Selenide.open(BASE_URL);
//    }

    @AfterMethod
    public void cleanUp() {
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }


}

