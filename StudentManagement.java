package StudentManagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Contains: Main, checkMenuInput,userEnterString 
 * @author alexgeronimo
 */
public class StudentManagement {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Student> studentList = new ArrayList<>();
        
        // Create Menu, handle input  
        boolean menu = true; 
        while (menu == true){
            Scanner in = new Scanner(System.in);
            System.out.println("Choose an Option:\n"+ "1. Add a student\n"
            + "2. Remove a student\n"+ "3. Update student GPA\n"+ "4. Display student information\n"
            + "5. Display all students\n" + "6. Exit");
            int menu_option = checkMenuInput(in);

        // Handle menu options 
        
        // Menu 1
            if (menu_option == 1){
                String name = userEnterString("full name");
                String sID = userEnterString("student ID");
                String email = userEnterString("email");
                String major = userEnterString("major");
                
                int age = Integer.parseInt(userEnterString("age"));
                double gpa = Double.parseDouble(userEnterString("gpa"));
                System.out.println("");
                
                Student s = new Student(name, email, age, sID, major, gpa);
                System.out.println("New Student file for " + s.getName() + " created.\n");
                Iterator<Student> studentIterator = studentList.iterator();
                
                if (studentList.isEmpty()){
                    studentList.add(s);
                }
                else {
                 
                    while (studentIterator.hasNext() ){
                     Student student = studentIterator.next();
                        if (student.getStudentID().equals(sID)) {
                            System.out.println("Error: Student ID already exists\n"
                                 + "returning to main menu.../n");
                            break;
                        }   
                    }
                    
                    studentList.add(s);
                }  
            }
         
        // Menu 2    
            else if ( menu_option == 2){
                
                if (studentList.isEmpty()){
                    System.out.println("Error: No records on file\nNew student must be added first\n");
                    continue; 
                }
                
                String sID = userEnterString("student ID");
                Iterator<Student> studentIterator = studentList.iterator();
                
                int count = 0;
                while(studentIterator.hasNext()){
                    Student student = studentIterator.next();
                    if(student.getStudentID().equals(sID)) {
                        studentList.remove(count);
                        System.out.println("Student " + student.getName() + " has been removed.\n"
                                + "returning to main menu...\n");
                        break;
                    }
                    count++;
                }
            }
        
        // Menu 3    
            else if ( menu_option == 3){
                
                if (studentList.isEmpty()){
                    System.out.println("Error: No records on file\nNew student must be added first\n");
                    continue; 
                }
                
                String sID = userEnterString("student ID");
                double gpa = Double.parseDouble(userEnterString("gpa"));
                
                Iterator<Student> studentIterator = studentList.iterator();
                
                boolean student_in = false;
                while (studentIterator.hasNext()){
                     
                    Student student = studentIterator.next();
                    if(student.getStudentID().equals(sID)) {
                        student_in = true;
                        student.setGpa(gpa);
                        System.out.println("Student " + student.getName() +
                                "'s gpa has been changed to " + student.getGpa());
                        break;
                    }  
                }
                
                if (student_in = false) {
                        System.out.println("Student " + sID + " does not exist."
                                        + "returning to main menu...\n");
                    }
            }
            
        // Menu 4        
            else if ( menu_option == 4){
                String sID = userEnterString("student ID");
                
                Iterator<Student> studentIterator = studentList.iterator();
                
                boolean student_in = false;
                while (studentIterator.hasNext()){
                     
                    Student student = studentIterator.next();
                    if(student.getStudentID().equals(sID)) {
                        student_in = true;
                        student.printStudent();
                        break;
                    }
                }
                
                if (student_in = false) {
                        System.out.println("Student " + sID + " does not exist."
                                        + "returning to main menu...\n");
                    }
            }
            
        // Menu 5    
            else if ( menu_option == 5){
                Iterator<Student> studentIterator = studentList.iterator();
                int student_count = studentList.size();
                System.out.println("Number of students currently in the list is: " + student_count);
                
                while (studentIterator.hasNext()) {
                    Student student = studentIterator.next();
                    student.printStudent();
                }
            }
        
        // Menu 6    
            else if ( menu_option == 6){
                System.out.println("Good Bye!");
                   menu = false;
            }
            
        // Other Integers...    
            else {
                System.out.println("\nError: Please a number 1-6\nreturing to main menu...\n");
            }
        }
    }
    //************** End Main **********************************
    
    /**
     * Check if input is integer, catch exception, wait for correct input before returning to main
     * @param in
     * @return 
     */
    public static int checkMenuInput(Scanner in){
        String menu_in = in.next();
        try {
            int menu_int = Integer.parseInt(menu_in);
            return menu_int;
        }
        
        catch (NumberFormatException ex) {
            System.out.println("Please enter '1', '2', '3', '4', '5', or '6' to exit." + "\n");}
            System.out.println("Choose an Option:\n"+ "1. Add a student\n"
            + "2. Remove a student\n"+ "3. Update student GPA\n"+ "4. Display student information\n"
            + "5. Display all students\n" + "6. Exit");
            int menu_int_again = checkMenuInput(in);
            return menu_int_again; 
    }
    
    /**
     * Prompt user to enter full name
     * @return String user input 
     */
    public static String userEnterString(String string){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter " + string + ":");
        String string_in = in.nextLine().trim();
        return string_in;
    }
    
    
    
}
