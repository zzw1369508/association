package com.zzw.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zzw.dao.StudentMapper;
import com.zzw.entity.Student;
import com.zzw.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
