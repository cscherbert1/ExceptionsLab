package lab0;

/**
 *
 * @author Instlogin
 */
public class Startup {

    public static void main(String[] args) {
        // Always declare variables outside of try block so they can
        // be used elsewhere (see line 40)
        Employee emp = null;
        
        // Think about this code. It wouldn't work if firstName or lastName 
        // were null or empty string. Instead, the program will crash. 
        // Comment this out and see what happens with the correct sample below.
//        emp = new Employee("","","3333333333",28);
//        String fullNameInCaps = 
//                emp.getFirstName().toUpperCase() 
//                + " " + emp.getLastName().toUpperCase();
//        System.out.println("Employee Name: " + fullNameInCaps);
        
        // Here's the correct way: use a try block to attempt code excecution.
        // then catch one or more exceptions if something goes wrong. But you
        // have to know what goes wrong -- if it's an exception or not. You
        // can do this by examining the code, the documentation or the output
        // if there's a crash. In this example the program does not crash and
        // the user gets a nice, friendly message.
        try {
            emp = new Employee("","","3333333333",28);
            String fullNameInCaps = 
                emp.getFirstName().toUpperCase() 
                + " " + emp.getLastName().toUpperCase();
            System.out.println("Employee Name: " + fullNameInCaps);
            
        } catch(IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        
        System.out.println(emp.toString());
    }
}
