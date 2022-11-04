package ru.ice.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ice.chat.entity.Chat;
import ru.ice.chat.entity.Message;

import java.util.List;

/**
 * User: Maxim Burov
 * Time: 2022-08-31 08:55
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByChat(Chat chat);
}
