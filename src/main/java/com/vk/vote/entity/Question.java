package com.vk.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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
    @GeneratedValue
    private UUID id;
    private String text;
    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "questionId")
    private List<Answer> answerList;
    @ManyToOne
    @JoinColumn(name = "votingId", insertable = false, updatable = false)
    private Voting voting;
}
