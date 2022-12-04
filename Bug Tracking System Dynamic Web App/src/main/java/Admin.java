import java.util.ArrayList;
import java.util.Scanner;

//Singleton Class
public class Admin extends Profile{

	private String Security_Code;
	public String getSecurity_Code() {
		return Security_Code;
	}
	private ArrayList<Department> Departments_to_add = new ArrayList<Department>();
	private ArrayList<Project> Projects_to_add = new ArrayList<Project>();
	
	private static Admin single_instance = null;
	
	private Admin(String email, String password, String security_Code) {
		super(null, null, null, null, 0, null, email, null, null, null,null, null, password,"Admin");
		Security_Code = security_Code;
	}

	public static Admin getInstance(String email, String password, String security_Code)
    {
        if (single_instance == null)
            single_instance = new Admin(email, password, security_Code);
  
        return single_instance;
    }
	
	@Override
	void Run_Account_Options(Scanner entries) { //options: 1-all functions below as buttons 2-logout
		System.out.println("Welcome Admin");
		boolean LoggedIn = true;
		System.out.println("1-Display Bugs   2-Display Employees   3-Display All-Bugs   4-Add Department   5-Add Project   6-Check Yearly rate   7-LogOut");
		String entry = entries.nextLine();
		while(LoggedIn) {
			switch (entry) {
			case "1": {
				Display_Bugs();
				break;
			}
			case "2": {
				Display_Employees();
				break;
			}
			case "3": {
				Display_ALL_Bugs();
				break;
			}
			case "4": {
				Add_Department(entries);
				break;
			}
			case "5": {
				Add_Project(entries);
				break;
			}
			case "6": {
				System.out.print("Enter Employeer Email: ");
				String EmployeerEmail = entries.nextLine();
				Check_Yearly_rate(EmployeerEmail);
				break;
			}
			case "7": {
				//Logout Connect and add data
				//...
//				Departments_to_add;
//				Projects_to_add;
				LoggedIn = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + entry);
			}
		}
	}

	@Override
	void Display_Bugs() {
		//Load Open Bugs with ALL informations from database:
		//...
		ArrayList<Bug> Bugs;
		
		
	}
	
	//Separate as not recommended on memory usage
	void Display_ALL_Bugs() {
		//Load ALL Bugs with ALL informations from database:
		//...
		//GUI option display bugs with boolean "Status"
		ArrayList<Bug> Bugs;
		
		
	}
	
	void Display_Employees() {
		//Load ALL Employees from database:
		//...
		ArrayList<Profile> Employees;
		
	}
	
	//Some add-on Functions extra

	public void Add_Department(Scanner entries) {
		System.out.print("Enter Name");
		String Name = entries.nextLine();
		System.out.print("Enter Location");
		String Location = entries.nextLine();
		Department NewDepartment = new Department(Name, Location);
		
		Departments_to_add.add(NewDepartment);
	}
	
	public void Add_Project(Scanner entries) {
		
		System.out.print("Enter Project's Name: ");
		String name = entries.nextLine();

		System.out.print("Enter Project's ID: ");
		int ID = Integer.parseInt(entries.nextLine());
		
		System.out.print("Enter Project's Description: ");
		String description = entries.nextLine();
		
		System.out.print("Enter Project's Start Date: ");
		String dateOfStart = entries.nextLine();
		
		System.out.print("Enter Project's Department Name: ");
		String department = entries.nextLine();
		
		System.out.print("Enter Project's Duration (d or m or y): ");
		String duration = entries.nextLine();
		
		System.out.print("Enter Project Manager: ");
		String project_Manager = entries.nextLine();
		
		System.out.print("Enter Client's Address: ");
		String client_Address = entries.nextLine();
		
		System.out.print("Enter Client's Email: ");
		String client_Email = entries.nextLine();
		
		System.out.print("Enter Client's Name: ");
		String client_Name = entries.nextLine();
		
		System.out.print("Enter Client's Phone: ");
		int client_Phone = Integer.parseInt(entries.nextLine());
		
		Project NewProject = new Project(client_Address, client_Email, client_Name, client_Phone, dateOfStart, department, description, duration, ID, name, project_Manager);

		Projects_to_add.add(NewProject);

	}
	
	//Check by using Days_Hired to accumulate increase rate of payment
	void Check_Yearly_rate(String EmployeerEmail) {
		//Restore account information from database by email given
		Profile employeer = null; //query
		
		int Years = employeer.Days_Hired()/365;
		
	}
}
