import java.util.Scanner;

public abstract class Profile {
	private String Address;
	private String Backup_Answer;
	public String Backup_Question;
	private String Birthdate;
	public int Contact;
	private String Degree;
	public String Email;
	public String FirstName;
	private String Gender;
	private String Hired_On;
	private String LastName;
	private String Martial_Status;
	private String Password;
	public String Position;
	
	public Profile(String address, String backup_Answer, String backup_Question, String birthdate, int contact,
			String degree, String email, String firstName, String gender, String hired_On, String lastName,
			String martial_Status, String password, String position) {
		super();
		Address = address;
		Backup_Answer = backup_Answer;
		Backup_Question = backup_Question;
		Birthdate = birthdate;
		Contact = contact;
		Degree = degree;
		Email = email;
		FirstName = firstName;
		Gender = gender;
		Hired_On = hired_On;
		LastName = lastName;
		Martial_Status = martial_Status;
		Password = password;
		Position = position;
	}

	public boolean Change_Password(String NewPassword) {
		System.out.print("Type \\\"0\\\" to Exit");	
		System.out.print("Confirm Password: ");
		Scanner entries = new Scanner(System.in);
		String confirmPass = entries.nextLine();
		entries.close();
		if(confirmPass == "0")return false;
		if(NewPassword == confirmPass){
			Password = NewPassword;
			return true;
		}
		else {
			return Change_Password(NewPassword);
		}
	}
	
	public int Days_Hired() {
		//Split date according to way stored in Database
		//subtract current from saved
		//multiply years and months add to days
		int No_days = 0;
		
		return  No_days;
	}
	
	public void Edit_Profile(String address, String backup_Answer, String backup_Question, String birthdate, int contact,
			String gender, String hired_On, String martial_Status, String password, String position) {
		Address = address;
		Backup_Answer = backup_Answer;
		Backup_Question = backup_Question;
		Birthdate = birthdate;
		Contact = contact;
		Gender = gender;
		Hired_On = hired_On;
		Martial_Status = martial_Status;
		Position = position;
		if(Change_Password(password)) {
			System.out.print("Password Changed Successfully");
		}else System.out.print("Password UnChanged!");
	}
	
	abstract void Display_Bugs();
	abstract void Run_Account_Options(Scanner entries);
	
}
