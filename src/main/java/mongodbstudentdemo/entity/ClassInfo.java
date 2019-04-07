package mongodbstudentdemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "ClassInfo")
public class ClassInfo implements Serializable {

    @Id
    private String id;

    private Integer classNo;

    private String className;

    private String institute;

    private String grade;

    private Integer classStudentNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getClassStudentNum() {
        return classStudentNum;
    }

    public void setClassStudentNum(Integer classStudentNum) {
        this.classStudentNum = classStudentNum;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "id='" + id + '\'' +
                ", classNo=" + classNo +
                ", className='" + className + '\'' +
                ", institute='" + institute + '\'' +
                ", grade='" + grade + '\'' +
                ", classStudentNum=" + classStudentNum +
                '}';
    }
}
