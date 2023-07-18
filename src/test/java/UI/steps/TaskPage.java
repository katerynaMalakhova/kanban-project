package UI.steps;

import UI.elements.TaskElements;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import DB.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class TaskPage extends TaskElements {

    @Step("The user adds comment to the task")
    public TaskPage addComment(String comment) {
        getTaskCommentAccordion().shouldBe(Condition.visible).click();
        getTaskCommentTextarea().shouldBe(Condition.visible).sendKeys(comment);
        getTaskCommentSaveButton().shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Get comments added to the task")
    public List<Comment> getComments() {

        List<Comment> comments = new ArrayList<>();

        for (int i = 0; i < getTaskComments().size(); i++) {
            Comment comment = new Comment();

            comment.setCommentAuthor(getTaskComments().get(i).find(getTaskCommentTitle()).getText());
            comment.setCommentContent(getTaskComments().get(i).find(getTaskCommentContent()).getText());

            comments.add(comment);
        }

        return comments;
    }

    @Step("The user closes the task")
    public TaskPage closeTask(String taskId) {
        getTaskCloseButton(taskId).scrollIntoView(true).shouldBe(Condition.visible).click();

//        getTaskCloseButton(taskId).shouldBe(Condition.visible).click();
        getTaskClosePopupTitle().shouldBe(Condition.visible).shouldHave(Condition.exactText("Close a task"));
        getTaskClosePopupYesButton().shouldBe(Condition.visible).click();

        return this;
    }

}
