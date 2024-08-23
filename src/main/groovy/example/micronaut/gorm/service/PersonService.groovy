package example.micronaut.gorm.service

import example.micronaut.gorm.domain.Aadhar
import example.micronaut.gorm.domain.PersonAadhar
import example.micronaut.gorm.domain.PersonDomain
import example.micronaut.gorm.model.Person
import grails.gorm.transactions.Transactional
import org.hibernate.SessionFactory

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PersonService {

    @Inject
    SessionFactory sessionFactory
    def PERSON_DETAILS= "select * from person_domain where age=:age"

  @Transactional
    def savePerson(Person person) {
      PersonDomain p = new PersonDomain()
      p.firstName=person.firstName
      p.lastName=person.lastName
      p.age=person.age
      p.save()
  }

    @Transactional(readOnly = true)
    def getPerson(String id) {
        PersonDomain domain=PersonDomain.get(id)
        Person p = new Person()
        p.firstName=domain.firstName
        p.lastName=domain.lastName
        p.age=domain.age
        return p
    }

    @Transactional(readOnly = true)
    def getPersonByFirstName(String firstName){
        PersonDomain domain=PersonDomain.findByFirstName(firstName)
        Person p = new Person()
        p.firstName=domain.firstName
        p.lastName=domain.lastName
        p.age=domain.age
        return p
    }

    @Transactional(readOnly = true)
    def getPersonByFirstNameILike(String firstName){
        PersonDomain domain=PersonDomain.findByFirstNameIlike(firstName)
        Person p = new Person()
        p.firstName=domain.firstName
        p.lastName=domain.lastName
        p.age=domain.age
        return p
    }

    @Transactional
    def savePersonAadhar(Person person) {
        PersonAadhar p = new PersonAadhar()
        Aadhar a =new Aadhar()
        a.aadharNumber="1123"
        p.aadhar =a
        p.firstName=person.firstName
        p.lastName=person.lastName
        p.age=person.age
        p.save()
    }

    @Transactional(readOnly = true)
    def getPersonAadhar(String id) {
        PersonAadhar domain=PersonAadhar.get(id)
        Person p = new Person()
        p.firstName=domain.firstName
        p.lastName=domain.lastName
        p.age=domain.age
        p.aadhar = domain.aadhar.aadharNumber
        return p
    }

    @Transactional
    def getPersonDetails(){
        def session = sessionFactory.getCurrentSession()
        def personDetails=session.createSQLQuery(PERSON_DETAILS).setParameter("age", 40).list()
       return personDetails
    }

}
