package example.micronaut.gorm.service

import example.micronaut.gorm.domain.AuthorDomain
import example.micronaut.gorm.domain.BooksDomain
import example.micronaut.gorm.model.AuthorModel
import example.micronaut.gorm.model.BookModel
import grails.gorm.transactions.Transactional


import javax.inject.Singleton


@Singleton
class AuthorBookService {

    @Transactional
    def saveAuthor(AuthorModel authorModel) {
        AuthorDomain authorDomain = new AuthorDomain()
        authorDomain.lastName = authorModel.lastName
        authorDomain.firstName = authorModel.firstName
        authorDomain.dob = authorModel.dob
        authorDomain.books = new HashSet<>()
        authorModel.books.each {
            BooksDomain booksDomain = new BooksDomain()
            booksDomain.title = it.title
            booksDomain.price = it.price
            booksDomain.pubDate = it.pubDate
            authorDomain.addToBooks(booksDomain)
        }
        return authorDomain.save()

    }

    @Transactional
    List<AuthorModel> getAllAuthors() {
        List<AuthorDomain> authorDomains = AuthorDomain.list() //AuthorDomain.list() is equal to SELECT * FROM author_domain
        return authorDomains.collect {
            AuthorModel authorModel=new AuthorModel()
            authorModel.id=it.id
            authorModel.firstName= it.firstName
            authorModel.lastName= it.lastName
            authorModel.dob= it.dob
            authorModel.books= it.books.collect { bookDomain ->
                new BookModel(
                        id:bookDomain.id,
                        title: bookDomain.title,
                        price: bookDomain.price,
                        pubDate: bookDomain.pubDate
                )
            }
            return authorModel
        }

//    def saveAuthor(AuthorModel authorModel) {
//        AuthorDomain authorDomain = authorModel.toAuthorDomain()
//        authorDomain.books = new HashSet<>()
//        authorModel.books.each {
//            BooksDomain booksDomain = new BooksDomain()
//            booksDomain.title = it.title
//            booksDomain.price = it.price
//            booksDomain.pubDate = it.pubDate
//            authorDomain.addToBooks(booksDomain)
//        }
//
//        return authorDomain.save()

//    }

}
}