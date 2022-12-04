
public class Bug {

	public String Coder;
	public String Date_Submitted;
	private int ID;
	public String Last_Checked;
	public int Level;
	public String Name;
	public int Priority;
	private int ProjectID;
	public boolean Status = true;
	public boolean SubmitToTest = false;
	private String Tester;
	public String Type;
	public String Report;
	
	
	public Bug(String coder, String date_Submitted, int iD, String last_Checked, int level, String name, int priority,
			int projectID, String tester, String type) {
		super();
		Coder = coder;
		Date_Submitted = date_Submitted;
		ID = iD;
		Last_Checked = last_Checked;
		Level = level;
		Name = name;
		Priority = priority;
		ProjectID = projectID;
		Tester = tester;
		Type = type;
	}
	
	//Left for additional options to be displayed in GUI as hypertext
	void Add_Comment(String Comment) {
		
	}
	
	void Update(String BugFixSnippet) {
		
	}
}
