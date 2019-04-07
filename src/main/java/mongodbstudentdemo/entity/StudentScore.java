package mongodbstudentdemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "StudentScore")
public class StudentScore implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private Integer studentNo;

    private Integer courseNo;

    private Integer score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "id='" + id + '\'' +
                ", studentNo=" + studentNo +
                ", courseNo=" + courseNo +
                ", score=" + score +
                '}';
    }
}
