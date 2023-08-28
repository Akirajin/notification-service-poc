package com.akirajin.notification.controllers;

import com.akirajin.notification.controllers.response.LogResponse;
import com.akirajin.notification.entities.LogHistory;
import com.akirajin.notification.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logs")
public class LogRest {

    LogService logService;

    @Autowired
    public LogRest(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    List<LogResponse> getAllLogs() {
        List<LogHistory> allHistory = logService.getAllLogs();
        List<LogResponse> history = allHistory.stream().map(h ->
                new LogResponse()
                        .setDatetime(h.getDatetime())
                        .setUser(h.getUser().getName())
                        .setCategory(h.getCategory())
                        .setMessage(h.getMessage())
                        .setChannel(h.getChannel())).collect(Collectors.toList());

        return ResponseEntity.ok().body(history).getBody();
    }

    @DeleteMapping
    void resetLogs(){
        logService.resetLogs();
    }

}
