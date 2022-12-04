import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Tester extends Profile{
	
	private ArrayList<Bug> Bugs_to_add;
	private ArrayList<Bug> Bugs_to_change;
	
	public Tester(String address, String backup_Answer, String backup_Question, String birthdate, int contact,
			String degree, String email, String firstName, String gender, String hired_On, String lastName,
			String martial_Status, String password) {
		super(address, backup_Answer, backup_Question, birthdate, contact, degree, email, firstName, gender, hired_On, lastName,
				martial_Status, password,"Tester");
	}

	@Override
	void Run_Account_Options(Scanner entries) {
		System.out.println("Welcome Tester");
		boolean LoggedIn = true;
		System.out.println("1-Display Bugs   2-Update Bug (Add Report)   3-Add Bug   4-LogOut");
		String entry = entries.nextLine();
		while(LoggedIn) {
			switch (entry) {
			case "1": {
				Display_Bugs();
				break;
			}
			case "2": {
				System.out.print("Enter Bug's ID: ");
				int BugID = Integer.parseInt(entries.nextLine());
				Update_Bug(BugID,entries);
				break;
			}
			case "3": {
				Add_Bug(entries);
				break;
			}
			case "4": {
				//Logout Connect and add data
				//...
//				Bugs_to_change;
				
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
		//Load Open Bugs assigned to current Tester by E-mail from database:
		//...
		ArrayList<Bug> Bugs;
		
	}
	
	void Update_Bug(int BugID,Scanner entries) {
		//Retrieve Bug from Database by ID
		Bug bug = null;
		System.out.println("1-Change Status   2-Add Report   3-Send back to Coder   4-Return");
		String entry = entries.nextLine();
		switch (entry) {
		case "1": {
			if(bug.Status)bug.Status = false;
			else bug.Status = true;
			Bugs_to_change.add(bug);
			break;
			}
		case "2": {
			System.out.print("Enter Your Report: ");
			String Report = entries.nextLine();
			bug.Report += "\nFinalized report: "+Report;
			Bugs_to_change.add(bug);
			break;
			}
		case "3": {
			System.out.print("Enter Your issue in Report: ");
			String Report = entries.nextLine();
			bug.Report += "\nIssue occurred: "+Report;
			bug.SubmitToTest = false;
			Bugs_to_change.add(bug);
			break;
			}
		case "4": {
			break;
			}
		default:
			throw new IllegalArgumentException("Unexpected value: " + entry);
		}
	}
	

	void Add_Bug(Scanner entries) {
		
		String Date_Submitted = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());    
		String Last_Checked = Date_Submitted;              
		String Tester = this.Email;
		System.out.println("Enter Bug's info: ");
		
		System.out.print("Name: ");
		String Name = entries.nextLine();

		System.out.print("ID: ");
		int ID = Integer.parseInt(entries.nextLine());
		
		System.out.print("Level: ");
		int Level = Integer.parseInt(entries.nextLine());
		
		System.out.print("Type: ");
		String Type = entries.nextLine();
		
		System.out.print("Coder Assigned: ");
		String Coder = entries.nextLine();
		
		System.out.print("Priority: ");
		int Priority = Integer.parseInt(entries.nextLine());
		
		System.out.print("Project's ID: ");
		int ProjectID = Integer.parseInt(entries.nextLine());
		
		System.out.print("Add Issue to Report: ");
		String Report = entries.nextLine();
		
		Bug bug = new Bug(Coder, Date_Submitted, ID, Last_Checked, Level, Name, Priority, ProjectID, Tester, Type);
		Bugs_to_add.add(bug);
	}

}
