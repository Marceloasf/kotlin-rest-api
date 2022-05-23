package br.com.kotlinrestapi.blog

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

// In Kotlin, the recommended way to manage your application properties is to leverage @ConfigurationProperties
// with @ConstructorBinding in order to be able to use read-only properties.
// Then we enable it at BlogApplication level.
@ConstructorBinding
@ConfigurationProperties("blog")
data class BlogProperties(var title: String, val banner: Banner) {
    data class Banner(val title: String? = null, val content: String)
}
