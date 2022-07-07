/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guivideo.guivideo1;

import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Horchata
 */
public class Library implements Serializable 
{
    //Create a book array in this class
  private static Book[] book = new Book[50];          // limit to 50 books 
  private static Student[] student = new Student[30];
  //This will create a book object 
  public static void addBook(String name, String author, int initialQuantity) //1
  {
	// add a new Book object to the books array (use next available slot)
	for(int i = 0; i < book.length; i++) 
	{
			// make sure object is null
			if(book[i] == null) 
			{
				Book book1 = new Book(name, author, initialQuantity);
				book[i] = book1;
				break;
			}
	}
}
  
  //This will print out all the books in the array object
  public static void printAllBooks() //2
   {
        // using the books array, if element is not null, print name, author, ISBN, initialQuantity
			for(int i = 0; i < book.length; i++) 
		{
			// make sure object is null then prints it out
			if(book[i] != null) 
			{
				JOptionPane.showMessageDialog(null,"[" + i + "]" + book[i].printBookInfo());
			}
		}
  }
  
  /*
  This is a text funtion i was playing around with nothing impotant
	public static String okay() {
		return book[1].getAuthorofbook() + "         " + book[3].getNameofbook() + "         " + book[3].getiSBN() + "         "  + book[3].getQuantity() ;
	}
*/
//This is just an example to help see the new book object changing the number will let you display what object in the list you want.


