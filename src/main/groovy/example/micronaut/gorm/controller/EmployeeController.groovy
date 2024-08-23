package example.micronaut.gorm.controller

import example.micronaut.gorm.model.EmployeeModel
import example.micronaut.gorm.service.EmployeeService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put

import javax.inject.Inject

@Controller("/emp")
class EmployeeController {

    @Inject
    EmployeeService employeeService

    @Post
    def saveEmployee(@Body EmployeeModel employee){
        employeeService.saveEmp(employee)
        return "employee save Successfully"
    }

    @Get
    def fetchAllEmp(){
        def employee=employeeService.fetchAllEmp()
        return (employee)
    }

    @Get("/{id}")
    def fetchEmpById(@PathVariable int id){
        def employee=employeeService.getEmpById(id)
        if(employee){
            return (employee)
        }
        else{
            return "Employee not found"
        }
    }
    @Delete("/{id}")
    def deleteEmployee(@PathVariable int id){
        employeeService.deleteEmp(id)
        return "employee deleted successfully"
    }

    @Put("/{id}")
    def updateEmployee(@PathVariable int id ,@Body EmployeeModel updateEmployee){
        employeeService.updateEmp(id,updateEmployee)
        return "Employee update successfully"
    }

}
