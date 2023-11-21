import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * The {@code FarmGame} class represents the main game application for a farming simulation.
 * It includes the game loop, rendering, and updating logic for the farm simulation. The game 
 * includes a day/hunter cycle, interactions with the farmer, animals, and crops,
 * as well as predator behavior.
 *
 * @author Corael Thompson
 * @version 1.0
 * @see Farmer
 * @see Farm
 * @see Animal
 * @see WheatCrop
 * @see HunterCycle
 * @see Predator
 */
public class FarmGame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int TICK_RATE = 60; // Ticks per second
    private static final int SECONDS_PER_DAY = 60; // Number of seconds in a day
    private int daysPassed;

    private Timer timer;
    private int ticks;

    private Farmer mainFarmer = new Farmer();
    private Farm mainFarm = new Farm();
    private ArrayList<Animal> animalsOnFarm = new ArrayList<Animal>();
    private ArrayList<WheatCrop> wheatCropsOnFarm = new ArrayList<WheatCrop>();

    private HunterCycle predCycle = new HunterCycle();
    private Predator bear = new Predator("Bear", "Cow");
    private Predator wolf = new Predator("Wolf", "Sheep");
    private Predator rabbit = new Predator("Rabbit", "Wheat");

    private String cowIconPath = "/Cow.png";
    private String sheepIconPath = "/Sheep.png";
    private String chickenIconPath = "/Chicken.png";
    private String wheatIconPath = "/Wheat.png";
    private String farmerIconPath = "/Farmer.png";
    private String farmIconPath = "/Farm.png";

    private ImageIcon cowIcon = loadImageIcon(cowIconPath);
    private ImageIcon sheepIcon = loadImageIcon(sheepIconPath);
    private ImageIcon chickenIcon = loadImageIcon(chickenIconPath);
    private ImageIcon wheatIcon = loadImageIcon(wheatIconPath);
    private ImageIcon farmerIcon = loadImageIcon(farmerIconPath);
    private ImageIcon farmIcon = loadImageIcon(farmIconPath);

    private double affinityValue = Math.random();
    private CropFarmingDecorator cropFarmAffin = new CropFarmingDecorator(mainFarmer);
    private SheepShearerDecorator sheepShearerDecorator = new SheepShearerDecorator(mainFarmer);
    private MoneyMakerDecorator moneyMakerDecorator = new MoneyMakerDecorator(mainFarmer);
    
    private boolean animalsPassed;
    private boolean wheatNeedsReplanting;

    /**
     * Default constructor for the {@code FarmGame} class.
     * Initializes the game window, sets up the game elements, and starts the game loop.
     */
    public FarmGame() {
        setTitle("Farm Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initialize();

        timer = new Timer(1000 / TICK_RATE, this);
        timer.start();

        setVisible(true);
    }

    private void initialize() {

        ticks = 0;
        animalsOnFarm.add(new Cow());
        wheatCropsOnFarm.add(new WheatCrop());

        predCycle.addObserver(bear);
        predCycle.addObserver(wolf);
        predCycle.addObserver(rabbit);
    }

    /**
     * Updates the game state based on the day/night cycle, interactions, and predator behavior.
     */
    private void update() {
        ticks++;
        animalsPassed = false;
        wheatNeedsReplanting = false;

        // Do daytime logic (e.g., brighter graphics)
        //Checks which animals are alive and produces resources from them 
        System.out.println("Producing Milk, Wool, Eggs, and Wheat Crops...");
        
        Iterator<Animal> iterator = animalsOnFarm.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.updateDaysRemaining() == false) {
                iterator.remove();
                animalsPassed = true;
            } else {
                animal.getProductProducer().produceProduct();
            }
        }
        
        if (animalsOnFarm.size() == 0) {
            System.out.println("New animals need to be bought!!");
        } else if (animalsPassed) {
            System.out.println("An animal has passed!!");
        }       

        //Checks which wheat crops are alive and produces resources from them
        Iterator<WheatCrop> wheatIterator = wheatCropsOnFarm.iterator();
        while (wheatIterator.hasNext()) {
            WheatCrop wheatCrop = wheatIterator.next();
            if (wheatCrop.needsReplanting()) {
                wheatIterator.remove();
                wheatNeedsReplanting = true;
            } else {
                wheatCrop.produceProduct();
            }
        }
        
        if (wheatCropsOnFarm.size() == 0) {
            System.out.println("New crops need to be bought!!");
        } else if (wheatNeedsReplanting) {
            System.out.println("Some crops need replanting!!");
        }

        mainFarmer.setFarm(mainFarm);
        mainFarmer.setAnimalsOnFarm(animalsOnFarm);
        mainFarmer.setWheatCropsOnFarm(wheatCropsOnFarm);
        
        CropFarmingDecorator cropFarmAffin = new CropFarmingDecorator(mainFarmer);
        SheepShearerDecorator sheepShearerDecorator = new SheepShearerDecorator(mainFarmer);
        MoneyMakerDecorator moneyMakerDecorator = new MoneyMakerDecorator(mainFarmer);
        
        if (daysPassed % 2 == 0) {
            // Determine the affinity based on the random value
            if (affinityValue < 1.0 / 3.0) {
                cropFarmAffin.sellResources();
                mainFarmer = cropFarmAffin.getFarmer();
                System.out.println("Someone has a green thumb :) !!");
            } else if (affinityValue < 2.0 / 3.0) {
                sheepShearerDecorator.sellResources();
                mainFarmer = sheepShearerDecorator.getFarmer();
                System.out.println("You're a master sheep handler :) !!");
            } else {
                moneyMakerDecorator.sellResources();
                mainFarmer = moneyMakerDecorator.getFarmer();
                System.out.println("Mr. Moneybags :) !!");
            }  
        }

        if (daysPassed % 3 == 0) {
            // Determine the affinity based on the random value
            if (affinityValue < 1.0 / 3.0) {
                cropFarmAffin.sellResources();
                mainFarmer = cropFarmAffin.getFarmer();
            } else if (affinityValue < 2.0 / 3.0) {
                sheepShearerDecorator.sellResources();
                mainFarmer = sheepShearerDecorator.getFarmer();
            } else {
                moneyMakerDecorator.sellResources();
                mainFarmer = moneyMakerDecorator.getFarmer();
            } 
        }

        mainFarmer.buyResources();

        mainFarm = mainFarmer.getFarm();
        animalsOnFarm = mainFarmer.getAnimalsOnFarm();
        wheatCropsOnFarm = mainFarmer.getWheatCropsOnFarm();

        // Calculate the number of days passed
        daysPassed = ticks / (TICK_RATE * SECONDS_PER_DAY);

        //Predators Hunt Throughout Day
        predCycle.setAnimalsToEat(animalsOnFarm);
        predCycle.setWheatCropsToEat(wheatCropsOnFarm);
        predCycle.setTimeToHunt(true);
        
        ArrayList<Animal> animalsOnFarmBeforeHunt = new ArrayList<Animal>(animalsOnFarm);
        animalsOnFarm = predCycle.getAnimalsToEat();
        
        if (animalsOnFarmBeforeHunt.size() != animalsOnFarm.size()) {
            System.out.println("Animals were eaten!!");
        }
        
        ArrayList<WheatCrop> wheatCropsOnFarmBeforeHunt = 
                new ArrayList<WheatCrop>(wheatCropsOnFarm);
        wheatCropsOnFarm = predCycle.getWheatCropsToEat(); 
        
        if (wheatCropsOnFarmBeforeHunt.size() != wheatCropsOnFarm.size()) {
            System.out.println("Some wheat crops were eaten!!");
        }
    }

    /**
     * Renders the game graphics, including background, icons, and text.
     */
    private void render() {
        // Render graphics
        // Use double buffering to avoid flickering
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        // Draw game elements here
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // Draw other game elements

        // Draw background image
        drawBackground(g, true);

        // Draw the farm icon
        drawIconWithText(g, farmIcon, "Farms In Possession: " + mainFarm.getNumOfFarms() 
            +  " Num of Levels: " + mainFarm.getLevel(), 300, 20);

        // Draw the farmer icon
        int numFarmers = mainFarmer.getFarmerBuddies() + 1;
        drawIconWithText(g, farmerIcon, "Total Farmers: " + numFarmers, 500, 10);

        // Draw icons and text
        String numOfAnimals = countAnimals();
        drawIconWithText(g, cowIcon, "Num of Cows: " + numOfAnimals.charAt(0), 20, 10);
        drawIconWithText(g, sheepIcon, "Num of Sheep: " + numOfAnimals.charAt(2), 200, 10);
        drawIconWithText(g, chickenIcon, "Num Of Chicken " + numOfAnimals.charAt(1), 330, 10);
        drawIconWithText(g, wheatIcon, "Num of Wheat: " + wheatCropsOnFarm.size(), 450, 10);

        g.dispose();
        bs.show();
    }

    /**
     * Draws the background image based on the day/night cycle.
     *
     * @param g      The Graphics object for drawing.
     * @param isDay  Indicates whether it is currently day or night.
     */
    private void drawBackground(Graphics g, boolean isDay) {
        // Use resource loading to load the appropriate background image
        String backgroundImagePath = 
                isDay ? "/FarmBackground.jpg" : "/FarmNightBackground.jpg";
        Image backgroundImage = 
                new ImageIcon(getClass().getResource(backgroundImagePath)).getImage();

        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, null);
    }

    /**
     * Draws an icon with associated text on the game window.
     *
     * @param g     The Graphics object for drawing.
     * @param icon  The ImageIcon to be drawn.
     * @param text  The text associated with the icon.
     * @param x     The x-coordinate for drawing.
     * @param y     The y-coordinate for drawing.
     */
    private void drawIconWithText(Graphics g, ImageIcon icon, String text, int x, int y) {
        Image scaledImage;
        // Scale the image to a smaller size
        if (text.charAt(0) == 'T') {
            scaledImage = 
                    icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        } else {
            scaledImage = 
                    icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);           
        }

        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        int positionForY = 0;

        if (text.charAt(0) != 'F') {
            positionForY = HEIGHT - scaledIcon.getIconHeight(); 
        } else {
            positionForY = 60;
        }

        // Draw the scaled icon
        scaledIcon.paintIcon(this, g, x, positionForY);

        // Draw the text above the icon
        g.setColor(Color.WHITE);
        g.drawString(text, x + scaledIcon.getIconWidth() / 2 
                - g.getFontMetrics().stringWidth(text) / 2, positionForY - 5);
    }

    /**
     * Handles the actionPerformed event for the game timer.
     * Invokes the update and render methods to maintain the game loop.
     *
     * @param e The ActionEvent triggered by the timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        render();
    }

    /**
     * Loads an ImageIcon from the specified resource path.
     *
     * @param path The path to the image resource.
     * @return An ImageIcon loaded from the specified path.
     */
    private ImageIcon loadImageIcon(String path) {
        try {
            return new ImageIcon(getClass().getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Counts the number of each type of animal on the farm and returns a combined string.
     *
     * @return A string representing the counts of cows, chickens, and sheep on the farm.
     */
    private String countAnimals() {
        int cowCount = 0;
        int chickenCount = 0;
        int sheepCount = 0;

        // Count the instances of each type of animal
        for (Animal animal : animalsOnFarm) {
            if (animal instanceof Cow) {
                cowCount++;
            } else if (animal instanceof Chicken) {
                chickenCount++;
            } else if (animal instanceof Sheep) {
                sheepCount++;
            }
        }

        // Build a combined string
        StringBuilder result = new StringBuilder();
        result.append(cowCount);
        result.append(chickenCount);
        result.append(sheepCount);
        return result.toString();
    }

    /**
     * The main method to launch the FarmGame application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FarmGame());
    }
}


