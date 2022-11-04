package ru.ice.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ice.chat.entity.Chat;
import ru.ice.chat.entity.Message;
import ru.ice.chat.entity.User;
import ru.ice.chat.repository.ChatRepository;
import ru.ice.chat.repository.MessageRepository;
import ru.ice.chat.repository.UserRepository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * User: Maxim Burov
 * Time: 2022-08-31 08:57
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;

    public Message addMessage(Message message, Long id) {
        Calendar calendar = new GregorianCalendar();
        message.setSysCreateDate(calendar.getTime());

        User user = userRepository.findByUsername(UserService.getCurrentUsername());
        Chat chat = chatRepository.findById(id).orElse(null);

        message.setUser(user);
        message.setChat(chat);

        return messageRepository.saveAndFlush(message);
    }

    public List<Message> chatMessages(Chat chat) {
        return messageRepository.findAllByChat(chat);
    }
}
