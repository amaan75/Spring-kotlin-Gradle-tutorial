package io.github.amaan75.courseApiApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author amaan75<amangulati075@gmail.com>
 *     this class is the main starter class for our spring boot application
 */
@SpringBootApplication
class CourseApiApp

fun main(args: Array<String>) {
    runApplication<CourseApiApp>(*args)
}