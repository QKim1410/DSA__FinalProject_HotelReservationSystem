package FProject;

public class SessionManager {
    private static SessionManager instance;
    private String loggedInEmail;

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void setLoggedInEmail(String email) {
        this.loggedInEmail = email;
    }

    public String getLoggedInEmail() {
        return loggedInEmail;
    }

    public void clearSession() {
        loggedInEmail = null;
    }

	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}
}
