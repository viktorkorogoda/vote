package com.vk.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Viktor.
 */
@Data
@Entity
@Table(name = "votes")
@NoArgsConstructor
@AllArgsConstructor
public class Vote {

    @Id
    @GeneratedValue
    private UUID id;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "answerId", updatable = false, insertable = false)
    private Answer answer;
}
