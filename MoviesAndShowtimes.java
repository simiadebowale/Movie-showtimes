//*********************************************************************************************
//Simileoluwa Adebowale
//MoviesAndShowtimes.Java
//A GUI window that will allow a user to see all showtimes for a selected movie or all movies
//playing at a selected showtime.
//IDE: eclipse
//
//********************************************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.List;
import java.io.*;

//main class
public class MoviesAndShowtimes {
	public static void main(String[] args) {
		new Selection();
	}
}

//define the GUI window
class Selection extends JFrame{
	
	//create an object to import certain variable from another class
	titleSearch titlesObj = new titleSearch();
	
	//create a 2D array with times and titles
	String[][] movies = titlesObj.titlesAndTimes();
	
	//use methods defined in the titleSearch class to create an ordered array of times and
	//a list of movie titles for use in a dropdown list
	String[][] moviesOrdered = titlesObj.checkingTitles(movies);
	String [] titles = titlesObj.titleList(moviesOrdered);
	
	//create a list of showtimes for use in a dropdown list
	String[] times = {"All Showtimes" , "9:00AM", "10:00AM" , "11:00AM" , "12:00PM" , "1:00PM" 
			, "2:00PM" , "3:00PM" , "4:00PM" , "5:00PM" , "6:00PM" , "7:00PM" , "8:00PM" 
			, "9:00PM" , "10:00PM" , "11:00PM"};
	
	
	//create labels for lists
	JLabel label1 = new JLabel("Select a movie title: ");
	JLabel label2 = new JLabel("Select a showtime: ");
	
	//create search buttons
	JButton searchTitle = new JButton("Search by Title");
	JButton searchTime = new JButton("Search by Time");

	//create a text display area
	JTextArea textArea = new JTextArea(30,50);	
	
	//create 3 J panels
	JPanel panelA = new JPanel();
	JPanel panelB = new JPanel();
	JPanel panelC = new JPanel();
	
	//create 2 dropdown lists
	JComboBox titleList = new JComboBox(titles);
	JComboBox timeList = new JComboBox(times);
	
	public Selection() {
		
		//set the layout type
		setLayout(new BorderLayout());
		
		//fill panel A with the title search
		panelA.add(label1);
		panelA.add(titleList);
		panelA.add(searchTitle);
		
		//fill panel B with the time search
		
		panelB.add(label2);
		panelB.add(timeList);
		panelB.add(searchTime);
		
		//fill panel C with the text display area
		panelC.add(textArea);
		
		//organize the panels
		add(panelA, BorderLayout.NORTH);
		add(panelB, BorderLayout.CENTER);
		add(panelC, BorderLayout.SOUTH);
	
		//creating the frame for the GUI window
		setTitle("Simileoluwa, Anthony, and Hyunjee's Movies");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,650);
		setVisible(true);
	
		//create the button listeners for the different button
		searchTitle.addActionListener(new ButtonListener());
		searchTime.addActionListener(new ButtonListener());
		
	}	

//button listener class
class ButtonListener implements ActionListener{
	
	//method for what to do when a button is pushed
	public void actionPerformed(ActionEvent e)
	{

	//create new object to record which button was pushed
		Object SearchType = e.getSource();
		int i = 0, k=1;
		
		//what to do if searching by title
		if(SearchType == searchTitle)
		{			
			String titleToSearch = (String)titleList.getSelectedItem();
			//call search method in class titleSearch
			textArea.setText(titleSearch.search(i, titleToSearch, moviesOrdered));		
		}
		
		//what to do if searching by time
		if(SearchType == searchTime)
		{
			String timeToSearch = (String)timeList.getSelectedItem();
		
			//display all movies and showtimes by converting the moviesOrdered array to a string
			//to be output into the text area
			if (timeToSearch == "All Showtimes")
			{
				String display = "";
				for(int j = 0; j < moviesOrdered.length; j++)
				{
					for(int l = 0; l < moviesOrdered[j].length; l++)
					{
						if(l == 0)
						{
							display = display + "\n" + moviesOrdered[j][0] + "\n   ";
						}
						else
							display = display + moviesOrdered[j][l] + "  ";
					}
				}
				textArea.setText(display);
			}
			
			//calls search method in the timeSearch class to create an output for a specific time
			else
				textArea.setText(timeSearch.search(i, timeToSearch, moviesOrdered));
			
		}
	}
}}


//parent class titleSearch
class titleSearch{
	
