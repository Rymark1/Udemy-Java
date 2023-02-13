package com.ryanmark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("MCCC", 8, 12);
        List<Theatre.Seat> seatcopy = new ArrayList<>(theatre.seats);
        printList(seatcopy);

        seatcopy.get(1).reserve();
        if (theatre.reserveSeat("A02"))
            System.out.println("Please pay for A02");
        else
            System.out.println("Seat already reserved");
        Collections.shuffle(seatcopy);
        System.out.println("Printing seatcopy");
        printList(seatcopy);
        System.out.println("Printing theatre.seat");
        printList(theatre.seats);
    }
    public static void printList(List<Theatre.Seat> list){
        for (Theatre.Seat seat :list){
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("=======================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list){
        for (int i=0; i < list.size() - 1; i++ ){
            for (int j=i+1; i < list.size(); j++){
                if (list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list,i,j);
                }
            }
        }
    }
}
