package com.bloo.dsl.demodsl.domain.post;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.bloo.dsl.demodsl.domain.category.Category;
import com.bloo.dsl.demodsl.domain.category.CategoryRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * CreateBy: Bloo
 * Date: 2021/05/28
 */

@SpringBootTest
class PostTest {

    @MockBean
    private PostQueryRepository queryRepository;

    @Mock
    private CategoryRepository categoryRepository;

    private Category category;
    private Post post;

    @BeforeEach
    void setUp () {
        // given
        category = Category.builder()
            .name("IT")
            .build();

        post = Post.builder()
            .title("Query DSL 실습")
            .author("김작가")
            .content("내용 입니다.")
            .category(category)
            .build();
    }

    @DisplayName ("")
    @Test
    void findById () {

        // when
        when(categoryRepository.findById(anyLong()))
            .thenReturn(Optional.of(category));

        when(queryRepository.findPost(anyLong()))
            .thenReturn(Optional.of(post));

        // then
        queryRepository.findPost(1L).ifPresent(
            System.out::println
        );
    }
}