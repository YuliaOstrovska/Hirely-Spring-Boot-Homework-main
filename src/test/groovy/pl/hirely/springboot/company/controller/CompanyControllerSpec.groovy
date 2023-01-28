package pl.hirely.springboot.company.controller

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import pl.hirely.springboot.company.model.service.CompanyService
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = CompanyController)
class CompanyControllerSpec extends Specification {
    @Autowired
    private MockMvc mockMvc
    @SpringBean
    private CompanyService companyService = Mock()

    def "should return 200 with correct body"() {
        given:
        companyService.() >> [
                new BlogPostDto("test-title", "test-content", []),
                new BlogPostDto("aa", "bb", [new BlogPostCommentDto("xxx")])
        ]

        when:
        def response = mockMvc.perform(get("/blog/post"))

        then:
        response
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.length()').value(2))
                .andExpect(jsonPath('$[0].title').value("test-title"))
                .andExpect(jsonPath('$[0].content').value("test-content"))
                .andExpect(jsonPath('$[1].title').value("aa"))
                .andExpect(jsonPath('$[1].content').value("bb"))
                .andExpect(jsonPath('$[1].comments[0].content').value("xxx"))
    }
}

