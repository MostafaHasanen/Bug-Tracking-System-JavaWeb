import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Coder extends Profile{
	
	private ArrayList<Bug> Bugs_to_change;
	
	public Coder(String address, String backup_Answer, String backup_Question, String birthdate, int contact,
			String degree, String email, String firstName, String gender, String hired_On, String lastName,
			String martial_Status, String password) {
		super(address, backup_Answer, backup_Question, birthdate, contact, degree, email, firstName, gender, hired_On, lastName,
				martial_Status, password,"Coder");
		// TODO Auto-generated constructor stub
	}

	@Override
	void Run_Account_Options(Scanner entries) {
		
		System.out.println("Welcome Tester");
		boolean LoggedIn = true;
		System.out.println("1-Display Bugs   2-Fix Bug (Add Snippet in Report)   3-LogOut");
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
				Fix_Bug(BugID,entries);
				break;
			}
			case "3": {
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
		//Load Open with "SubmitToTest"=false Bugs assigned to current Coder by E-mail from database:
		//...
		ArrayList<Bug> Bugs;
		
	}
	
	void Fix_Bug(int BugID,Scanner entries) {
		Bug bug = null;
		System.out.print("Enter Snippet"); //GUI going to add to existed Report
		String snippet = entries.nextLine();
		bug.Report += "\nSnippet solution: "+snippet;
		bug.SubmitToTest = true;
		bug.Last_Checked = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		Bugs_to_change.add(bug);
	}

}
