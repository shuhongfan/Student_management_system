# 基于Java的教务管理系统、学生管理系统、课表查询系统  (Spring、SpringBoot、thymeleaf)

- 基于Spring的教务管理系统、学生管理系统、课表查询系统  ，包含数据库文件

- 本作品主要实现了一个课表查询系统，采用了SSM（Spring + SpringMVC + MyBatis）的基础架构。

- 后端使用Maven 进行包管理，使用spring-boot框架、模板引擎使用thymeleaf、web模块使用springMVC、数据库连接池使用Druid、数据库访问使用mybatis-plus、工具包使用hutool。前端使用H-ui模板，结合Timetables展示课程表。

- 系统能够实现用户的登录退出，教室、班级、院系、地点、教工、学生、用户、课程、课程表的分页展示、增加、删除（批量）、修改、根据条件查询，排课（课程表增删改查）、课程表通过表格展示（可以通过教师、班级、学年、学期进行筛选）。

- 并且使用拦截器通过session判断用户是否登录。 

- 本作品是一个前后端不分离的课程表查询系统，基于SSM（Spring + SpringMVC + MyBatis），拥有信息管理和课表展示功能。

- 后端使用spring-boot作为基础，使用thymeleaf（基于Servlet）作为服务器端Java模板引擎。使用SpringMVC（spring内置的MVC框架，底层就是Servlet，它解决WEB开发中常见的问题(参数接收、文件上传、表单验证、国际化等等)，而且使用简单，与Spring无缝集成。支持 RESTful风格的URL请求）解决页面代码和后台代码的分离，降低代码的耦合性。使用mybatis-plus（一个 Mybatis 的增强工具，在 Mybatis 的基础上只做增强不做改变，为简化开发、提高效率而生），它已经封装好了一些crud方法，我们不需要再写xml了，直接调用这些方法就行，就类似于JPA。数据库使用MySQL数据库，数据库数据库连接池使用druid(Druid为监控而生的数据库连接池, 是Java语言中最好的数据库连接池)。使用Lombok在JavaBean中通过添加注解的方式，不需要为类编写getter/setter方法,也不需要编写构造器、equals等方法，同时可以自动化日志变量。同时引用hutool工具包，它能为我们自动生成验证码、格式化日期以及简化JDBC的操作。

- 前台使用H-ui 前端框架模板，它包含后台基本的增删改查页面，我们只要使用thymeleaf模板引擎循环替换H-UI模板的内容，并且更改静态文件路径，在springMVC的控制器中注册路由并且返回页面就能使用浏览器正常访问。课表的展示使用Timetables.js插件，它通过传入一个二维数组来展示课表，发送ajax请求从服务器获取课程表调用change方法进行展示。

- 系统能够实现用户的登录退出，教室、班级、院系、地点、教工、学生、用户、课程、课程表的分页展示、增加、删除（批量）、修改、根据条件查询，排课（课程表增删改查）、课程表通过表格展示（可以通过教师、班级、学年、学期进行筛选）。并且使用拦截器通过session判断用户是否登录，未登录用户跳转到登录页面。

  ![1652329782064](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329782064.png)

  ![1652329947249](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329947249.png)

  ![1652329862647](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329862647.png)

  ![1652329975589](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329975589.png)

  ![1652329990007](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329990007.png)

  ![1652329994439](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329994439.png)

  ![1652329999015](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329999015.png)

  ![1652329985016](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329985016.png)

  ![1652329980102](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329980102.png)

  ![1652329969252](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329969252.png)

  ![1652329871310](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329871310.png)

  ![1652330033576](C:\Users\shuho\Documents\Code\Student_management_system\images\1652330033576.png)

  ![1652330015442](C:\Users\shuho\Documents\Code\Student_management_system\images\1652330015442.png)

  ![1652329901407](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329901407.png)

- ![1652329916838](C:\Users\shuho\Documents\Code\Student_management_system\images\1652329916838.png)

#  使用的第三方库  

- 1. spring-boot

  2. spring-MVC

  3. thymeleaf

  4. mybatis-plus

  5. druid

  6. Lombok

  7. Hutool

  8. H-ui

  9. Timetables.js

# 使用说明

- SMS目录下的数据库文件sms.sql导入MySQL数据库，运行程序即可
- 后台登录界面为 admin.aspx ，默认账号：admin 密码：admin