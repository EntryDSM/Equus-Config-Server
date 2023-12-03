package hs.kr.equus.configserver

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@Controller
class RedirectController {
    @GetMapping("/equus-config/{name}/{profile}")
    fun redirect(@PathVariable name: String, @PathVariable profile: String): String {
        return "redirect:/$name/$profile"
    }
}