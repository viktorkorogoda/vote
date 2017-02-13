package com.vk.vote.entity;

import lombok.*;

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
@Table(name = "votings")
public class Voting {
    @Id
    private UUID id;
    private String title;
    private String link;
    private String result;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    private List<Question> questionList;
    private boolean opened;
}
