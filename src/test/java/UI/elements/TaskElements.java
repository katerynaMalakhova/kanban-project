package UI.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

public class TaskElements {

    private final SelenideElement taskTitle = Selenide.$x("//section [@id='task-summary']/h2");
    private final List<SelenideElement> taskComments = Selenide.$$x("//div[@id='comments']");
    private final By taskCommentTitle = By.xpath(".//strong[@class='comment-username']");
    private final By taskCommentContent = By.xpath(".//div[@class='comment-content']//p");
    private final SelenideElement taskCommentAccordion = Selenide.$x("//summary[contains(text(), 'Comments')]");
    private final SelenideElement taskCommentTextarea = Selenide.$x("//textarea[@name='comment']");
    private final SelenideElement taskCommentSaveButton = Selenide.$x("//button");
    private final SelenideElement taskCloseButton = Selenide.$x("//a[@href='/task/3/close']");
    private final SelenideElement taskClosePopupTitle = Selenide.$x("//div[@class='page-header']/h2");
    private final SelenideElement taskClosePopupAlert = Selenide.$x("//p[@class='alert alert-info']");
    private final SelenideElement taskClosePopupYesButton = Selenide.$x("//button[@id='modal-confirm-button']");
    private final SelenideElement taskAlert = Selenide.$x("//div[contains(@class,'alert-success')]");
    private final SelenideElement taskStatus = Selenide.$x("//li/strong[contains(text(),'Status:')]/following-sibling::span");

    public SelenideElement getTaskTitle() {
        return taskTitle;
    }

    public List<SelenideElement> getTaskComments() {
        return taskComments;
    }

    public SelenideElement getTaskCommentTextarea() {
        return taskCommentTextarea;
    }

    public SelenideElement getTaskCommentSaveButton() {
        return taskCommentSaveButton;
    }

    public SelenideElement getTaskCloseButton(String taskId) {
        String path = String.format("//a[@href='/task/%s/close']", taskId);
        return Selenide.$x(path);
    }

    public SelenideElement getTaskCommentAccordion() {return taskCommentAccordion;}

    public SelenideElement getTaskClosePopupTitle() {
        return taskClosePopupTitle;
    }

    public SelenideElement getTaskClosePopupAlert() {
        return taskClosePopupAlert;
    }

    public SelenideElement getTaskClosePopupYesButton() {
        return taskClosePopupYesButton;
    }

    public SelenideElement getTaskAlert() {
        return taskAlert;
    }

    public By getTaskCommentTitle() {
        return taskCommentTitle;
    }

    public By getTaskCommentContent() {
        return taskCommentContent;
    }

    public SelenideElement getTaskStatus() {
        return taskStatus;
    }
}
