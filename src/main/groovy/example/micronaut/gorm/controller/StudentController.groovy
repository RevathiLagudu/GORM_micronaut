package example.micronaut.gorm.controller

import example.micronaut.gorm.model.StudentModel
import example.micronaut.gorm.service.StudentService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

import javax.inject.Inject

@Controller("/student")
class StudentController {

    @Inject
    StudentService service

    @Post("/saveStudent")
    def saveStudent(StudentModel studentModel) {
      service.saveStudent(studentModel)
        return "Saved Data"
    }

    @Get("/getStudent/{id}")
    def getStudent(@PathVariable String id) {
        return service.getStudent(id)
    }
}
