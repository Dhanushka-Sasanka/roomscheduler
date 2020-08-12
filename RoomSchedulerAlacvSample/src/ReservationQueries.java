
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 *
 * @author RachelBrooks
 */


public class ReservationQueries {
    
    private static Connection connection;
    private static PreparedStatement getReservationByDate;
    private static PreparedStatement getReservationEntry;
    private static PreparedStatement addReservationEntry;
    private static PreparedStatement getReservationByFaculty;
    //private static PreparedStatement addReservationsByDate;
    private static PreparedStatement cancelReservation;
    private static PreparedStatement deleteReservation;
    private static ResultSet resultSet;
    private static ResultSet resultSet2;
    
    public static void addReservationEntry(String name, String room, Date date, int seats, Timestamp timestamp)
            {
                connection = DBConnection.getConnection();
                try
                {
                   addReservationEntry = connection.prepareStatement("insert into reservations (faculty, rooms, date, seats, timestamp) values (?,?,?,?,?)");
                   addReservationEntry.setString(1, name); 
                   addReservationEntry.setString(2, room); 
                   addReservationEntry.setDate(3, date);
                   addReservationEntry.setInt(4, seats);
                   addReservationEntry.setTimestamp(5, timestamp);
                   
                   addReservationEntry.executeUpdate(); 
                }
                catch(SQLException sqlException)
                {
                    sqlException.printStackTrace();
                }
            }
    public static ArrayList<ReservationEntry> getReservationByDate (Date date)
    {
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservation = new ArrayList<ReservationEntry>();
        try
        {
            getReservationEntry = connection.prepareStatement("select faculty, rooms, date, seats, timestamp from reservations where date = (?)");
            getReservationEntry.setDate(1, date);
            resultSet2=getReservationEntry.executeQuery();
            while (resultSet2.next())
            {
                ReservationEntry newres = new ReservationEntry(resultSet2.getString(1), resultSet2.getString(2), resultSet2.getDate(3), resultSet2.getInt(4), resultSet2.getTimestamp(5));
                reservation.add(newres);
            }
        }
        catch(SQLException sqlException)
        {
              sqlException.printStackTrace();      
        }
        return reservation;
    }
    public static ArrayList<ReservationEntry> getReservationByFaculty (String name)
    {
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservation = new ArrayList<ReservationEntry>();
        try
        {
            getReservationByFaculty = connection.prepareStatement("select faculty, rooms, date, seats, timestamp from reservations where faculty = (?)");
            getReservationByFaculty.setString(1, name);
            resultSet2=getReservationByFaculty.executeQuery();
            while (resultSet2.next())
            {
                ReservationEntry newres = new ReservationEntry(resultSet2.getString(1), resultSet2.getString(2), resultSet2.getDate(3), resultSet2.getInt(4), resultSet2.getTimestamp(5));
                reservation.add(newres);
            }
        }
        catch(SQLException sqlException)
        {
              sqlException.printStackTrace();      
        }
        return reservation;
    }
    
    
    public static ArrayList<ReservationEntry> getReservationEntry ()
    {
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservation = new ArrayList<ReservationEntry>();
        try
        {
            getReservationEntry = connection.prepareStatement("select faculty, rooms, date, seats, timestamp from reservations");
            resultSet2=getReservationEntry.executeQuery();
            while (resultSet2.next())
            {
                ReservationEntry newres = new ReservationEntry(resultSet2.getString(1), resultSet2.getString(2), resultSet2.getDate(3), resultSet2.getInt(4), resultSet2.getTimestamp(5));
                reservation.add(newres);
            }
        }
        catch(SQLException sqlException)
        {
              sqlException.printStackTrace();      
        }
        return reservation;
    }
    public static ArrayList<String> getRoomsReservedByDate (Date date)
            {
                connection = DBConnection.getConnection();
                ArrayList<String> reservation = new ArrayList<String>();
                try
                {
                   getReservationByDate = connection.prepareStatement("select rooms from reservations where date=(?) order by rooms");
                   getReservationByDate.setDate(1, date); 
                   resultSet = getReservationByDate.executeQuery(); 
                   while (resultSet.next())
                    {
                    reservation.add(resultSet.getString(1));
                    } 
                }
                catch(SQLException sqlException)
                {
                    sqlException.printStackTrace();
                }
            return reservation;
            }
    
    public static int cancelReservation(String faculty, Date date){
        connection = DBConnection.getConnection(); 
        int count = 0;
        try
        {
            cancelReservation = connection.prepareStatement("delete from reservations where faculty = (?) and date = (?)");
            cancelReservation.setString(1, faculty);
            cancelReservation.setDate(2, date);
            count = cancelReservation.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count;
    }
    public static int deleteReservation(String room){
        connection = DBConnection.getConnection(); 
        int count = 0;
        try
        {
            deleteReservation = connection.prepareStatement("delete from reservations where rooms = (?)");
            deleteReservation.setString(1, room);
            count = deleteReservation.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count;
    }
}