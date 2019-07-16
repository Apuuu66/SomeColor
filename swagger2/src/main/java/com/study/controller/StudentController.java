package com.study.controller;

import com.study.entity.Student;
import com.study.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: YiGui
 * Date: 2019/7/9
 * Time: 17:08
 */
@RestController
@RequestMapping("/student")
// @Api：修饰整个类，描述Controller的作用
@Api("StudentController Api 接口文档")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // @ApiOperation：描述一个类的一个方法，或者说一个接口
    @ApiOperation(value="获取所有学生列表", notes="获取所有学生列表")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public List<Student> getStudent() {
        List<Student> list = studentService.findAll();
        return list;
    }

    @ApiOperation(value="添加学生信息", notes="添加学生信息")
    // @ApiImplicitParam：一个请求参数
    @ApiImplicitParam(name = "student", value = "学生信息详细实体", required = true, dataType = "Student", paramType = "body")
    @PostMapping("/save")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @ApiOperation(value="获学生信息", notes="根据url的id来获取学生详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Integer id){
        return studentService.findById(id);
    }

    @ApiOperation(value="删除学生", notes="根据url的id来指定删除的学生")
    @ApiImplicitParam(name = "id", value = "学生ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        studentService.delete(id);
        return "success";
    }

    @ApiOperation(value="更新学生信息", notes="根据url的id来指定更新学生信息")
    // @ApiImplicitParams：多个请求参数
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生ID", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "student", value = "学生实体student", required = true, dataType = "Student")
    })
    @PutMapping(value="/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        Student oldStudent = this.findById(id);
        oldStudent.setId(student.getId());
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        studentService.save(oldStudent);
        return "success";
    }

    // 使用该注解忽略这个API
    @ApiIgnore
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String  jsonTest() {
        return " hi you!";
    }
}
