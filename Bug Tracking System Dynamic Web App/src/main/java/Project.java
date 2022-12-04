
public class Project {
	
	private String Client_Address;
	private String Client_Email;
	public String Client_Name;
	private int Client_Phone;
	public String DateOfStart;
	public String Department;
	public String Description;
	public String Duration;
	private int ID;
	public String Name;
	public String Project_Manager;
	
	public Project(String client_Address, String client_Email, String client_Name, int client_Phone, String dateOfStart,
			String department, String description, String duration, int iD, String name, String project_Manager) {
		super();
		Client_Address = client_Address;
		Client_Email = client_Email;
		Client_Name = client_Name;
		Client_Phone = client_Phone;
		DateOfStart = dateOfStart;
		Department = department;
		Description = description;
		Duration = duration;
		ID = iD;
		Name = name;
		Project_Manager = project_Manager;
	}

	
}
