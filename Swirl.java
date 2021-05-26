import java.util.Random;

/**
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (25.05.2021)
 */
public class Swirl implements CrunchOperation{

    /**
     * diese Methode führt n zufaellige Vertauschungen der Datenfelder durch
     *
     * @param values ist die uebergegbene Array
     */
    @Override
    public void crunch(float[] values) {
        //Überprüft ob die Array leer ist
        if (values == null ) {
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
}
