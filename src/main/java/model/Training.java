package model;

import javax.persistence.Column;
import javax.persistence.Id;


/**
 * Created by ositadinmaeze on 12/06/2016.
 */
public class Training {
    @Id
    private Long id;
    @Column
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

}
