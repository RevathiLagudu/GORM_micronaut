package example.micronaut.gorm.service

import example.micronaut.gorm.domain.EmployeeDomain
import example.micronaut.gorm.model.EmployeeModel
import grails.gorm.transactions.Transactional

import javax.inject.Singleton

@Singleton
class EmployeeService {

    @Transactional
    def saveEmp(EmployeeModel employee){
    EmployeeDomain emp= employee.toDomain()
//        emp.empName=employee.empName
//        emp.age=employee.age
//        emp.depName=employee.depName
//        emp.phoneNum=employee.phoneNum
//        emp.aadhar=employee.aadhar
//        emp.joinDate=employee.joinDate
        emp.save(flush: true, failOnError: true)
        //The parameters flush: true and failOnError: true are used to immediately write the changes to the database and to throw an error if any validation fails during the save operation.
    }

    @Transactional(readOnly = true)
    def fetchAllEmp(){
        return EmployeeDomain.list()
    }

    @Transactional(readOnly = true)
    def getEmpById(int id){
        return EmployeeDomain.get(id)
    }

    @Transactional
    def deleteEmp(int id){
        EmployeeDomain employeeDomain=EmployeeDomain.get(id)
        if(employeeDomain){
            employeeDomain.delete(flush: true)
        }
    }
    @Transactional
    def updateEmp(Long id, EmployeeModel updatedEmployee) {
        EmployeeDomain employeeDomain = EmployeeDomain.get(id)
        if (employeeDomain) {
            employeeDomain.empName = updatedEmployee.empName
            employeeDomain.age = updatedEmployee.age
            employeeDomain.depName = updatedEmployee.depName
            employeeDomain.phoneNum = updatedEmployee.phoneNum
            employeeDomain.aadhar = updatedEmployee.aadhar
            employeeDomain.joinDate = updatedEmployee.joinDate
            employeeDomain.save(flush: true, failOnError: true)
        }
    }

}
