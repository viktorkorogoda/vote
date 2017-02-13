package com.vk.vote.repository;

import com.vk.vote.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

/**
 * Created by Viktor.
 */
public interface QuestionRepository extends JpaRepository<Question, UUID> {

}
