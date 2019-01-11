package uca.es.congress;

import java.io.Serializable;

public class Users implements Serializable {
    private String name;
    private String lastname;
    private String dni;
    private int telephone;
    private int type;
    private String email;
    private String start_date;
    private String end_date;

    public Users(String name, String lastname, String dni, int telephone, String email, String start_date, String end_date, int type) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.telephone = telephone;
        this.email = email;
        this.start_date = start_date;
        this.end_date = end_date;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
