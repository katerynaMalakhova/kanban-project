package baseTest;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DashboardPage {

//   private final SelenideElement createNewProjectLink = Selenide.$x("(//span[@class='title'])[1]");
   private final SelenideElement createNewProjectLink = Selenide.$x("(//a[@href='/project/create'])[2]");

    private final SelenideElement newProjectFormNameField = Selenide.$x("//input[@name='name']");

    private final SelenideElement newProjectFormIdField = Selenide.$x("//input[@name='identifier']");

    private final SelenideElement newProjectFormTaskLimitField = Selenide.$x("//input[@name='task_limit']");

    private final SelenideElement newProjectFormSaveButton = Selenide.$x("//form//button");

    @Step("The user creates project")
    public ProjectPage createProject(String projectName, String projectId, int projectLimit) {
        getCreateNewProjectLink().shouldBe(Condition.visible).hover().click();
        getNewProjectFormNameField().shouldBe(Condition.visible).sendKeys(projectName);
        getNewProjectFormIdField().shouldBe(Condition.visible).sendKeys(projectId);
        getNewProjectFormTaskLimitField().shouldBe(Condition.visible).sendKeys(String.valueOf(projectLimit));
        getNewProjectFormSaveButton().shouldBe(Condition.visible).click();

        return new ProjectPage();
    }


    public SelenideElement getCreateNewProjectLink() {
        return createNewProjectLink;
    }

    public SelenideElement getNewProjectFormNameField() {
        return newProjectFormNameField;
    }

    public SelenideElement getNewProjectFormIdField() {
        return newProjectFormIdField;
    }

    public SelenideElement getNewProjectFormTaskLimitField() {
        return newProjectFormTaskLimitField;
    }

    public SelenideElement getNewProjectFormSaveButton() {
        return newProjectFormSaveButton;
    }

}
