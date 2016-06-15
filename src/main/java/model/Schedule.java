package model;


import java.time.LocalTime;

/**
 * Created by ositadinmaeze on 12/06/2016.
 */

public abstract class Schedule {
    private LocalTime startTime;
    private LocalTime endTime;


    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


}
