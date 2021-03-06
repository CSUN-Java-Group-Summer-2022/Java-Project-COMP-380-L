/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guivideo.guivideo1;
/**
 *
 * @author Horchata
 */
import java.io.*;
public class Book implements Serializable 
{
  private String nameofbook;
  private String authorofbook;
  private int iSBN; // random 10 digit number (i.e. 9000000001)
  private int quantity = -1;
  
  // changes here
  
  //Contructors
public Book(String nameofbook, String authorofbook, int quantity) {
    this.nameofbook = nameofbook;
    this.authorofbook = authorofbook;
    this.iSBN = generateISBN();
    this.quantity = quantity;
    
    //change change
    }
    //Might have to compare two of the same objects, To prevent repeats.
    
    //Getters 
    public String getNameofbook() {
        return nameofbook;
    }

    public String getAuthorofbook() {
        return authorofbook;
    }

    public int getiSBN() {
        return iSBN;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public int getISBN(){
        return iSBN;
    }
  
    //Setters

    public void setNameofbook(String nameofbook) {
        this.nameofbook = nameofbook;
    }

    public void setAuthorofbook(String authorofbook) {
        this.authorofbook = authorofbook;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setISBN( int newISBN)
  {
	  this.iSBN = newISBN;
  }
  
    // helper methods
	private int generateISBN() 
	{
		int id = (int) (Math.random() * 1000000) + 1;
		return id;
	}
        
	public String printBookInfo()
	{
	String a = "Title: " + nameofbook +" Author: " + authorofbook + " ISBN: " + iSBN + " In Stock: " + quantity;
	return a;
	}
}
