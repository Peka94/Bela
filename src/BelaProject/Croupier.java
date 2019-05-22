package BelaProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Croupier {
    
    public static void main(String[] args) {
        //Ezzel a metódussal érjük el a főmenüt
        getInterface();
        
    }
    
    /*Ebben a metódusban hívhatjuk meg a főmenü metódusát, illetve itt lehet
    kilépni a programból. */
    private static void getInterface(){
        boolean quit = false;
        do{
            quit = getMainMenu();
            if(!quit){
                quit = getQuit();
            }
        }while(!quit);
        System.out.println("Pápáá! :)");
    }
    
    /*Ebben a metódusban a felhasználó választhat szimuláció vagy egyszemélyes mód között. 
    A választása alapján hívjuk meg az adott módnak a metódusát. Amennyiben abból a metódusból kilépett,
    ebben a menürészben rákérdez, hogy kilépünk-e a programból. */
    private static boolean getMainMenu(){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("|                     (･_･)( ･_)(　･)(　RULETT　)(･　)(_･ )(･_･)                    |");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("______________________________________FŐMENÜ______________________________________");
        System.out.println("");
        System.out.println("Szimuláció végzéséhez nyomja meg az 1- es gombot, majd Enter.");
        System.out.println("Egyszemélyes játékhoz nyomja meg a 2-es gombot, majd Enter.");
        System.out.println("Kilépés: Q ");
        System.out.println("");
        String program = "";
            do{
                try{
                    Scanner sc = new Scanner(System.in);
                    program = sc.nextLine();
                    if(!program.equals("1") && !program.equals("2") && !program.equals("q")){
                        System.out.println("Kérlek 1 vagy 2 számot adj meg!");
                    }
                }catch(InputMismatchException e){
                    System.out.println("Kérlek számot adj meg!");
                }
            }while(!program.equals("1") && !program.equals("2") && !program.equals("q"));
            if(program.equals("1")){
                getSimulation();
            }else if(program.equals("2")){
                
            }else{
                return getQuit();
            }
            return false;
    }
    
    //Kilépés metódusa, mely meghívja a promptYesOrNo metódust, itt várjuk a választ
    private static boolean getQuit(){
        System.out.println("");
        System.out.println("Ki szeretne lépni?(Y/N)");
        return promptYesOrNo();
    }
    
    //Bekérés egy igenre vagy nemre. Elfogad kis illetve nagybetűs karaktert is.
    private static boolean promptYesOrNo(){
        String quit = "";
        //Addig nem lépünk ki, amíg a bekért adat helyes nem lesz.
        do{
            //Egy String bekérése.
            Scanner sc = new Scanner(System.in);
            quit = sc.next();
            //Ha igen a bekért adat, akkor visszatérünk igennel.
            if(quit.equals("Y")||quit.equals("y")){
                return true;
            //Ha nem a bekért adat, akkor visszatérünk hamissal.
            }else if(quit.equals("N")|| quit.equals("n")){
                return false;
            //Ha elgépelés történt, és nem azt kaptuk amit vártunk, akkor kiírjuk, hogy rossz karakter.
            }else{
                System.out.println("Kérlek vagy \"Y\" vagy \"N\" karaktert adj meg!");
            }
        }while(!quit.equals("Y")&& !quit.equals("y") && !quit.equals("N") && !quit.equals("n"));
        return false;
    }
    
    private static void getSimulation(){
        Game game = new Game();
        
    }
}
    
