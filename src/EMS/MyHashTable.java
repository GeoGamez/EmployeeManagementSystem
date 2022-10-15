package EMS;


import java.util.*;
public class MyHashTable {
//ATTRIbutes
	
	public ArrayList <EmployeeInfo> [] buckets;
	public int numInHashTable;
//Constructor 
	public MyHashTable(int howManyBuckets) {
		buckets = new ArrayList[howManyBuckets];
		for (int i =0; i<howManyBuckets; i++) {
			buckets[i] = new ArrayList();
		}
                numInHashTable = 0;
	}


//Method
        	public int getNumInHashTable() {
		return numInHashTable;
	}

	public int calcBucket(int employeeNumber) {
		return(employeeNumber % buckets.length);
	}
	public boolean checkDupe(int theEmployee){
            if (getFromTable(theEmployee) == null){
                return true;
            }else{
                return false;
            }
        }
        	public void clearAll(){
                numInHashTable = 0;
		for (int i =0; i<buckets.length; i++) {
			buckets[i].clear();
		}
	}
	public boolean addEmployee(EmployeeInfo theEmployee) {
		if(theEmployee == null) {
			return false; 
		}else{
                    	for (int i =0; i<buckets.length; i++) {
			if(calcBucket(theEmployee.employeeNumber) ==i) {
			buckets[i].add(theEmployee);
			numInHashTable++;
                        return true;
			}

		}
                }

                return false;
	}
	public void displayContents () {
		for (int i =0; i<buckets.length; i++) {
			System.out.println("Bucket: "+ i);
			if(buckets[i].size() == 0 ) {
				System.out.println("<empty>");	
			}
			for(int j =0; j<buckets[i].size();j++) {
				System.out.println(buckets[i].get(j).employeeNumber+", " + buckets[i].get(j).firstName +", "+ buckets[i].get(j).lastName);
			}
		}
	}
	public String writeContents (int i, int j) {
			if(buckets[i].isEmpty()) {
                                return("");
			}
                        if (buckets[i].get(j) instanceof FTE) {
                            FTE theFTE = (FTE) buckets[i].get(j);
                            	return(theFTE.employeeNumber+"," + theFTE.firstName +","+ theFTE.lastName+ ","+theFTE.gender +","+theFTE.birthYear+","+theFTE.deductRate+","+ theFTE.getYearlySalary());
                        }
                        if (buckets[i].get(j) instanceof PTE) {
                            PTE thePTE = (PTE) buckets[i].get(j);
                            return(thePTE.employeeNumber+"," + thePTE.firstName +","+ thePTE.lastName+ ","+thePTE.gender +","+thePTE.birthYear+","+thePTE.deductRate+","+ thePTE.hourlyWage +","+thePTE.hoursPerWeek +","+thePTE.weeksPerYear);
                        }
			return("");
		}

//	public void displayContents() {
//		
//		System.out.println("\n\nDISPLAYING THE CONTENTS OF A HASH TABLE!");
//		
//		System.out.println("\n  This hash table contains " + numInHashTable + " entries.");
//		
//		// Print the employee numbers for the employees stored in each bucket's ArrayList,
//		// starting with bucket 0, then bucket 1, and so on.
//		
//		for (int i = 0; i < buckets.length; i++) {
//
//		    // For the current bucket, print out the emp num for each item
//                    // in its ArrayList.
//
//                    System.out.println("\n  Examining the ArrayList for bucket " + i);
//                    int listSize = buckets[i].size();
//                    if (listSize == 0) {
//                    	System.out.println("    Nothing in its ArrayList!");
//                    }
//                    else {
//                        for (int j = 0; j < listSize; j++) {
//                           int theEmpNum = buckets[i].get(j).getEmpNum();
//                           System.out.println("    Employee " + theEmpNum);
//                        }
//                    }
//
//                }
//
//	}

	
	public EmployeeInfo removeFromTable(int employeeNum) {
		int key = calcBucket(employeeNum);
		if(buckets[key].size() == 0 ) {
			System.out.println("Couldn't REMOVE value due to NOT FOUND");	
			return null;
		}else {	
			for(int j =0; j<buckets[key].size();j++) {
				if(buckets[key].get(j).employeeNumber == employeeNum) {
					EmployeeInfo removed = buckets[key].remove(j);
					numInHashTable--;
					System.out.println("Item Found! Returning to user...");	
					return removed;
				}
		}
			System.out.println("Couldn't ReEMOVE value due to NOT FOUND");	
			return null;
	}
	}


		

	public EmployeeInfo getFromTable(int employeeNum) {
		int key = calcBucket(employeeNum);
		if(buckets[key].size() == 0 ) {
			System.out.println("Couldn't GET value due to NOT FOUND");	
			return null;
		}else {	
			for(int j =0; j<buckets[key].size();j++) {
				if(buckets[key].get(j).employeeNumber == employeeNum) {
					System.out.println("Item Found! Returning to user...");	
					return buckets[key].get(j);
				}
		}
			System.out.println("Couldn't GET value due to NOT FOUND");	
			return null;
	}
	}
        
}



	
	// METHODS
	

	
	

	

	
//	public int searchByEmployeeNumber(int employeeNum) {
//
//		// Determine the position of the employee in the ArrayList for the bucket that that employee hashes to.
//		// If the employee is not found, return -1.
//		
//		int targetBucket = calcBucket(employeeNum);
//		
//		// Walk through the ArrayList and look for the employee.
//		for (int j = 0; j < buckets[targetBucket].size(); j++) {
//			if (employeeNum == buckets[targetBucket].get(j).getEmpNum()) {
//				return(j); // The employee number is for the employee at position j in the target bucket's ArrayList.
//			}			
//		}
//		
//		return(-1); // The employee number was not found for any employee in target bucket's ArrayList.
//		
//	} // end searchByEmployeeNumber
	
	