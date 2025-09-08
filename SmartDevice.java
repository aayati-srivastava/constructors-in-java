public class SmartDevice {
    private String deviceName;
    private String location;
    private boolean isOnline;
    private double powerConsumption;
    private String[] connectedDevices;
    private int connectionCount;

    // Constructor with parameter names same as fields
    public SmartDevice(String deviceName, String location,
                      boolean isOnline, double powerConsumption) {
        this.deviceName = deviceName;       // disambiguation
        this.location = location;
        this.isOnline = isOnline;
        this.powerConsumption = powerConsumption;
        this.connectedDevices = new String[5]; // max 5 devices
        this.connectionCount = 0;
    }

    // Method using this for parameter disambiguation
    public void updateLocation(String location) {
        this.location = location; // disambiguation
        System.out.println(this.deviceName + " moved to " + this.location);
    }

    // Method using this for disambiguation
    public void updatePowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption; // disambiguation
        System.out.println("Power consumption updated for " + this.deviceName);
    }

    // Method returning this for chaining
    public SmartDevice setOnline(boolean isOnline) {
        this.isOnline = isOnline;
        return this;
    }

    // Connect device to this device
    public SmartDevice connectDevice(String deviceName) {
        if (this.connectionCount < this.connectedDevices.length) {
            this.connectedDevices[this.connectionCount] = deviceName;
            this.connectionCount++;
            System.out.println(this.deviceName + " connected to " + deviceName);
        } else {
            System.out.println("No more connections available!");
        }
        return this; // enable method chaining
    }

    // Rename device (with this for disambiguation)
    public SmartDevice rename(String deviceName) {
        String oldName = this.deviceName;
        this.deviceName = deviceName;
        System.out.println("Device renamed from " + oldName + " to " + this.deviceName);
        return this;
    }

    // Display device information
    public void displayDeviceInfo() {
        System.out.println("=== " + this.deviceName + " INFO ===");
        System.out.println("Location: " + this.location);
        System.out.println("Status: " + (this.isOnline ? "Online" : "Offline"));
        System.out.println("Power: " + this.powerConsumption + " W");
        System.out.println("Connections: " + this.connectionCount);
        for (int i = 0; i < this.connectionCount; i++) {
            System.out.println(" -> " + this.connectedDevices[i]);
        }
        System.out.println("-----------------------------");
    }

    // Calls other methods using this
    public void performInitialSetup() {
        this.setOnline(true);
        System.out.println(this.deviceName + " initial setup completed");
    }

    public static void main(String[] args) {
        System.out.println("=== SMART HOME DEVICE NETWORK ===");

        // Create devices
        SmartDevice d1 = new SmartDevice("LightBulb", "Living Room", false, 10.5);
        SmartDevice d2 = new SmartDevice("SmartSpeaker", "Bedroom", true, 20.0);

        // Test method chaining
        d1.setOnline(true)
          .connectDevice("Alexa")
          .rename("Kitchen Hub");

        // Test disambiguation
        d2.updateLocation("Dining Room");
        d2.updatePowerConsumption(25.0);

        // Perform initial setup
        d1.performInitialSetup();

        // Display device info
        d1.displayDeviceInfo();
        d2.displayDeviceInfo();
    }
}
