package mongodbstudentdemo.service;

import mongodbstudentdemo.entity.StuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoService {
    @Autowired
    MongoTemplate mongoTemplate;

    //通过学号进行更新学生信息
    public StuInfo updateBySetAndStudentNo(Integer StudentNo,StuInfo stuInfo){

        Update update = new Update();
        if (stuInfo.getStudentName() != null)
            update.set("studentName",stuInfo.getStudentName());
        if (stuInfo.getSex() != null)
            update.set("sex",stuInfo.getSex());
        if (stuInfo.getBirthday() != null)
            update.set("birthday",stuInfo.getBirthday());
        if (stuInfo.getNation() != null)
            update.set("native",stuInfo.getNation());
        if (stuInfo.getClassNo() != null)
            update.set("classNo",stuInfo.getClassNo());

        if (update.toString().equals("{ }"))
            return null;

        Query query = new Query().addCriteria(Criteria.where("studentNo").is(StudentNo));

        StuInfo backStuInfo = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), StuInfo.class);
        return backStuInfo;
    }


}
