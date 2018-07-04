package io.github.amaan75.courseApiApp.course

import org.springframework.data.repository.CrudRepository


interface CourseRepository : CrudRepository<Course, String> {
    fun findByTopicId(topicId: String): List<Course>
}