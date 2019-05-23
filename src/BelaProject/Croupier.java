package BelaProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Croupier {

    public static SinglePlayer sp = new SinglePlayer(0, PlayerID.BELA);
    
    public static void main(String[] args) {
        //Ezzel a metódussal érjük el a főmenüt
        getInterface();

    }

    /*Ebben a metódusban hívhatjuk meg a főmenü metódusát, illetve itt lehet
    kilépni a programból. */
    private static void getInterface() {
        boolean quit = false;
        do {
            quit = getMainMenu();
            if (!quit) {
                quit = getQuit();
            }
        } while (!quit);
        System.out.println("Pápáá! :)");
    }

    /*Ebben a metódusban a felhasználó választhat szimuláció vagy egyszemélyes mód között. 
    A választása alapján hívjuk meg az adott módnak a metódusát. Amennyiben abból a metódusból kilépett,
    ebben a menürészben rákérdez, hogy kilépünk-e a programból. */
    private static boolean getMainMenu() {
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
        do {
            try {
                Scanner sc = new Scanner(System.in);
                program = sc.nextLine();
                if (!program.equals("1") && !program.equals("2") && !program.equals("q") && !program.equals("Q")) {
                    System.out.println("Kérlek 1 vagy 2 számot adj meg!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Kérlek számot adj meg!");
            }
        } while (!program.equals("1") && !program.equals("2") && !program.equals("q") && !program.equals("Q"));
        if (program.equals("1")) {
            getSimulation();
        } else if (program.equals("2")) {
            getSinglePlayer();
        } else {
            return getQuit();
        }
        return false;
    }

    //Kilépés metódusa, mely meghívja a promptYesOrNo metódust, itt várjuk a választ
    private static boolean getQuit() {
        System.out.println("");
        System.out.println("Ki szeretne lépni?(Y/N)");
        return promptYesOrNo();
    }

    //Bekérés egy igenre vagy nemre. Elfogad kis illetve nagybetűs karaktert is.
    private static boolean promptYesOrNo() {
        String quit = "";
        //Addig nem lépünk ki, amíg a bekért adat helyes nem lesz.
        do {
            //Egy String bekérése.
            Scanner sc = new Scanner(System.in);
            quit = sc.next();
            //Ha igen a bekért adat, akkor visszatérünk igennel.
            if (quit.equals("Y") || quit.equals("y")) {
                return true;
                //Ha nem a bekért adat, akkor visszatérünk hamissal.
            } else if (quit.equals("N") || quit.equals("n")) {
                return false;
                //Ha elgépelés történt, és nem azt kaptuk amit vártunk, akkor kiírjuk, hogy rossz karakter.
            } else {
                System.out.println("Kérlek vagy \"Y\" vagy \"N\" karaktert adj meg!");
            }
        } while (!quit.equals("Y") && !quit.equals("y") && !quit.equals("N") && !quit.equals("n"));
        return false;
    }

    private static void getSimulation() {
        Game game = new Game();
        for (int i = 0; i < 100; i++) {
            game.getRound();
            System.out.println((i+1)+". menet");
            for (int j = 0; j < game.roundHistory.get(i).size(); j++) {
                
                System.out.println("\t"+game.roundHistory.get(i).get(j).getPlayerId()+" " + game.roundHistory.get(i).get(j).getBet() + " Ft tét. " + game.roundHistory.get(i).get(j).getGiveYourNumber() + " fogadás -" + game.roundHistory.get(i).get(j).isWinner() + " kimenetel - " + game.roundHistory.get(i).get(j).getCurrentBudget() + " jelenlegi pénze.");
            }
        }
    }

    private static void getSinglePlayer() {
        if(!giveYourBank()){
            
        }else{
            giveYourBet();
            giveYourNumber();
            Game game=new Game(sp);
            game.getRoundwithPlayer(sp);
            int i = 0;
            for (int j = 0; j < game.roundHistory.get(i).size(); j++) {
                
                System.out.println("\t"+game.roundHistory.get(i).get(j).getPlayerId()+" " + game.roundHistory.get(i).get(j).getBet() + " Ft tét. " + game.roundHistory.get(i).get(j).getGiveYourNumber() + " fogadás -" + game.roundHistory.get(i).get(j).isWinner() + " kimenetel - " + game.roundHistory.get(i).get(j).getCurrentBudget() + " jelenlegi pénze.");
            }
        }
    }
    
    private static boolean giveYourBank(){
        System.out.println("Add meg mennyi pénzt hoztál!");
        int program = 0;
        boolean go = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                program = sc.nextInt();
                if(program < Casino.MinBet){
                    System.out.println("Nem tudsz játszani, mert a casino minimum tétjét nem éri el a bankszámlád..");
                    System.out.println("Ugorj haza pénzért!");
                    return false;
                }else{
                    go = true;
                    
                }
            } catch (Exception e) {
                System.out.println("Kérlek számot adj meg!");
            }
        } while (!go);
        sp.setCurrentBudget(program);
        return true;
    }
    
    private static void giveYourBet(){
        System.out.println("A kaszinó minimum alaptétje 100 Ft és a maximum alaptétje 10000 Ft.");
        System.out.println("Mennyit kockáztatsz?");
        int program = 0;
        boolean go = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                program = sc.nextInt();
                if (program > sp.getCurrentBudget() || program < 100 || program > 10000 ) {
                    System.out.println("Kérlek 100 és 10000 között add meg a tétet, vagy ellenőrizd van e annyi pénzed!");
                }
                else{
                    go = true;
                    sp.setBet(program);
                }
            } catch (Exception e) {
                System.out.println("Kérlek számot adj meg!");
            }
        } while (!go);
    }
    
    private static void giveYourNumber(){
        System.out.println("Add meg, mire teszel. Csak 0-36 közötti számot, vagy piros és fekete színt adhatsz meg!");
        String program = "";
        boolean go = false;
        int count = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                program = sc.nextLine();
                if(program.equals("piros")){
                    program = "RED";
                }
                if(program.equals("fekete")){
                    program = "BLACK";
                }
                for (BetOption value : BetOption.values()) {
                    String v = value.toString();
                    if (program.equals(v.substring(1))) {
                        count++;
                        sp.setMyBet(value);
                    }
                }
                if (count == 0) {
                    System.out.println("Nem jó adatot adtál.");
                }else{
                        go = true;
                    }
            } catch (Exception e) {
                System.out.println("nem okés!");
            }
        } while (!go);
        
    }
}
