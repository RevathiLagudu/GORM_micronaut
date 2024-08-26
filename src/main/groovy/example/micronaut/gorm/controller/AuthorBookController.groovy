package example.micronaut.gorm.controller


import example.micronaut.gorm.model.AuthorModel

import example.micronaut.gorm.service.AuthorBookService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

import javax.inject.Inject

@Controller("/authorBook")
class AuthorBookController {

    @Inject
    AuthorBookService authorBookService


    @Post
    def saveAuthorDetails(@Body AuthorModel author){
        authorBookService.saveAuthor(author)
        return "Author details saved successfully"
    }


    @Get
    def getAllAuthors(){
        return authorBookService.getAllAuthors()
    }
     @Get("/{id}")
    BooksDomain fetchById(@PathVariable int id){
        return authorBookService.getBookById(id)
    }

    @Put("/{id}")
    def update(@PathVariable int id, @Body AuthorModel author ){
        return authorBookService.updateAuthor(id,author)

    }

    @Delete("/{id}")
    def delete(@PathVariable int id){
        return authorBookService.deleteAuthor(id)
    }



}
