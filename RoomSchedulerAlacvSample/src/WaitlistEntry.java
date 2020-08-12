/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Date;
import java.sql.Timestamp;
/**
 *
 * @author RachelBrooks
 */

public class WaitlistEntry 
{
    private String faculty;
    private Date date;
    private int seats;
    private Timestamp timestamp;
    
    
    public WaitlistEntry(String faculty, Date date, int seats, Timestamp timestamp)
    {
        
        getFaculty();
        setFaculty(faculty);
        
        getDate();
        setDate(date);
        
        getSeats();
        setSeats(seats);
        
        getTimestamp();
        setTimestamp(timestamp);
      
    }
 
    public String getFaculty() 
    {
        return faculty;
    }

    public void setFaculty(String faculty) 
    {
        this.faculty = faculty;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public int getSeats() 
    {
        return seats;
    }

    public void setSeats(int seats) 
    {
        this.seats = seats;
    }
    
    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp=timestamp;
    }
    
    public Timestamp getTimestamp()
    {
        return timestamp;
        
    }
    
    
    
}
