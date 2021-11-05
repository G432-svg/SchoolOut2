package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String familyName;
    @Enumerated
    private Gender gender;
    @ManyToOne
    private Course courseActive;
    @OneToMany
    private List<Course> courseHistory;


    public Person() {
    }

    public Person(int id, String firstName, String familyName) {
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
    }

    public Person(String firstName, String familyName, Gender gender) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.gender = gender;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Course getCourseActive() {
        return courseActive;
    }

    public void setCourseActive(Course courseActive) {
        this.courseActive = courseActive;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", gender=" + gender +
                ", courseActive=" + courseActive +
                '}';
    }
}
