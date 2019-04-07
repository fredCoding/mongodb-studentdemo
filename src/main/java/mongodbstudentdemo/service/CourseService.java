package mongodbstudentdemo.service;


import mongodbstudentdemo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class CourseService {

    @Autowired
    MongoTemplate mongoTemplate;

    //通过课程号更新课程信息
    public Course updateBySetAndCourseNo(Integer courseNo,Course course){

        Update update = new Update();

        if(course.getCourseName() != null)
            update.set("courseName",course.getCourseName());
        if (course.getCreditHour() != 0){
            update.set("creditHour",course.getCreditHour());
        }
        if (course.getCourseHour() != null)
            update.set("courseHour",course.getCourseHour());

        //判断Course对象是否有到bean属性上，没有则直接返回nll
        if (update.toString().equals("{ }"))
            return null;

        Query query = new Query().addCriteria(Criteria.where("courseNo").is(courseNo));


        Course backCourse = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), Course.class);
        return backCourse;
    }


}
