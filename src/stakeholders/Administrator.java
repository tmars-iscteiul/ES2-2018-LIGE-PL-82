package stakeholders;

/**
 * Class representing the administrator
 * @author skner
 *
 */
public class Administrator {
	private String name;
	private String email;
	
	public Administrator(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Administrator [Name:" + name + ", Email:" + email + "]";
	}
	
}
