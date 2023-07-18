package DB.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task extends Object{
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
    private String taskId;
    private String taskTitle;
    private String taskDetail;
    private String taskAssignee;
    private String taskPriority;
    private String taskDueDate;
    private String taskStartDate;
    private int taskEstimateHours;
    private int taskSpendHours;
    private int taskComplexity;

    public Task(){}

    public Task(String taskTitle, String taskDetail, String taskAssignee, String taskPriority, String taskDueDate, String taskStartDate, int taskEstimateHours, int taskSpendHours, int taskComplexity) {
        this.taskTitle = taskTitle;
        this.taskDetail = taskDetail;
        this.taskAssignee = taskAssignee;
        this.taskPriority = taskPriority;
        this.taskDueDate = taskDueDate;
        this.taskStartDate = taskStartDate;
        this.taskEstimateHours = taskEstimateHours;
        this.taskSpendHours = taskSpendHours;
        this.taskComplexity = taskComplexity;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public String getTaskPriority() {
        return taskPriority;
    }

    public String getTaskDueDate() throws ParseException {
        return simpleDateFormat.parse(taskDueDate).toString();
    }

    public String getTaskStartDate() throws ParseException {
        return simpleDateFormat.parse(taskStartDate).toString();
    }

    public int getTaskEstimateHours() {
        return taskEstimateHours;
    }

    public int getTaskSpendHours() {
        return taskSpendHours;
    }

    public int getTaskComplexity() {
        return taskComplexity;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public void setTaskStartDate(String taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public void setTaskEstimateHours(int taskEstimateHours) {
        this.taskEstimateHours = taskEstimateHours;
    }

    public void setTaskSpendHours(int taskSpendHours) {
        this.taskSpendHours = taskSpendHours;
    }

    public void setTaskComplexity(int taskComplexity) {
        this.taskComplexity = taskComplexity;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task)
        {
            Task c = (Task) obj;
            if ( this.taskTitle.equals(c.taskTitle)&&
                    this.taskAssignee.equals(c.taskAssignee)
//                    this.taskPriority == c.taskPriority &&
//                    this.taskDueDate.equals(c.taskDueDate)&&
//                    this.taskEstimateHours == c.taskEstimateHours &&
//                    this.taskSpendHours == c.taskSpendHours &&
//                    this.taskComplexity == c.taskComplexity
            )
                return true;
        }
            return false;
    }


}
