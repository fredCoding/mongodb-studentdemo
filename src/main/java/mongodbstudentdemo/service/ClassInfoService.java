package mongodbstudentdemo.service;

import mongodbstudentdemo.entity.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import sun.plugin2.os.windows.FLASHWINFO;

@Component
public class ClassInfoService {
    @Autowired
    MongoTemplate mongoTemplate;

    //更新班级信息
    public ClassInfo updateByClassName(String className,ClassInfo classInfo){
        Update update = new Update();

        if(classInfo.getClassNo() != null)
            update.set("classNo",classInfo.getClassNo());
        if(classInfo.getClassName() != null)
            update.set("className",classInfo.getClassName());
        if(classInfo.getInstitute() != null)
            update.set("institute",classInfo.getInstitute());
        if (classInfo.getGrade() != null)
            update.set("grade",classInfo.getGrade());
        if (classInfo.getClassStudentNum() != null)
            update.set("classStudentNum",classInfo.getClassStudentNum());

        if (update.toString().equals("{ }"))
            return null;

        Query query = new Query();
        query.addCriteria(Criteria.where("className").is(className));

        ClassInfo backClassInfo = mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true).upsert(false), ClassInfo.class);

        return  backClassInfo;
    }


}
