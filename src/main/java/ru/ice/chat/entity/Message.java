package ru.ice.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * User: Maxim Burov
 * Time: 2022-08-31 08:48
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String messageText;

    @ManyToOne
    User user;

    @ManyToOne
    Chat chat;

    @Temporal(TemporalType.TIMESTAMP)
    Date sysCreateDate;
}
