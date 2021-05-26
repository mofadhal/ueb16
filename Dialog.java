import java.util.Scanner;

public class Dialog {
    //------------------choose class----------
    private final int ENDE = 0;//Ende Programmm .
    private final int TOP_LEVEL_KLASSE = 1;
    private final int ANONYM = 2;
    //-------------------Operations------------
    private final int BACK = 0;
    private final int SUM_DIALOG = 1;
    private final int SWIRL_DIALOG = 2;
    private final int DIVIDE_DIALOG = 3;
    private final int SUBTRACT_DIALOG = 4;
    private final int AVERAGE_DIALOG = 5;
    //--------------------Choose function-----------------

    private final int CREAT_NUMBERS = 1;
    private final int CHOOSE_OPERTION = 2;
    private final int SHOW_NUMBERS = 3;
    private final int PERFORM_OPERATION = 4;
    //-------------------------------------
    private Scanner input ;
    private NumberCruncherTopLevel topLevel;
    private NumberCruncherAnonym anonym;
    private float[] numberDialog ;
    private String[] oprationDialog;
    private int size = 0 ;
    private int sizeOperation = 0 ;
    private int choosenCalss;

    /**
     * diese Methode ist zum Auswahl der Klassen
     *
     * @return The return value
     */
    private int einlesenFunction() {

        System.out.println("\n"+
                "Select cruncher:   "+
                TOP_LEVEL_KLASSE + ": Top-Leve class cruncher" + "  "+
                ANONYM + ":  Anonym class cruncher" + "  "+
                ENDE + ": Ende Programm ");

        input = new Scanner(System.in);
        return choosenCalss = input.nextInt();

    }

    /**
     * neue Array-nummer einzulegen
     */
    private void crunchLengthAndNumbers (){
        int i = 1; ;
        System.out.println("How many numbers do you want to cruncher ?");
        size =  input.nextInt();
        if (size < 0 ) {
            throw new IllegalArgumentException("The number must be bigger than 0");
        }
        numberDialog = new float[size];
        int counter = size;
        while (counter != 0){
            System.out.println("Enter the number "+ i +" of " + size + " :" );
            numberDialog[i-1] = input.nextFloat();
            i ++ ;
            counter --;
        }
        topLevel = new NumberCruncherTopLevel(numberDialog);
        anonym = new NumberCruncherAnonym(numberDialog);

    }

    /**
     * diese Methode ist zum auswählen einer Methode
     *
     */
    private void chosseFrom(){
        int chosseNumber ;
        System.out.println("\n"+"What would you like to do ?"+"\n"+
                CREAT_NUMBERS + ":Creat Array  "+CHOOSE_OPERTION + ":Choose operations  "+
                           SHOW_NUMBERS + ":Show cruncher numbers  " + PERFORM_OPERATION +":perform operations  " + BACK+":return to menu");
        chosseNumber = input.nextInt();
        if (chosseNumber < 0 ) {
            throw new IllegalArgumentException("The number must be bigger than 0");
        }

        switch (chosseNumber){
            case SHOW_NUMBERS:{
                if (numberDialog == null){
                    System.out.println("You must select 'Creat Array' at first");
                    chosseFrom();
                }
                System.out.println("Numbers: ");
                for (int i = 0; i <numberDialog.length ; i++) {
                    System.out.println((i+1)+": " +numberDialog[i]);
                }
                chosseFrom();

            }case CHOOSE_OPERTION:{
                if (numberDialog == null){
                    System.out.println("You must select 'Creat Array' at first");
                    chosseFrom();
                }
                chosseOperation();
                chosseFrom();
                break;

            }case PERFORM_OPERATION:{
                if (numberDialog == null ){
                    System.out.println("You must select 'Creat Array' at first");
                    chosseFrom();
                    break;
                }else if( oprationDialog == null){
                    System.out.println("You must select 'Choose operations' at first");
                    chosseFrom();
                    break;
                }
                if (choosenCalss == 1){
                    topLevel.crunch(oprationDialog);
                    chosseFrom();
                    break;
                }
                else if (choosenCalss == 2){
                    anonym.crunch(oprationDialog);
                    chosseFrom();
                    break;
                }
            }case CREAT_NUMBERS:{
                crunchLengthAndNumbers();
                chosseFrom();
                break;
            }case BACK:{
                einlesenFunction();
                break;
            }
            default:
                System.out.println("There is no operation under this number");
        }
    }

    /**
     * diese Methode ist zum auswählen einer Operation
     *
     */
    private void chosseOperation(){
        System.out.println("How many operation do you like to perform ?");
          sizeOperation = input.nextInt();
          if (sizeOperation < 0) {
              throw new IllegalArgumentException("The number must be bigger than 0");
          }
        oprationDialog = new String[sizeOperation];
        int counter = sizeOperation;
        int i = 1;
        System.out.println("\n"+"Select operation :  "+
                SUM_DIALOG +":Sum   " + SWIRL_DIALOG +":Swirl   " + DIVIDE_DIALOG +":Divide   " +
                SUBTRACT_DIALOG + ":Subtract   " + AVERAGE_DIALOG +":Average   "  );
        while (counter != 0){
            System.out.println("Operation "+ i +" of " + sizeOperation + " :" );

            int opNumber = input.nextInt();
            if (opNumber < 0){
                throw new IllegalArgumentException("There is no operation under this number");
            }
            if (opNumber > 5){
                throw new IllegalArgumentException("There is only 5 operation");
            }
            switch (opNumber){
                case 1:{
                    oprationDialog[i-1] = "sum";
                    break;
                }case 2:{
                    oprationDialog[i-1] = "swirl";
                    break;
                }case 3:{
                    oprationDialog[i-1] = "divide";
                    break;
                }case 4:{
                    oprationDialog[i-1] = "subtract";
                    break;
                }case 5:{
                    oprationDialog[i-1] = "average";
                    break;
                } default:
                    System.out.println("There is no operation under this number");
            }
            i ++ ;
            counter --;
        }
    }

    /**
     * diese Methode ist zum ausführen der Funktionen
     *
     * @param funktion ist die ausgewählte Funktion
     */
    private void ausfuehrungFunction(int funktion) {
        switch (funktion) {
            case TOP_LEVEL_KLASSE:{
                chosseFrom();
                break;
            }
            case ANONYM:{
                chosseFrom();
                break;
            }
            case ENDE:{
                System.out.println("Ende programm");
                break;
            }
            default:
                System.out.println("There is no operation under this number");
        }

    }

    /**
     * diese Methode ist zum starten des Programms
     *
     */
    private void start() {
        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einlesenFunction();
                ausfuehrungFunction(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                input.nextLine();
            }
        }
    }

    private static void main(String[] args) {
        new Dialog().start();
    }
}
