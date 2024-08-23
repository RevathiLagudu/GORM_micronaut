package example.micronaut.gorm.domain

import grails.gorm.annotation.Entity

@Entity
class StudentDomain {

    String name
    static hasMany = [courses:CourseDomain]

    static mapping = {
        courses fetch:"join"
    }
}
