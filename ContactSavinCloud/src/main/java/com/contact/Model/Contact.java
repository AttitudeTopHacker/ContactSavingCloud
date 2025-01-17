package com.contact.Model;

import jakarta.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Contact{" +
                "c_id=" + c_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", image_c='" + image_c + '\'' +
                ", work='" + work + '\'' +
                ", user=" + user +
                '}';
    }

    private String email;
    private String phone;
    private String image_c;
    private String work;
    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contact(String firstName, String lastName, String email, String phone, String image_c, String work) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.image_c = image_c;
        this.work = work;
    }


    public Contact() {

    }

    public int getId() {
        return c_id;
    }

    public void setId(int c_id) {
        this.c_id = c_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage_c() {
        return image_c;
    }

    public void setImage_c(String image_c) {
        this.image_c = image_c;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
