package funing.excel;

public class bug_id_s {
	private String bug_id;

    private String serverity;


    public bug_id_s(String bug_id, String serverity) {
        this.bug_id = bug_id;
        this.serverity = serverity;
    }
    
    public String getBug_id() {
		return bug_id;
	}


	public void setBug_id(String bug_id) {
		this.bug_id = bug_id;
	}


	public String getServerity() {
		return serverity;
	}


	public void setServerity(String serverity) {
		this.serverity = serverity;
	}



}
