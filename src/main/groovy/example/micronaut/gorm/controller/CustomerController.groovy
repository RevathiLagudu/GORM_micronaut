package example.micronaut.gorm.controller

import example.micronaut.gorm.model.Customer
import example.micronaut.gorm.model.Person
import example.micronaut.gorm.service.CustomerService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

import javax.inject.Inject

@Controller("/customer")
class CustomerController {

    @Inject
    CustomerService customerService
    @Post("/save")
    def saveCustomer(@Body Customer customer) {
        customerService.saveCustomer(customer)
        return "Saved Customer Successfully"
    }

    @Get("/getCustomer/{id}")
    def getCustomer(@PathVariable String id){
        return customerService.getCustomer(id)
    }
}
