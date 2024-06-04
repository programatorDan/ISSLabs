package org.example;

import java.util.Objects;

public class RepoRoom {
    public void addRoom(Room room) {
        HibernateUtils.getRoom().inTransaction(session -> session.persist(room));
    }

    public void updateRoom(Room room) {
        HibernateUtils.getRoom().inTransaction(session -> {
            if (!Objects.isNull(session.find(Room.class, room.getId()))) {
                session.merge(room);
                session.flush();
            }
        });
    }
}
