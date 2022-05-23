package br.com.kotlinrestapi

import br.com.kotlinrestapi.blog.BlogProperties
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class KotlinrestapiApplication

fun main(args: Array<String>) {
    runApplication<KotlinrestapiApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}
