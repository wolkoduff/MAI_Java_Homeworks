package ru.mai.sample.entity;

public class Projects {
    private String ProjectName;         // Наименование проекта
    private String ProjectDuration;     // Длительность проекта
    private String ProjectDateBegin;    // Дата начала проекта
    private String ProjectDateComplete; // Дата завершения проекта

    private int ProjectId;

    public Projects(){
        super();
        ProjectId = -1;
    }

    public Projects(String PName){
        this();
        this.ProjectName = PName;
    }

    public Projects(String PName, String PDure, String PDStart){
        this.ProjectName = PName;
        this.ProjectDuration = PDure;
        this.ProjectDateBegin = PDStart;
    }

    public Projects(int PId, String PName, String PDure, String PDStart, String PDComp){
        this.ProjectId = PId;
        this.ProjectName = PName;
        this.ProjectDuration = PDure;
        this.ProjectDateBegin = PDStart;
        this.ProjectDateComplete = PDComp;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getProjectDuration() {
        return ProjectDuration;
    }

    public void setProjectDuration(String projectDuration) {
        ProjectDuration = projectDuration;
    }

    public String getProjectDateBegin() {
        return ProjectDateBegin;
    }

    public void setProjectDateBegin(String projectDateBegin) {
        ProjectDateBegin = projectDateBegin;
    }

    public String getProjectDateComplete() {
        return ProjectDateComplete;
    }

    public void setProjectDateComplete(String projectDateComplete) {
        ProjectDateComplete = projectDateComplete;
    }
}
