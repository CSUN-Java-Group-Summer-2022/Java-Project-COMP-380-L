/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guivideo.guivideo1;

import java.io.*;

/**
 *
 * @author Horchata
 */
public class Student implements Serializable 
{
    private int checkedOutBook = 0;
    private int id;
    private String name;
    //Might need to add in a job class for this class
    
    public Student(String name) {
        this.id = generateId();
        this.name = name;
        this.checkedOutBook = checkedOutBook;
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
       //Need method to create a random student ID number
    
    	private int generateId() {
	  int id = (int) (Math.random() * 100000000) + 1;
	  return id;
	}
    
    	public void setCheckedOutBooks( int newChecked)
	{
		if(newChecked <= 3 && 0 <= newChecked)
		{
			this.checkedOutBook = newChecked;
		}
		else 
		{
			System.out.print("Already has more than 3 books checked out");
		}
	}
    
    
    
    	public String getStudentInfo()
	{
		String a = "Student Name: " + name + " ID: " + id + " Checked out books: " + checkedOutBook; 
		return a;
	}
    
}
