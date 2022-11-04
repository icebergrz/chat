package ru.ice.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * User: Maxim Burov
 * Time: 2022-08-31 08:37
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String chatname;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "chat")
    List<Message> messages;

    @Temporal(TemporalType.TIMESTAMP)
    Date sysCreateDate;
}
