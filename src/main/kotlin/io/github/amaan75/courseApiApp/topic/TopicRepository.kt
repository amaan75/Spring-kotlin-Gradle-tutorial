package io.github.amaan75.courseApiApp.topic

import org.springframework.data.repository.CrudRepository


interface TopicRepository : CrudRepository<Topic, String>