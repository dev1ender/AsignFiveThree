

//This ois employee class that is created abstracct having certian properties and abstract nethods
abstract class Employee {
	int empId;
	String empName;
	int total_leaves;
	double total_salary;
	 abstract void calculate_balance_leaves();
	 abstract boolean avail_leave(int no_of_leaves,char type_of_leave);
	 abstract void calculate_salary();
	
}

//permanent emp class extends employee class and implemetns the abstract methods 
class Permanentemp extends Employee{
	int paid_leave,sick_leave,casual_leave;
	double basic,hra,pfs;
	
	void print_leave_detail(){
		System.out.println("No of Paid Leave :"+paid_leave);
		System.out.println("No of Sick leave :"+sick_leave);
		System.out.println("No of Casual Leave :"+casual_leave);
		
	}
	
	//implements the avail_leave method of employee class
	boolean avail_leave(int no_of_leaves,char type_of_leave){
		if(type_of_leave =='p' && total_leaves>= no_of_leaves){
			total_leaves=total_leaves-no_of_leaves;
			paid_leave=no_of_leaves;
			return true;
		}
		else if(type_of_leave =='s' && total_leaves>= no_of_leaves){
			total_leaves=total_leaves-no_of_leaves;
			sick_leave=no_of_leaves;
			return true;
		}
		else if(type_of_leave =='c' && total_leaves>= no_of_leaves){
			total_leaves=total_leaves-no_of_leaves;
			casual_leave=no_of_leaves;
			return true;
		}
		else{
			return false;
		}
	
	}
	
	//method is used to print the cobjecct of this class
	@Override
	public String toString() {
		return "Permanentemp empId=" + empId + ", empName=" + empName ;
	}

//used to calculate the salary of the class
	void calculate_salary(){
		pfs=(basic*12)/100;
		hra =(basic*50)/100;
		System.out.println("Basic Salary :"+basic);
		System.out.println("Pf :"+pfs);
		System.out.println("hra :"+hra);
		total_salary=(basic+hra-pfs);
		System.out.println("Total Salary :"+total_salary);
	}

	//implement s the calculate balamnc leave
	@Override
	void calculate_balance_leaves() {
		// TODO Auto-generated method stub
		System.out.println("balance Leave :"+total_leaves);
	}
	
}
//temporary emp class extends the employee class that is abstract
class TemporaryEmp extends Employee{
       
	//impliments the avail_leave method of employee calsss fo temmp members
	boolean avail_leave(int no_of_leaves,char type_of_leave){
		if(total_leaves>=no_of_leaves){
			total_leaves=total_leaves-no_of_leaves;
			return true;
		}
		else
		return false;
		
	}
	
	//calculate the total salary of the class 
	void calculate_salary(){
		
		System.out.println("Total Salary :"+total_salary);
	}

	//used to print the object of temparay class
	@Override
	public String toString() {
		return "TemporaryEmp empId=" + empId + ", empName=" + empName ;
	}

	
	//used to print and calculat the balance leaves of hte temp emp class
	void calculate_balance_leaves() {
		// TODO Auto-generated method stub
		System.out.println("balance Leave :"+total_leaves);
	}
}

//classs that contian the main method
public class AsignFiveThree {
	//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//create the permanent emp class object and passing certain values to it 
		Permanentemp premp=new Permanentemp();
		
		premp.empId=11;
		premp.empName="Amit";
		premp.basic=2000;
		premp.total_leaves=20;
		premp.avail_leave(4,'s');
		premp.avail_leave(2, 'c');
		premp.avail_leave(5, 'p');
		System.out.println(premp);
		premp.print_leave_detail();
		premp.calculate_balance_leaves();
		premp.calculate_salary();
		
		
		//createaa the temp class object and passing certain values to it and calling it mthods
		TemporaryEmp tmpemp = new TemporaryEmp();
		tmpemp.empId=12;
		tmpemp.empName="Rahul";
		tmpemp.total_salary=2000;
		tmpemp.total_leaves=30;
		tmpemp.avail_leave(5,'c');
		tmpemp.avail_leave(4,'s');
		System.out.println(tmpemp);
		tmpemp.calculate_balance_leaves();
		tmpemp.calculate_salary();
		
		
		
		
		
		
		
		
	}

}
