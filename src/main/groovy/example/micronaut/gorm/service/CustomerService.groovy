package example.micronaut.gorm.service

import example.micronaut.gorm.domain.Address
import example.micronaut.gorm.model.Customer
import grails.gorm.transactions.Transactional

import javax.inject.Singleton

@Singleton
class CustomerService {


    @Transactional
    def saveCustomer(Customer customer) {
        Set<Address> set = new HashSet<>()
        Address a1 = new Address()
        a1.address ="Vizag"
        Address a2 = new Address()
        a2.address ="Hyd"
        set.add(a1)
        set.add(a2)
        example.micronaut.gorm.domain.Customer customer1 = new example.micronaut.gorm.domain.Customer()
        customer1.name=customer.name
        customer1.address=set
        customer1.save()
    }

    @Transactional
    def getCustomer(String id) {
        example.micronaut.gorm.domain.Customer customer = example.micronaut.gorm.domain.Customer.get(id)
        Customer c = new Customer()
        c.address=customer.address
        c.name = customer.name
        return c
    }
}
