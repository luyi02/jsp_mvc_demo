##1.程序的基本功能

 - 实现简单的登录功能
 - 登录功能中包括一次性验证码功能和记住用户名功能

##2.运行环境

 - JavaEE2.5版本
 - jdk8版本
 - MySQL8.017版本


##3.依赖的jar包

 - c3p0-0.9.5.2.jar（连接池jar包）
 - mchange-commons-java-0.2.12.jar（c3p0的使用需要这个包）
 - commons-dbutils-1.7.jar（DBUtils使用依赖的jar包）
 - mysql-connector-java-8.0.17.jar（连接数据库时依赖的jar包）

##4.依赖的数据库的创建
创建数据库：

	create database my;
创建表：

	CREATE TABLE user(
		 nid int not null auto_increment PRIMARY KEY,
		 username varchar(20),
		 password varchar(20),
		 role varchar(20)
	);
添加数据：

	insert into student(username, `password`, role) VALUES("luyi", "123", "student"), ("luer","321", "teacher")

##5.代码目录

	jsp_mvc_demo/
	
	|--.settings
	
	
	|--src
	
	|  |--cn.luyi.controller:MVC的C层，存放负责调度控制的java文件
	
	      |--LoginServlet.java:负责登录功能的实现的Servlet
	
	      |--LogoutServlet.java:负责退出系统的功能实现的Servlet
	
	      |--RandomCodeImageServlet.java:负责生成验证码图片的Servlet
	
	   |--cn.luyi.domain：存放封装数据的javaBean
	
	      |--User.java:封装了User表信息的javaBean
	
	   |--cn.luyi.model：MVC的M层，存放与数据库数据交互的java文件
	
		  |--UserModel.java:获取数据库数据的类，返回一个User对象
	
	   |--cn.luyi.utils：存放java的工具类
	
		  |--JDBCUtils.java:使用连接池连接数据库的工具类
	
	   |--c3p0-config.xml：c3p0连接池连接数据库的配置文件
	
	|--WebRoot
	
	   |--Meta-INF:
	
	   |--WEB-INF:
	
	   |--lib:存放依赖的jar包
	
	   |--web.xml:用来初始化配置信息的，Servlet的使用就需要在这里进行配置
	
	   |--login.jsp:
	
	   |--success.jsp:
	
	!--.classpath
	
	|--.project

