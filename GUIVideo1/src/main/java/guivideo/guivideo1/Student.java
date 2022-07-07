/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guivideo.guivideo1;

import java.io.*;
import java.util.Arrays;

/**
 *
 * @author Horchata
 */
public class Student implements Serializable 
{
    //private int checkedOutBook = 0;
    private int id;
    private String name;
    private int[] coBooks = {-1, -1, -1}; 
    //Might need to add in a job class for this class
    
    public Student(String name) {
        this.id = generateId();
        this.name = name;
        this.coBooks = coBooks;
    }
    
    //Getters
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumCheckedOut()
    {
        return coBooks.length;
    }
    
    public boolean addBook(int isbn) {
        for(int i = 0; i < 3; i++){
            if(coBooks[i] == -1){
                coBooks[i] = isbn;
                return true;
            }
        }
        return false;
    }
    
    public boolean removeBook(int isbn) {
        for(int i = 0; i < 3; i++){
            if(coBooks[i] == isbn){
                coBooks[i] = -1;
                return true;
            }
        }
        return false;
    }
    
    //Setters
    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    private int bookCount(){
        int tempCount = 0; 
        for(int i = 0; i < 3; i++){
            if(coBooks[i] != -1){
                tempCount++;
            }
        }
        return tempCount;
    }
       //Need method to create a random student ID number
    
    	private int generateId() {
	  int id = (int) (Math.random() * 100000000) + 1;
	  return id;
	}
    
    	/*public void setCheckedOutBooks( int newChecked)
	{
		if(newChecked <= 3 && 0 <= newChecked)
		{
			this.checkedOutBook = newChecked;
		}
		else 
		{
			System.out.print("Already has more than 3 books checked out");
		}
	}*/
    
    
    
    	public String getStudentInfo()
	{
		String a = "Student Name: " + name + "\nID: " + id + "\nChecked out books: " + bookCount() + "\n" + Arrays.toString(coBooks); 
		return a;
	}
    
}
