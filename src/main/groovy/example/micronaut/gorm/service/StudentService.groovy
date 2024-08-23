package example.micronaut.gorm.service

import example.micronaut.gorm.domain.CourseDomain
import example.micronaut.gorm.domain.StudentDomain
import example.micronaut.gorm.model.StudentModel
import grails.gorm.transactions.Transactional

import javax.inject.Singleton


@Singleton
class StudentService {


    @Transactional
    def saveStudent(StudentModel studentModel) {
        StudentDomain studentDomain = new StudentDomain()
        studentDomain.name=studentModel.name
        studentDomain.courses = new HashSet<>()
        studentModel.courseDomains.each {
            CourseDomain courseDomain = new CourseDomain()
            courseDomain.courseName= it.courseName
            studentDomain.addToCourses(courseDomain)
        }
        studentDomain.save()
    }

    @Transactional
    def getStudent(String id){
        StudentDomain s= StudentDomain.get(id)
        StudentModel sm = new StudentModel()
        sm.name=s.name
        return sm
    }
}
