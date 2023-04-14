-- Insert teams
INSERT INTO team (id, name, quality) VALUES (1, 'Recal-k', 80);
INSERT INTO team (id, name, quality) VALUES (2, 'Entas-k', 85);

-- Insert players types
INSERT INTO player_type (id, name) VALUES (1, 'Portero');
INSERT INTO player_type (id, name) VALUES (2, 'Defensa');
INSERT INTO player_type (id, name) VALUES (3, 'Medio');
INSERT INTO player_type (id, name) VALUES (4, 'Delantero');

-- Insert players
INSERT INTO player (id, name, position, team_id) VALUES (1, 'Roni', 1, 1);
INSERT INTO player (id, name, position, team_id) VALUES (2, 'Nacho', 2, 1);
INSERT INTO player (name, surname, number, position, team_id, available, goals, yellow_cards, red_cards) VALUES ('Julio', 'Pérez', 21, 3, 1, true, 0, 0, 0);
INSERT INTO player (id, name, position, team_id) VALUES (4, 'Mark', 4, 1);

INSERT INTO player (id, name, position, team_id) VALUES (1, 'Vizcaino', 1, 2);
INSERT INTO player (id, name, position, team_id) VALUES (2, 'Yael', 2, 2);
INSERT INTO player (id, name, position, team_id) VALUES (3, 'Sergio', 3, 2);
INSERT INTO player (id, name, position, team_id) VALUES (4, 'Rafa', 4, 2);

-- Insert match events types
INSERT INTO match_event_type (id, name) VALUES (1, 'Gol');
INSERT INTO match_event_type (id, name) VALUES (2, 'Falta');
INSERT INTO match_event_type (id, name) VALUES (3, 'Ocasión de gol');
INSERT INTO match_event_type (id, name) VALUES (4, 'Corner');
INSERT INTO match_event_type (id, name) VALUES (5, 'Penalti');
INSERT INTO match_event_type (id, name) VALUES (6, 'Tarjeta amarilla');
INSERT INTO match_event_type (id, name) VALUES (7, 'Tarjeta roja');


-- Insert matches (you should adjust this based on your match table structure)
INSERT INTO match (id, home_team_id, away_team_id, date) VALUES (1, 1, 2, '2023-03-15 14:30:00');
