package app.core.login;

public class ManagerLogin {

	private String email = "admin@mail";
	private String password = "admin";

	private boolean logged;

	public boolean login(String email, String password) {
		if (email.equals(this.email) && password.equals(this.password)) {
			logged = true;
			return true;
		} else {
			return false;
		}
	}

	public void logout() {
		logged = false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogged() {
		return logged;
	}

}
