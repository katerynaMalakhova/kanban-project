package UI.elements;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


public class DashboardElements {

    //   private final SelenideElement createNewProjectLink = Selenide.$x("(//span[@class='title'])[1]");
    private final SelenideElement createNewProjectLink = Selenide.$x("(//a[@href='/project/create'])[2]");
    private final SelenideElement newProjectFormNameField = Selenide.$x("//input[@name='name']");
    private final SelenideElement newProjectFormIdField = Selenide.$x("//input[@name='identifier']");
    private final SelenideElement newProjectFormTaskLimitField = Selenide.$x("//input[@name='task_limit']");
    private final SelenideElement newProjectFormSaveButton = Selenide.$x("//form//button");
    private final SelenideElement dashboardTitle = Selenide.$x("//span[@class='title']");
    private SelenideElement projectLink;

    public SelenideElement getDashboardTitle() {
        return dashboardTitle;
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

    public SelenideElement getProjectLink(String projectId) {
        String path = String.format("//span/a[contains(@href, '/board/%s')]", projectId);
        return Selenide.$x(path);
    }
}