    //This will create a text file with the array of Book objects saved to it
    public static void saveBooksToFile()
    {
        try
        {
            FileOutputStream file = new FileOutputStream("books.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);

            outputFile.writeObject(book);
            outputFile.close();
            
            JOptionPane.showMessageDialog(null, "Succesfully Saved!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
  

    
    //This takes the saved file and loads the data back into the program
    public static void loadBooksFromFile()
    {
        try
        {
            FileInputStream file = new FileInputStream("books.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            book = (Book[]) inputFile.readObject();
            
            inputFile.close();
            
            JOptionPane.showMessageDialog(null, "Books loaded.");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    

    public static void registerStudent(String name) //5
  {
	  for(int i = 0 ; i < student.length; i++)
	  {
		if(student[i] == null)
		{
			Student student1 = new Student(name);
			student[i] = student1;
			break;
		}
	  }
  }
   
      public static void printRegisteredStudents() 
  {
	// using the students array, if element is not null, print name, id and checkedOutBooks
			for(int i = 0; i < student.length; i++) 
	{
			// make sure object is null then prints it out
			if(student[i] != null) 
			{
				JOptionPane.showMessageDialog(null,"[" + i + "]" + student[i].getStudentInfo() + "\n");
			}
	}
  }
      
  
  // saves student array to a (new or existing) file
  public static void saveStudentsToFile()
    {
        try
        {
            FileOutputStream file = new FileOutputStream("students.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);

            outputFile.writeObject(student);
            outputFile.close();
            
            JOptionPane.showMessageDialog(null, "Succesfully Saved!");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
  
    // loads student array from a file
    public static void loadStudentsFromFile()
    {
        try
        {
            FileInputStream file = new FileInputStream("students.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);

            student = (Student[]) inputFile.readObject();
            
            inputFile.close();
            
            JOptionPane.showMessageDialog(null, "Students loaded.");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
      
  public static void updateBookQuantity(int ISBN, int input) 
  {
	// find the book in the books array using the ISBN number
	// update the quantity based on input
        try{
	for(int i = 0; i < book.length; i++) 
	{
		if (book[i].getISBN() == ISBN)
		{
			book[i].setQuantity(input);
                        JOptionPane.showMessageDialog(null,"Book was found and updated");
			break;
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"Looks like nothing was found ");
			//break;
		}
	}
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Looks like nothing was found");
        }
  }
  
    public static String searchBookByISBN( String nameOfBook,String author) //4 ,String authorOfBook, int ISBN
  {
	// search for the book in the books array using the ISBN
	// if found return the Book object, return null otherwise
        try{
            for(int i = 0; i < book.length; i++) 
            {
                    if (book[i].getNameofbook().equalsIgnoreCase(nameOfBook) ||book[i].getAuthorofbook().equalsIgnoreCase(author) ) //book[i].getISBN() == ISBN ||book[i].getNameofbook().equalsIgnoreCase(nameOfBook) == true ||
                    {
                           // JOptionPane.showMessageDialog(null,"returning book");
                            return book[i].printBookInfo();
                    }
                    else
                    {
                        //JOptionPane.showMessageDialog(null,"Smelly");
                        //break;
                    }
            }
        }        
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Null Pointer execption");
        }
          return null;
  }
    
        public static String searchStudentID(String studentName) //int studentID
    {
	// search student array for a match with inputted studentName
	// if found return the student information, return null otherwise
        try{
            for(int i = 0; i < 30; i++) 
            {
                    if ( student[i].getName().equalsIgnoreCase(studentName) ) // student[i].getID()== studentID ||
                    {
                           // JOptionPane.showMessageDialog(null,"returning student information");
                            return student[i].getStudentInfo();
                    }
                    else
                    {
                        //JOptionPane.showMessageDialog(null,"Smelly");
                    }
            }
        }        
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Null Pointer execption");
        }
          return null;
  }
        
        public static int getBookIndex(int isbn)
        {
            try{
            for(int i = 0; i < book.length; i++) 
            {
                    if (book[i].getISBN() == isbn) //book[i].getISBN() == ISBN ||book[i].getNameofbook().equalsIgnoreCase(nameOfBook) == true ||
                    {
                            //JOptionPane.showMessageDialog(null,"returning student info");
                           
                            return i;
                    }
                    else
                    {
                        //JOptionPane.showMessageDialog(null,"ID NULL");
                       // break;
                    }
            }
        }        
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Null Pointer execption");
        }
          return -1;
        }
        
        public static int getStudentIndex(int studentID)
        {
            try{
            for(int i = 0; i < student.length; i++) 
            {
                    if (student[i].getID() == studentID) //book[i].getISBN() == ISBN ||book[i].getNameofbook().equalsIgnoreCase(nameOfBook) == true ||
                    {
                            //JOptionPane.showMessageDialog(null,"returning student info");
                           
                            return i;
                    }
                    else
                    {
                        //JOptionPane.showMessageDialog(null,"ID NULL");
                       // break;
                    }
            }
        }        
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Null Pointer execption");
        }
          return -1;
        }
        
        public static String searchID(int studentID)
        {
            try{
            for(int i = 0; i < student.length; i++) 
            {
                    if (student[i].getID() == studentID) //book[i].getISBN() == ISBN ||book[i].getNameofbook().equalsIgnoreCase(nameOfBook) == true ||
                    {
                            //JOptionPane.showMessageDialog(null,"returning student info");
                           
                            return student[i].getStudentInfo();
                    }
                    else
                    {
                        //JOptionPane.showMessageDialog(null,"ID NULL");
                       // break;
                    }
            }
        }        
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Null Pointer execption");
        }
          return null;
        }
        
        public static String SearchISBN(int bookISBN)
        {
            try{
            for(int i = 0; i < book.length; i++) 
            {
                    if (book[i].getISBN() == bookISBN) //book[i].getISBN() == ISBN ||book[i].getNameofbook().equalsIgnoreCase(nameOfBook) == true ||
                    {
                            //JOptionPane.showMessageDialog(null,"returning student info");
                           
                            return book[i].printBookInfo();
                    }
                    else
                    {
                        //JOptionPane.showMessageDialog(null,"NO ISBN found");
                       // break;
                    }
            }
        }        
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Null Pointer execption");
        }
          return null;
        }
        
        
        
    public static void checkOutBook(int studentID, int isbn) //9
    {
        int studIndex = getStudentIndex(studentID);
        int bookIndex = getBookIndex(isbn);
        if(studIndex != -1 && bookIndex != -1){
            if(student[studIndex].addBook(isbn)){
                book[bookIndex].setQuantity(book[bookIndex].getQuantity() - 1);
                JOptionPane.showMessageDialog(null,"Book checked out!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Student already has max. (3 books) checked out.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Cannot find student or book.");
        }
    }    
    
        public static void checkInBook(int studentID, int isbn) //9
    {
        int studIndex = getStudentIndex(studentID);
        int bookIndex = getBookIndex(isbn);
        if(studIndex != -1 && bookIndex != -1){
            if(student[studIndex].removeBook(isbn)){
                book[bookIndex].setQuantity(book[bookIndex].getQuantity() + 1);
                JOptionPane.showMessageDialog(null,"Book checked in!");
            }
            else{
                JOptionPane.showMessageDialog(null,"Could not check in book.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Cannot find student or book.");
        }
    }    
        
        //CheckoutBooks Method
    /*public static void checkOutBook(int studentId, int isbn) //9
    {
	for(int i = 0; i < student.length; i++)
	{
            if(searchID(studentId) != null)
            {
		if(student[i].getID() == studentId)
		{
			if(student[i].getCheckedOutBook() >= 0 && student[i].getCheckedOutBook() < 3)
			{   
                            for(int j = 0; j < book.length; j++)
                            {
                                if(SearchISBN(isbn) != null)
                                {
				if(book[j].getISBN() == isbn)
				{
					if(book[j].getQuantity() == 0)
					{
						JOptionPane.showMessageDialog(null,"Seems like there are no more books available");
						//break; 
					}
					else
					{
						student[i].setCheckedOutBooks(student[i].getCheckedOutBook() + 1);
						book[j].setQuantity(book[j].getQuantity() -1);
                                                JOptionPane.showMessageDialog(null,"Checked Out");
						//break;
					}
				}
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Seems like the book ISBN does not match");
                                    break;
                                }
                            }
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Seems like the student already has max amount of books");
				//break;
			}
		}
                }
		else 
		{
			JOptionPane.showMessageDialog(null,"Seems like the student is not registered!!");
			break;
		}
	}
  }*/
          
    /*public static void checkInBook(int studentId, int isbn) //10
	{
		for(int i = 0; i < student.length; i++)
		{
                    if(searchID(studentId) != null)
                    {
			if(student[i].getID() == studentId)
			{
				if(student[i].getCheckedOutBook() != 0)
				{
                                    for(int j = 0; j < book.length; j++)
                                    {   
                                    if(SearchISBN(isbn) != null)
                                    {  
                            
					if(book[j].getISBN() == isbn)
					{
                                            student[i].setCheckedOutBooks(student[i].getCheckedOutBook() - 1);
                                            book[j].setQuantity(book[j].getQuantity() + 1);
                                            JOptionPane.showMessageDialog(null,"Checked in");
                                            //break;
					}
                                    }    
                                    else
                                    {
						JOptionPane.showMessageDialog(null,"Seems like the book ISBN does not match");
						break;
                                    }
                                    }
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Seems like the student doesnt have any books to check in");
					//break;
				}
			}
                        }
			else 
			{
				JOptionPane.showMessageDialog(null,"Seems like the student is not registered");
				break;
			}
		}	
	}*/
          
          
          
          
          
        
    
}
