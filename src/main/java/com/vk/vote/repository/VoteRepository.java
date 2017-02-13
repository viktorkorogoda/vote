package com.vk.vote.repository;

import com.vk.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Viktor.
 */
public interface VoteRepository extends JpaRepository<Vote, UUID> {
}
