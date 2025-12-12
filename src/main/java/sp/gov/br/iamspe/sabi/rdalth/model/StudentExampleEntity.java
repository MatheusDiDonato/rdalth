package sp.gov.br.iamspe.sabi.rdalth.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Objects;

@RedisHash("Student")
public class StudentExampleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum Gender {
        MALE, FEMALE
    }

    @Id
    private String id;
    private String name;
    private Gender gender;
    private int grade;

    public StudentExampleEntity() {
    }

    public StudentExampleEntity(String id, String name, Gender gender, int grade) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentExampleEntity studentExampleEntity = (StudentExampleEntity) o;
        return grade == studentExampleEntity.grade && Objects.equals(id, studentExampleEntity.id) && Objects.equals(name, studentExampleEntity.name) && gender == studentExampleEntity.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", grade=" + grade +
                '}';
    }
}

