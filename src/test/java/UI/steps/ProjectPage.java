package UI.steps;

import UI.elements.ProjectElements;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import DB.models.Task;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ProjectPage extends ProjectElements {

    @Step("The user open task detail page")
    public TaskPage openTask(String taskId) {
        getTasklink(taskId).shouldBe(Condition.visible).click();
        return new TaskPage();
    }

    @Step("The user creates task")
    public ProjectPage createTask(Task task) throws ParseException {
        getAddNewTaskButton().shouldBe(Condition.visible).click();
        getTaskTitleInput().shouldBe(Condition.visible).sendKeys(task.getTaskTitle());
        getTaskDetailInput().shouldBe(Condition.visible).sendKeys(task.getTaskDetail());
        getTaskAssigneeDropdown().shouldBe(Condition.visible).selectOption(task.getTaskAssignee());
        getTaskPriorityDropdown().shouldBe(Condition.visible).selectOption(task.getTaskPriority());
//        getTaskDueDateInput().shouldBe(Condition.visible).sendKeys(task.getTaskDueDate());
//        getTaskStartDateInput().shouldBe(Condition.visible).sendKeys(task.getTaskStartDate());
        getTaskEstimateHoursInput().shouldBe(Condition.visible).sendKeys(Integer.toString(task.getTaskEstimateHours()));
        getTaskSpendHoursInput().shouldBe(Condition.visible).sendKeys(Integer.toString(task.getTaskSpendHours()));
        getTaskComplexityInput().shouldBe(Condition.visible).sendKeys(Integer.toString(task.getTaskComplexity()));
        getTaskCreateNewCheckbox().shouldBe(Condition.visible).click();//????
        getTaskSaveButton().shouldBe(Condition.visible).click();

        return this;
    }

    @Step("Get created tasks")
    public List<Task> getTasks() { //improvements needed

        Pattern estimateHoursPattern = Pattern.compile("[0-9]+\\/.*");
        Pattern spentHoursPattern = Pattern.compile(".*[0-9]+h");

        List<Task> tasks = new ArrayList<>();
        List<SelenideElement> stickers = getTaskStickers();

        for (int i = 0; i < getTaskStickers().size(); i++) {
            Task task = new Task();
            task.setTaskId(getTaskStickers().get(i).find(getTaskStickerId()).getText().replace("#","")); //.substring(1));
            task.setTaskTitle(getTaskStickers().get(i).find(getTaskStickerTitle()).getText());
            task.setTaskAssignee(getTaskStickers().get(i).find(getTaskStickerAssignee()).getText());
            task.setTaskPriority(getTaskStickers().get(i).find(getTaskStickerPriority()).getText());
////
//           task.setTaskDueDate(stickers.get(i).find(getTaskStickerDueDate()).getText());
//            task.setTaskEstimateHours(Integer.valueOf(estimateHoursPattern.matcher(stickers.get(i).find(getTaskStickerTimeRealToEstimated()).getText()).group(1)));
//            task.setTaskSpendHours(Integer.valueOf(spentHoursPattern.matcher(stickers.get(i).find(getTaskStickerTimeRealToEstimated()).getText()).group(1)));
//            task.setTaskComplexity(Integer.valueOf(stickers.get(i).find(getTaskStickerComplexity()).getText()));

            tasks.add(task);
        }
        return tasks;
    }
}

