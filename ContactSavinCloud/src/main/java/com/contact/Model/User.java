package com.contact.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_id;
    @Size(min = 4, max = 20 ,message = "between range")
    private String name;
    @NotBlank
    @NotEmpty
    @NotNull
    @Column(unique=true)
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;
    @NotBlank
    @NotEmpty
    private String password;
    @Pattern(regexp = "^(?![12345])[6-9][0-9]{9}$", message = "Invalid phone number")
    private String phone;
    @Column(columnDefinition = "varchar(10) default 'ROLE_USER'")
    private String role;
    @ColumnDefault("true")
    private boolean enabled;
    @ColumnDefault("default.png")
    private String imageUrl;

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contact> contact;

    public User(String name, String email, String password, String phone, String role, boolean enabled, String imageUrl, String about) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.enabled = enabled;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return u_id;
    }

    public void setId(int u_id) {
        this.u_id = u_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public User() {
        super();
    }
}
