 
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox; 
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.BorderFactory; 
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Component;
import java.awt.Insets;
import java.io.File;
import javax.swing.ImageIcon;
import java.awt.Image;

public class TeacherGUI implements ActionListener
{

    ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    
    JFrame frame1;
    JPanel mainPanel;
    JPanel sectionPanelCover, sectionPanel, teacherIDPanel, panel1, gradedScorePanel, panel2, panel3, panel3_2, buttonPanel;
    
    JLabel title;
    
    JLabel mainBackground, panel1Background, menuBackground;
    JLabel menuLabel;
    JLabel teacherIDLabel, teacherNameLabel, addressLabel;
    JLabel workingTypeLabel, employmentStatusLabel, workingHoursLabel;
    JLabel departmentLabel, yearsOfExperienceLabel, gradedScoreLabel;
    JLabel salaryLabel, specializationLabel, academicQualificationsLabel;
    JLabel performanceIndexLabel;
    
    JTextField teacherIDTxt, teacherNameTxt, addressTxt;
    JTextField workingTypeTxt, employmentStatusTxt;
    JTextField workingHoursTxt, departmentTxt, yearsOfExperienceTxt;
    JTextField gradedScoreTxt, salaryTxt, specializationTxt;
    JTextField academicQualificationsTxt, performanceIndexTxt;
    
    ButtonGroup menuButtonGroup;
    JButton lecturerMenu, tutorMenu, gradeAssignmentMenu, setSalaryMenu;
    JButton addLecturerButton, addTutorButton, gradeAssignmentButton, setSalaryButton, removeButton, displayButton;
    
    JTable lecturerTable, tutorTable;
    
    Font customFont;
    
