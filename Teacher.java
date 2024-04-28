 

import java.util.ArrayList; 

public class Teacher
{
    //Declaration of attributes i.e. instance variables.
    private int teacherID;
    private String teacherName;
    private String address;
    private String workingType;
    private String employmentStatus;
    private int workingHours;
    /*
     * "private" keyword is used to encapsulate the class. 
     * consequently, getter and setter methods will be used to access or modify these attributes.
     */

    //Constructor
    public Teacher(int teacherID, String teacherName, String address, String workingType, String employmentStatus)
    {
        //"this." keyword is used to call the insance variables declared above
        this.teacherID = teacherID; //basically means attribute teacherID = parameter teacherID
        this.teacherName = teacherName;
        this.address = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
    }
    
    //Accessor methods for each attribute. Retrievess information about the attributes
    
    public int getTeacherID() 
    {
        return this.teacherID;
    }
    
    public String getTeacherName() 
    {
        return this.teacherName;
    }
    
    public String getAddress() 
    {
        return this.address;
    }
    
    public String getWorkingType() 
    {
        return this.workingType;
    }
    
    public String getEmploymentStatus() 
    {
        return this.employmentStatus;
    }
    
    public int getWorkingHours() 
    {
        return this.workingHours;
    }
    
    //Mutator method for setting the value of workingHours attribute.
    public void setWorkingHours(int workingHours)
    {
        this.workingHours = workingHours; //assigns parameter WorkingHours to instance variable WorkingHours present outside the method.
    }
    
    /*
     * Displays information about the teacher
     * accessor methods are called to retrieve the current attributes of the teacher.
     */
    public void displayInfo()
    {
        System.out.println("Teacher ID : " + getTeacherID());
        System.out.println("Name : " + getTeacherName());
        System.out.println("address : " + getAddress());
        System.out.println("Working Type : " + getWorkingType());
        System.out.println("Employment status : " + getEmploymentStatus());
        if(workingHours == 0)
        {
            System.out.println("Working Hours: has not been assigned");
        }
        else
        {
            System.out.println("Working Hours : " + getWorkingHours());
        }
    }
    
    
} 
