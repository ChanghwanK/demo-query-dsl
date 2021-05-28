package com.bloo.dsl.demodsl.domain.post;

import com.bloo.dsl.demodsl.domain.category.Category;
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
import lombok.ToString;

/**
 * CreateBy: Bloo Date: 2021/05/28
 */

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String author;
    private String content;

    @JoinColumn(name = "category_id")
    @ManyToOne (fetch = FetchType.LAZY)
    private Category category;
}
