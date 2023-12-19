package com.AAA.csEban.service.impl;

import com.AAA.csEban.mapper.PojoMapper;
import com.AAA.csEban.pojo.AbsentRequest;
import com.AAA.csEban.pojo.Notice;
import com.AAA.csEban.pojo.Student;
import com.AAA.csEban.pojo.Teacher;
import com.AAA.csEban.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private PojoMapper pojoMapper;

    @Override
    public Student getStudentInfo(int studentId) {
        Student student = pojoMapper.queryStudentById(studentId);
        return student;
    }

    @Override
    public List<Notice> getNoticeInfo(int deptId) {
        List<Teacher> teacherList = pojoMapper.queryTeacherListForDept(deptId);
        List<Notice> noticeList = new LinkedList<>();
        for (Teacher teacher : teacherList){
            for (Notice notice : teacher.getNoticeList()){
                noticeList.add(notice);
            }
        }
        return noticeList;
    }

    @Override
    public Notice lookNotice(int studentId, int NoticeId) {
        pojoMapper.updateStudentLookNotice(NoticeId, studentId);
        return pojoMapper.queryNoticeById(NoticeId);
    }


    @Override
    public void submitAbsentRequest(AbsentRequest absentRequest) {
        pojoMapper.addRequest(absentRequest);
        pojoMapper.addAbsentRequest(absentRequest);
    }

    @Override
    public List<AbsentRequest> getAbsentRequestList(int studentId) {
        return pojoMapper.queryAbsentRequestList(studentId);
    }

    @Override
    public List<Teacher> getInstructorListByStudentId(int studentId) {
        Student student = pojoMapper.queryStudentById(studentId);
        return pojoMapper.queryInstructorListForDept(student.getDept().getDeptId());
    }
}
