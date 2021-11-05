package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Module {
    @Id
    private long id;
    private String name;
    private String description;
    @ManyToOne
    private Course course;
    @OneToMany
    public List<Exam> exams;

    public Module() {
    }

    public Module(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Module(String name) {
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", course=" + course +
                ", exams=" + exams +
                '}';
    }
}