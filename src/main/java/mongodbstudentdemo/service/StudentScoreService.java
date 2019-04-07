package mongodbstudentdemo.service;


import com.sun.org.apache.bcel.internal.generic.NEW;
import mongodbstudentdemo.entity.StudentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import sun.awt.image.IntegerComponentRaster;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class StudentScoreService{

    @Autowired
    MongoTemplate mongoTemplate;

    //会直接替换原有数据
    public StudentScore updateByStudentNo(Integer studentNo,StudentScore studentScore){



        Query query = new Query();
        query.addCriteria(Criteria.where("studentNo").is(studentNo));


        Optional<StudentScore> updateResult = mongoTemplate.update(StudentScore.class).matching(query).replaceWith(studentScore).as(StudentScore.class).findAndReplace();
        if(updateResult.isPresent()){
            return updateResult.get();
        }

        return null;
    }

    //和本地$set修饰效果一致
    public StudentScore updateBysetStudentNo(Integer studentNo,StudentScore studentScore){

        Update update = new Update();

        if(studentScore.getScore() !=  null)
            update.set("score",studentScore.getScore());
        if (studentScore.getCourseNo() != null)
            update.set("courseNo",studentScore.getCourseNo());

        if (update.toString().equals("{ }"))
            return null;

        Query query = new Query().addCriteria(Criteria.where("studentNo").is(studentNo));

        StudentScore studentScore_back = mongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true).upsert(false),StudentScore.class);

        return studentScore_back;
    }



}
