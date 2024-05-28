import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Arrays;

public class HorseRaceAnimation {
    private JFrame frame;
    private JLabel[] horses;
    private int[] positions;
    private int[] speeds;
    private String[] horseList = {"CERBERUS", "PERSEPHONE", "HADES", "VOSKOPOULOS", "TOM"};
    private boolean raceOver = false;

    public HorseRaceAnimation() {
        frame = new JFrame("Horse Race Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new GridLayout(5, 1));

        horses = new JLabel[5];
        positions = new int[5];
        speeds = new int[5];

        // Generate unique speeds for each horse
        generateUniqueSpeeds();

        for (int i = 0; i < 5; i++) {
            horses[i] = new JLabel(horseList[i] + " - Speed: " + speeds[i]);
            frame.add(horses[i]);
            positions[i] = 0;
        }

        Timer timer = new Timer(100, e -> {
            if (!raceOver) {
                for (int i = 0; i < 5; i++) {
                    positions[i] += speeds[i];
                    horses[i].setText(horseList[i] + " - Position: " + positions[i] + " - Speed: " + speeds[i]);
                    if (positions[i] >= 1000) {
                        raceOver = true;
                        displayStandings(positions);
                        break;
                    }
                }
            }
        });

        timer.start();

        frame.setVisible(true);
    }

    private void generateUniqueSpeeds() {
        boolean[] usedSpeeds = new boolean[21];
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            int speed;
            do {
                speed = rand.nextInt(5) + 1;
            } while (usedSpeeds[speed]);
            usedSpeeds[speed] = true;
            speeds[i] = speed;
        }
    }

    private void displayStandings(int[] finalPositions) {
        String[] standings = new String[5];
        int[] sortedPositions = finalPositions.clone();
        Arrays.sort(sortedPositions);

        for (int i = 0; i < 5; i++) {
            int position = 0;
            for (int j = 0; j < 5; j++) {
                if (finalPositions[j] == sortedPositions[4 - i]) {
                    position = j + 1;
                    break;
                }
            }
            standings[i] = horseList[position - 1] + " - " + getPositionString(position);
        }

        for (String standing : standings) {
            System.out.println(standing);
        }
    }

    private String getPositionString(int position) {
        switch (position) {
            case 1:
                return "1st";
            case 2:
                return "2nd";
            case 3:
                return "3rd";
            default:
                return position + "th";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HorseRaceAnimation());
    }
}