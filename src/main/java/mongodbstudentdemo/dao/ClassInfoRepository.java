package mongodbstudentdemo.dao;

import mongodbstudentdemo.entity.ClassInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClassInfoRepository extends MongoRepository<ClassInfo,String>{
    //以班级名称为查询条件，查询班级信息
    Optional<ClassInfo> findOneByClassName(String className);

    //新增一个班级信息
    ClassInfo insert(ClassInfo classInfo);

    //删除一个班级
    void deleteByClassName(String className);
}
