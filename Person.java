
public class Person{
	private String name;
	private final int ID;
	private int queue;
	
	Person(String name, int ID, int queue)
	{
		this.name = name;
		this.ID = ID;
		this.queue = queue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQueue() {
		return queue;
	}

	public void setQueue(int queue) {
		this.queue = queue;
	}

	public int getID() {
		return ID;
	}
	
}
