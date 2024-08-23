package example.micronaut.gorm.model

import example.micronaut.gorm.domain.AuthorDomain
import example.micronaut.gorm.domain.BooksDomain

class AuthorModel {
    Long id
    String firstName
    String lastName
    Date dob

    Set<BooksDomain> books

//    AuthorDomain toAuthorDomain(){
//        AuthorDomain author=new AuthorDomain()
//        author.firstName=this.firstName
//        author.lastName=this.lastName
//        author.dob=this.dob
//        return author
//
//    }

}
