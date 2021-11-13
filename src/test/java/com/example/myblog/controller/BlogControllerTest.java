package com.example.myblog.controller;

import com.example.myblog.IntegrationTestSupport;
import com.example.myblog.dto.request.BlogSaveRequest;
import com.example.myblog.model.Blog;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
        "server-port=0",
        "command.line.runner.enabled=false"
})
@RunWith(SpringRunner.class)
@DirtiesContext
class BlogControllerTest extends IntegrationTestSupport {

    @Test
    void createBlogContent() throws Exception {

        Blog blog = blogRepository.save(generateBlog());
        BlogSaveRequest saveRequest = generateSaveRequest();

        this.mockMvc.perform(post(BLOG_CONTENT_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(blog)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content",notNullValue()))
                .andExpect(jsonPath("$.videoUrl",is(blog.getVideoUrl())))
                .andExpect(jsonPath("$.author",is(blog.getAuthor())));

    }

    @Test
    void listBlogs() {
    }

    @Test
    void findById() {
    }

    @Test
    void testFindById() {
    }
}