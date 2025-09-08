class MovieTicket {
    private String movieName;
    private String theatreName;
    private int seatNumber;
    private double price;

    // 1. Default constructor → assigns "Unknown" movie
    public MovieTicket() {
        this.movieName = "Unknown";
        this.theatreName = "Unknown";
        this.seatNumber = 0;
        this.price = 0.0;
    }

    // 2. Constructor with movie name → assigns default price = 200
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.theatreName = "Unknown";
        this.seatNumber = 0;
        this.price = 200.0;
    }

    // 3. Constructor with movie name and seat number → assigns default theatre "PVR"
    public MovieTicket(String movieName, int seatNumber) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.theatreName = "PVR";
        this.price = 200.0;
    }

    // 4. Full constructor → sets all details
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Method to print ticket details
    public void printTicket() {
        System.out.println("🎟️ Movie Ticket");
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: ₹" + price);
        System.out.println("-------------------------");
    }
}

// Main class
public class MovieTicketSystem {
    public static void main(String[] args) {
        // Using different constructors
        MovieTicket t1 = new MovieTicket();  // Default constructor
        MovieTicket t2 = new MovieTicket("Inception");  // Movie only
        MovieTicket t3 = new MovieTicket("Interstellar", 12);  // Movie + Seat
        MovieTicket t4 = new MovieTicket("Oppenheimer", "IMAX", 25, 500.0);  // Full details

        // Print all tickets
        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}
