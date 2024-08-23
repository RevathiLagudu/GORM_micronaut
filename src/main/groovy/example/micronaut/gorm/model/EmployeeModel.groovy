package example.micronaut.gorm.model

import example.micronaut.gorm.domain.EmployeeDomain

class EmployeeModel {
    String empName
    int age
    String depName
    long phoneNum
    long aadhar
    Date joinDate

    EmployeeDomain  toDomain(){
        EmployeeDomain emp=new EmployeeDomain()
        emp.empName=this.empName
        emp.age=this.age
        emp.depName=this.depName
        emp.phoneNum=this.phoneNum
        emp.aadhar=this.aadhar
        emp.joinDate=this.joinDate
        return emp
    }
}
