import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

/**
 * JUnit test class for the {@link MoneyMakerDecorator} class.
 */
public class MoneyMakerDecoratorTest {

    @Test
    public void testSellResources() {
        Animal animal1 = new Animal(100, 5, 1, new EggProducer());
        Animal animal2 = new Animal(150, 7, 2, new MilkProducer());

        WheatCrop wheatCrop1 = new WheatCrop();
        WheatCrop wheatCrop2 = new WheatCrop();

        Farmer mockFarmer = new Farmer();
        
        mockFarmer.setAnimalsOnFarm(createActualAnimalList(animal1, animal2));
        mockFarmer.setWheatCropsOnFarm(createActualWheatCropList(wheatCrop1, wheatCrop2));

        MoneyMakerDecorator moneyMakerDecorator = new MoneyMakerDecorator(mockFarmer);

        moneyMakerDecorator.sellResources();
        
        mockFarmer = moneyMakerDecorator.getFarmer();

        assertTrue(0 == mockFarmer.getTotalIncome());
    }

    /**
     * Helper method to make a list of animals. 
     */
    private ArrayList<Animal> createActualAnimalList(Animal... animals) {
        ArrayList<Animal> animalList = new ArrayList<>();
        for (Animal animal : animals) {
            animalList.add(animal);
        }
        return animalList;
    }

    /**
     * Helper method to make a list of wheat crops. 
     */
    private ArrayList<WheatCrop> createActualWheatCropList(WheatCrop... wheatCrops) {
        ArrayList<WheatCrop> wheatCropList = new ArrayList<>();
        for (WheatCrop wheatCrop : wheatCrops) {
            wheatCropList.add(wheatCrop);
        }
        return wheatCropList;
    }
}
