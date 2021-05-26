import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @author (Mofadhal Al - Manari und Leen Alkhadraa)
 * @version (25.05.2021)
 */
public class NumberCruncherAnonym extends Crunch {


    private float[] numbers;

    /**
     * NumberCruncherAnonym Constructor
     *
     * @param numbers ist das uebergeben Array
     */
    public NumberCruncherAnonym(float[] numbers) {
        if (numbers == null){

            throw new IllegalArgumentException("NumberCruncherAnonym-flout is Empty");
        }
        this.numbers = numbers;
    }

    /**
     * diese Methode ist zu implementieren eine anonyme Klasse, die die Elemente
     * im Array paarweise von links nach rechts summiert
     * und den neuen Wert in dem jeweils rechten Datenfeld speichert
     */
    private void sum() {
        new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                //Überprüft ob das Array leer ist
                if (values == null ) {
                    throw new IllegalArgumentException("Array ist Leer");
                }
                //Überprüft ob es nur ein Wert im Array gibt
                if (values.length <= 1)
                    return ;
                for(int i = 0 ; i  < values.length -1 ; i++ ){
                    values[i+1] = values[i] + values[i+1];
                }
            }
        }.crunch(numbers);
    }

    /**
     * diese Methode ist zu implementieren eine anonyme Klasse, die
     * n zufaellige Vertauschungen der Datenfelder durchführt
     */
    private void swirl() {
        new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                if (values == null) {
                    throw new IllegalArgumentException("Array ist Leer");
                }
                Random rand = new Random();

                for (int i = 0; i < values.length; i++) {
                    int randomIndexToSwap = rand.nextInt(values.length);
                    var temp = values[randomIndexToSwap];
                    values[randomIndexToSwap] = values[i];
                    values[i] = temp;
                }
            }
        }.crunch(numbers);
    }

    /**
     * diese Methode ist zu implementieren eine anonyme Klasse, die n/2 groeßten Werte
     * durch n/2 kleinsten teilt und den neuen Wert im groeßten Wert speichert
     *
     */
    private void divide() {
        new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                if (values == null) {
                    throw new IllegalArgumentException("Array ist Leer");
                }
                int hoechsterIndex = values.length - 1;
                int einfuegeIndex = 0;
                while (einfuegeIndex < hoechsterIndex) {
                    int minPosition = einfuegeIndex;
                    for (int i = einfuegeIndex + 1; i <= hoechsterIndex; i++) {
                        if (values[i] < values[minPosition])
                            minPosition = i;
                    }
                    float vertauch = values[minPosition];
                    values[minPosition] = values[einfuegeIndex];
                    values[einfuegeIndex] = vertauch;
                    einfuegeIndex++;

                }
                int vallength = values.length -1 ;
                for (int i = 0; i < values.length  ; i++) {
                    values[vallength - i] /= values[i];
                }
            }
        }.crunch(numbers);
    }

    /**
     * diese Methode ist zu implementieren eine anonyme Klasse, die die Elemente
     * im Array paarweise von links nach rechts subtrahiert
     * und den neuen Wert in dem jeweils rechten Datenfeld speichert
     */
    private void subtract() {
        new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                if (values == null) {
                    throw new IllegalArgumentException("Array ist Leer");
                }
                if (values.length <= 1)
                    return;
                for (int i = 0; i < values.length - 1; i++) {
                    values[i+1] -= values[i] ;;
                }

            }
        }.crunch(numbers);
    }

    /**
     * diese Methode ist zu implementieren eine anonyme Klasse, die den Durchschnitt
     * aller Werte im array bestimmt und speichert im groeßten Wert
     *
     */
    private void average() {
        new CrunchOperation() {
            @Override
            public void crunch(float[] values) {
                if (values == null) {
                    throw new IllegalArgumentException("Array ist Leer");
                }
                int max = 0;
                for (int j = 0; j <= values.length - 1; j++) {
                    if (values[j] > values[max] && values[j] > 0)
                        max = j;
                }
                int temp = 0;
                for (int i = 0; i < values.length; i++) {
                    temp += values[i];
                }
                temp /= values.length;
                values[max] = temp;
            }
        }.crunch(numbers);

    }


    /**
     * diese Methode beinhaltet die Operationen
     *
     * @param operations sind die ausgewählte Opreationen
     */
    @Override
    public void crunch(String[] operations) {
        for (String operation : operations) {
            System.out.println(operation + " :");
            switch (operation) {
                case "sum" : {
                    sum();
                    printNumbers();
                    break;
                }
                case "swirl" : {
                    swirl();
                    printNumbers();
                    break;
                }
                case "divide" : {
                    divide();
                    printNumbers();
                    break;
                }
                case "subtract" : {
                    subtract();
                    printNumbers();
                    break;
                }
                case "average" :{
                    average();
                    printNumbers();
                    break;
                }
                default :
                   System.out.println("invalid operation");
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
