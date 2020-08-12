# roomscheduler

This is a GUI room shceduler
The rooms are reservedby Faculty name. Faculty can request a room reservation for a specific Datebased on the number of seats they require. The room will be assigned by the program, faculty do not get to request a specific room.Each Dateis just a specific Date. Faculty areidentified by a single name. 

Faculty - A faculty member is added to the database. The faculty member is identified by only onename.

Reserve- Faculty Date Seats: The faculty memberwill be assigned aroomfor the requested Date, if there are seatsavailable. The rooms will be assigned in a best fit manner. Thefaculty membershould be assigned the smallest room that has enough seats for their request. If there are no rooms available or no rooms with enough seats available, the faculty memberwill be put on thewait list for that Date. The waiting list must be maintained in the order the faculty members tried to reserve their rooms. 

Status - Reserversations by Date: The Status command by Date will display the faculty members that have rooms reserved on that Date
Status - Waitlist:The Status command for the Waitlist will display all the Faculty members waiting for rooms.It will be displayed in Dateorder and then in the order of when the reservation was requested.

Drop Room - removes room : Remove room from database.aculty with this room reserved must get a reservation for another room for the date(s) they were originally booked, if possible. If not possible, the reservation should be added to the waitlist.Faculty should get reservations based on priority (their timestamp).User should be informed of all actions.

Status - Cancel Reservation by Date: 
Status - Cancel Waitlist by Entry :  Remove reservation or waitlist corresponding to that faculty and date from the database. Must cancel reservation by faculty and date only (should not include room number). If a reservation was cancelled, check the waitlist and make a reservation for any faculty waiting for that date that will fit in the room o    Faculty from waitlist must be booked in order of their position (timestamp).


Database: The RoomsTable should be preloaded with several Rooms such as 101, 102 and the number of seats inthe room. You should have a different number of seats per roomso that you can test the proper reservation of rooms for different class sizes.You will be shown how to preload tables with values.The DateTable should be preloaded with several Dates of your choice.These are just normal Dates.The database tables should not contain redundant data, i.e. relevant data should only appear in one table.

GUI: 
You can have a separate tab for each function, or you can combine multiple functions on the same tab.
You should have combo boxes to check faculty status, drop room, cancel faculty date, etc.
The combo boxes should be updated automatically when additional data is added to the database.
When a command is performed, the results of that command should be displayed to the user without the user needing to check the status to see what was done.  For example, if you add a faculty to the database you should display the name of the faculty that was added and if the faculty was added to the database successfully.  Likewise, after adding a reservation, you should display which faculty was booked on which room on what date.  If a room is full, you must display information that the faculty was added to the waitlist





