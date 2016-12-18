package dad.atelier3_2.model;

public class Session {

	private String pid;
	private String parent;
	private String refIndividu;

	public Session(String pid, String parent, String refIndividu) {
		super();
		this.pid = pid;
		this.parent = parent;
		this.refIndividu = refIndividu;
	}

	public String getPid() {
		return pid;
	}

	public String getParent() {
		return parent;
	}

	public String getRefIndividu() {
		return refIndividu;
	}

	public boolean isInPopin() {
		return parent == null;
	}
}
