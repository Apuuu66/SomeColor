package com.guier.jpa;

import com.guier.jpa.pojo.Book;
import com.guier.jpa.pojo.Course;
import com.guier.jpa.pojo.Grade;
import com.guier.jpa.pojo.Student;
import com.guier.jpa.repository.BookRepository;
import com.guier.jpa.repository.CourseRepository;
import com.guier.jpa.repository.GradeRepository;
import com.guier.jpa.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://www.jianshu.com/p/54108abb070f
@SpringBootApplication
@RestController
public class JpaApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    @Autowired
    private BookRepository repository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    BookRepository bookRepository;


    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @GetMapping("/insert")
    public void insert() {
        Grade grade = new Grade().setGName("三年级");
        Student student1 = new Student().setSName("小狗狗").setGrade(grade);
        Student student2 = new Student().setSName("二狗狗").setGrade(grade);
        Student student3 = new Student().setSName("大狗狗").setGrade(grade);
        Course course1 = new Course().setCName("语文");
        Course course2 = new Course().setCName("数学");
        Course course3 = new Course().setCName("英语");
        HashSet<Course> courses = new HashSet<>(Arrays.asList(course1, course2, course3));
        student1.setCourses(courses);
        studentRepository.saveAll(Arrays.asList(student1, student2, student3));
    }

    @GetMapping("all")
    public void getAll() {
        List<Student> students = studentRepository.findAll();
        List<Grade> grades = gradeRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        System.out.println(students);
        System.out.println(grades);
        System.out.println(courses);
        // System.out.println(bookRepository.findById(1L));
        System.out.println(bookRepository.findById(new Book(1L, 1L, "1")));

        // System.out.println(123);
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
        // s.getCourses().add(c);
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
        // c.getStudents().add(s);
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
        // s.getCourses().add(c);
        // c.getStudents().add(s);
        courseRepository.save(c);
    }

    public void bookTest() {

        repository.save(new Book("Java"));
        repository.save(new Book("Node"));
        repository.save(new Book("Python"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(System.out::println);

        System.out.println("\nfindById(1L)");
        // repository.findById(1L).ifPresent(System.out::println);

        System.out.println("\nfindByName('Node')");
        repository.findByName("Node").forEach(System.out::println);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
