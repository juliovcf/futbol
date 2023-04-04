package com.torneo.futbol;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.torneo.futbol.config.Logger;
import com.torneo.futbol.model.Match;
import com.torneo.futbol.model.Team;
import com.torneo.futbol.repository.MatchEventRepository;
import com.torneo.futbol.repository.TeamRepository;
import com.torneo.futbol.service.MatchService;

class MatchSimulatorTest {

    @Mock
    private TeamRepository teamRepository;

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
        Team team1 = new Team(1L, "Team 1", 50);
        Team team2 = new Team(2L, "Team 2", 50);
        Match match = new Match(1L, null, team1, 0, team2, 0, false, false, null);

        // Configurar comportamiento de los objetos mock
        when(teamRepository.findById(1L)).thenReturn(Optional.of(team1));
        when(teamRepository.findById(2L)).thenReturn(Optional.of(team2));

        Logger.info("Hola, esto es una prueba");

        // Llamar al método que se está probando
        matchSimulator.simulateMatch(match);

        match.getGoalsAway();

        // Verificar el comportamiento y/o los resultados esperados
        // Aquí puedes agregar las verificaciones que necesites según los resultados que esperas de la simulación
    }
}
