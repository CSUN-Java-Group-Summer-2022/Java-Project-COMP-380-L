/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guivideo.guivideo1;

import java.io.*;
import java.io.Serializable;

/**
 *
 * @author Horchata
 */
public class Library implements Serializable 
{
  private static Book[] book = new Book[50];          // limit to 50 books
  
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
  
  public static void printAllBooks() //2
   {
        // using the books array, if element is not null, print name, author, ISBN, initialQuantity
			for(int i = 0; i < book.length; i++) 
		{
			// make sure object is null then prints it out
			if(book[i] != null) 
			{
				System.out.print("[" + i + "]" + book[i].getNameofbook() + "   " + book[i].getAuthorofbook() +book[i].getiSBN()    );
			}
		}
  }
	//public static String okay() {
	//	return book[1].getAuthorofbook() + "         " + book[3].getNameofbook() + "         " + book[3].getiSBN() + "         "  + book[3].getQuantity() ;
	//}
//This is just an example to help see the new book object changing the number will let you display what object in the list you want.
public static String printBookInfo()
{
String a = book[0].getNameofbook() + " " + book[0].getAuthorofbook() + " " + book[0].getiSBN() + " " + book[0].getQuantity() + "\n" ;
return a;
}
  
  
  
}
