package com.vk.vote.entity;

import lombok.*;
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
@Table(name = "votings")
public class Voting {
    @Id
    private UUID id;
    private String title;
    private String link;
    private String result;
    @OneToMany
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "votingId")
    private List<Question> questionList;
    private boolean opened;
}
