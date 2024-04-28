 



public class Tutor extends Teacher
{
    //Declaration of attributes i.e. instance variables.
    private double salary;
    private String specialization;
    private String academicQualifications;
    private int performanceIndex;
    private boolean isCertified;

    /*
     * "private" keyword is used to encapsulate the class. 
     * consequently, getter and setter methods will be used to access or modify these attributes.
     */
    
    //Constructor
    public Tutor(int teacherID, String teacherName, String address, String workingType, String employmentStatus, int workingHours, double salary, String specialization, String academicQualifications, int performanceIndex)
    {
        //"super" keyword used to call constructor of the parentclass.
        super(teacherID, teacherName, address, workingType, employmentStatus);
        //"this." keyword is used to call the insance variables declared above
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualifications = academicQualifications;
        this.performanceIndex = performanceIndex;
        this.isCertified = false;
        setWorkingHours(workingHours); //no need to use "super" or "this" to call method as it is inherited from parent class.
    }
    
    //Accessor methods for each attribute. Retrievess information about the attributes    
    public double getSalary()
    {
        return this.salary;
    }
    
    public String getSpecialization()
    {
        return this.specialization;
    }
    
    public String getAcademicQualifications()
    {
        return this.academicQualifications;
    }
    
    public int getPerformanceIndex()
    {
        return this.performanceIndex;
    }
    
    public boolean getIsCertified()
    {
        return this.isCertified;
    }
    
    /*
     * Mutator method that sets the new salary and performanceIndex if conditions are met
     * salary is increased according to the appraisal percentage.
     * formula used : salary = salary + appraisal*salary
     */
    public void setSalary(double salary, int performanceIndex)
    {
        if (performanceIndex >= 5 && getWorkingHours() > 20)
        {
            this.performanceIndex = performanceIndex;
            if (performanceIndex <= 7)
            {
                this.salary = salary + (5.00/100)*salary;
            }
            else if (performanceIndex <= 9)
            {
                this.salary = salary + (10.00/100)*salary;
            }
            else if (performanceIndex == 10)
            {
                this.salary = salary + (20.00/100)*salary;
            }
            
            this.isCertified = true;
        }
        else
        {
            System.out.println("Performance Index or working hours requirements not met");
        }
    }
    
    /*
     * method used to remove the tutor
     * sets the values of all attributes to null
     */
    public void removeTutor()
    {
        if(this.isCertified != true)
        {
            this.salary = 0.00;
            this.performanceIndex = 0;
            this.specialization = "";
            this.academicQualifications = "";
            this.isCertified = false;
        }
    }
    
    /*
     * Only displays attributes of parent class if tutor is not certified
     * else display attributes of both parent class and child class
     */
    public void displayInfo()
    {
        if(this.isCertified != true)
        {
            super.displayInfo();//Calling display method of superclass. (Method overriding)
        }
        else
        {
            super.displayInfo();
            System.out.println("Salary : " + getSalary());
            System.out.println("Specialization : " + getSpecialization());
            System.out.println("Academic Qualifications : " + getAcademicQualifications());
            System.out.println("Performance Index : " + getPerformanceIndex());
        }
    }
}
