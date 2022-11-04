package ru.ice.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ice.chat.entity.Chat;
import ru.ice.chat.entity.User;
import ru.ice.chat.repository.ChatRepository;
import ru.ice.chat.repository.UserRepository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * User: Maxim Burov
 * Time: 2022-08-31 08:57
 */
@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    public List<Chat> allChats() {
        return chatRepository.findAll();
    }

    public List<Chat> userChats(User user) {
        return chatRepository.findAllByUser(user);
    }

    public Chat addChat(Chat chat) {
        Calendar calendar = new GregorianCalendar();
        chat.setSysCreateDate(calendar.getTime());

        String username = userService.getCurrentUsername();
        chat.setUser(userRepository.findByUsername(username));

        return chatRepository.saveAndFlush(chat);
    }

    public Chat selectChat(Long id) {
        return chatRepository.findById(id).orElse(null);
    }
}
