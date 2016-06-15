package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ositadinmaeze on 14/06/2016.
 */


public class WorkSchedule extends Schedule {

    private LocalDate startDate;
    private LocalDate endDate;
    private String note;
    private Employee employee;
    private ServiceUser serviceUser;

    public WorkSchedule(){}
    public WorkSchedule(LocalTime startTime, LocalTime endTime, LocalDate startDate, LocalDate endDate, String note, Employee employee, ServiceUser serviceUser){}


    public void findUs(){

    }

    public static void main(String[] arg){
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("HH mm");
        WorkSchedule workSchedule = new WorkSchedule();
        LocalTime t = LocalTime.parse("22 00",fm);

        workSchedule.setStartTime(t);

        System.out.println(workSchedule.getStartTime());
        System.out.println(t.minusHours(8));
    }
}
