package mongodbstudentdemo.dao;


import mongodbstudentdemo.entity.StuInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StuInfoRepository extends MongoRepository<StuInfo, String> {

    //通过学号查找学生信息
    List<StuInfo> findAllByStudentNo(Integer studentNo);

    //通过Object_id查找学生信息
    Optional<StuInfo> findById(String s);

    //插入一条学生信息
    StuInfo insert(StuInfo stuInfo);

    //删除一条学生信息
    void deleteByStudentNo(Integer studentNo);
}
