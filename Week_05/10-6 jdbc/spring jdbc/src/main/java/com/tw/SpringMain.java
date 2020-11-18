package com.tw;

import com.tw.dao.JdbcStudentDAO;
import com.tw.data.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 61404
 */
@ContextConfiguration({"classpath*:com/tw/xml/Spring-Config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringMain {


    @Test
    public void main() {
        // 根据XML配置文件生成应用上下文
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:com/tw/xml/Spring-Config.xml");


        // 读取customerDAO的JavaBean，转型为customerDAO
        JdbcStudentDAO studentDAO = context.getBean(JdbcStudentDAO.class);

        // 用封装好DAO进行类似ORM的操作
        studentDAO.insert(new Student(1, "Jack", 21));
        studentDAO.insert(new Student(2, "Tom", 24));
        studentDAO.insert(new Student(3, "Jane", 25));

        Student student = studentDAO.findByStudentId(2);
        System.out.println(student);
    }
}
