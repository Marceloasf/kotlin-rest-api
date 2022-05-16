package br.com.kotlinrestapi.blog

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BlogController {

    @GetMapping("/")
    fun getBlog(model: Model): String {

        //using 'ui.set' instead of model.addAttribute("title", "Blog")
        model["title"] = "Blog"
        return "blog"
    }
}
