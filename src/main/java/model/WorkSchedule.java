package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ositadinmaeze on 14/06/2016.
 */

@Entity
@Table(name = "work_schedule")
public class WorkSchedule extends Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name="note_on_schedule")
    private String noteOnSchedule;

   // private Employee employee;
    //private ServiceUser serviceUser;

    public WorkSchedule(){}
    public WorkSchedule(LocalTime startTime, LocalTime endTime, LocalDate startDate, LocalDate endDate, String noteOnSchedule, Employee employee, ServiceUser serviceUser){
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setNoteOnSchedule(noteOnSchedule);
      //  this.employee = employee;
        //this.serviceUser = serviceUser;

    }


    public void findUs(){

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getNoteOnSchedule() {
        return noteOnSchedule;
    }

    public void setNoteOnSchedule(String noteOnSchedule) {
        this.noteOnSchedule = noteOnSchedule;
    }

  /*  public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ServiceUser getServiceUser() {
        return serviceUser;
    }

    public void setServiceUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }
*/

    public static void main(String[] arg){
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("HH mm");
        WorkSchedule workSchedule = new WorkSchedule();
        LocalTime t = LocalTime.parse("22 00",fm);

        workSchedule.setStartTime(t);

        System.out.println(workSchedule.getStartTime());
        System.out.println(t.minusHours(8));
    }
}
