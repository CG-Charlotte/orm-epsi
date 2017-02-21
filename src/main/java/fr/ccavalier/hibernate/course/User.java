package fr.ccavalier.hibernate.course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccavalie on 31/01/2017.
 */

public class User {

    Integer id;
    String firstName;
    String lastName;

    String city;
    String email;

    static class Media{
        String value;
        String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private List<Media> contacts = new ArrayList<Media>();

    public List<Media> getContacts() {
        return contacts;
    }

    public void setContacts(List<Media> contacts) {
        this.contacts = contacts;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + firstName + ", city=" + city + "]";
    }

}