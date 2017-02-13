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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "votes")
public class Vote {
    @Id
    private UUID id;
    @Column(name = "answer_id")
    private UUID answer;
    private LocalDateTime date;
}
