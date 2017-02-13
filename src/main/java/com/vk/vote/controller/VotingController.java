package com.vk.vote.controller;

import com.vk.vote.entity.Voting;
import com.vk.vote.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

/**
 * Created by Viktor.
 */
@Controller
@RequestMapping(value = "voting")
public class VotingController {

    private final VotingService votingService;

    @Autowired
    public VotingController(VotingService votingService) {
        this.votingService = votingService;
    }

    @RequestMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST
    )
    public Voting createVoting(@RequestBody Voting voting) {
        return votingService.createVoting(voting);
    }

    @RequestMapping(value = "/close/{votingId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Voting closeVoting(@Param(value = "votingId") UUID votingId) {
        return votingService.closeVoting(votingId);
    }

    @RequestMapping(value = "/start", consumes = MediaType.APPLICATION_JSON_VALUE, produces=  MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Voting startVoting(@RequestBody Voting voting) {
        return votingService.startVoting(voting);
    }
}
