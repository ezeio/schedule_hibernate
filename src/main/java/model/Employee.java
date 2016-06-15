package model;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by ositadinmaeze on 12/06/2016.
 */
@Entity
@Table(name = "")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "sex")
    private String Sex;
    @Column(name = "employee_role")
    private String employeeRole;
    @Column(name = "skill_type")
    private ArrayList<String> skillType;


    public Employee(){}

    public Employee(String firstName, String lastName, String sex, String employeeRole, ArrayList <String> skillType){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSex(sex);
        this.setEmployeeRole(employeeRole);
        this.setSkillType(skillType);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public ArrayList<String> getSkillType() {
        return skillType;
    }

    public void setSkillType(ArrayList<String> skillType) {
        this.skillType = skillType;
    }
}
