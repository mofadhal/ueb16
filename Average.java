
/**
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (25.05.2021)
 */
public class Average implements CrunchOperation {

    /**
     * diese Methode bestimmt den Durchschnitt aller Werte im array
     * und speichert im groeßten Wert
     * @param values ist die uebergegebene Array
     */
    @Override
    public void crunch(float[] values) {
        //Überprüft ob die Array leer ist
        if (values == null ) {
            throw new IllegalArgumentException("Array ist Leer");
        }
        int max = 0;
        for (int j = 0; j <= values.length -1  ; j++) {
            if (values[j] > values[max] && values[j] > 0)
                max = j;
        }
        int temp = 0;
        for (int i = 0; i < values.length ; i++) {
            temp +=  values[i];
        }
        temp /= values.length;
        values[max] = temp;
    }

}
