package com.vk.vote.repository;

import com.vk.vote.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Viktor.
 */
public interface AnswerRepository extends JpaRepository<Answer, UUID> {
}