	//class defining all movies and showtimes
	public String[][] titlesAndTimes(){
	   final String[][] movies = new String[][] {
			   new String[] {"Creed II", "12:00PM", "3:00PM", "6:00PM", "9:00PM"},
			   new String[] {"Ralph Breaks the Internet", "10:00AM", "11:00AM", "2:00PM", "4:00PM", "5:00PM", "8:00PM", "9:00PM", "11:00PM"},
			   new String[] {"Robin Hood", "11:00AM", "12:00PM", "3:00PM", "6:00PM", "9:00PM"},
			   new String[] {"The Possession of Hannah Grace", "11:00AM", "2:00PM", "4:00PM", "6:00PM", "9:00PM", "11:00PM"},
			   new String[] {"Dr. Seuss' The Grinch", "11:00AM", "12:00PM", "2:00PM", "3:00PM", "4:00PM", "6:00PM", "7:00PM", "8:00PM", "9:00PM", "11:00PM"},
			   new String[] {"Fantastic Beasts: The Crimes of Grindelwald", "11:00AM", "1:00PM", "2:00PM", "3:00PM", "4:00PM", "5:00PM", "7:00PM", "9:00PM", "10:00PM", "11:00PM"},
			   new String[] {"Bohemian Rhapsody", "11:00AM", "3:00PM", "6:00PM", "9:00PM"},
			   new String[] {"Green Book", "12:00PM", "4:00PM", "7:00PM", "10:00PM"},
			   new String[] {"Instant Family", "11:00AM", "2:00PM", "5:00PM", "8:00PM"},
			   new String[] {"A Star Is Born", "3:00PM", "6:00PM"},
			   new String[] {"Widows", "11:00AM", "2:00PM", "5:00PM", "8:00PM"},
			   new String[] {"The Nutcracker and the Four Realms", "11:00AM", "4:00PM", "10:00PM"},
			   new String[] {"The Front Runner", "2:00PM", "7:00PM"},
			   new String[] {"Overlord", "11:00AM", "2:00PM", "5:00PM", "8:00PM", "10:00PM"},
			   new String[] {"Nobody's Fool", "12:00PM", "3:00PM", "5:00PM", "8:00PM", "11:00PM"}
		};
		
	return movies;
	}
	
	//creates a single array of just titles for use in the dropdown
	public String[] titleList(String[][] movies){
		String [] titles = new String[movies.length];
		for(int i = 0; i < movies.length; i++) {
			titles[i] = movies[i][0];
		}
		return titles;
	}
		
	//bubble sort algorithm to put the titles in alphabetical order
		public static String[][] checkingTitles(String[][] movies) {
			if (checkOrder(movies) == false)
			{
				BubbleSort(movies);
				return movies;
			}	
			else
				return movies;
		}
		
		public static <T extends Comparable<T>> boolean checkOrder(T[][] movies)
		{
			int a = 0;
			//This for loop is used to count the number of values greater than the value following it.
			for (int i = 0; i < movies.length - 1; i++)
			{
				if (movies[i][0].compareTo(movies[i+1][0]) > 0)
					a = a + 1;
			}
			
			//if the count is zero, the Boolean returns true.
			if (a == 0)
				return true;
			
			//if the count is anything other than zero, the Boolean returns false, which will
			//cause the sort to run.
			else
				return false;
		}

		public static <T extends Comparable<T>> void BubbleSort(T[][] movies)
		{
			int position, scan;
			T temp;

			for (position = movies.length - 1; position >= 0; position--)
			{
				
				for (scan = 0; scan <= position - 1; scan++)
				{

					if (movies[scan][0].compareTo(movies[scan+1][0]) > 0)

						swap(movies, scan, scan + 1);
				}
			}
		}
		
		public static <T> void swap(T[] movies, int i, int j)
		{
			  T temp = movies[i];
			  movies[i] = movies[j];
			  movies[j] = temp;
		}
		
		
		//main search method used to find the titles and create the output
		public static String search(int i, String titleToSearch, String[][] movies) {
			//orders the 2D array by movie title
			checkingTitles(movies);
			
			//used to find only the array within the 2D array that contains the title being searched for.
			//this ends once the title is found and defines the value i for later use.
			while(titleSearch.searchBoolean(i, titleToSearch, movies) == true)
			{
				i++;
			}
			
			//create a list ADT
			List<String> list = new LinkedList<String>();
			
			//create an output string
			String displayValue = "";
			
			//adds relevant array values to a list
			for(int j = 0; j < (movies[i].length); j++) {
				list.add(movies[i][j]);
			}
			
			//converts list values into a string.
			while(list.isEmpty() == false) {
				displayValue = displayValue + list.remove(0) + "\n";
			}
			//returns display value
			return displayValue;
		}
		
		//search algorithm to determine if the index location contains the desired value.
		public static boolean searchBoolean(int i, String titleToSearch, String[][] movies) {
			if (titleToSearch != movies[i][0]) {
				return true;
			}
			else {
				return false;
			}
			
		}
}



//child class timeSearch. Inherits searchBoolean, timesAndTitles, and several other methods from
//parent class. Overwrites the search method.
class timeSearch extends titleSearch{

	//polymorphic search class using method overloading
	public static String search(int i, String timeToSearch, String[][] movies) {
		
		//orders the 2D array by movie title
		checkingTitles(movies);
		
		//create a stack ADT
		Stack stack = new Stack();
		
		//create a String
		String listOfTitles = "";
		
		//find the time in the list of times for the movie and it present, add the movie
		//title to a stack.
		for (i = (movies.length - 1); i >= 0; i--)
		{
			
			//find index location of the desired show time
			int index = findTime(i, 0, timeToSearch, movies);
			
			//push the title to the stack
			if(index != 99) {
				stack.push(movies[i][0]);
			}
		
		}
		
		//places stack values in a string for output
		while(stack.isEmpty() == false)
		{
			listOfTitles = listOfTitles + stack.pop() + "\n";
		}
		
		//if else statement to return the list of times or a different message if there are no
		//movies at that time.
		if(listOfTitles.isEmpty() == false)
		{
			return listOfTitles;
		}
		else {
			return "No movies starting at " + timeToSearch;
		}
	}
	
	//recursive method to find the index position of a time and stop when it's found
	public static int findTime(int i, int j, String timeToSearch, String[][] movies) {
		if(movies[i][j] == timeToSearch)
			return j;
		else if(j == (movies[i].length) - 1)
			return 99;
		else
			return findTime(i, j + 1, timeToSearch, movies);
	}
}