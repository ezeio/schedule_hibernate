package model;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by ositadinmaeze on 12/06/2016.
 */

public abstract class Schedule {
    private Timestamp startTime;
    private Timestamp endTime;


    public void setStartTime(Timestamp timestamp){
        startTime = timestamp;
    };
    public void getStartTime(Timestamp timestamp){
        endTime = timestamp;
    }
}
