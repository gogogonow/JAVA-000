package com.tw.itf;

import com.tw.data.Student;

/**
 * @author 61404
 */
public interface IStudentDAO {

    void insert(Student student);

    Student findByStudentId(int custId);
}
