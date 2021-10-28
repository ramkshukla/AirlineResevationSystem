package com.company;
import java.util.*;


class Reservation{
    static boolean [] arrSeats = new boolean[10];
    static Scanner scn = new Scanner(System.in);

    public boolean assignSeats(String section){
        if (section.equals("First")){
            if (getFreeSeats(section) > 0){
                for (int i=0; i<5; i++){
                    if (!arrSeats[i]){
                        arrSeats[i] = true;
                        printBoardingPass(i);
                        return true;
                    }
                }
            }
        }
        else if (section.equals("Economy")){
            if (getFreeSeats(section) > 0){
                for (int i=5; i<arrSeats.length; i++){
                    if (!arrSeats[i]){
                        arrSeats[i] = true;
                        printBoardingPass(i);
                        return true;
                    }
                }
            }
        }

        System.out.println("All Seats in section " + section + "are booked.");
        System.out.println("Would you like to move to section" + section + " (y/n)? " + ((section.equals("First")) ? "Economy" : "First"));

        if (scn.next().charAt(0) == 'y'){
            assignSeats((section.equals("First")) ? "Economy" : "First");
        }else{
            System.out.println("Next flight leaves in 3 hours.");
        }
        return false;
    }

    private int getFreeSeats(String section){
        int total = 0;
        if (section.equals("First")){
            for (int i=0; i<5; i++) {
                if (!arrSeats[i]) {
                    total += 1;
                }
            }
        }
        else if (section.equals("Economy")){
            for (int i=5; i<arrSeats.length; i++){
                if(!arrSeats[i]){
                    total += 1;
                }
            }
        }
        return total;
    }

    public boolean seatsAvailable(){
        for (boolean seat : arrSeats){
            if (!seat){
                return true;
            }
        }
        return false;
    }
    public void printGreetings(){
    System.out.println("Welcome to crap Airline booking system \n");
    }

    public void printMenu(){
        System.out.printf("1. Economy class %s\n",  (getFreeSeats("Economy") > 0) ? "(" + Integer.toString((getFreeSeats("Economy"))) + ")" : "(Full)");
        System.out.printf("2. First class %s\n", (getFreeSeats("First") > 0) ? "(" + Integer.toString((getFreeSeats("First"))) + ")" : "(Full)");
    }

    public void printBoardingPass(int seat){
        System.out.println("Boarding pass for Crap Airlines.");
        System.out.printf("\nSECTION: %s\nSEAT NUMBER: %d\n\n\n", (seat < 5) ? "First" : "Economy", seat+1);
    }
}


class Main{
    public static void main(String[] args) {
        Reservation reservation = new Reservation();
        reservation.printGreetings();
        reservation.printMenu();
        reservation.seatsAvailable();
        Scanner scn = new Scanner(System.in);
        String section = scn.next();
        reservation.assignSeats(section);
    }
}