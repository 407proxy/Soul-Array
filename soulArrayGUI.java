import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;


public class soulArrayGUI {

    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, storyContinuePanel, menuPanel, menuButton, coinsPanel, goBackToMainPanel, userHpLabel, oppHpLabel, bodyTextPanel, fighPassPanel, turnPanel; 

    JLabel titleTextLabel, menuTitle, coinsText, userHp, oppHp, turnText;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font subFont = new Font("Times New Roman", Font.PLAIN, 60);
    JButton startButton, storyButton, buy, sell, play, quit, goBackToMainB, fight, pass, cont;
    JTextArea mainTextArea, messageTextArea, bodyTextArea;

    //organs
    JPanel organsButtons;
    JButton brain, guts, hands, heart, legs, eyes, lungs, kidney, teeth, skin;

    // horses
    JPanel horses;
    JButton cerberus, persephone, hades, voskopoulos, tom;
    // horse racing panels
    JLabel hrTitle, hrSubtitle, hrEnterBet;
    JPanel hrTitlePanel, hrSubPanel, hrBetPanel;

    //games
    JPanel gamesButtons;
    JButton danceWdevilB, horseRacingB, rockPaperScissorsB;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ContinueButtonHandler cbHandler = new ContinueButtonHandler();
    PlayHandler playHandler = new PlayHandler();
    SellHandler sellHandler = new SellHandler();
    QuitHandler quitHandler = new QuitHandler();
    BuyHandler buyHandler = new BuyHandler();
    GoBackHandler goBackHandler = new GoBackHandler();
    DanceWDevilHandler dwdHandler = new DanceWDevilHandler();
    HorseRacingHandler hrHandler = new HorseRacingHandler();

    ArrayList<String> mainArray = new ArrayList<>(Arrays.asList("BRAIN", "GUTS", "HANDS", "HEART", "LEGS"));
    ArrayList<String> sellArray = new ArrayList<>(Arrays.asList("EYES", "LUNGS", "KIDNEY", "TEETH", "SKIN"));
    ArrayList<Integer> mainArrayPrice = new ArrayList<>(Arrays.asList(2000, 1800, 1500, 3500, 2300));
    ArrayList<Integer> sellArrayPrice = new ArrayList<>(Arrays.asList(800, 1250, 1000, 750, 900));

    private int coins = 50000;
    private int userHpAmount = 1000;
    private int oppHpAmount = 1000;
    ArrayList<String> boughtOrgans = new ArrayList<>();
    ArrayList<String> soldOrgans = new ArrayList<>();

    public static void main(String[] args){
        new soulArrayGUI();
    }

