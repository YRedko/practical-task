package project.domain;

import project.domain.enums.OpportunityType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "opportunity_type", columnDefinition = "enum('POTENTIAL','LEAD','CLOSER')")
    @Enumerated(EnumType.STRING)
    private OpportunityType type;
    private float probability;
    private String project;
    @ManyToOne
    private Employee sales;
    private Date start;
    @Column(name = "end_date")
    private Date end;

    public Opportunity(){}

    public Opportunity(String name, String description, OpportunityType type, float probability, String project, Date start, Date end) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.probability = probability;
        this.project = project;
        this.start = start;
        this.end = end;
    }

    public Opportunity(String name, String description, OpportunityType type, float probability, String project, Employee sales, Date start, Date end) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.probability = probability;
        this.project = project;
        this.sales = sales;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public OpportunityType getType() { return type; }

    public void setType(OpportunityType type) { this.type = type; }

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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
