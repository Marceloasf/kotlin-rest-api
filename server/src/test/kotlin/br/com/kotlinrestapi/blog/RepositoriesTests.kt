package br.com.kotlinrestapi.blog

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    private val entityManager: TestEntityManager,
    private val userRepository: UserRepository,
    private val articleRepository: ArticleRepository
) {

//  We use here the CrudRepository.findByIdOrNull Kotlin extension provided by default with Spring Data,
//  which is a nullable variant of the Optional based CrudRepository.findById
    @Test
    fun `When findByIdOrNull then return Article`() {

        val juergen = User("springjuergen", "Juergen", "Hoeller")

        entityManager.persist(juergen)

        val article = Article("Spring Framework 5.0 goes GA", "Dear Spring community ...", "Lorem ipsum", juergen)

        entityManager.persist(article)
        entityManager.flush()

        val found = articleRepository.findByIdOrNull(article.id!!)

        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {

        val juergen = User("springjuergen", "Juergen", "Hoeller")

        entityManager.persist(juergen)
        entityManager.flush()

        val user = userRepository.findByLogin(juergen.login)

        assertThat(user).isEqualTo(juergen)
    }
}
