package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ositadinmaeze on 12/06/2016.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sex")
    private String Sex;

    @Column(name = "employee_role")
    private String employeeRole;

    @ElementCollection
    @CollectionTable(name="employee_skill_types", joinColumns=@JoinColumn(name="id"))
    @Column(name = "skill_type")
    private Set<String> skillType = new HashSet();


    public Employee(){}

    public Employee(String firstName, String middleName, String lastName, String sex, String employeeRole, Set<String> skillType){
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setSex(sex);
        this.setEmployeeRole(employeeRole);
        this.setSkillType(skillType);
    }

    public Employee(String firstName, String lastName, String sex, String employeeRole, Set <String> skillType){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSex(sex);
        this.setEmployeeRole(employeeRole);
        this.setSkillType(skillType);
    }

    public Employee(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public Set<String> getSkillType() {
        return skillType;
    }

    public void setSkillType(Set<String> skillType) {
        this.skillType = skillType;
    }

    @Override
    public String toString(){
        return this.getFirstName() + " " + this.getLastName() + " " + this.getSkillType();
    }
}
