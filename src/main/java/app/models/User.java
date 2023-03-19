package app.models;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Proxy(lazy = false) // ←-- это какая-то странная фигня, ухудшающая перформанс,
@Table(name = "users") // но без неё вылетает org.hibernate.LazyInitializationException 🤷‍♂️
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private byte age;
    @Column
    private String email;

    public User() {
    }

    public User(String name, String lastName, byte age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .add("email='" + email + "'")
                .toString();
    }
}
