package com.akirajin.notification.service;

import com.akirajin.notification.entities.Category;
import com.akirajin.notification.entities.Channel;
import com.akirajin.notification.entities.LogHistory;
import com.akirajin.notification.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {
    List<LogHistory> databaseLogs = new ArrayList<>();

    public void addLog(User user, Category category, List<Channel> channel) {
        databaseLogs.add(new LogHistory(user, category, channel));
    }

    public List<LogHistory> getAllLogs() {
        return databaseLogs;
    }
}
