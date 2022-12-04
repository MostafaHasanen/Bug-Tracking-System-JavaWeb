import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main_Program {

	//Database Storage units specified for each stage to avoid overloading memory with all information
	public static Hashtable<String, String> Email_Password_Registered = new Hashtable<String, String>();
	public static ArrayList<String> Emails_LoggedIn = new ArrayList<String>();
	public static Admin admin;	
	public static void main(String[] args) {
		//Scanner for entire process
		//GUI Replace Scanner entries with Text catchers
		Scanner entries = new Scanner(System.in);		
		
		// Admin Info only accessed by code, rest of personal info can be edited
		String email = "Admin@CompanyName.co";
		String password = "ChangablePassowrd";
		String security_Code = "CodeWrittenByAdminInSourceCode";
		Email_Password_Registered.put(email, password);
		admin = Admin.getInstance(email, password, security_Code);
		
		//Code Area to load data stored in Database:
		//...
		
		
		//Program Started
		boolean ProgramRunFlag = true;
		while(ProgramRunFlag){
			System.out.println("Welcome To Bug Tracking System");
			System.out.print("1-LogIn    2-Register    3-Exit: ");
			String entry = entries.nextLine();
			switch(entry) {
				case "1":
					Login(entries);
					break;
				case "2":
					Register(entries);
					break;
				case "3":
					ProgramRunFlag=false;
					break;
				default:
					System.out.println("Wrong Entry, Please Try Again!");
			}
			
		}
		entries.close();
	}
	
	public static void Login(Scanner entries) {
		//Authentication phase and class creation:
		System.out.println("Type \"0\" to Exit");
		System.out.print("Enter your E-mail: ");
		String EntryEmail = entries.nextLine();
		if(EntryEmail == "0")return;
		System.out.print("Enter your Password: ");
		String EntryPassword = entries.nextLine();
		if(EntryPassword == "0")return;
		
		// Wrong Email
		if(Email_Password_Registered.get(EntryEmail) == null) {
			System.out.println("Email Does not exist! Register if new! or Try Again!");
			Login(entries);
			return;
		}
		else {
			//Wrong Password
			if(Email_Password_Registered.get(EntryEmail) != EntryPassword) {
				System.out.println("Password Incorrect Please Try Again!");
				Login(entries);
				return;
			}
			//Program successfully Logged In
			else {
				Emails_LoggedIn.add(EntryEmail);
				//Load Email info from Database:
				//...

				String firstName = null;
				String lastName = null;
				String gender = null;
				String address = null;
				String hired_On = null;
				String martial_Status = null;
				String backup_Answer = null; 
				String backup_Question = null;
				String birthdate = null;
				int contact = 0;
				String degree = null;
				String position = "";
				
				//Check Which Type of Email logged-in:
				Profile loggedAccount = null;
				switch(position) {
					case "Coder":
						loggedAccount = new Coder(address, backup_Answer, backup_Question, birthdate, contact, degree, EntryEmail, firstName, gender, hired_On, lastName,
								martial_Status, EntryPassword);
						break;
					case "Tester":
						loggedAccount = new Tester(address, backup_Answer, backup_Question, birthdate, contact, degree, EntryEmail, firstName, gender, hired_On, lastName,
								martial_Status, EntryPassword);
						break;
					case "Admin":
						int countBlock = 0;
						while(true) {
							System.out.println("Type \"0\" to Exit");
							System.out.print("Please Confirm your Security Code: ");
							String EntryCode = entries.nextLine();
							if(EntryCode == "0")break;
							if(admin.getSecurity_Code() == EntryCode) {
								System.out.println("Security Code is correct welcome Admin!");
								loggedAccount = admin;
								
							}
							else {
								countBlock++;
								System.out.println("Security Code is incorrect! tries (Max 3): "+countBlock);
								if(countBlock == 3)break;
							}
						}
						break;
					default:
						System.out.println("WHY AM I HERE!!!");
				}
				// Initialized in switch case
				loggedAccount.Run_Account_Options(entries); //Globalized to give option to add to LOGS
				Logout();
			}
		}
	}

	public static void Register(Scanner entries) {		
		System.out.println("Type \"0\" to Exit");
		System.out.print("Enter new E-mail: ");
		String EntryEmail = entries.nextLine();
		if(EntryEmail == "0")return;
		System.out.print("Enter your Password: ");
		String EntryPassword = entries.nextLine();
		if(EntryPassword == "0")return;
		System.out.print("Confirm your Password: ");
		String ConfirmPassword = entries.nextLine();
		if(ConfirmPassword == "0")return;
		
		// Email already Exist
		if(Email_Password_Registered.get(EntryEmail) != null) {
			System.out.println("Email already exist! Try Again with unique Email!");
			Register(entries);
			return;
		}
		else {
			//Wrong Confirmation
			if(EntryPassword != ConfirmPassword) {
				System.out.println("Password Confirmation does not match!");
				Register(entries);
				return;
			}
			//Account successfully Registered In
			else {
				//Essential info for register: Fulfill with GUI
//				String firstName;
//				String lastName;
//				int contact;
//				String degree;
				
				Email_Password_Registered.put(EntryEmail, EntryPassword);
				Login(entries);
			}
		}
	}
	
	public static void Logout() {
		
		System.out.flush();
		
		//Code Area to write changes occurred in Main to database:
		//...
		
	}
}
