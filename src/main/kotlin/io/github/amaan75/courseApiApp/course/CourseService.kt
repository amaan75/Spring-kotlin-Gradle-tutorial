package io.github.amaan75.courseApiApp.course

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * This is a business service for the course api and will
 * hold all the courses, which is hardcoded for now
 */
@Service
class CourseService(@Autowired val courseRepository: CourseRepository) {

    /**
     * @return fetches the courses from the database and then returns a list of all of them
     */
    fun getAllCourses(topicId: String) = courseRepository.findByTopicId(topicId).toMutableList()

    /**
     * @param id for the course you want to fetch.
     * @return {@link Course} returns a single Course based on the id param that was supplied
     */
    fun getCourse(id: String) = courseRepository.findById(id)

    /**
     * This method is used to add a course to the list of courses
     * @param course:Takes a course Object and adds the course to the database
     */
    fun addCourse(course:Course) = courseRepository.save(course)


    /**
     *  This method will update an existing course based on the id
     *  @param id The id of the course to be updated
     *  @param course the course object which will replace the old one
     */
    fun updateCourse(id: String, course:Course) = courseRepository.save(course)


    /**
     * This method is used to remove a course from the list of all courses
     * @param id id of the course to be removed
     */
    fun deleteCourse(id: String) = courseRepository.deleteById(id)


}