    public TeacherGUI()
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        try {
            File fontStyle = new File("Fonts/Neue Montreal Bold 700.otf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontStyle);
            //customFont = Font.createFont(Font.TRUETYPE_FONT, TeacherGUI.class.getResourceAsStream("/Fonts/pp-neue-montreal-mono.ttf")).deriveFont(15f);
        } catch (Exception e) {
            e.printStackTrace();
            // In case of error loading font, use default font
            customFont = new Font("Arial", Font.PLAIN, 12);
        }
        UIManager.put("Label.font", new FontUIResource(customFont.deriveFont(15f)));
        UIManager.put("Label.foreground", new Color(56,56,56));
        
        UIManager.put("Panel.background", new Color(0, 0, 0, 0));
        UIManager.put("TextField.border", BorderFactory.createEmptyBorder(0,10,0,0));
        UIManager.put("Button.font", new FontUIResource(customFont.deriveFont(15f)));
        UIManager.put("Button.border", BorderFactory.createEmptyBorder());
        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("Button.foreground", new Color(56,56,56));
        UIManager.put("Button.focus", new Color(0,0,0,0));
        UIManager.put("Button.select", Color.BLUE);
        
        

        
        frame1 = new JFrame();
        mainPanel = new JPanel();
        teacherIDPanel = new JPanel();
        mainBackground = new JLabel(new ImageIcon("Imagess/dark mesh.png"));
        panel1Background = new JLabel(new ImageIcon("Imagess/Rectangle.png"));
        /*ImageIcon icon = new ImageIcon("Imagess/Rectangle10.png");
        Image image = icon.getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        menuBackground = new JLabel(new ImageIcon(image));*/
        menuBackground = new JLabel(new ImageIcon("Imagess/solid orange.png"));
        //menuBackground.setBackground(new Color(254, 104, 45, 100));
        panel1 = new JPanel();
        panel2 = new JPanel();
        gradedScorePanel = new JPanel();
        panel3 = new JPanel();
        panel3_2 = new JPanel();
        buttonPanel = new JPanel();
        
        lecturerTable = new JTable();
        tutorTable = new JTable();
        
        title = new JLabel("Add Lecturer");
        
        menuLabel = new JLabel("Menu");
        
        teacherIDLabel = new JLabel("Teacher ID:", SwingConstants.RIGHT);
        teacherNameLabel = new JLabel("Name:", SwingConstants.RIGHT);
        addressLabel = new JLabel("Address:",SwingConstants.RIGHT);
        
        workingTypeLabel = new JLabel("Working Type:", SwingConstants.RIGHT);
        employmentStatusLabel = new JLabel("Employment Status:", SwingConstants.RIGHT);
        workingHoursLabel = new JLabel("Working Hours:", SwingConstants.RIGHT);
        
        departmentLabel = new JLabel("Department:", SwingConstants.RIGHT);
        yearsOfExperienceLabel = new JLabel("Years of Experience:", SwingConstants.RIGHT);
        gradedScoreLabel = new JLabel("Graded Score:", SwingConstants.RIGHT);
        
        salaryLabel = new JLabel("Salary:", SwingConstants.RIGHT);
        specializationLabel = new JLabel("Specialization:", SwingConstants.RIGHT);
        academicQualificationsLabel = new JLabel("Academic Qualifications:", SwingConstants.RIGHT);
        performanceIndexLabel = new JLabel("Performance Index:", SwingConstants.RIGHT);
        
        
        teacherIDTxt = new JTextField();
        teacherNameTxt = new JTextField();
        addressTxt = new JTextField();
        
        workingTypeTxt = new JTextField();
        employmentStatusTxt = new JTextField();
        workingHoursTxt = new JTextField();
        
        departmentTxt = new JTextField();
        yearsOfExperienceTxt = new JTextField();
        gradedScoreTxt = new JTextField();
        
        salaryTxt = new JTextField();
        specializationTxt = new JTextField();
        academicQualificationsTxt = new JTextField();
        performanceIndexTxt = new JTextField();
        
        //Action Buttons
        addLecturerButton = new JButton("Add Lecturer");
        addLecturerButton.addActionListener(this);
        addTutorButton = new JButton("Add Tutor");
        addTutorButton.addActionListener(this);
        gradeAssignmentButton = new JButton("Grade Assignment");
        gradeAssignmentButton.addActionListener(this);
        setSalaryButton = new JButton("Set salary");
        setSalaryButton.addActionListener(this);
        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        displayButton = new JButton("Display");
        displayButton.addActionListener(this);
        
        //Section Buttons
        lecturerMenu = new JButton("Add Lecturer");
        lecturerMenu.addActionListener(this);
        tutorMenu = new JButton("Add Tutor");
        tutorMenu.addActionListener(this);
        gradeAssignmentMenu = new JButton("Grade\nAssignment");
        gradeAssignmentMenu.addActionListener(this);
        setSalaryMenu = new JButton("Set Salary");
        setSalaryMenu.addActionListener(this);
        
        
        
        title.setBounds(100, 30, 700, 70);
        title.setFont(customFont.deriveFont(70f));
        title.setForeground(new Color(100,100,100));
        sectionPanelCover = new JPanel();
        sectionPanel = new JPanel(); //Panel that contains the section change buttons
        
        sectionPanelCover.setBackground(new Color(0,0,0,0));
        sectionPanelCover.setBounds(100,100, 190, 450);
        sectionPanelCover.setLayout(null);
        menuBackground.setBounds(100, 100, 190, 450);
        menuLabel.setBounds(40, 30, 150, 50);
        menuLabel.setFont(customFont.deriveFont(40f));
        menuLabel.setForeground(Color.WHITE);
        
        sectionPanel.setLayout(new GridLayout(5, 1, 0, 30)); 
        sectionPanel.setBounds(20, 110, 150, 300);
        sectionPanel.setBackground(null);
        sectionPanel.add(lecturerMenu);
        sectionPanel.add(tutorMenu);
        sectionPanel.add(gradeAssignmentMenu);
        sectionPanel.add(setSalaryMenu);

        sectionPanelCover.add(sectionPanel);
        sectionPanelCover.add(menuLabel);
        
        
        
        /* DROPDOWN CONCEPT
        String[] dropdownItems = {"Add Lecturer", "Add Tutor", "Grade Assignment", "Set Salary"};
        dropdown = new JComboBox(dropdownItems);
        dropdown.setBounds(80, 40, 250, 50);
        dropdown.setFont(new Font("PP Neue Montreal", Font.PLAIN, 25));
        */
        
        mainBackground.setBounds(0,0, 1300, 700);
       
        teacherIDPanel.setBounds(320, 150, 320, 25);
        panel1.setBounds(320, 190, 320, 200);
        panel1.setOpaque(false);
        panel1Background.setBounds(100, 100, 1100, 450);
        panel2.setBounds(680, 150, 400, 80);
        gradedScorePanel.setBounds(680, 240, 400, 30);
        panel3.setBounds(680, 150, 440, 85);
        panel3_2.setBounds(680, 250, 440, 85);
        buttonPanel.setBounds(360, 420, 700, 150);
        
        teacherIDPanel.setLayout(new GridLayout(1,2, 30, 25));
        panel1.setLayout(new GridLayout(5,2, 30, 20));
        panel2.setLayout(new GridLayout(2, 2, 30, 25));
        gradedScorePanel.setLayout(new GridLayout(1, 2, 30, 25));
        panel3.setLayout(new GridLayout(2, 2, 30, 25));
        panel3_2.setLayout(new GridLayout(2, 2, 30, 25));
        buttonPanel.setLayout(new GridLayout(3, 2, 120, 10));
        
        
        teacherIDPanel.add(teacherIDLabel); teacherIDPanel.add(teacherIDTxt);
        panel1.add(teacherNameLabel); panel1.add(teacherNameTxt);
        panel1.add(addressLabel); panel1.add(addressTxt);
        panel1.add(workingTypeLabel); panel1.add(workingTypeTxt);
        panel1.add(workingHoursLabel); panel1.add(workingHoursTxt); 
        panel1.add(employmentStatusLabel); panel1.add(employmentStatusTxt);
        
        
        //Required for Lecturer
        panel2.add(departmentLabel); panel2.add(departmentTxt);
        panel2.add(yearsOfExperienceLabel); panel2.add(yearsOfExperienceTxt);
        gradedScorePanel.add(gradedScoreLabel); gradedScorePanel.add(gradedScoreTxt);
        
        //Required for Tutor
        panel3.add(salaryLabel); panel3.add(salaryTxt);
        panel3.add(performanceIndexLabel); panel3.add(performanceIndexTxt);
        panel3_2.add(specializationLabel); panel3_2.add(specializationTxt);
        panel3_2.add(academicQualificationsLabel); panel3_2.add(academicQualificationsTxt);
        
        
        buttonPanel.add(addLecturerButton); buttonPanel.add(addTutorButton);
        buttonPanel.add(gradeAssignmentButton); buttonPanel.add(setSalaryButton);
        buttonPanel.add(removeButton); buttonPanel.add(displayButton);
        
        mainPanel.add(sectionPanelCover); mainPanel.add(teacherIDPanel); 
        mainPanel.add(panel1); mainPanel.add(panel2); 
        mainPanel.add(gradedScorePanel); mainPanel.add(panel3); 
        mainPanel.add(panel3_2); mainPanel.add(buttonPanel); 
         
        /* aligning to the right with loop
        for (Component component : panel1.getComponents()) {
            // Check if the component is a JLabel
            if (component instanceof JLabel) {
                // Set the horizontal alignment to right
                ((JLabel) component).setHorizontalAlignment(SwingConstants.RIGHT);
            }
        }*/
        
        //frame1.add(dropdown);
        frame1.add(buttonPanel);
        frame1.add(title);
        frame1.add(sectionPanelCover);
        //frame1.add(sectionPanel); //I DONT NEED TO ADD THIS AFTER I HAVE ALREADY ADDED SECTIONPANELCOVER
        frame1.add(teacherIDPanel);
        frame1.add(panel1);
        frame1.add(panel2);
        frame1.add(gradedScorePanel);
        frame1.add(panel3);
        frame1.add(panel3_2);
        frame1.add(menuBackground);
        frame1.add(panel1Background);
        frame1.add(mainBackground);
        
        
        panel3.setVisible(false);
        panel3_2.setVisible(false);
        addLecturerButton.setVisible(true);
        addTutorButton.setVisible(false);
        gradeAssignmentButton.setVisible(false);
        setSalaryButton.setVisible(false);
        removeButton.setVisible(false);
        displayButton.setVisible(false);
        
        frame1.setLayout(null);
        frame1.setSize(1300, 700);
        //frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == lecturerMenu)
        {
            panel1.setVisible(true);
            panel2.setVisible(true);
            gradedScorePanel.setVisible(false);
            panel3.setVisible(false);
            panel3_2.setVisible(false);
            title.setText("Add Lecturer");
            
            addLecturerButton.setVisible(true);
            addTutorButton.setVisible(false);
            gradeAssignmentButton.setVisible(false);
            setSalaryButton.setVisible(false);
            removeButton.setVisible(true);
            displayButton.setVisible(false);
            frame1.repaint();
            frame1.revalidate();
        }
        else if(ae.getSource() == tutorMenu)
        {
            panel1.setVisible(true);
            panel2.setVisible(false);
            gradedScorePanel.setVisible(false);
            panel3.setVisible(true);
            panel3_2.setVisible(true);
            title.setText("Add Tutor");
            
            addLecturerButton.setVisible(false);
            addTutorButton.setVisible(true);
            gradeAssignmentButton.setVisible(false);
            setSalaryButton.setVisible(false);
            removeButton.setVisible(true);
            displayButton.setVisible(false);
        }
        else if(ae.getSource() == gradeAssignmentMenu)
        {
            panel1.setVisible(false);
            panel2.setVisible(true);
            gradedScorePanel.setVisible(true);
            panel3.setVisible(false);
            panel3_2.setVisible(false);
            title.setText("Grade Assignment");
            
            addLecturerButton.setVisible(false);
            addTutorButton.setVisible(false);
            gradeAssignmentButton.setVisible(true);
            setSalaryButton.setVisible(false);
            removeButton.setVisible(false);
            displayButton.setVisible(false);
        }
        else if(ae.getSource() == setSalaryMenu)
        {
            panel1.setVisible(false);
            panel2.setVisible(false);
            gradedScorePanel.setVisible(false);
            panel3.setVisible(true);
            panel3_2.setVisible(false);
            title.setText("Set Salary");
            
            addLecturerButton.setVisible(true);
            addTutorButton.setVisible(false);
            gradeAssignmentButton.setVisible(false);
            setSalaryButton.setVisible(false);
            removeButton.setVisible(false);
            displayButton.setVisible(false);
        }
        //WOOOAAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
        else{ 
            
            if(ae.getSource() == addLecturerButton)
            {
                if(teacherIDTxt.getText().isEmpty() || teacherNameTxt.getText().isEmpty() || addressTxt.getText().isEmpty() || workingTypeTxt.getText().isEmpty() || employmentStatusTxt.getText().isEmpty() || workingHoursTxt.getText().isEmpty() || departmentTxt.getText().isEmpty() || yearsOfExperienceTxt.getText().isEmpty())
                {
                   JOptionPane.showMessageDialog(frame1, "Please fill in all the required fields", "error dialog", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    int teacherID = Integer.parseInt(teacherIDTxt.getText());
                    String teacherName = teacherNameTxt.getText();
                    String address = addressTxt.getText();
                    String workingType = workingTypeTxt.getText();
                    String employmentStatus = employmentStatusTxt.getText();
                    int workingHours = Integer.parseInt(workingHoursTxt.getText());
                    String department = departmentTxt.getText();
                    int yearsOfExperience = Integer.parseInt(yearsOfExperienceTxt.getText());
                    
                    boolean found = false;
                    if(teacherList.isEmpty()){
                        teacherList.add(new Lecturer(teacherID,teacherName, address, workingType, employmentStatus, department, yearsOfExperience, workingHours));
                        System.out.println(teacherList);
                    }
                    else{
                        
                        for(Teacher teacher : teacherList){
                            if(teacher instanceof Lecturer){
                                if(teacher.getTeacherID() != teacherID){
                                    found = false;
                                }
                                else{
                                    found = true;
                                    break;
                                }
                            }
                        }
                        
                        if(found == false)
                        {
                            teacherList.add(new Lecturer(teacherID,teacherName, address, workingType, employmentStatus, department, yearsOfExperience, workingHours));
                            System.out.println(teacherList);
                        }
                        else {
                            System.out.println("Please enter a different TeacherID");
                        }
                    }
                    
                }
                
                //Lecturer lecturer11 = (Lecturer) teacherList.get(0);
                //System.out.println(lecturer11.gradeAssignment(gradedScore, department, yearsOfExperience));
                //ArrayList tempList = new ArrayList();
                //(teacherList.get(0)).gradeAssignment();
                //System.out.println(teacherList);
                //yettikai test garna matra haaleko yo. teacher ID ko list banaayera print garcha.
                //for(Teacher teacher: teacherList)
                //{
                    //tempList.add(teacher.getTeacherID());
                //}
            }
            
            else if(ae.getSource() == addTutorButton)
            {
                if(teacherIDTxt.getText().isEmpty() || teacherNameTxt.getText().isEmpty() || addressTxt.getText().isEmpty() || workingTypeTxt.getText().isEmpty() || employmentStatusTxt.getText().isEmpty() || workingHoursTxt.getText().isEmpty() || salaryTxt.getText().isEmpty() || specializationTxt.getText().isEmpty() || academicQualificationsTxt.getText().isEmpty() || performanceIndexTxt.getText().isEmpty())
                {
                   JOptionPane.showMessageDialog(frame1, "Please fill in all the required fields", "error dialog", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    int teacherID = Integer.parseInt(teacherIDTxt.getText());
                    String teacherName = teacherNameTxt.getText();
                    String address = addressTxt.getText();
                    String workingType = workingTypeTxt.getText();
                    String employmentStatus = employmentStatusTxt.getText();
                    int workingHours = Integer.parseInt(workingHoursTxt.getText());
                    double salary = Double.parseDouble(salaryTxt.getText());
                    String specialization = specializationTxt.getText();
                    String academicQualifications = academicQualificationsTxt.getText();
                    int performanceIndex = Integer.parseInt(performanceIndexTxt.getText());                
                    
                    boolean found = false;
                    for(Teacher teacher : teacherList){
                        if(teacher instanceof Tutor){
                            if(teacher.getTeacherID() != teacherID){
                                found = false;
                            }
                            else{
                                found = true;
                                
                                break;
                            }
                        }
                    }
                    
                    if(found == false)
                    {
                        teacherList.add(new Tutor(teacherID,teacherName, address, workingType, employmentStatus, workingHours, salary, specialization, academicQualifications, performanceIndex));
                    }
                    else 
                    {
                        System.out.println("Please enter a different TeacherID");
                    }
                    
                    System.out.println(teacherList);
                }
            }
            
            else if(ae.getSource() == gradeAssignmentButton)
            {
                if(teacherIDTxt.getText().isEmpty() || departmentTxt.getText().isEmpty() || yearsOfExperienceTxt.getText().isEmpty())
                {
                   JOptionPane.showMessageDialog(frame1, "Please fill in all the required fields", "error dialog", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    boolean found = false;
                    
                    int teacherID = Integer.parseInt(teacherIDTxt.getText());
                    String department = departmentTxt.getText();
                    int yearsOfExperience = Integer.parseInt(yearsOfExperienceTxt.getText());
                    int gradedScore =
                    Integer.parseInt(gradedScoreTxt.getText());
                    for(Teacher teacher: teacherList)
                    {
                        if(teacher instanceof Lecturer)
                        {
                            if(teacher.getTeacherID() == teacherID)
                            {
                                Lecturer tempObject1 = (Lecturer) teacher;
                                System.out.println("teacherId: " + teacher.getTeacherID()); //prints teacherID, just to check if loop is working
                                System.out.println(tempObject1.gradeAssignment(gradedScore, department, yearsOfExperience));
                                found = true;
                                break;
                            }
                        }
                    }
                    if(found == false)
                    {
                        System.out.println("Invalid ID");
                    }
                }
            }
            else if(ae.getSource() == setSalaryButton)
            {
                boolean found = false;
                
                if(teacherIDTxt.getText().isEmpty() || salaryTxt.getText().isEmpty() || specializationTxt.getText().isEmpty() || academicQualificationsTxt.getText().isEmpty() || performanceIndexTxt.getText().isEmpty())
                {
                   JOptionPane.showMessageDialog(frame1, "Please fill in all the required fields", "error dialog", JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    int teacherID = Integer.parseInt(teacherIDTxt.getText());
                    double salary = Double.parseDouble(salaryTxt.getText());
                    int performanceIndex = Integer.parseInt(performanceIndexTxt.getText());  
                    for(Teacher teacher : teacherList)
                    {
                        if(teacher instanceof Tutor)
                        {
                            if(teacher.getTeacherID()== teacherID)
                            {
                                Tutor tempObject2 = (Tutor) teacher;
                                tempObject2.setSalary(salary, performanceIndex);
                                found = true;
                                break;
                            }
                        }
                    }
                    if(found == false)
                    {
                        System.out.print("Invalid Teacher ID, teacher not found");
                    }
                }
            }
            else if(ae.getSource() == removeButton)
            {
                boolean found = false;
                
                int teacherID = Integer.parseInt(teacherIDTxt.getText());
                for(Teacher teacher : teacherList)
                {
                    if(teacher instanceof Tutor)
                    {
                        if(teacher.getTeacherID() == teacherID)
                        {
                            found = true;
                            Tutor tempObject3 = (Tutor) teacher;
                            tempObject3.removeTutor();
                            break;
                        }
                    }
                }
                if(found == false)
                {
                    System.out.print("Invalid Teacher ID, teacher not found");
                }
            }
            else if(ae.getSource() == displayButton)
            {
                JFrame lecturerFrame = new JFrame("Lecturer Table Frame");
                
                Object[][] tableData = {{1,2,3,4,5}, {1,2,3,4,5}};
                String[] columnn = {"haha", "haha", "haha", "haha", "haha"};
                
                JTable lectTable = new JTable(tableData, columnn);
                lectTable.setBounds(10,10,400,400);
                
                lecturerFrame.add(lectTable); 
                
                lecturerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                lecturerFrame.setSize(800, 800);
                lecturerFrame.setLocationRelativeTo(null); // Center the frame
                lecturerFrame.setVisible(true);
                
                for(Teacher teacher: teacherList)
                {
                    if(teacher instanceof Lecturer)
                    {
                        //Object[][] tableData = new Object[2][5];
                        Lecturer lectObj = (Lecturer) teacher;
                        lectObj.displayInfo();
                        System.out.println("");
                    }
                    else
                    {
                        Tutor tutObj = (Tutor) teacher;
                        tutObj.displayInfo();
                        System.out.println("");
                    }
                }
                
            }
            
        }
    }
    
    public static void main(String[] args)
    {
        new TeacherGUI();
    }
}

