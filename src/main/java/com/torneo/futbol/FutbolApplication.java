package com.torneo.futbol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.torneo.futbol.model.Match;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.service.MatchService;
import com.torneo.futbol.service.impl.MatchServiceImpl;

@SpringBootApplication
public class FutbolApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutbolApplication.class, args);

		Team team1 = new Team(null, "Argentina", 90);
		Team team2 = new Team(null, "Brasil", 80);
		/*Player player1 = new Player(null, team1, "Messi", "null", null, 10, 0, 0, 0, true);
		Player player2 = new Player(null, team1, "Kun", "null", null, 10, 0, 0, 0, true);
		Player player3 = new Player(null, team2, "Neymar", "null", null, 10, 0, 0, 0, true);
		Player player4 = new Player(null, team2, "Ronaldo", "null", null, 10, 0, 0, 0, true);*/
		Match match = new Match(null, null, team1, 0, team2, 0, false);

		MatchService matchService = new MatchServiceImpl();
		matchService.simulateMatch(match);
	}

}
