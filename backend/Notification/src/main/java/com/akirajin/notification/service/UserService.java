package com.akirajin.notification.service;

import com.akirajin.notification.entities.Category;
import com.akirajin.notification.entities.Channel;
import com.akirajin.notification.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    //    Mocking this part adding 3 users just for example purposes

    List<User> databaseUsers = new ArrayList<>(Arrays.asList(
            new User()
                    .setID(1)
                    .setName("Thomas")
                    .setEmail("thomas.ueda@alumni.usp.br")
                    .setPhone("+5511988888888")
                    .setChannels(new ArrayList<>(Arrays.asList(Channel.EMAIL)))
                    .setSubscribedCategories(new ArrayList<>(Arrays.asList(Category.MOVIES)))
            ,
            new User()
                    .setID(2)
                    .setName("Akira")
                    .setEmail("akirajin@gmail.com")
                    .setPhone("+5511988888881")
                    .setChannels(new ArrayList<>(Arrays.asList(Channel.PUSH, Channel.SMS)))
                    .setSubscribedCategories(new ArrayList<>(Arrays.asList(Category.FINANCE)))
            ,
            new User()
                    .setID(3)
                    .setName("Ueda")
                    .setEmail("thomas.ueda@alumni.usp.br")
                    .setPhone("+5511988888882")
                    .setChannels(new ArrayList<>(Arrays.asList(Channel.SMS)))
                    .setSubscribedCategories(new ArrayList<>(Arrays.asList(Category.MOVIES, Category.SPORTS)))


    ));


    public void addUser(String name, String email, String phone, List<Category> subscribedCategories, List<Channel> channels) {
        long lastID = databaseUsers.stream()
                .mapToLong(User::getID)
                .max()
                .orElse(0);

        User user = new User().setID(lastID + 1)
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .setSubscribedCategories(subscribedCategories)
                .setChannels(channels);

        databaseUsers.add(user);

    }

    public List<User> listAllUser() {
        return databaseUsers;
    }
}
