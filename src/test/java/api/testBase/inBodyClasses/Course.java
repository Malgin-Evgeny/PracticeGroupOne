package api.testBase.inBodyClasses;

public class Course {
    public String name;
    public String description;
    public int disciplineId;
    public int teacherId;
    public String startDate;
    public String finishDate;
    public int lessonCost;
    public int percent;
    public int visitsPercent;
    public String type;
    public Course(String name, String description, int disciplineId, int teacherId, String startDate, String finishDate, int lessonCost, int percent, int visitsPercent, String type) {
        this.name = name;
        this.description = description;
        this.disciplineId = disciplineId;
        this.teacherId = teacherId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.lessonCost = lessonCost;
        this.percent = percent;
        this.visitsPercent = visitsPercent;
        this.type = type;
    }
}