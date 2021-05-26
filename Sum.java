
/**
 *
 * @author (Mofadhal Al-Manari und Leen Alkhadraa)
 * @version (25.05.2021)
 */
public class Sum implements CrunchOperation{

    /**
     * diese Methode summiert die Elemente im Array paarweise von links nach rechts
     * und speichert den neuen Wert in dem jeweils rechten Datenfeld
     * @param values ist das uebergegebene Array
     */
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
}
