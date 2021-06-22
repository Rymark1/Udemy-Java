import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team>{

    public String name;
    private ArrayList<T> teams;

    public League() {
        this.teams = new ArrayList<>();
    }

    public boolean addTeam(T team){
        if (teams.contains(team)){
            System.out.println("This team already exists.");
            return false;
        }
        else{
            teams.add(team);
            return true;
        }
    }

    public void listStandings(){
        for (int i = 0; i< teams.size(); i++) {
            System.out.println((i+1) + ": " + teams.get(i).getName());
        }

        Collections.sort(teams);

        for (int i = 0; i< teams.size(); i++) {
            System.out.println((i+1) + ": " + teams.get(i).getName());
        }
    }
}
