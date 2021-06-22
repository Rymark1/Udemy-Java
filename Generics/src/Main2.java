public class Main2 {

    public static void main(String[] args) {

        Team<BaseballPlayer> baseballTeam = new Team<>("Houston Astros");
        Team<BaseballPlayer> baseballTeam1 = new Team<>("Boston Red Sox");
        Team<BaseballPlayer> baseballTeam2 = new Team<>("New York Stankees");
        Team<FootballPlayer> footballTeam = new Team<>("New York Giants");

        League<Team<BaseballPlayer>> mlb = new League();
        mlb.addTeam(baseballTeam2);
        mlb.addTeam(baseballTeam);
        mlb.addTeam(baseballTeam1);
        mlb.addTeam(baseballTeam);

        baseballTeam.matchResult(baseballTeam1,5,1);
        baseballTeam.matchResult(baseballTeam2,5,1);
        baseballTeam1.matchResult(baseballTeam2,10,2);

        mlb.listStandings();
    }
}