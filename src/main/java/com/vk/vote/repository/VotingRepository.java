package com.vk.vote.repository;

import com.vk.vote.entity.Voting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Viktor.
 */
public interface VotingRepository  extends JpaRepository<Voting, UUID>{
}
