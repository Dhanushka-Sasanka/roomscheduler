/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RachelBrooks
 */

public class RoomEntry 
{
    
    private String name;
    private int seats;
    
    
    public RoomEntry(String name, int seats)
    {
        setName(name);
        getName();
        
        
        setSeats(seats);
        getSeats();
        
    } 
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    
    public void setSeats(int seats)
    {
        this.seats = seats;
    }
    public int getSeats()
    {
        return seats;
    }
}