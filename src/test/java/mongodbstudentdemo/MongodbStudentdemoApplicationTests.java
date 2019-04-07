package mongodbstudentdemo;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import mongodbstudentdemo.dao.ClassInfoRepository;
import mongodbstudentdemo.dao.CourseNoRepository;
import mongodbstudentdemo.dao.StuInfoRepository;
import mongodbstudentdemo.dao.StudentScoreRespository;
import mongodbstudentdemo.entity.ClassInfo;
import mongodbstudentdemo.entity.Course;
import mongodbstudentdemo.entity.StuInfo;
import mongodbstudentdemo.entity.StudentScore;
import mongodbstudentdemo.service.ClassInfoService;
import mongodbstudentdemo.service.CourseService;
import mongodbstudentdemo.service.StudentInfoService;
import mongodbstudentdemo.service.StudentScoreService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.xml.ws.Service;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbStudentdemoApplicationTests {


	@Autowired
	StuInfoRepository stuInfoRepository;

	@Autowired
	StudentScoreRespository studentScoreRespository;

	@Autowired
	StudentScoreService studentScoreService;

	@Test
	public void contextLoads() throws SQLException {
		StuInfo stuInfo = new StuInfo();
		stuInfo.setStudentNo(201604227);
		stuInfo.setStudentName("刘赛川");
		stuInfo.setSex("male");
		stuInfo.setBirthday("1997-04-19");
		stuInfo.setNation("汉");
		stuInfo.setClassNo(3);

		StuInfo stuInfo1 = stuInfoRepository.insert(stuInfo);
		System.out.println(stuInfo1);

//		Optional<StuInfo> byId = stuInfoRepository.findById("5c924690480ecdd23b78bb47");
//		List<StuInfo> allByStudentNo = stuInfoRepository.findAllByStudentNo(201604225);
//		System.out.println(allByStudentNo);

//		boolean present = byId.isPresent();
//		System.out.println(present);

	}

	@Test
	public void deleteStudentInfo(){
		stuInfoRepository.deleteByStudentNo(201604227);
	}


	//测试StudentScoreRespository
	@Test
	public void findOne(){
		Optional<StudentScore> hasStudentScore = studentScoreRespository.findOneByStudentNo(201604225);
		System.out.println(hasStudentScore.isPresent());
		System.out.println(hasStudentScore.get());
	}

	@Test
	public void insertOne(){
		StudentScore studentScore = new StudentScore();
		studentScore.setStudentNo(201604227);
		studentScore.setCourseNo(108);
		studentScore.setScore(96);

		studentScoreRespository.insert(studentScore);

	}

	@Test
	public void deleteOne(){
		studentScoreRespository.deleteByStudentNo(201604227);
	}


	@Test
	public void update(){
		StudentScore studentScore = new StudentScore();
		studentScore.setId("5c924a4b480ecdd23b78bb4f");
		studentScore.setScore(91);

		studentScoreRespository.save(studentScore);

	}

	@Test
	public void testjsonconvertBean(){
		StudentScore studentScore = new StudentScore();
		studentScore.setScore(86);

		StudentScore studentScore1 = studentScoreService.updateByStudentNo(201604225, studentScore);
		System.out.println(studentScore1);

	}

	@Test
	public  void testupdateSet(){
		StudentScore studentScore = new StudentScore();
		studentScore.setScore(88);

		StudentScore studentScore1 = studentScoreService.updateBysetStudentNo(201604226, studentScore);
		System.out.println(studentScore1);

	}



	//对课程信息类进行增删改查测试
	@Autowired
	CourseNoRepository courseNoRepository;

	@Autowired
	CourseService courseService;
	@Test
	public void testCourseNoRepository(){
		//查
		Optional<Course> courseNo = courseNoRepository.findOneByCourseNo(105);
		System.out.println(courseNo);

		//插入
		Course course = new Course();
		course.setCourseName("计算机组成原理");
		course.setCourseNo(100);
		course.setCreditHour(3);
		course.setCourseNo(56);
		course.setCourseHour(48);

		Course insert = courseNoRepository.insert(course);
		System.out.println(insert);

		//删除
		courseNoRepository.deleteByCourseNo(56);

	}

	@Test
	public void testupateMongoTemplate(){
		Course course = new Course();
		course.setCreditHour(7);
		course.setCourseName("计算机组成原理");
		course.setCourseHour(23);

		Course backCourse = courseService.updateBySetAndCourseNo(106, course);
		System.out.println(backCourse);

	}

	//对班级信息进行测试
	@Autowired
	ClassInfoRepository classInfoRepository;

	@Autowired
	ClassInfoService classInfoService;
	@Test
	public void testClassInfoRepository(){
		//测试查询
		Optional<ClassInfo> classInfo = classInfoRepository.findOneByClassName("信息1班");
		System.out.println(classInfo);

		//新增一个班级
		ClassInfo classInfo1 = new ClassInfo();
		classInfo1.setClassNo(1);
		classInfo1.setClassName("电子1班");
		classInfo1.setInstitute("机械学院");
		classInfo1.setGrade("2018");
		classInfo1.setClassStudentNum(29);
		ClassInfo backClassinfo = classInfoRepository.insert(classInfo1);
		System.out.println(backClassinfo);

		//删除一个班级
		classInfoRepository.deleteByClassName("信息2班");
	}

	@Test
	public void testClassInfoService(){
		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassNo(2);
		classInfo.setInstitute("电子学院");
		classInfo.setGrade("2018");
		classInfo.setClassStudentNum(55);


		ClassInfo backclassInfo = classInfoService.updateByClassName("信息1班",classInfo);
		System.out.println(backclassInfo);

	}

	//测试StudentInfo

	@Autowired
	StudentInfoService studentInfoService;

	@Test
	public void testupdateByset(){
		StuInfo stuInfo = new StuInfo();
		stuInfo.setStudentName("刘赛川");
		stuInfo.setNation("藏");
		stuInfo.setClassNo(3);

		StuInfo backstuInfo = studentInfoService.updateBySetAndStudentNo(201604225, stuInfo);
		System.out.println(backstuInfo);
	}


}
