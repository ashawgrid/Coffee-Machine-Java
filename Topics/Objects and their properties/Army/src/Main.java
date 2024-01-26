import java.util.*;
class Army {

    public static void createArmy() {
        // Create all objects here
        Unit[] u=new Unit[5];
        for(int i=0;i<5;i++){
            u[i]=new Unit("Aayush"+Integer.toString(i));
        }
        Knight[] k=new Knight[3];
        for(int i=0;i<3;i++){
            k[i]=new Knight("Ayush"+Integer.toString(i));
        }
        General g=new General("Purvesh");
        Doctor d=new Doctor("Aditya");
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}
