package com.jsystems.mockitoPacket;

//Adnotacje używane przy użyciu ORM-a hibernate
//@Entity
public class UserMock {

//    @Id
    private Long id;

//    @Column(name = "name")
    private String name;
//    @Column(name = "surname")
    private String surname;

    public UserMock(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public UserMock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "UserMock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
