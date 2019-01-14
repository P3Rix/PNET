package com.example.pnet.ejemplo;

public class User {
    private String name;
    private String dni;
    private String email;

    public User(String name, String dni, String email)
    {
        this.name = name;
        this.dni = dni;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
