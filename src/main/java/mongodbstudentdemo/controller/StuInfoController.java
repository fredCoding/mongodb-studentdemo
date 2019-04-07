package mongodbstudentdemo.controller;

import mongodbstudentdemo.dao.StuInfoRepository;
import mongodbstudentdemo.entity.StuInfo;
import mongodbstudentdemo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//通过注解controller层直接向前端json格式数据
@RestController
public class StuInfoController {

    @Autowired
    StuInfoRepository stuInfoRepository;

    @Autowired
    StudentInfoService studentInfoService;

    //通过学号查询所有
    @GetMapping("stuentInfo/{no}")
    public List<StuInfo> findAll(@PathVariable("no") Integer id){
        List<StuInfo> studentInfos = stuInfoRepository.findAllByStudentNo(id);
        System.out.println(studentInfos);
        return studentInfos;
    }

    //通过Object_id查询
    @GetMapping("stuentInfo")
    public StuInfo findById(String str){
        Optional<StuInfo> hasStudentInfo = stuInfoRepository.findById(str);
        StuInfo studentInfo = hasStudentInfo.get();
        System.out.println(studentInfo);
        return studentInfo;
    }

    //插入
    @PostMapping("stuentInfo")
    public StuInfo insert(StuInfo stuInfo){
        return stuInfoRepository.insert(stuInfo);
    }

    //发起删除请求
    @DeleteMapping("stuentInfo/{studentNo}")
    public void deleteByStudentNo(@PathVariable("studentNo") Integer studentNo){
        stuInfoRepository.deleteByStudentNo(studentNo);
    }


    //更新操作
    @PutMapping("stuentInfo")
    public StuInfo update(Integer studentNo,StuInfo stuInfo){
        StuInfo backStudentInfo = studentInfoService.updateBySetAndStudentNo(studentNo, stuInfo);
        return backStudentInfo;
    }

}
