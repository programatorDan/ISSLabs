package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table( name = "admin")
public class Admin extends org.example.Entity<Long> {
    private String Email;
    private String Password;
    private String Phone;

    @Column(name = "email")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Column(name = "phone")
    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    @Id
    @GeneratedValue(generator = "increment")
    public Long getId() {
        return this.Id;
    }
}
