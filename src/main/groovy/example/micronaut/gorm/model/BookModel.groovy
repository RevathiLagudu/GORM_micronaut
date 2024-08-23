package example.micronaut.gorm.model

import example.micronaut.gorm.domain.AuthorDomain

class BookModel {
    Long id
    String title
    double price
    Date pubDate
    AuthorDomain author

//    BookModel(String title, double price, Date pubDate) {
//        this.title = title
//        this.price = price
//        this.pubDate = pubDate
//    }
}
