package com.wecp.progressive.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Vote;
import com.wecp.progressive.repository.VoteRepository;
import com.wecp.progressive.service.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
 
@Service
public class VoteServiceImpl{
 
    @Autowired
    private VoteRepository voteRepository;
 
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> votes = voteRepository.findAll();
        return ResponseEntity.ok(votes);
    }
 
    public ResponseEntity<Integer> createVote(Vote vote) {
        Vote savedVote = voteRepository.save(vote);
        return ResponseEntity.status(201).body(savedVote.getVoteId());
    }
 
    public ResponseEntity<Map<String, Long>> getVotesCountOfAllCategories() {
        List<Object[]> results = voteRepository.countVotesByCategory();
        Map<String, Long> votesCount = new HashMap<>();
        for (Object[] result : results) {
            String category = (String) result[0];
            Long totalVotes = (Long) result[1];
            votesCount.put(category, totalVotes);
        }
        return ResponseEntity.ok(votesCount);
    }
}