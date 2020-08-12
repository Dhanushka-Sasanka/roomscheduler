/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


 *
 * @author RachelBrooks
 */
import java.sql.Timestamp;
import java.sql.Date;

public class ReservationEntry 
{
    
    private String name;
    private int seats;
    private Date date;
    private String room;
    private Timestamp timestamp;
    
    public ReservationEntry(String name, String room, Date date, int seats , Timestamp timestamp)
    {  
        setName(name);
        getName();
        
        setSeats(seats);
        getSeats();
        
        setDate(date);
        getDate();
        
        setRoom(room);
        getRoom();
        
        getTimestamp();     
        setTimestamp(timestamp);
    }
    
    public void setName(String name)
    {
        this.name= name;
    }
    public String getName()
    {
        return name;
    }
    
    public void setSeats(int seats)
    {
        this.seats= seats;
    }
    public int getSeats()
    {
        return seats;
    }
    
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    public Date getDate()
    {
        return date;
    }
    
    
    public void setRoom(String room)
    {
        this.room= room;
    }
    public String getRoom(){
        return room;
    }
    
    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }
    
    public Timestamp getTimestamp()
    {
        return timestamp;
        
    }
    
}
