package ru.ice.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ice.chat.entity.User;

/**
 * User: Maxim Burov
 * Time: 2022-08-30 20:47
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
