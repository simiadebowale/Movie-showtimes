# Movie&showtimes

# Description: 

This program uses a graphical user interface that allows the user to look up movie showtimes based on title or time. The program sorts the movies in alphabetical order, and displays them based on what the user is searching.


# Imports:

-java.awt.* contains all of the classes for creating user interfaces.

-Java.awt.event.* provides interfaces and classes for dealing with different types of events fired by AWT components.
-Javax.swing.* imports all classes from the package.
-Java.util.* contains the collections framework, legacy collection classes, event model, date and time facilities, internationalization, and miscellaneous utility classes.


# Class Selection: 

The Selection class extends JFrame which supports the JFC/Swing component architecture. This method sets up the graphical user interface for the program. The titlesObj is created to import certain variables from another class. A 2D array, movies, is created. An array, times, is created with all of the options in the drop down list for the showtimes. Two labels are created for the title and showtime drop down lists. Two buttons are created to search for the title and times. A text area is created to display the results of the searches. Three panels are created to hold the labels, buttons, and text area. Two drop down lists are created for the user to select a movie or showtime to search.


# Constructor: 

This constructor adds the labels, drop down lists, buttons, and text area to the GUI.


# Class ButtonListener:

The ButtonListener class implements a listener interface for receiving action events.


# actionPerformed: 

This method tells the program what to do when a button is pushed. The method is comprised of 2 for loops, making the efficiency O(n2). The first if statement searches based on the title selected by the user, then calls the search method into the titleSearch class. The second if statement searches based on the time selected by the user. The if statement inside of the second loop displays all the movies and showtimes by converting the moviesOrdered array to a string to be displayed in the text area if the user chooses the “All Showtimes” option in the drop down list. If the user chooses any other option, the method will call the search method in the timeSearch class to create an output for the specified time.


# Class titleSearch: 

This method is the parent class for the timeSearch class. 


# titlesAndTimes: 

This method creates a 2D array for all of the movies and showtimes, and returns the array.
