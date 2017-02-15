package com.vk.vote.controller;

import com.vk.vote.entity.Answer;
import com.vk.vote.entity.Voting;
import com.vk.vote.service.AnswerService;
import com.vk.vote.service.VotingService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Viktor.
 */
@Controller
@RequestMapping(value = "voting")
public class VotingController {

    private final VotingService votingService;
    private final AnswerService answerService;

    @Autowired
    public VotingController(VotingService votingService, AnswerService answerService) {
        this.votingService = votingService;
        this.answerService = answerService;
    }

    @RequestMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST
    )
    @ResponseBody
    public Voting createVoting(@RequestBody Voting voting) {
        val voting1 =  votingService.createVoting(voting);
        return voting1;
    }

    @RequestMapping(value = "/close/{votingId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Voting closeVoting(@PathVariable String votingId) {
        return votingService.closeVoting(UUID.fromString(votingId));
    }

    @RequestMapping(value = "/start/{votingId}", produces=  MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Voting startVoting(@PathVariable UUID votingId) {
        return votingService.startVoting(votingId);
    }

    @RequestMapping(value = "/vote/{answerId}", method = RequestMethod.PUT, produces=  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Voting registerVote(@PathVariable UUID answerId) {
        UUID votingId =  answerService.registerVote(answerId).getId();
        return votingService.getVoting(votingId);
    }

    @RequestMapping(value = "/{votingId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public Voting getVoting(@PathVariable UUID votingId){
        val vot =  votingService.getVoting(votingId);
        return vot;
    }
}
