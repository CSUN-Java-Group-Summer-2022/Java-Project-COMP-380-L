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


    //This will create a text file with the objects saved 
    public static void saveBooksToFile()
    {
        try
        {
            FileOutputStream file = new FileOutputStream("Jobs.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for(int i = 0; i < book.length; i++)
            {
             outputFile.writeObject(book[i]);
            }
            outputFile.close();
            
            JOptionPane.showMessageDialog(null, "Succesfully Saved!");
            //this.dispose();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
  

    
    //This will take the saved file and populate the array (NOT WORKING)
    public static void populateArrayList()
    {
        try
        {
            FileInputStream file = new FileInputStream("Jobs.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean endOfFile = false;
            while(!endOfFile)
            {
                //inputFile.readObject()
                try
                {
                    int i = 0;
                    Book book1 = (Book)inputFile.readObject();
                    book[i] = book1;
                    i++;
                }
                catch(EOFException e)
                {
                    endOfFile = true; 
                }
                catch(Exception f)
                {
                    JOptionPane.showMessageDialog(null, f.getMessage() + book);
                    
                }
            }
            inputFile.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Place your methods that will be callled in other classes here.
    //Remeber to start if with Public static Void (type) nameofmethod(Any peramriters);
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
			break;
		}
	}
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Looks like nothing was found");
        }
  }
  
    public static Book searchBookByISBN(String nameOfBook,String authorOfBook, int ISBN) //4
  {
	// search for the book in the books array using the ISBN
	// if found return the Book object, return null otherwise
	for(int i = 0; i < book.length; i++) 
	{
		if (book[i].getISBN() == ISBN || book[i].getNameofbook() == nameOfBook || book[i].getAuthorofbook() == authorOfBook)
		{
			return book[i];
		}
	}
	return null;
  }
      
      
      
  
}
