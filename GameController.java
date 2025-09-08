public class GameController {
    // Instance variables
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;    // 0 - 100
    private double sensitivity;  // 0.1 - 3.0

    // Default constructor - standard setup
    public GameController() {
        controllerBrand = "GenericPad";
        connectionType = "USB";
        hasVibration = true;
        batteryLevel = 100;
        sensitivity = 1.0;
    }

    // Full parameterized constructor
    public GameController(String controllerBrand, String connectionType,
                         boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;

        // Validate battery (0 - 100)
        if (batteryLevel < 0) {
            this.batteryLevel = 0;
        } else if (batteryLevel > 100) {
            this.batteryLevel = 100;
        } else {
            this.batteryLevel = batteryLevel;
        }

        // Validate sensitivity (0.1 - 3.0)
        if (sensitivity < 0.1) {
            this.sensitivity = 0.1;
        } else if (sensitivity > 3.0) {
            this.sensitivity = 3.0;
        } else {
            this.sensitivity = sensitivity;
        }
    }

    // Convenience constructor (brand + connectionType only)
    public GameController(String brand, String connectionType) {
        this(brand, connectionType, true, 100, 1.0);
    }

    // Methods to test functionality
    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("=== Controller Configuration ===");
        System.out.println("Brand: " + controllerBrand);
        System.out.println("Connection: " + connectionType);
        System.out.println("Vibration: " + hasVibration);
        System.out.println("Battery: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
        System.out.println("-------------------------------");
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("BUZZ! Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        // Create controller with default constructor
        GameController c1 = new GameController();

        // Create controller with full parameterized constructor
        GameController c2 = new GameController("ProGamerX", "Bluetooth", true, 85, 2.5);

        // Create controller with convenience constructor
        GameController c3 = new GameController("LitePad", "USB");

        // Test all methods on each controller
        c1.displayConfiguration();
        c1.calibrateController();
        c1.testVibration();

        c2.displayConfiguration();
        c2.calibrateController();
        c2.testVibration();

        c3.displayConfiguration();
        c3.calibrateController();
        c3.testVibration();
    }
}
