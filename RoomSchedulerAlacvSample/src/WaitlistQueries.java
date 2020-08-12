
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author RachelBrooks
 */
public class WaitlistQueries {
    public static Connection connection; 
    private static PreparedStatement getWaitlistByDate;
    private static PreparedStatement addWaitlistEntry; 
    private static PreparedStatement getWaitlistByFaculty; 
    private static PreparedStatement cancelWaitlistEntry; 
    private static PreparedStatement deleteWaitlistEntry;
    private static ResultSet resultSet; 
    
    
public static void addWaitlistEntry(String faculty, Date date, int seats, Timestamp timestamp){
    connection = DBConnection.getConnection();
    try{
        addWaitlistEntry = connection.prepareStatement("insert into waitlist (faculty, date, seats, timestamp) values (?,?,?,?)");
        addWaitlistEntry.setString(1, faculty);
        addWaitlistEntry.setDate(2, date);
        addWaitlistEntry.setInt(3, seats);
        addWaitlistEntry.setTimestamp(4, timestamp);
        addWaitlistEntry.executeUpdate();
    }
    catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
}

public static ArrayList<WaitlistEntry> getWaitlistByDate(Date date){
    connection = DBConnection.getConnection();
    ArrayList<WaitlistEntry> waitlists = new ArrayList<WaitlistEntry>();
    try 
    {
        getWaitlistByDate = connection.prepareStatement("Select faculty, date, seats, timestamp from waitlist where date = (?) order by timestamp");
        getWaitlistByDate.setDate(1, date);
        resultSet = getWaitlistByDate.executeQuery();
        
        while(resultSet.next()){
            WaitlistEntry waitlist = new WaitlistEntry(resultSet.getString(1), resultSet.getDate(2), resultSet.getInt(3), resultSet.getTimestamp(4));
            waitlists.add(waitlist);
        }
    }
    catch(SQLException sqlException)
    {
        sqlException.printStackTrace();
    }
    return waitlists; 
}
public static ArrayList<WaitlistEntry> getWaitlistByFaculty(String faculty){
    connection = DBConnection.getConnection();
    ArrayList<WaitlistEntry> waitlists = new ArrayList<WaitlistEntry>();
    try 
    {
        getWaitlistByFaculty = connection.prepareStatement("select faculty, date, seats, timestamp from waitlist where faculty = ?");
        resultSet = getWaitlistByFaculty.executeQuery();
        
        while(resultSet.next()){
            WaitlistEntry waitlist = new WaitlistEntry(resultSet.getString(1), resultSet.getDate(2), resultSet.getInt(3), resultSet.getTimestamp(4));
            waitlists.add(waitlist);
        }
    }
    catch(SQLException sqlException)
    {
        sqlException.printStackTrace();
    }
    return waitlists; 
}
public static int cancelWaitlistEntry(String faculty, Date date){
    connection = DBConnection.getConnection();
    int count=0;
    try
    {
        cancelWaitlistEntry = connection.prepareStatement("delete from waitlist where faculty = ? and date = ?");
        cancelWaitlistEntry.setString(1, faculty);
        cancelWaitlistEntry.setDate(2, date);
        count = cancelWaitlistEntry.executeUpdate();
    }
    catch(SQLException sqlException)
    {
        sqlException.printStackTrace();
    }
    return count;
}//end cancelwaitlistentry

}
    
   
