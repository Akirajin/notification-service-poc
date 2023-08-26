package com.akirajin.notification.controllers;

import com.akirajin.notification.entities.LogHistory;
import com.akirajin.notification.service.LogService;
import com.akirajin.notification.controllers.response.LogResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
        return allHistory.stream().map(h ->
                new LogResponse()
                        .setDatetime(h.getDatetime())
                        .setUser(h.getUser())
                        .setCategory(h.getCategory())
                        .setChannel(h.getChannel())).collect(Collectors.toList());
    }

}
