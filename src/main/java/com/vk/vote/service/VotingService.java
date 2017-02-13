package com.vk.vote.service;

import com.vk.vote.entity.Voting;
import com.vk.vote.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Viktor.
 */
@Service
public class VotingService {

    private final VotingRepository votingRepository;

    @Autowired
    public VotingService(VotingRepository votingRepository) {
        this.votingRepository = votingRepository;
    }

    public Voting createVoting(Voting voting){
        UUID votingId = UUID.randomUUID();
        voting.setId(votingId);
        voting.setLink("/" + votingId.toString());
        voting.setResult("/result/" + votingId.toString());
        return votingRepository.saveAndFlush(voting);
    }

    public Voting startVoting(Voting voting){
        voting.setOpened(true);
        return votingRepository.saveAndFlush(voting);
    }

    public Voting closeVoting(UUID uuid){
        Voting voting = votingRepository.findOne(uuid);
        voting.setOpened(false);
        return votingRepository.saveAndFlush(voting);
    }
}
