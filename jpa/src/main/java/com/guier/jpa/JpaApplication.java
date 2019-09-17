package com.guier.jpa;

import com.guier.jpa.pojo.Book;
import com.guier.jpa.pojo.Course;
import com.guier.jpa.pojo.Student;
import com.guier.jpa.repository.BookRepository;
import com.guier.jpa.repository.CourseRepository;
import com.guier.jpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://www.jianshu.com/p/54108abb070f
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    @Autowired
    private BookRepository repository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
        System.out.println("############################" + 2);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("############################StartApplication...");
//        bookTest();
        course_student1();
        course_student2();
        course_student3();
    }
    /**
     * 仅将被维护方对象添加进维护方对象Set中
     * 保存维护方对象
     */
    public void course_student1() {
        Student s = new Student();
        s.setSName("二狗");
        Course c = new Course();
        c.setCName("语文");
        s.getCourses().add(c);
        studentRepository.save(s);
    }
    /**
     * 仅将维护方对象添加进被维护方对象Set中
     * 保存被维护方对象
     */
    public void course_student2() {
        Student s = new Student();
        s.setSName("三汪");
        Course c = new Course();
        c.setCName("英语");
        c.getStudents().add(s);
        courseRepository.save(c);
    }
    /**
     * 将双方对象均添加进双方Set中
     * 保存被维护方对象
     */
    public void course_student3() {
        Student s = new Student();
        s.setSName("一晌");
        Course c = new Course();
        c.setCName("数学");
        s.getCourses().add(c);
        c.getStudents().add(s);
        courseRepository.save(c);
    }

    public void bookTest() {

        repository.save(new Book("Java"));
        repository.save(new Book("Node"));
        repository.save(new Book("Python"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        repository.findByName("Node").forEach(x -> System.out.println(x));
    }
}
