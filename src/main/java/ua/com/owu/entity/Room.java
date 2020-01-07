package ua.com.owu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

private  String roomNumber;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Room(String roomNumber, List<User> userList) {
        this.roomNumber = roomNumber;
        this.userList = userList;
    }

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Room() {
    }

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinTable(name = "room_user",
            inverseJoinColumns = @JoinColumn(name = "users_id")
            ,
            joinColumns = @JoinColumn(name = "rooms_id")
    )
List<User> userList = new ArrayList<>();

}
