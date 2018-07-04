package io.github.amaan75.courseApiApp.hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * This controller should say hi to the user.
 */
@RestController
class HelloController {

    /**
     *  @return this method returns a hi, when a request is mapped to "/hello" path
     */
    @GetMapping("/hello")
    fun sayHi() = "Hi"


}