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
        /*Get Books Details By Id*/
    @Transactional
    BooksDomain getBookById(int id){
        BooksDomain bookDomain=BooksDomain.findById(id)
        if(bookDomain){
            BookModel bookModel = new BookModel()
            bookModel.title = bookDomain.title
            bookModel.price=bookDomain.price
            bookModel.pubDate=bookDomain.pubDate
            // Instantiate the AuthorModel and set its properties
            AuthorModel authorModel = new AuthorModel()
            authorModel.firstName = bookDomain.author.firstName
            authorModel.lastName = bookDomain.author.lastName
            authorModel.dob = bookDomain.author.dob
            // Set the authorModel in bookModel
            bookModel.author = authorModel
            return bookModel

        }
    }


        @Transactional
        def deleteAuthor(int id){
            AuthorDomain authorDomain=AuthorDomain.findById(id)
            if(authorDomain){
                authorDomain.delete()
                return true
            }
            else{
                return false
            }
        }


        /*update By AuthorId*/
        @Transactional
        def updateAuthor(int id,AuthorModel updatedAuthorModel){
            AuthorDomain authorDomain=AuthorDomain.findById(id)
            authorDomain.firstName=updatedAuthorModel.firstName
            authorDomain.lastName=updatedAuthorModel.lastName
            authorDomain.dob=updatedAuthorModel.dob
            authorDomain.save()
            updatedAuthorModel.books.each{
                BooksDomain bookDomain=new BooksDomain()
                bookDomain.title=it.title
                bookDomain.price=it.price
                bookDomain.pubDate=it.pubDate
                bookDomain.author=authorDomain
                authorDomain.addToBooks(bookDomain)
                bookDomain.save()
            }
            authorDomain.save()
            return updatedAuthorModel
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
