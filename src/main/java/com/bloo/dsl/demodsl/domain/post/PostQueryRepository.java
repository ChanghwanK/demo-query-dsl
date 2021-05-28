package com.bloo.dsl.demodsl.domain.post;

import static javax.management.Query.eq;

import static com.bloo.dsl.demodsl.domain.post.QPost.post;
import static com.bloo.dsl.demodsl.domain.category.QCategory.category;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * CreateBy: Bloo Date: 2021/05/28
 */

@RequiredArgsConstructor
@Repository
public class PostQueryRepository {

    private final JPAQueryFactory queryFactory;

    public Optional<Post> findPost(Long id) {
        return Optional.ofNullable(queryFactory.selectFrom(post)
            .where(post.Id.eq(id))
            .fetchOne());
    }

    public List<Post> findAllPosts() {
        return queryFactory.selectFrom(post)
            .innerJoin(post.category, category)
            .fetch();
    }
}
