import java.util.Arrays;
import java.util.List;


/**
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (25.05.2021)
 */
public class NumberCruncherTopLevel extends Crunch {


    private float[] numbers;
    private final List<CrunchOperation> operations;


    /**
     * NumberCruncherTopLevel Konstructor
     *
     * @param numbers A parameter
     */
    public NumberCruncherTopLevel (float[] numbers){

        this.numbers = numbers;
        operations = Arrays.asList(new Sum(), new Swirl(), new Divide(), new Subtract(), new Average());
    }

    /**
     * diese Methode beinhaltet die Operationen
     *
     * @param operations sind die ausgewählte operationen
     */
    @Override
    public void crunch(String[] operations) {
        for ( String op: operations) {
            System.out.println(op + " :");
            switch (op){
                case "sum":{
                    Sum x = new Sum();
                    x.crunch(numbers);
                    printNumbers();
                    break;
                }
                case "swirl": {
                    Swirl x =  new Swirl();
                    x.crunch(numbers);
                    printNumbers();
                    break;
                }
                case "divide": {
                    Divide x =  new Divide();
                    x.crunch(numbers);
                    printNumbers();
                    break;
                }
                case "subtract": {
                    Subtract x =  new Subtract();
                    x.crunch(numbers);
                    printNumbers();
                    break;
                }
                case "average": {
                    Average x =  new Average();
                    x.crunch(numbers);
                    printNumbers();
                    break;
                }
                default:
                    System.out.println("wrong operation to perform");
                    break;
            }

        }

    }

    /**
     * die Methode getNumbers gibt float-Array zurück
     *
     * @return The return value
     */
    public float[] getNumbers() {
        return numbers;
    }

    /**
     * Ausgabe der operationen
     */
    private void printNumbers(){
        for (float number : numbers) {
            System.out.print(number + "  ");
        }
        System.out.println();
    }

}