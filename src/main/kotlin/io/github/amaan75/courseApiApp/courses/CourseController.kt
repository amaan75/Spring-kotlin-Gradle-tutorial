package io.github.amaan75.courseApiApp.course

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.Id

/**
 * This is a data class to hold a single course
 * @property id : this is the id of a particular course
 * @property name: String name of a particular course
 * @property description :String description of a particular {@link Course}
 */
@Entity
data class Course(@Id val id: String, val name: String, val description: String)


/**
 * @author : amaan75 <amangulati075@gmail.com>
 *    This rest controller will return all the courses available in json format
 * @property: This is an auto wired property of type CourseService
 */
@RestController
class CourseController(@Autowired val courseService: CourseService) {

    /**
     * @return returns a String that says all courses
     */
    @GetMapping("/topics/{id}/courses")
    fun getAllCourses(@PathVariable id: String) = courseService.getAllCourses(id)


    /**
     * The function exposes an api endpoint to fetch 1 course from a list of courses
     * @param id the id that is passed in the uri
     * @return returns a single json of type course based on the id that was passed in {@link Course}
     */
    @GetMapping("/topic/{topicId}/courses/{id}")
    fun getCourse(@PathVariable id: String) = courseService.getCourse(id)

    /**
     * This method will execute on a Post Request, and takes a json course
     * It adds a course to the list of courses
     * @param course : this param is the id of the course that has to be added
     */
    @PostMapping("/courses")
    fun addCourse(@RequestBody course:Course) = courseService.addCourse(course)


    /**
     * This method will update the contents of a particular course
     * @param id This parameter takes in the id of the course to be updated
     * @param course The new course object which will be added onto the list
     */
    @PutMapping("/courses/{id}")
    fun updateCourse(@PathVariable id: String, @RequestBody course: Course) =
            courseService.updateCourse(id, course)


    /**
     * This method deletes a course from then list of courses based on the id
     * @param id The course to be deleted
     */
    @DeleteMapping("/courses/{id}")
    fun deleteCourse(@PathVariable id: String) = courseService.deleteCourse(id)

}