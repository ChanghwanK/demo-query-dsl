package com.bloo.dsl.demodsl.domain.comment;

import com.bloo.dsl.demodsl.domain.category.Category;
import com.bloo.dsl.demodsl.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CreateBy: Bloo Date: 2021/05/28
 */
public interface CommentRepository extends JpaRepository<Category, Long> {

}
