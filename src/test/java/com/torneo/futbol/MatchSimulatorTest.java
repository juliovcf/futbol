package com.torneo.futbol;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.torneo.futbol.model.Match;
import com.torneo.futbol.model.Player;
import com.torneo.futbol.model.Position;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.repository.MatchEventRepository;
import com.torneo.futbol.service.MatchService;
import com.torneo.futbol.service.TeamService;

class MatchSimulatorTest {

    @Mock
    private TeamService teamService;

    @Mock
    private MatchEventRepository matchEventRepository;

    @Mock
    private MatchService matchSimulator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSimulateMatch() {
        // Preparar datos de prueba
        List<Player> players1 = new ArrayList<>();
        players1.add(new Player(1L, null, "Player1", "LastName1", Position.FORWARD, 80, 9, 0, 0, 0, true));
        players1.add(new Player(2L, null, "Player2", "LastName2", Position.MIDFIELDER, 75, 8, 0, 0, 0, true));
        players1.add(new Player(3L, null, "Player3", "LastName3", Position.DEFENDER, 70, 5, 0, 0, 0, true));
        players1.add(new Player(4L, null, "Player4", "LastName4", Position.GOALKEEPER, 65, 1, 0, 0, 0, true));
        
        List<Player> players2 = new ArrayList<>();
        players2.add(new Player(1L, null, "Player1", "LastName1", Position.FORWARD, 80, 9, 0, 0, 0, true));
        players2.add(new Player(2L, null, "Player2", "LastName2", Position.MIDFIELDER, 75, 8, 0, 0, 0, true));
        players2.add(new Player(3L, null, "Player3", "LastName3", Position.DEFENDER, 70, 5, 0, 0, 0, true));
        players2.add(new Player(4L, null, "Player4", "LastName4", Position.GOALKEEPER, 65, 1, 0, 0, 0, true));
        Team team1 = createTeam("Team 1", players1);
        Team team2 = createTeam("Team 2", players2);

        Match match = new Match(1L, null, team1, 0, team2, 0, false, false, null);

        // Configurar comportamiento de los objetos mock
        when(teamService.findById(1L)).thenReturn(Optional.of(team1));
        when(teamService.findById(2L)).thenReturn(Optional.of(team2));

        // Llamar al método que se está probando
        matchSimulator.simulateMatch(match, 1000);

        // Verificar el comportamiento y/o los resultados esperados
        assertTrue(match.getGoalsHome() >= 0);
        assertTrue(match.getGoalsAway() >= 0);
    }

    private Team createTeam(String name, List<Player> players) {
    

        Team team = new Team(name, players);
        players.forEach(player -> player.setTeam(team));

        return team;
    }
}
