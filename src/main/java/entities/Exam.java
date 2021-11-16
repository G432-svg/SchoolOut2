package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Exam {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private LocalDate date;
    private int weight;
    private int total;
    @ManyToOne
    private Module module;
    @ManyToOne
    private Exam examGroup;
    @OneToMany(mappedBy = "examGroup",cascade = {CascadeType.MERGE})
    private List<Exam> subExams;

    public Exam() {
    }

    public Exam(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Exam getExamGroup() {
        return examGroup;
    }

    public void setExamGroup(Exam examGroup) {
        this.examGroup = examGroup;
    }

    public List<Exam> getSubExams() {
        return subExams;
    }

    public void setSubExams(List<Exam> subExams) {
        this.subExams = subExams;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", weight=" + weight +
                ", total=" + total +
                ", module=" + module +
                ", examGroup=" + examGroup +
                ", subExams=" + subExams +
                '}';
    }
}