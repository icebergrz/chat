package ru.ice.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ice.chat.entity.Chat;
import ru.ice.chat.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * User: Maxim Burov
 * Time: 2022-08-31 08:54
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findAllByUser(User user);

    Chat findByUser(User user);
}
