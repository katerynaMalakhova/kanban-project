package baseTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.Comment;
import models.Task;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TaskPage {

    private final SelenideElement taskTitle = Selenide.$x("//section [@id='task-summary']/h2");

    private final List<SelenideElement> taskComments = Selenide.$$x("//div[@id='comments']");
    private final By taskCommentTitle = By.xpath(".//div[@id='comment-title']");
    private final By taskCommentContent = By.xpath(".//div[@id='comment-content']");

    private final SelenideElement taskCommentTextarea = Selenide.$x("//textarea[@name='comment']");
    private final SelenideElement taskCommentSaveButton = Selenide.$x("//button");


    private final SelenideElement taskCloseButton = Selenide.$x("//a[@href='/task/3/close']");

    private final SelenideElement taskClosePopupTitle = Selenide.$x("//div[@class='page-header']/h2");
    private final SelenideElement taskClosePopupAlert = Selenide.$x("//p[@class='alert alert-info']");
    private final SelenideElement taskClosePopupYesButton = Selenide.$x("//button[@id='modal-confirm-button']");
    private final SelenideElement taskAlert = Selenide.$x("//div[contains(@class,'alert-success')]");
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

    public SelenideElement getTaskCloseButton() {
        return taskCloseButton;
    }

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

    @Step("The user adds comment to the task")
    public TaskPage addComment() {
        getTaskCommentTextarea().shouldBe(Condition.visible).sendKeys("comment");
        getTaskCommentSaveButton().shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Get comments added to the task")
    public List<Comment> getComments() {

        List<Comment> comments = new ArrayList<>();

        for (int i = 0; i < getTaskComments().size(); i++) {
            Comment comment = new Comment();

            comment.setCommentAuthor(getTaskComments().get(i).find(taskCommentTitle).getText());
            comment.setCommentContent(getTaskComments().get(i).find(taskCommentContent).getText());

            comments.add(comment);
        }

        return comments;
    }

    @Step("The user closes the task")
    public TaskPage closeTask() {
        getTaskCloseButton().shouldBe(Condition.visible).click();
        getTaskClosePopupTitle().shouldBe(Condition.visible).shouldHave(Condition.exactText("Close a task"));
        getTaskClosePopupYesButton().shouldBe(Condition.visible).click();

        return this;
    }

}
