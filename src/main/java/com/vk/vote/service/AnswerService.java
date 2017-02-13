package com.vk.vote.service;

import com.vk.vote.entity.Answer;
import com.vk.vote.entity.Vote;
import com.vk.vote.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Viktor.
 */
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }


    public Answer registerVote(UUID answerId){
        Answer answer = getAnswerById(answerId);
        Vote vote = new Vote(UUID.randomUUID(), answerId, LocalDateTime.now());
        answer.getVoteList().add(vote);
        return answerRepository.saveAndFlush(answer);
    }

    public Answer getAnswerById(UUID answerId){
        return answerRepository.getOne(answerId);
    }
}
