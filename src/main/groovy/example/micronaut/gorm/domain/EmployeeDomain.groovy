package example.micronaut.gorm.domain

import grails.gorm.annotation.Entity

@Entity
class EmployeeDomain {
    String empName
    int age
    String depName
    long phoneNum
    long aadhar
    Date joinDate

    static mapping = {
        id generator:'increment'
    }
    static constraints = {
        empName nullable: true
        age nullable: false
        depName nullable: true
        phoneNum unique:true
        aadhar unique: true
        joinDate nullable: true
    }
}
