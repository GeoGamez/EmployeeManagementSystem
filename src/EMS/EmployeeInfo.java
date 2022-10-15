package EMS;



public class EmployeeInfo {

    
    // ATTRIBUTES
    public int employeeNumber;
    public String firstName;
    public String lastName;
    public int gender; // encode e.g. 0 for M, 1 for F, etc.
    public int birthYear;
    public double deductRate; // e.g. 0.21 for 21%
    
    
    // CONSTRUCTORS
    
    public EmployeeInfo(int eN, String fN, String lN, int g, int bY, double dR) {
    	employeeNumber = eN;
    	firstName = fN;
    	lastName = lN;
    	gender = g;
    	birthYear = bY;
    	deductRate = dR;
    }
    
    
    // METHODS
    
    public int getEmpNum() {
    	return employeeNumber;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
}
