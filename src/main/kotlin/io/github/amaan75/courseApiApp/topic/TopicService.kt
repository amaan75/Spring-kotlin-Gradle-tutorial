package io.github.amaan75.courseApiApp.topic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * This is a business service for the course api and will
 * hold all the topics, which is hardcoded for now
 */
@Service
class TopicService(@Autowired val topicRepository: TopicRepository) {

    /**
     * @return fetches the topics from the database and then returns a list of all of them
     */
    fun getAllTopics() = topicRepository.findAll().toMutableList()

    /**
     * @param id for the topic you want to fetch.
     * @return {@link Topic} returns a single Topic based on the id param that was supplied
     */
    fun getTopic(id: String) = topicRepository.findById(id)

    /**
     * This method is used to add a topic to the list of topics
     * @param topic:Takes a topic Object and adds the topic to the database
     */
    fun addTopic(topic: Topic) = topicRepository.save(topic)


    /**
     *  This method will update an existing topic based on the id
     *  @param id The id of the topic to be updated
     *  @param topic the topic object which will replace the old one
     */
    fun updateTopic(id: String, topic: Topic) = topicRepository.save(topic)


    /**
     * This method is used to remove a topic from the list of all topics
     * @param id id of the topic to be removed
     */
    fun deleteTopic(id: String) = topicRepository.deleteById(id)


}