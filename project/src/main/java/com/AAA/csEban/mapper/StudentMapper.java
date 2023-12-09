package com.AAA.csEban.mapper;

import com.AAA.csEban.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    List<Student> queryStudentList();

    Student queryStudentById(int id);

//    int addStudent(Student student);
//
//    int updateStudent(Student student);
//
//    int deleteStudent(int id);
}
