
/**
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (25.05.2021)
 */
public class Divide implements CrunchOperation {

    /**
     * diese Methode teilt n/2 groeßten Werte durch n/2 kleinsten
     * und speichert den neuen Wert im groeßten Wert
     * @param values ist die uebergegebene Array
     */
    @Override
    public void crunch(float[] values) {
        //Überprüft ob die Array leer ist
        if (values == null ) {
            throw new IllegalArgumentException("Array ist Leer");
        }
        int hoechsterIndex = values.length -1;
        int einfuegeIndex = 0;
        while (einfuegeIndex < hoechsterIndex){
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
}
