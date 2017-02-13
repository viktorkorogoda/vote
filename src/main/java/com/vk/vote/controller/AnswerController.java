package com.vk.vote.controller;

import com.vk.vote.entity.Answer;
import com.vk.vote.entity.Vote;
import com.vk.vote.service.AnswerService;
import com.vk.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Viktor.
 */
@Controller
@RequestMapping(value = "answer")
public class AnswerController {

    private final AnswerService answerService;
    private final VoteService voteService;

    @Autowired
    public AnswerController(AnswerService answerService, VoteService voteService) {
        this.answerService = answerService;
        this.voteService = voteService;
    }

    @RequestMapping(value = "reg", method = RequestMethod.PUT)
    public Answer registerVote(UUID answerId){
        return answerService.registerVote(answerId);
    }
}