    public soulArrayGUI(){
        
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleTextLabel = new JLabel("SOUL ARRAY");
        titleTextLabel.setForeground(Color.white);
        titleTextLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleTextLabel);
        startButtonPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);

        //go back to main menu button
        goBackToMainPanel = new JPanel();
        goBackToMainPanel.setBounds(10, 10, 100, 50);
        goBackToMainPanel.setBackground(Color.black);
        goBackToMainB = new JButton("Menu");
        goBackToMainB.setBackground(Color.black);
        goBackToMainB.setForeground(Color.white);
        goBackToMainB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        goBackToMainB.setFocusPainted(false);
        goBackToMainB.addActionListener(goBackHandler);
        goBackToMainPanel.add(goBackToMainB);
        goBackToMainPanel.setVisible(false); // Initially hidden

        window.add(goBackToMainPanel);
        window.setVisible(true);
    }

    public void storyScreen(){
        
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(200, 200, 600, 150);
        mainTextPanel.setBackground(Color.black);
        mainTextPanel.setLayout(new BorderLayout());
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("You've sold your soul to me");
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea, BorderLayout.NORTH);

        messageTextArea = new JTextArea();
        messageTextArea.setBackground(Color.black);
        messageTextArea.setForeground(Color.green);
        messageTextArea.setFont(normalFont);
        messageTextArea.setLineWrap(true);
        mainTextPanel.add(messageTextArea, BorderLayout.CENTER);

        storyContinuePanel = new JPanel();
        storyContinuePanel.setBounds(225, 350, 300, 150);
        storyContinuePanel.setBackground(Color.black);
        window.add(storyContinuePanel); 
    
        storyButton = new JButton("continue");
        storyButton.setBackground(Color.black);
        storyButton.setForeground(Color.white);
        storyButton.setFont(normalFont);
        storyButton.setFocusPainted(false);
        storyButton.addActionListener(cbHandler);
        storyContinuePanel.add(storyButton);
    }

    public void mainMenu(){
        if (storyContinuePanel != null) storyContinuePanel.setVisible(false);
        if (mainTextPanel != null) mainTextPanel.setVisible(false);
        if (coinsPanel != null) coinsPanel.setVisible(false);
        if (organsButtons != null) organsButtons.setVisible(false);
        if (gamesButtons != null) gamesButtons.setVisible(false);
        if (userHpLabel != null) userHpLabel.setVisible(false);
        if (oppHpLabel != null) oppHpLabel.setVisible(false);
        if (bodyTextPanel != null)bodyTextPanel.setVisible(false);
        if (fighPassPanel != null) fighPassPanel.setVisible(false);
        if (turnPanel != null) turnPanel.setVisible(false);
        if (hrTitlePanel != null) hrTitlePanel.setVisible(false);
        if (hrSubPanel != null) hrSubPanel.setVisible(false);
        if (hrBetPanel != null) hrBetPanel.setVisible(false);
        if (horses != null) horses.setVisible(false);

        if (messageTextArea != null) messageTextArea.setText("");

        menuPanel = new JPanel();
        menuPanel.setBounds(100, 100, 600, 150);
        menuPanel.setBackground(Color.black);
        menuTitle = new JLabel("MAIN MENU");
        menuTitle.setForeground(Color.white);
        menuTitle.setFont(titleFont);

        menuPanel.add(menuTitle);
        window.add(menuPanel);

        menuButton = new JPanel();
        menuButton.setBounds(225, 350, 300, 150);
        menuButton.setBackground(Color.black);
        menuButton.setLayout(new GridLayout(2, 2));
        window.add(menuButton); 
    
        play = new JButton("Play");
        play.setBackground(Color.black);
        play.setForeground(Color.green);
        play.setFont(normalFont);
        play.addActionListener(playHandler);
        play.setFocusPainted(false);

        quit = new JButton("Quit");
        quit.setBackground(Color.black);
        quit.setForeground(Color.red);
        quit.setFont(normalFont);
        quit.addActionListener(quitHandler);
        quit.setFocusPainted(false);

        buy = new JButton("Buy");
        buy.setBackground(Color.black);
        buy.setForeground(Color.white);
        buy.setFont(normalFont);
        buy.addActionListener(buyHandler);
        buy.setFocusPainted(false);

        sell = new JButton("Sell");
        sell.setBackground(Color.black);
        sell.setForeground(Color.white);
        sell.setFont(normalFont);
        sell.addActionListener(sellHandler);
        sell.setFocusPainted(false);

        menuButton.add(play);
        menuButton.add(quit);
        menuButton.add(buy);
        menuButton.add(sell);

        goBackToMainPanel.setVisible(false);
    }

    public void games(){
        goBackToMainPanel.setVisible(true);
        if (menuPanel != null) menuPanel.setVisible(false);
        if (menuButton != null) menuButton.setVisible(false);
        
        mainTextPanel.setVisible(true);
        mainTextArea.setText("Which game do you want to play?");

        coinsPanel = new JPanel();
        coinsPanel.setBounds(80, 100, 600, 150);
        coinsPanel.setBackground(Color.black);
        coinsText = new JLabel();
        coinsText.setText("Coins: " + coins);
        coinsText.setForeground(Color.yellow);
        coinsText.setFont(normalFont);
        coinsPanel.add(coinsText);

        gamesButtons = new JPanel();
        gamesButtons.setBounds(225, 350, 300, 150);
        gamesButtons.setBackground(Color.black);
        gamesButtons.setLayout(new GridLayout(3, 3));
        window.add(gamesButtons);

        danceWdevilB = choiceButton("Dance with the Devil");
        danceWdevilB.addActionListener(dwdHandler);
        horseRacingB = choiceButton("Horse Racing");
        horseRacingB.addActionListener(hrHandler);
        rockPaperScissorsB = choiceButton("Rock Paper Scissors");

        gamesButtons.add(danceWdevilB);
        gamesButtons.add(horseRacingB);
        gamesButtons.add(rockPaperScissorsB);

        window.add(coinsPanel);

    }

    public void danceWdevil(){
        if (gamesButtons != null) gamesButtons.setVisible(false);
        if (menuButton != null) menuButton.setVisible(false);
        if (mainTextPanel != null) mainTextPanel.setVisible(false);
        coinsPanel.setBounds(270, 80, 200, 50);

        userHpLabel = new JPanel();
        userHpLabel.setBounds(10, 120, 200, 50);
        userHpLabel.setBackground(Color.red);

        userHp = new JLabel("HP: " + userHpAmount);
        userHp.setForeground(Color.white);
        userHp.setFont(normalFont);

        userHpLabel.add(userHp);
        window.add(userHpLabel);

        oppHpLabel = new JPanel();
        oppHpLabel.setBounds(550, 120, 200, 50);
        oppHpLabel.setBackground(Color.blue);

        oppHp = new JLabel("Devil's HP: " + oppHpAmount);
        oppHp.setForeground(Color.red);
        oppHp.setFont(normalFont);

        oppHpLabel.add(oppHp);
        window.add(oppHpLabel);

        turnPanel = new JPanel();
        turnPanel.setBounds(280, 170, 200, 50);
        turnPanel.setBackground(Color.blue);

        String userTurn = "Your turn";
        String devilTurn = "Opponent's turn";

        turnText = new JLabel(userTurn);
        turnText.setForeground(Color.red);
        turnText.setFont(normalFont);

        turnPanel.add(turnText);
        window.add(turnPanel);

        bodyTextPanel = new JPanel();
        bodyTextPanel.setBounds(40, 250, 700, 150);
        bodyTextPanel.setBackground(Color.red);
        bodyTextPanel.setLayout(new BorderLayout());
        window.add(bodyTextPanel);

        bodyTextArea = new JTextArea("You inflicted bla bnla bla\nYou inflicted bla bnla bla\nYou inflicted bla bnla bla\nYou inflicted bla bnla bla");
        bodyTextArea.setBackground(Color.green);
        bodyTextArea.setForeground(Color.white);
        bodyTextArea.setFont(normalFont);
        bodyTextArea.setLineWrap(true);
        bodyTextPanel.add(bodyTextArea, BorderLayout.NORTH);
        
        fighPassPanel = new JPanel();
        fighPassPanel.setBounds(150, 450, 500, 50);
        fighPassPanel.setBackground(Color.pink);
        fighPassPanel.setLayout(new GridLayout(1, 3));

        JButton fight = new JButton("FIGHT");
        fight.setBackground(Color.green);
        fight.setForeground(Color.white);
        fight.setFont(normalFont);
        fight.setFocusPainted(false);

        JButton pass = new JButton("Pass");
        pass.setBackground(Color.red);
        pass.setForeground(Color.white);
        pass.setFont(normalFont);
        pass.setFocusPainted(false);

        JButton cont = new JButton(">");
        cont.setBackground(Color.orange);
        cont.setForeground(Color.white);
        cont.setFont(normalFont);
        cont.setFocusPainted(false);

        fighPassPanel.add(fight);
        fighPassPanel.add(cont);
        fighPassPanel.add(pass);
        window.add(fighPassPanel);
    }

    public void horseRacing(){
        if (gamesButtons != null) gamesButtons.setVisible(false);
        if (menuButton != null) menuButton.setVisible(false);
        if (mainTextPanel != null) mainTextPanel.setVisible(false);
        coinsPanel.setBounds(300, 80, 200, 50);

        hrTitlePanel = new JPanel();
        hrTitlePanel.setBounds(150, 150, 500, 75);
        hrTitlePanel.setBackground(Color.black);

        hrTitle = new JLabel("Horse Racing");
        hrTitle.setForeground(Color.red);
        hrTitle.setFont(subFont);

        hrTitlePanel.add(hrTitle);
        window.add(hrTitlePanel);

        hrSubPanel = new JPanel();
        hrSubPanel.setBounds(150, 240, 500, 80);
        hrSubPanel.setBackground(Color.black);

        hrSubtitle = new JLabel("Pick your horse");
        hrSubtitle.setForeground(Color.white);
        hrSubtitle.setFont(normalFont);

        hrSubPanel.add(hrSubtitle);
        window.add(hrSubPanel);

        horses = new JPanel();
        horses.setBounds(250, 350, 300, 150);
        horses.setBackground(Color.black);
        horses.setLayout(new GridLayout(5, 1));
        window.add(horses); 
    
        final String[] selectedHorse = {""};

        cerberus = choiceButton("Cerberus");
        persephone = choiceButton("Persephone");
        hades = choiceButton("Hades");
        voskopoulos = choiceButton("Voskopoulos");
        tom = choiceButton("Tom");

        cerberus.addActionListener(e -> {
            selectedHorse[0] = "Cerberus";
            horses.setVisible(false);
            hrSubPanel.setVisible(false);
        });
        
        persephone.addActionListener(e -> {
            selectedHorse[0] = "Persephone";
            horses.setVisible(false);
            hrSubPanel.setVisible(false);
        });
        
        hades.addActionListener(e -> {
            selectedHorse[0] = "Hades";
            horses.setVisible(false);
            hrSubPanel.setVisible(false);
        });
        
        voskopoulos.addActionListener(e -> {
            selectedHorse[0] = "Voskopoulos";
            horses.setVisible(false);
            hrSubPanel.setVisible(false);
        });
        
        tom.addActionListener(e -> {
            selectedHorse[0] = "Tom";
            horses.setVisible(false);
            hrSubPanel.setVisible(false);
        });
    
        horses.add(cerberus);
        horses.add(persephone);
        horses.add(hades);
        horses.add(voskopoulos);
        horses.add(tom);

        hrBetPanel = new JPanel();
        hrBetPanel.setBounds(150, 240, 500, 80);
        hrBetPanel.setBackground(Color.black);

        hrEnterBet = new JLabel("Enter amount to bet.");
        hrEnterBet.setForeground(Color.white);
        hrEnterBet.setFont(normalFont);

        hrBetPanel.add(hrEnterBet);
        window.add(hrBetPanel);

        // add a text field here that only accepts integers. there is also a button underneath it entitled "ENTER". if the user inputs an int, and clicks ENTER, it will be stored in a variable. 
        // else, if the field is blank or the input isn't an integer or the input equals 0, display an error message and wait until the user inputs a valid input again.


    }

    public JButton choiceButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(normalFont);
        button.setFocusPainted(false);
        return button;
    }

    public void buy(){
        goBackToMainPanel.setVisible(true);
        if (menuPanel != null) menuPanel.setVisible(false);
        if (menuButton != null) menuButton.setVisible(false);
        
        mainTextPanel.setVisible(true);
        mainTextArea.setText("Which organ do you want to buy?");
        messageTextArea.setText(""); // Clear the message area
    
        coinsPanel = new JPanel();
        coinsPanel.setBounds(80, 100, 600, 150);
        coinsPanel.setBackground(Color.black);
        coinsText = new JLabel();
        coinsText.setText("Coins: " + coins);
        coinsText.setForeground(Color.yellow);
        coinsText.setFont(normalFont);
        coinsPanel.add(coinsText);
    
        organsButtons = new JPanel();
        organsButtons.setBounds(225, 350, 300, 150);
        organsButtons.setBackground(Color.black);
        organsButtons.setLayout(new GridLayout(5, 1));
        window.add(organsButtons); 
    
        brain = choiceButton("Brain");
        brain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buyOrgan("BRAIN", mainArray, mainArrayPrice);
            }
        });
    
        guts = choiceButton("Guts");
        guts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buyOrgan("GUTS", mainArray, mainArrayPrice);
            }
        });
    
        hands = choiceButton("Hands");
        hands.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buyOrgan("HANDS", mainArray, mainArrayPrice);
            }
        });
    
        heart = choiceButton("Heart");
        heart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buyOrgan("HEART", mainArray, mainArrayPrice);
            }
        });
    
        legs = choiceButton("Legs");
        legs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buyOrgan("LEGS", mainArray, mainArrayPrice);
            }
        });
    
        organsButtons.add(brain);
        organsButtons.add(guts);
        organsButtons.add(hands);
        organsButtons.add(heart);
        organsButtons.add(legs);
        window.add(coinsPanel);

        if(mainArray.isEmpty()){
            organsButtons.setVisible(false);
            coinsPanel.setVisible(false);
            messageTextArea.setVisible(false);
            mainTextArea.setText("You win! You bought \nall your organs".toUpperCase());

        }
    }

    public void sell() {
        goBackToMainPanel.setVisible(true);
        if (menuPanel != null) menuPanel.setVisible(false);
        if (menuButton != null) menuButton.setVisible(false);
        
        mainTextPanel.setVisible(true);
        mainTextArea.setText("Which organ do you want to sell?");
        messageTextArea.setText(""); // Clear the message area
    
        coinsPanel = new JPanel();
        coinsPanel.setBounds(80, 100, 600, 150);
        coinsPanel.setBackground(Color.black);
        coinsText = new JLabel();
        coinsText.setText("Coins: " + coins);
        coinsText.setForeground(Color.yellow);
        coinsText.setFont(normalFont);
        coinsPanel.add(coinsText);
    
        organsButtons = new JPanel();
        organsButtons.setBounds(225, 350, 300, 150);
        organsButtons.setBackground(Color.black);
        organsButtons.setLayout(new GridLayout(5, 1));
        window.add(organsButtons); 
    
        eyes = choiceButton("Eyes");
        eyes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sellOrgan("EYES", sellArray, sellArrayPrice);
            }
        });

        lungs = choiceButton("Lungs");
        lungs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sellOrgan("LUNGS", sellArray, sellArrayPrice);
            }
        });

        kidney = choiceButton("Kidney");
        kidney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sellOrgan("KIDNEY", sellArray, sellArrayPrice);
            }
        });

        teeth = choiceButton("Teeth");
        teeth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sellOrgan("TEETH", sellArray, sellArrayPrice);
            }
        });

        skin = choiceButton("Skin");
        skin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sellOrgan("SKIN", sellArray, sellArrayPrice);
            }
        });
    
        organsButtons.add(eyes);
        organsButtons.add(lungs);
        organsButtons.add(kidney);
        organsButtons.add(teeth);
        organsButtons.add(skin);
        window.add(coinsPanel);

        if(sellArray.isEmpty()){
            organsButtons.setVisible(false);
            coinsPanel.setVisible(false);
            messageTextArea.setVisible(false);
            mainTextArea.setText("You've sold all \nyour available organs".toUpperCase());
        }
    }

    private void buyOrgan(String organ, ArrayList<String> organsList, ArrayList<Integer> pricesList) {
        int index = organsList.indexOf(organ);
        if (index != -1) {
            int price = pricesList.get(index);
            if (coins >= price) {
                coins -= price;
                coinsText.setText("Coins: " + coins);
                organsList.remove(index);
                pricesList.remove(index);
                // Inform the user
                messageTextArea.setText("You've bought " + organ);
                boughtOrgans.add(organ);
                switch (organ) {
                    case "BRAIN":
                        brain.setForeground(Color.gray);
                        break;
                    case "GUTS":
                        guts.setForeground(Color.gray);
                        break;
                    case "HANDS":
                        hands.setForeground(Color.gray);
                        break;
                    case "HEART":
                        heart.setForeground(Color.gray);
                        break;
                    case "LEGS":
                        legs.setForeground(Color.gray);
                        break;
                }
            } else {
                messageTextArea.setText("Not enough coins to buy " + organ);
            }
        }
        if(organsList.isEmpty()){
            organsButtons.setVisible(false);
            coinsPanel.setVisible(false);
            messageTextArea.setVisible(false);
            mainTextArea.setText("You WIN, you've bought \nall your available organs back".toUpperCase());
            goBackToMainPanel.setVisible(false);
        }
    }

    private void sellOrgan(String organ, ArrayList<String> organsList, ArrayList<Integer> pricesList) {
        int index = organsList.indexOf(organ);
        if (index != -1) {
            int price = pricesList.get(index);
            coins += price;
            coinsText.setText("Coins: " + coins);
            organsList.remove(index);
            pricesList.remove(index);
            // Inform the user
            messageTextArea.setText("You've sold " + organ);
            soldOrgans.add(organ);
            switch (organ) {
                case "EYES":
                    eyes.setForeground(Color.gray);
                    break;
                case "LUNGS":
                    lungs.setForeground(Color.gray);
                    break;
                case "KIDNEY":
                    kidney.setForeground(Color.gray);
                    break;
                case "TEETH":
                    teeth.setForeground(Color.gray);
                    break;
                case "SKIN":
                    skin.setForeground(Color.gray);
                    break;
            }
        }
        if(organsList.isEmpty()){
            organsButtons.setVisible(false);
            coinsPanel.setVisible(false);
            messageTextArea.setVisible(false);
            mainTextArea.setText("You've sold all \nyour available organs".toUpperCase());
        }
    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            storyScreen();
        }
    }

    public class ContinueButtonHandler implements ActionListener {
        private int clickCount = 0;
        public void actionPerformed(ActionEvent event) {
            clickCount++;
            if (clickCount == 1) {
                mainTextArea.setText("And now you regret it?");
            } else if (clickCount == 2) {
                mainTextArea.setText("Fine, you can have it back");
            } else if (clickCount == 3) {
                mainTextArea.setText("If you can beat me in a little game of course");
            } else if (clickCount == 4) {
                mainMenu();
            }
        }
    }

    public class PlayHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            games();
        }
    }

    public class BuyHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            buy();
        }
    }

    public class SellHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            sell();
        }
    }

    public class QuitHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            System.exit(0);
        }
    }

    public class GoBackHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            mainMenu();
        }
    }

    public class DanceWDevilHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            danceWdevil();
        }
    }

    public class HorseRacingHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            horseRacing();
        }
    }
}
