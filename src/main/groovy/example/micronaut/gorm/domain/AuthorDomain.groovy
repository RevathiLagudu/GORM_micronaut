package example.micronaut.gorm.domain

import grails.gorm.annotation.Entity



@Entity
class AuthorDomain {

    String firstName
    String lastName
    Date dob

    static hasMany = [books:BooksDomain]

    static  mapping ={
        id generator:'increment'
    }

    static constraints = {
        firstName nullable: false
        lastName nullable: false
        dob nullable: false
    }


}
