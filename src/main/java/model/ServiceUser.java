package model;

import javax.persistence.*;

/**
 * Created by ositadinmaeze on 12/06/2016.
 */
@Entity
@Table(name = "service_user")
public class ServiceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    public ServiceUser (){}
    public ServiceUser(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
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
}
