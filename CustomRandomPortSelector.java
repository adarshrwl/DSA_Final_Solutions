import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CustomRandomPortSelector {
    private int range; // Total range of available ports
    private Set<Integer> blacklist; // Set of blacklisted ports
    private Random random; // Random number generator

    public CustomRandomPortSelector(int range, int[] blacklistedPorts) {
        this.range = range;
        this.blacklist = new HashSet<>();
        for (int port : blacklistedPorts) {
            blacklist.add(port);
        }
        this.random = new Random();
    }

    public int getRandomPort() {
        int availablePorts = range - blacklist.size();
        int randomPort = random.nextInt(availablePorts);
        int count = 0;

        // Iterate through all possible ports to find the randomly selected one
        for (int port = 0; port < range; port++) {
            if (!blacklist.contains(port)) {
                if (count == randomPort) {
                    return port;
                }
                count++;
            }
        }
        return -1; // Return -1 if no available port is found
    }

    public static void main(String[] args) {
        int[] blacklistedPorts = { 2, 3, 5 };
        CustomRandomPortSelector portSelector = new CustomRandomPortSelector(7, blacklistedPorts);

        // Generate and print random ports
        System.out.println("Random Port: " + portSelector.getRandomPort());
        System.out.println("Random Port: " + portSelector.getRandomPort());
        System.out.println("Random Port: " + portSelector.getRandomPort());
        System.out.println("Random Port: " + portSelector.getRandomPort());
        System.out.println("Random Port: " + portSelector.getRandomPort());
    }
}
