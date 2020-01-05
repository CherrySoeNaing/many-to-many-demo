package com.solt.demo.manytomanydemo.service;

import com.solt.demo.manytomanydemo.domain.Student;
import com.solt.demo.manytomanydemo.domain.Subject;
import com.solt.demo.manytomanydemo.repository.StudentRepository;
import com.solt.demo.manytomanydemo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IDatabaseImpl implements IDatabase {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    public IDatabaseImpl(SubjectRepository subjectRepository, StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void createTable() {

        Student s1 = new Student("Thaw Thaw", 23, "Latha");
        Student s2 = new Student("Maw Maw", 23, "Ygn");
        Student s3 = new Student("Thaw Maw", 23, "SanChaung");

        Subject su1 = new Subject("Java", 6);
        Subject su2 = new Subject("Python", 6);
        Subject su3 = new Subject("Groovy", 6);

        su1.getStudentList().add(s1);
        su1.getStudentList().add(s2);
        su1.getStudentList().add(s3);

        su2.getStudentList().add(s2);

        su3.getStudentList().add(s3);
        s1.getSubjects().add(su1);
        s2.getSubjects().add(su1);
        s3.getSubjects().add(su1);

        s2.getSubjects().add(su2);

        s3.getSubjects().add(su3);

//        subjectRepository.save(su1);
//        subjectRepository.save(su2);
//        subjectRepository.save(su3);

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);


    }
}
