package example.micronaut.gorm.controller

import example.micronaut.gorm.domain.PersonDomain
import example.micronaut.gorm.model.Person
import example.micronaut.gorm.service.PersonService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

import javax.inject.Inject

@Controller("/person")
class PersonController {

    @Inject
    PersonService personService

    @Post("/save")
    def savePerson(@Body Person person) {
        personService.savePerson(person)
        return "Saved Person Successfully"
    }

    @Get("/getPerson/{id}")
    def getPerson(@PathVariable String id) {
        return personService.getPerson(id)
    }

    @Get("/getPersonByFirstName/{name}")
    def getPersonByFirstName(@PathVariable String name) {
        return personService.getPersonByFirstName(name)
    }

    @Get("/getPersonByFirstNameILike/{name}")
    def getPersonByFirstNameILike(@PathVariable String name) {
        return personService.getPersonByFirstNameILike(name)
    }

    @Post("/savePA")
    def savePersonAadhar(@Body Person person) {
        personService.savePersonAadhar(person)
        return "Saved Person Successfully"
    }

    @Get("/getPersonAadhar/{id}")
    def getPersonAadhar(@PathVariable String id) {
        return personService.getPersonAadhar(id)
    }

    @Get("/getPersonDetails")
    def getPersonDetails() {
        return personService.getPersonDetails()
    }

}
