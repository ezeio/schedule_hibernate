package model;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by ositadinmaeze on 12/06/2016.
 */
public class Training {
    private String Title;

    public Training (){}

    public Training(String title){
        this.setTitle(title);
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void us(){
       try{
           DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
           Date date = dateFormat.parse("23/06/2016");
           Timestamp time = new Timestamp("")
           WorkSchedule workSchedule = new WorkSchedule();
           workSchedule.setStartTime();
       }catch(Exception ex){
           ex.printStackTrace();
       }

    }
}
