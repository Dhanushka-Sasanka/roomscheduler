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

/**
 *
 * @author RachelBrooks
 */


public class RoomQueries {
    
    private static Connection connection;
    private static PreparedStatement getAllPossibleRooms;
    private static PreparedStatement getRooms;
    private static PreparedStatement addRoom;
    private static PreparedStatement dropRoom;
    private static PreparedStatement getSeatsfromRoom;
    private static ResultSet resultSet;
    
    public static ArrayList<String> getAllPossibleRooms(int seats)
    {
        connection = DBConnection.getConnection();
        ArrayList<String> room = new ArrayList<String>();
        try
        {
            getAllPossibleRooms = connection.prepareStatement("select name from rooms where seats >= (?) order by seats");
            getAllPossibleRooms.setInt(1, seats);
            resultSet = getAllPossibleRooms.executeQuery();
            
            while(resultSet.next())
            {
                room.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return room;
    }
    public static int getSeatsfromRoom(String name)
    {
        connection = DBConnection.getConnection();
        int seats = 0;
        try
        {
            getSeatsfromRoom = connection.prepareStatement("select * from ROOMS where NAME=?");
            getSeatsfromRoom.setString(1, name);
            resultSet = getSeatsfromRoom.executeQuery();
            if (resultSet.next()) { System.out.println("not empty");}
            seats = resultSet.getInt("SEATS");
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return seats;
    }
    public static ArrayList<String> getRooms()
    {
        connection = DBConnection.getConnection();
        ArrayList<String> rooms = new ArrayList<String>();
        try
        {
            getRooms = connection.prepareStatement("select name from rooms");
            resultSet = getRooms.executeQuery();
            
            while(resultSet.next())
            {
                rooms.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return rooms;
    }
    
    public static void addRoom(String name, int seats)
    {
        connection = DBConnection.getConnection();
        try
        {
            addRoom = connection.prepareStatement("insert into rooms (name, seats) values (?,?)");
            addRoom.setString(1, name);
            addRoom.setInt(2, seats);
            addRoom.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static void dropRoom(String name)
    {
        connection=DBConnection.getConnection();
        try
        {
            dropRoom = connection.prepareStatement("delete from rooms where name=(?)");
            dropRoom.setString(1, name);
            dropRoom.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
}

    

