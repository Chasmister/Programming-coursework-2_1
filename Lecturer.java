 



public class Lecturer extends Teacher
{
    //Declaration of attributes i.e. instance variables.
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;
    private char letterGrade;
    /*
     * "private" keyword is used to encapsulate the class. 
     * consequently, getter and setter methods will be used to access or modify these attributes.
     */
    
    //Constructor
    public Lecturer(int teacherID, String teacherName, String address, String workingType, String employmentStatus, String department, int yearsOfExperience, int workingHours){
        //"super" keyword used to call constructor of the parentclass.
        super(teacherID, teacherName, address, workingType, employmentStatus);
        //"this." keyword is used to call the insance variables declared above
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
        this.gradedScore = 0;
        this.hasGraded = false;
        setWorkingHours(workingHours); //no need to use "super" or "this" to call method as it is inherited from parent class
    }
    
    //Accessor methods for each attribute. Retrievess information about the attributes    
    public String getDepartment(){
        return this.department;
    }
    
    public int getYearsOfExperience(){
        return this.yearsOfExperience;
    }
    
    public int getGradedScore(){
        return this.gradedScore;
    }
    
    public boolean getHasGraded(){
        return this.hasGraded;
    }
    
    //mutator method for setting gradedScore
    public void setGradedScore(int gradedScore){
        this.gradedScore = gradedScore;
    }
    
    /*
     * Method that sets letterGrade value according to gradedscore.
     * also checks if teacher is eligible to grade the assignment.
     */
    public char gradeAssignment(int gradedScore, String department, int yearsOfExperience){
        
       
        if (hasGraded == false)
        {
            if (yearsOfExperience >= 5 && department.equals(this.department)){
                 this.gradedScore = gradedScore; //new graded score is set
                 this.yearsOfExperience = yearsOfExperience; //new years of experience is set
                if(gradedScore >= 70){
                    letterGrade = 'A';
                }
                else if(gradedScore >= 60 && gradedScore < 70){
                    letterGrade = 'B';
                }
                else if(gradedScore >= 50 && gradedScore < 60){
                    letterGrade = 'C';
                }
                else if(gradedScore >= 40 && gradedScore < 50){
                    letterGrade = 'D';
                }
                else {
                    letterGrade = 'E';
                }
                
                hasGraded = true;
            }
            else
            {
                System.out.println("Experience requirements not met // department invalid");
            }
        }
        else
        {
            System.out.println("Teacher has already graded the assignments");
        }
        
        return letterGrade;
    }
    
    /*
     * Displays attributes of the parent class as well as the child class.
     * accessor methods are called to retrieve the current attributes of the teacher.
     * method overriding concept is used to call display method of super class
     */
    public void displayInfo()
    {
        super.displayInfo(); //Calling display method of superclass. (Method overriding)
        System.out.println("Department: " + getDepartment());
        System.out.println("Years of Experience: " + getYearsOfExperience());
        if(getHasGraded() != true)
        {
            System.out.println("Teacher has not graded yet");
        }
        else
        {
            System.out.println("Teacher has graded the assignments");            
        }
    }
    
}
