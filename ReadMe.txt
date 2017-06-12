This repository includes the eclipse java project for the code test as issued by Viagogo and a runnable .jar file. 

The raw code can be examined by directing to [address within]

To run the code, run the following when in the same directory as the .jar file 
java -jar Viagogo.jar 

For examining the application, the most intuitive way to follow the flow of the application is:
Core -> Grid -> Location -> Event -> Ticket
and MyTools and Values as required.

MyTools contains a few general methods. 
Values is an enum file that contains several "constant variables" ie numbers that are set within the running of this application but are likely to change when the application scales up.
They have been isolated for ease of expansion of many parts of the application, but more importantly if the "world size" changes.

For the seeding of information, I have given each location a 1/10 chance in having and event but only one event will be populated. 
However, each location can indeed have more than one event.


Assumptions
- every index in the 2d array (grid) represents a "street corner" (to rationalize the manhattan distance.)
- grid includes 0,0 and the revelant line
- max capacity for an event is 20 (can be changed in Values)
- max ticket price is 100 (can be changed in Values)
- if there are too many events the same distance apart, all will be displayed, but no further distances will be displayed. 
- the grid is always a square
