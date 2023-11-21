# assign5_ser316-fall23B-cmthom55 
Sources for the Design Patterns I used:
- Observer: https://refactoring.guru/design-patterns/observer
- Strategy: https://refactoring.guru/design-patterns/strategy
- Decorator: https://refactoring.guru/design-patterns/decorator

For Strategy (from PDF):

> I defined an interface ProductProducer which sets a list of “strategies” for selling/ producing different products that allows for the classes  MilkProducer, EggProducer, and WoolProducer that implement it to be used more interchangeably to fit greater user needs. Each producer has their own unique implementation of the ProductProduct.

Why is this a Good Choice?
> As mentioned above it makes the producers in our system more interchangeable and therefore easier to work with. It perfectly maintains the differing production and sell behavior for different items in our system and makes it easy to add future productions. It also gets rid of repeating code by allowing us to put differing behavior in their own class hierarchy. This pattern in this case also encapsulates the dependencies needed for us to produce resources in our system. 

 For Reference:
 - [Product Producer](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/ProductProducer.java)
 - [EggProducer](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/EggProducer.java)
 - [MilkProducer](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/MilkProducer.java)
 - [WoolProducer](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/WoolProducer.java)


For Decorator (from PDF):

> I defined an interface, FarmerDecorator, that uses a Farmer object as a base component to decorate with affinities that positively affect the income gained by farmers when selling resources. The three classes I used to implement the FarmerDecorator interface are CropFarmingDecorator, SheepShearerDecorator, and MoneyMakerDecorator.

Why is this a Good Choice?
> The decorator in this allows us to add extra affinities and therefore extra behaviors to a regular farmer at run time without affecting other behaviors in our system. It gives us customization flexibility without having to sacrifice parts of our already in place implementation, making it easy to work with and expand upon as it is isolated. It is a more flexible version of an inheritance relationship. 

For Reference:
- [FarmerDecorator](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/FarmerDecorator.java)
- [CropFarmingDecorator](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/CropFarmingDecorator.java)
- [SheepShearerDecorator](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/SheepShearerDecorator.java)
- [MoneyMakerDecorator](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/MoneyMakerDecorator.java)
- [Farmer](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/Farmer.java)

For Observer (from PDF):
> I defined an interface HunterCycleObserver that has the method updateHuntCycle that alerts all observers added to the HunterCycle object declared that it is hunting time.  HunterCycle also implements the HunterSubject interface to handle the observers. The observers in this case are simply the predators on our farm which come out at night, more specifically the ones defined through the Predator class.

Why is this a Good Choice?
> In this case the observer pattern allows us to let all the predators know at the same time to go on the hunt. It makes the system's behavior more smooth and automatic as we continue to extend the list of predators which leads to a better runtime and allows us to have more dynamic behavior in our system indicative of a video game. It also helps us control for how long the predators hunt if we need to only alert the predators for a certain amount of frames, such as at night time. 

 For Reference:
 - [HunterCycleObserver](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/HunterCycleObserver.java)
 - [HunterCycle](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/HunterCycle.java)
 - [HunterSubject](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/HunterCycleSubject.java)
 - [Predator](https://github.com/cmthom55/assign5_ser316-fall23B-cmthom55/blob/main/src/main/java/Predator.java)
