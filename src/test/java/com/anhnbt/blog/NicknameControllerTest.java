package com.anhnbt.blog;

import com.anhnbt.blog.controller.NicknameController;
import com.anhnbt.blog.service.NicknameService;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Array;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class NicknameControllerTest {

    @Autowired
    private NicknameController nicknameController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NicknameService nicknameService;

    @Test
    @DisplayName("NicknameController Load")
    public void contextLoads() throws Exception {
        assertThat(nicknameController).isNotNull();
    }

    @Test
    @DisplayName("Nickname return data success")
    public void shouldReturnDefaultMessage() throws Exception {
        String expectedMessage = "success";
        MvcResult result = this.mockMvc.perform(get("/nicknames")
                        .param("page", "5")
                        .param("size", "10")
                        .param("sort", "id,desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.code", is("00")))
                .andExpect(jsonPath("$.message", is(expectedMessage)))
                .andReturn();
        ArgumentCaptor<Pageable> pageableCaptor =
                ArgumentCaptor.forClass(Pageable.class);
        verify(nicknameService).findAll(pageableCaptor.capture());
        PageRequest pageable = (PageRequest) pageableCaptor.getValue();

        System.out.println(pageable);
//        assertThat(pageable).hasPageNumber(5);
//        assertThat(pageable).hasPageSize(10);
//        assertThat(pageable).hasSort("name", Sort.Direction.ASC);
//        assertThat(pageable).hasSort("id", Sort.Direction.DESC);
//        String content = result.getResponse().getContentAsString();
    }
}
