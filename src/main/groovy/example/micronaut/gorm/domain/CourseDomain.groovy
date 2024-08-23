package example.micronaut.gorm.domain

import grails.gorm.annotation.Entity

@Entity
class CourseDomain {
    static belongsTo = StudentDomain
    String courseName
    static hasMany = [students:StudentDomain]
    static mapping = {
        students fetch:"join"
    }
}
