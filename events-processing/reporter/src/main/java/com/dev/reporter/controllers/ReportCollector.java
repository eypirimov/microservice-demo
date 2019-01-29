package com.dev.reporter.controllers;

import com.dev.reporter.services.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/report")
public class ReportCollector {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/action/{postId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getTotalActionLikeAndUnlikeByPostId(@PathVariable String postId) {
        log.info("ReportCollector <getTotalActionLikeAndUnlikeByPostId>  Input Post Id {}", postId);
        return ResponseEntity.ok(reportService.getActionCountByPostId(postId));
    }
}
