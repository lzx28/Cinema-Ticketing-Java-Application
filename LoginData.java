
public class LoginData 
{
	private String userName, password;
	
	public LoginData()
	{
		this.userName = "";
		this.password = "";
	}
	
	public LoginData(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void WelcomeToMovieList()
	{
		MovieList gui = new MovieList();
		
		gui.setVisible(true);
		gui.pack();
		gui.setLocationRelativeTo(null);
	}
	
	
}
