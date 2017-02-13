package com.vk.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Viktor.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id
    private UUID id;
    private String text;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    private List<Answer> answerList;

}
