package mongodbstudentdemo.dao;

import mongodbstudentdemo.entity.Course;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CourseNoRepository extends MongoRepository<Course,String>{

    //通过课号查询有哪些课程具体信息
    Optional<Course> findOneByCourseNo(Integer courseNo);

    //增加一门课程
    Course insert(Course course);

    //通过课号删除一门课程
    void deleteByCourseNo(Integer courseNo);
}
