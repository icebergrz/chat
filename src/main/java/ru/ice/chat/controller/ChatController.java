package ru.ice.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ice.chat.entity.Chat;
import ru.ice.chat.entity.Message;
import ru.ice.chat.repository.UserRepository;
import ru.ice.chat.service.ChatService;
import ru.ice.chat.service.MessageService;
import ru.ice.chat.service.UserService;

/**
 * User: Maxim Burov
 * Time: 2022-08-31 08:57
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageService messageService;

    @GetMapping
    public String userChats(Model model) {
        String username = userService.getCurrentUsername();

        model.addAttribute("chats", chatService.userChats(userRepository.findByUsername(username)));

        return "chat/index";
    }

    @GetMapping("/new")
    public String newChat(@ModelAttribute("chat") Chat chat) {
        return "chat/new";
    }

    @PostMapping
    public String addChat(@ModelAttribute("chat") Chat chat) {
        chatService.addChat(chat);
        return "redirect:/chat";
    }

    @PostMapping("/{id}")
    public String addMessage(@PathVariable("id") Long id, @ModelAttribute("message") Message message) {
        Chat chat = chatService.selectChat(id);

        messageService.addMessage(message, id);
        assert chat != null;

        return "redirect:/chat/" + chat.getId();
    }

    @GetMapping("/{id}")
    public String selectChat(@ModelAttribute("message") Message message, @PathVariable("id") Long id, Model model) {
        Chat chat = chatService.selectChat(id);
        model.addAttribute("selectedChat", chat);
        model.addAttribute("chats", chatService.allChats());
        model.addAttribute("messages", messageService.chatMessages(chat));
        return "chat/index";
    }
}
