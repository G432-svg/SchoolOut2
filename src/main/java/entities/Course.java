package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String code;
    private String imageURL;
    boolean active;
    @OneToMany(mappedBy = "course",cascade = {CascadeType.PERSIST})
    public List<Module> modules;
    @Temporal(value = TemporalType.DATE)
    private Date date;

    public Course() {
    }

    public Course(String name) {
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

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", active=" + active +
                ", modules=" + modules +
                '}';
    }
}