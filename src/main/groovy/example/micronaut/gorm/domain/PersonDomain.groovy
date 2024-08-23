package example.micronaut.gorm.domain

import grails.gorm.annotation.Entity

@Entity
class PersonDomain {

    String firstName
    String lastName
    int age
  //  Aadhar aadhar


    static mapping = {
        id generator:'increment'
        lastName column: "lname"
    }
    static constraints = {
        firstName nullable: false
        lastName nullable: true
    //    aadhar unique: true
    }



}
