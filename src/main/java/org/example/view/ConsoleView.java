package org.example.view;

import org.example.model.Tribute;

import java.util.List;

/**
 * Handles all console output for the application.
 */
public class ConsoleView {

    /**
     * Prints the counts of loaded entities.
     *
     * @param tributeCount Number of tributes.
     * @param eventCount   Number of events.
     * @param giftCount    Number of gifts.
     */
    public void displayCounts(int tributeCount, int eventCount, int giftCount) {
        System.out.println("Tributes loaded: " + tributeCount);
        System.out.println("Events loaded: " + eventCount);
        System.out.println("Gifts loaded: " + giftCount);
        System.out.println(); // Add a blank line for separation
    }

    /**
     * Prints all tributes to the console, one per line, using the specified format.
     *
     * @param tributes The list of tributes to display.
     */
    public void displayAllTributes(List<Tribute> tributes) {
        for (Tribute tribute : tributes) {
            // The toString() method in the Tribute class is formatted as required
            System.out.println(tribute.toString());
        }
    }
}
