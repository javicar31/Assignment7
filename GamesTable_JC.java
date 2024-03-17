
/********************************************************************* 
 *  Program: GamesTable_JC.java                                     *
 *  Author:  Javier Carnicer                                         * 
 *  Purpose: take two .txt files and output a table                  *
 *  Date Created: 03/17/2024                                         *
 *  Date Modified: 03/17/2024                                        *
 *********************************************************************/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GamesTable_JC {
    public static void main(String[] args) throws IOException {
        // Reading and storing games.txt
        String[][] gamesArray = new String[20][3];
        BufferedReader reader = new BufferedReader(new FileReader("games.txt"));
        String line;
        int row = 0;
        while ((line = reader.readLine()) != null) {
            gamesArray[row] = line.split(" ");
            row++;
        }
        reader.close();
        
        // Reading and storing teams.txt
        String[][] teamsArray = new String[20][1];
        reader = new BufferedReader(new FileReader("teams.txt"));
        row = 0;
        while ((line = reader.readLine()) != null) {
            teamsArray[row][0] = line;
            row++;
        }
        reader.close();
        
        // Printing the Games Table
        System.out.println();
        System.out.println("MIAMI HEAT SEASON");
        System.out.println("-------------------------------------------------------------");
        System.out.println("| GAME | HEAT SCORE | OPP SCORE |  W/L  | OPPONENT     ");
        System.out.println("-------------------------------------------------------------");
        
        int wins = 0;
        int losses = 0;
        for (int i = 0; i < gamesArray.length; i++) {
            int heatScore = Integer.parseInt(gamesArray[i][1]);
            int opponentScore = Integer.parseInt(gamesArray[i][2]);
            String result = heatScore > opponentScore ? "W" : "L";
            
            if (result.equals("W")) {
                wins++;
            } else {
                losses++;
            }
            
            System.out.printf("|  %2s  |    %3s     |    %3s    |   %s   | %-17s %n", 
                              gamesArray[i][0], heatScore, opponentScore, result, teamsArray[i][0]);
        }
        
        System.out.println("-------------------------------------------------------------");
        double winPercentage = ((double) wins / (wins + losses)) * 100;
        System.out.println("With " + wins + " wins and " + losses + " losses, the Miami Heat win percentage is " + String.format("%.2f%%", winPercentage));
    }

    @Override
    public String toString() {
        return "GamesTable_JC []";
    }
}
