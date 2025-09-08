public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    // No-argument constructor (default values via this())
    public AudioMixer() {
        this("StandardMix-8", 8, false); // Calls 3-parameter constructor
    }

    // Two-parameter constructor (defaults bluetooth to false)
    public AudioMixer(String mixerModel, int numberOfChannels) {
        this(mixerModel, numberOfChannels, false); // Calls 3-parameter constructor
    }

    // Three-parameter constructor (defaults max volume to 128.0)
    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 128.0); // Calls full constructor
    }

    // Main constructor (all fields)
    public AudioMixer(String mixerModel, int numberOfChannels,
                      boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;

        // Initialize connected devices array
        connectedDevices = new String[numberOfChannels];
        deviceCount = 0;

        // Print construction message
        System.out.println("AudioMixer created: " + mixerModel);
    }

    // Method to connect devices
    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied");
        }
    }

    // Method to display mixer status
    public void displayMixerStatus() {
        System.out.println("=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + " / " + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println("  Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");

        // Create mixers with different constructors
        AudioMixer m1 = new AudioMixer(); // no-arg constructor
        AudioMixer m2 = new AudioMixer("ClubMix-16", 16); // two-parameter
        AudioMixer m3 = new AudioMixer("ProMix-24", 24, true); // three-parameter
        AudioMixer m4 = new AudioMixer("UltraMix-32", 32, true, 150.0); // full constructor

        // Connect devices
        m1.connectDevice("Microphone A");
        m1.connectDevice("Guitar Input");

        m2.connectDevice("Keyboard");
        m2.connectDevice("Drum Machine");

        m3.connectDevice("DJ Controller");

        m4.connectDevice("Vocal Mic");
        m4.connectDevice("Synthesizer");
        m4.connectDevice("Bass Guitar");

        // Display mixer statuses
        m1.displayMixerStatus();
        m2.displayMixerStatus();
        m3.displayMixerStatus();
        m4.displayMixerStatus();
    }
}
