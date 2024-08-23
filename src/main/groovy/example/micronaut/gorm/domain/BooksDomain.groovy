package example.micronaut.gorm.domain

import grails.gorm.annotation.Entity



@Entity
class BooksDomain {
    String title
    double price
    Date pubDate



    static belongsTo = [author:AuthorDomain]

    static mapping = {
        id generator:"increment"
    }

    static constraints = {
        title nullable: false
        price nullable:false
        pubDate nullable: false
        author nullable: false
    }


}
