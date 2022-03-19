import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Java INterview Vertual Room
public class JIVR {
	private int queue = 0;
	private int prevID = 111;
	private Queue<Person> qList = new LinkedList<Person>();
	private Queue<Person> lobbyList = new LinkedList<Person>();
	private Scanner isc = new Scanner(System.in);
	private Scanner sc = new Scanner(System.in);

	/*
	 * Method to load all the students to the Lobby and Queue just to avoid manual
	 * Inputing details
	 */
	void loadData() {
		lobbyList.add(new Person("Kumar Saravanan", prevID++, queue++));
		lobbyList.add(new Person("Manoj Sasikumar", prevID++, queue++));
		lobbyList.add(new Person("Anpupama Mukesh", prevID++, queue++));
		lobbyList.add(new Person("Jagdeesh Sasikumar", prevID++, queue++));

		qList.add(new Person("Namdhana", prevID++, queue++));
		qList.add(new Person("Kundana", prevID++, queue++));
		qList.add(new Person("Samatha", prevID++, queue++));
		qList.add(new Person("Ravi", prevID++, queue++));
	}

	/*
	 * Main Option Menu which will route the requests accordingly
	 */
	void start() {
		loadData();

		do {
			sop("==================================================================");
			sop("1. ADD new person.");
			sop("2. Send to Interview Room.");
			sop("3. Print interviewed people List");
			sop("4. exit(E)");
			sop("==================================================================");

			sop("Please enter your input:");
			int inp = isc.nextInt();
			if (inp > 0 && inp < 3)
				selection(inp);
			else
				sop("Sorry please try again..");

		} while (true);
	}

	void selection(int val) {
		switch (val) {
		case 1:
			registerNew();
			break;
		case 2:
			sendIn();
			break;
		case 3:
			break;
		case 4:
			System.exit(0);
			break;
		default:
			sop("Sorry incorrect input");
		}
	}

	// register
	void registerNew() {

		sop("How many people would you like to register ? ");
		int n = isc.nextInt();
		int i = 1;

		do {
			sop("Please enter the name of " + i++ + " person: ");
			String name = sc.nextLine();
			Person p = new Person(name, prevID++, queue++);

			// lobby or line
			if (lobbyList.size() <= 3) {
				sop(" ");
				lobbyList.add(p);
				sop("Added Succesfully to Lobby!- EWT: " + lobbyList.size());
				sop(" " + p.getName() + " " + p.getID() + " " + p.getQueue());
			} else {

				qList.add(p);
				sop("Added Succesfully to the main Queue!- EWT: " + qList.size());
				sop(" " + p.getName() + " " + p.getID() + " " + p.getQueue());
			}
		} while (n-- > 0);

	}

	/*
	 * Method that deals with the insertion of person into the interview and manages
	 * the outer queue
	 */
	void sendIn() {

		// Making sure the lobby has people
		if (lobbyList.peek() != null) {
			Person p = lobbyList.poll();
			sop("Sent " + p.getName() + " to the interview room:");

			// checking if the outer queue has at lease 1 person
			if (qList.size() > 1) {
				Person lp = qList.poll();
				sop(lp.getName() + " with ID No. " + lp.getID() + " sent to lobby!");
				sop("The length of the outer queue is now: " + qList.size());
			}
		} else {
			sop("No reconds available.");
		}
	}

	// just to print text
	void sop(String value) {
		System.out.println(value);
	}

	// Main Method
	public static void main(String[] args) {
		new JIVR().start();
	}

}
