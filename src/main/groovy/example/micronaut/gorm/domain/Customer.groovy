package example.micronaut.gorm.domain

import grails.gorm.annotation.Entity

@Entity
class Customer {
    String name
    static hasMany = [address: Address]
    static mapping = {
        address fetch:"join"
    }
}
