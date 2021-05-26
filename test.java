import java.util.Random;

/**
 * Ein Test-Klass mit gegebene Nummern und Operationen.
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (25.05.2021)
 */
public class test {
    public static void main(String[] args) {
        String[] opration = {"sum" , "swirl" , "divide" , "subtract" , "average"};
        float[] numbers  = new float[5];
        Random random = new Random();
        NumberCruncherAnonym anonym ;
        NumberCruncherTopLevel topLevel;
        topLevel = new NumberCruncherTopLevel(numbers);
        anonym = new NumberCruncherAnonym(numbers);
        float min = 1;
        float max = 20;
        System.out.println("-----------Nummern---------");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = min + random.nextFloat() * (max - min);
        }
        for (float x : numbers
             ) {
            System.out.println(x);

        }
        System.out.println("-----------------Top-Level---------");
        topLevel.crunch(opration);
        System.out.println("-----------------Anonym---------");
        anonym.crunch(opration);
        Divide x = new Divide();




    }
}
