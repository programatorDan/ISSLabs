package org.example.dto;

import java.io.Serializable;

public class AdminDto implements Serializable {
    private String Email;
    private String Password;
    private String Phone;
    private Long Id;

    public AdminDto(String email, String password, String phone, Long id) {
        Email = email;
        Password = password;
        Phone = phone;
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhone() {
        return Phone;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Id=" + Id +
                '}';
    }
}
