package io.github.amaan75.courseApiApp.topic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.persistence.Entity
import javax.persistence.Id

/**
 * This is a data class to hold a single topic
 * @property id : this is the id of a particular topic
 * @property name: String name of a particular topic
 * @property description :String description of a particular {@link Topic}
 */
@Entity
data class Topic(@Id val id: String, val name: String, val description: String)


/**
 * @author : amaan75 <amangulati075@gmail.com>
 *    This rest controller will return all the topics available in json format
 * @property: This is an auto wired property of type TopicService
 */
@RestController
class TopicController(@Autowired val topicService: TopicService) {

    /**
     * @return returns a String that says all topics
     */
    @GetMapping("/topics")
    fun getAllTopics() = topicService.getAllTopics()


    /**
     * The function exposes an api endpoint to fetch 1 topic from a list of topics
     * @param id the id that is passed in the uri
     * @return returns a single json of type topic based on the id that was passed in {@link Topic}
     */
    @GetMapping("/topics/{id}")
    fun getTopic(@PathVariable id: String) = topicService.getTopic(id)

    /**
     * This method will execute on a Post Request, and takes a json topic
     * It adds a topic to the list of topics
     * @param topic : this param is the id of the topic that has to be added
     */
    @PostMapping("/topics")
    fun addTopic(@RequestBody topic: Topic) = topicService.addTopic(topic)


    /**
     * This method will update the contents of a particular topic
     * @param id This parameter takes in the id of the topic to be updated
     * @param topic The new topic object which will be added onto the list
     */
    @PutMapping("/topics/{id}")
    fun updateTopic(@PathVariable id: String, @RequestBody topic: Topic) = topicService.updateTopic(id, topic)


    /**
     * This method deletes a topic from then list of topics based on the id
     * @param id The topic to be deleted
     */
    @DeleteMapping("/topics/{id}")
    fun deleteTopic(@PathVariable id: String) = topicService.deleteTopic(id)

}