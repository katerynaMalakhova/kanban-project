package UI.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

public class BoardElements {
    private final SelenideElement addNewTaskButton = Selenide.$x("(//div[@class='board-add-icon'])[1]");
    private final SelenideElement taskTitleInput = Selenide.$x("//input[@name='title']");
    private final SelenideElement taskDetailInput = Selenide.$x("//textarea[@name='description']");
    private final SelenideElement taskTagSelect = Selenide.$x("//select[@name='tags[]']");
    private final SelenideElement taskColorDropdown = Selenide.$x("//select[@name='color_id']");
    private final SelenideElement taskAssigneeDropdown = Selenide.$x( "//select[@name='owner_id']");
    private final SelenideElement taskPriorityDropdown = Selenide.$x("//select[@name='priority']");
    private final SelenideElement taskDueDateInput = Selenide.$x("//input[@name='date_due']");
    private final SelenideElement taskStartDateInput = Selenide.$x("//input[@name='date_started']");
    private final SelenideElement taskEstimateHoursInput = Selenide.$x("//input[@name='time_estimated']");
    private final SelenideElement taskSpendHoursInput = Selenide.$x("//input[@name='time_spent']");
    private final SelenideElement taskComplexityInput = Selenide.$x("//input[@name='score']");
    private final SelenideElement taskCreateNewCheckbox = Selenide.$x("//input[@name='reference']");
    private final SelenideElement taskSaveButton = Selenide.$x("//button");
    private final List<SelenideElement> taskStickers = Selenide.$$x("//div[@class='task-board-expanded']");
    private final By taskStickerDropdown = By.xpath(".//div[@class='dropdown']");
    private final By taskStickerId = By.xpath(".//div[@class='task-board-header']//strong");
    private final By taskStickerTitle = By.xpath(".//div[@class='task-board-title']/a");
    private final By taskStickerComplexity = By.xpath(".//span[@class='task-score']");
    private final By taskStickerTimeRealToEstimated = By.xpath(".//span[@class='task-time-estimated']");
    private final By taskStickerDueDate = By.xpath(".//span[@class='task-date']");
    private final By taskStickerAssignee = By.xpath(".//span[@class='task-board-assignee']");
    private final By taskStickerPriority = By.xpath(".//span[@class='task-priority']");


    public SelenideElement getAddNewTaskButton() {
        return addNewTaskButton;
    }
    public SelenideElement getTaskTitleInput() {
        return taskTitleInput;
    }

    public SelenideElement getTaskDetailInput() {
        return taskDetailInput;
    }

    public SelenideElement getTaskTagSelect() {
        return taskTagSelect;
    }

    public SelenideElement getTaskColorDropdown() {
        return taskColorDropdown;
    }

    public SelenideElement getTaskAssigneeDropdown() {
        return taskAssigneeDropdown;
    }

    public SelenideElement getTaskPriorityDropdown() {
        return taskPriorityDropdown;
    }

    public SelenideElement getTaskDueDateInput() {
        return taskDueDateInput;
    }

    public SelenideElement getTaskStartDateInput() {
        return taskStartDateInput;
    }

    public SelenideElement getTaskEstimateHoursInput() {
        return taskEstimateHoursInput;
    }

    public SelenideElement getTaskSpendHoursInput() {
        return taskSpendHoursInput;
    }

    public SelenideElement getTaskComplexityInput() {
        return taskComplexityInput;
    }

    public SelenideElement getTaskCreateNewCheckbox() {
        return taskCreateNewCheckbox;
    }

    public SelenideElement getTaskSaveButton() {
        return taskSaveButton;
    }

    public List<SelenideElement> getTaskStickers() {
        return taskStickers;
    }

    public By getTaskStickerDropdown() {
        return taskStickerDropdown;
    }
    public By getTaskStickerId() {
        return taskStickerId;
    }
    public By getTaskStickerTitle() {
        return taskStickerTitle;
    }

    public By getTaskStickerComplexity() {
        return taskStickerComplexity;
    }

    public By getTaskStickerTimeRealToEstimated() {
        return taskStickerTimeRealToEstimated;
    }

    public By getTaskStickerDueDate() {
        return taskStickerDueDate;
    }

    public By getTaskStickerAssignee() {
        return taskStickerAssignee;
    }

    public By getTaskStickerPriority() {
        return taskStickerPriority;
    }
}

