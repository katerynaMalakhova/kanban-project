package UI.steps;

import UI.elements.DashboardElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


public class DashboardPage extends DashboardElements {

    @Step("The user creates project")
    public ProjectPage createProject(String projectName, String projectId, int projectLimit) {
        getCreateNewProjectLink().shouldBe(Condition.visible).hover().click();
        getNewProjectFormNameField().shouldBe(Condition.visible).sendKeys(projectName);
        getNewProjectFormIdField().shouldBe(Condition.visible).sendKeys(projectId);
        getNewProjectFormTaskLimitField().shouldBe(Condition.visible).sendKeys(String.valueOf(projectLimit));
        getNewProjectFormSaveButton().shouldBe(Condition.visible).click();

        return new ProjectPage();
    }

    @Step("The user open project detail page")
    public ProjectPage openProject(String projectId) {
        getProjectLink(projectId).shouldBe(Condition.visible).click();

        return new ProjectPage();
    }

}
