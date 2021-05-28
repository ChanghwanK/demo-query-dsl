package com.bloo.dsl.demodsl.domain.comment;

import com.bloo.dsl.demodsl.domain.post.Post;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CreateBy: Bloo Date: 2021/05/28
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String author;
    private String content;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "post_id")
    private Post post;
}
