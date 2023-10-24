/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collectionsandenumshw;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *GITHUB : https://github.com/2022569kellen/CollectionsandEnumsHW
 * @author Kellen- studentnumber 2022569
 */
public class CollectionsandEnumsHW {

    /**
     * @param args the command line arguments
     */
    
static class dataPerson { //Declaring variables for data of each person
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public dataPerson(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }
}

static class Team { //declaring variables of teams
    private String name;
    private List<dataPerson> members;

    public Team(String name, List<dataPerson> members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public List<dataPerson> getMembers() {
        return members;
    }
}


    public static void main(String[] args) {
        String csvFile = "C:/Users/35383/Documents/data.csv"; //Finds the path of the CSV file.
        List<dataPerson> people = new ArrayList<>();

        // Reads the data from the CSV file and stores it in the list of people.
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                String email = data[3];
                dataPerson person = new dataPerson(id, firstName, lastName, email);
                people.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Shuffles the list of people.
        Collections.shuffle(people);

        // Creat teams.
        List<Team> teams = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            List<dataPerson> teamMembers = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                if (!people.isEmpty()) {
                    teamMembers.add(people.remove(0));
                }
            }
            teams.add(new Team("Equipe " + i, teamMembers));
        }

        // Showing us the output of the teams.
        for (Team team : teams) {
            System.out.println("Equipe: " + team.getName());
            for (dataPerson person : team.getMembers()) {
                System.out.println("  - " + person.getFullName() + " (" + person.getEmail() + ")");
            }
            System.out.println();
        }
    }
}
 // 
    
    

