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
        voting.setLink("/voting/" + votingId.toString());
        voting.setResult("/result/" + votingId.toString());
        return votingRepository.save(voting);
    }

    public Voting startVoting(UUID votingId){
        Voting voting = votingRepository.getOne(votingId);
        voting.setOpened(true);
        return votingRepository.save(voting);
    }

    public Voting closeVoting(UUID uuid){
        Voting voting = votingRepository.findOne(uuid);
        voting.setOpened(false);
        return votingRepository.save(voting);
    }

    public Voting getVoting(UUID votingId){
        return votingRepository.getOne(votingId);
    }


}
