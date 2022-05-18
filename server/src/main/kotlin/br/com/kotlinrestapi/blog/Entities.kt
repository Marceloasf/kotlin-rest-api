package br.com.kotlinrestapi.blog

import br.com.kotlinrestapi.extensions.toSlug
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

//  Here we don’t use data classes with val properties because JPA is not designed to work
//  with immutable classes or the methods generated automatically by data classes.
//  While Spring Data JPA makes it possible to use natural IDs, it is recommended to always use
//  entities with generated IDs in Kotlin

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null)

@Entity
class User(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null)
