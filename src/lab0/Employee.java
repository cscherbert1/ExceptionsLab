package lab0;

import com.sun.xml.internal.ws.util.StringUtils;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 * In this challenge you need to address the probability that at some point the
 * arguments to method parameters may not be valid.
 * <p>
 * For example, String arguments may be null or empty; other objects may be
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all arguments
 * are valid. The only exception is when any argument is acceptable based on
 * requirements. Fix the code below using if logic to validate method arguments
 * and throw IllegalArgumentException if the validation fails.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {

    public int maxVacationDays = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private int daysVacation;

    public Employee() {
        // initialize a bunch of default values
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        daysVacation = 0;
    }

    /**
     * Convenience constructor to set all properties.
     * @param firstName - cannot be null or empty
     * @param lastName - cannot be null or empty
     * @param ssn
     * @param daysVacation
     * @throws IllegalArgumentException if parameters are not valid
     */
    public Employee(String firstName, String lastName, String ssn, int daysVacation) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setDaysVacation(daysVacation);
    }

    public final int getDaysVacation() {
        return daysVacation;
    }

    public final void setDaysVacation(int daysVacation) throws IllegalArgumentException{
        if (daysVacation <0 || daysVacation > maxVacationDays){
            throw new IllegalArgumentException("Vacation days must be between 0 and" + getMaxVacationDays() + ". Please try again.");
        }
        this.daysVacation = daysVacation;
    }

    public final String getFirstName() {
        return firstName;
    }

    /**
     * Mutates the first name.
     * @param firstName - cannot be null or empty
     * @throws IllegalArgumentException if firstName is null or empty
     */
    public final void setFirstName(String firstName) throws IllegalArgumentException {
        if(firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Sorry, first name is mandatory. Please try again");
        }
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    /**
     * Mutates the lastName.
     * @param lastName - cannot be null or empty
     * @throws IllegalArgumentException if lastName is null or empty
     */
    public final void setLastName(String lastName) throws IllegalArgumentException {
        if(lastName == null || lastName.isEmpty()) {
            throw new MandatoryStringException();
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    public final void setSsn(String ssn) {
        //need validation (homework)
        /*
        complicated. a lot can go wrong. 
        9 digits, 11 characters w/ hyphens
        always need 9 digits. Parsing must be in specific place
        
        1- find requirements
        2- are the requirements (from your boss) accurate? --> research
        
        focus is the validation handling
        */
        if (ssn == null || ssn.isEmpty()){
            throw new IllegalArgumentException("SSSN Cannot be null or empty.");
        }
        String[] parts = ssn.split("-");
        if(parts.length == 1) {
            if (ssn.length() != 9){
                throw new IllegalArgumentException("SSN must be 9 digits without hyphens");
            } else if (!isNumber(ssn)){
                throw new IllegalArgumentException("SSN must only be comprised of digits.");
            }           
        } else if (parts.length == 3){
            if(!ssn.charAt(3).equals("-") && !ssn.charAt(6).equals("-") ){
                throw new IllegalArgumentException("SSN is formatted incorrectly. Use the form XXX-XX-XXXX ");
            }
        }
        this.ssn = ssn;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public int getMaxVacationDays() {
        return maxVacationDays;
    }

    public void setMaxVacationDays(int maxVacationDays) {
        //validation
        this.maxVacationDays = maxVacationDays;
    }
    
    
}
