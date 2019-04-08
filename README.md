# mongodb-studentdemo
基于springboot 2.1.3启动maven，通过springdata提供的MongoRepository<T,ID>接口进行增删查，通过注入MongoTemplate类进行更新操作
执行插入语句时会自动创建数据库和对应的一个文档但有局限性:
手动创建一个studentManagerDemo数据库并执行以下四个初始化数据文档命令:

db.stuInfo.insert([
                    {studentNo:201604226,studentName:"李三",sex:"male",birthday:"2000-05-15",native:"汉",classNo:4},
                    {studentNo:201604225,studentName:"李雷",sex:"male",birthday:"1998-04-15",native:"汉",classNo:4}       
                
]);

db.course.insert([
                    {courseNo:105,courseName:"计算机网络",creditHour:3.5,courseHour:48}, 
                    {courseNo:106,courseName:"毛概",creditHour:6,courseHour:50},
                    {courseNo:107,courseName:"汇编",creditHour:3,courseHour:40},   

])

db.ClassInfo.insert([
                {classNo:1,className:"电子1班",institute:"信息科学工程学院",grade:"2016",classStudentNum:38},
                {classNo:2,className:"信息2班",institute:"信息科学工程学院",grade:"2018",classStudentNum:40}

])

db.StudentScore.insert([
                         {studentNo:201803555,courseNo:107,score:85},
                         {studentNo:201700335,courseNo:105,score:90}
                         
])

