import java.util.function.Function;

/**
 * AnimalFarm
 */
public class AnimalFarm {

    public String sayHello(Function<String, String> function, String sound) {
        return function.apply(sound);
    }

    public static void main(String[] args) {
    
        AnimalFarm animalFarm = new AnimalFarm();
        Function<String, String> dog = sound -> "Dog says : " + sound;
        Function<String, String> lion = sound -> "Lion makes : " + sound;
        Function<String, String> fox = sound -> "What does the fox say ? " + sound;

        System.out.println(animalFarm.sayHello(dog, "Barks"));
        System.out.println(animalFarm.sayHello(lion, "Roarrr"));
        System.out.println(animalFarm.sayHello(fox, "Dont know"));
    }
}