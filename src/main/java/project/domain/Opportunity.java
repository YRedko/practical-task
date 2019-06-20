package project.domain;

import java.time.LocalDate;

public class Opportunity {

    private String name;
    private String description;
    private OpportunityTypeEnum type;
    private float probability;
    private String project;
    private Employee sales;
    private LocalDate start;
    private LocalDate end;

    public Opportunity(){}

    public Opportunity(String name, String description, OpportunityTypeEnum type, float probability, String project, Employee sales, LocalDate start, LocalDate end) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.probability = probability;
        this.project = project;
        this.sales = sales;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OpportunityTypeEnum getType() { return type; }

    public void setType(OpportunityTypeEnum type) { this.type = type; }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Employee getSales() {
        return sales;
    }

    public void setSales(Employee sales) {
        this.sales = sales;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
