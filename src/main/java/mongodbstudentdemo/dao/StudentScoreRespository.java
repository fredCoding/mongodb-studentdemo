package mongodbstudentdemo.dao;

import mongodbstudentdemo.entity.StudentScore;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface StudentScoreRespository extends MongoRepository<StudentScore,String>{

    //通过学号查询 科目对应的成绩
    Optional<StudentScore> findOneByStudentNo(Integer studentNo);

    //增加一条信息
    StudentScore insert(StudentScore studentScore);

    //按学号删除一条信息
    void deleteByStudentNo(Integer studentNo);

}
