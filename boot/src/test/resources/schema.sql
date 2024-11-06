CREATE TABLE spaceships (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description TEXT,
                            source VARCHAR(255)
);

INSERT INTO spaceships (name, description, source)
VALUES
    ('Serenity', 'Nave de transporte clase Firefly, capitaneada por Malcolm Reynolds en la serie Firefly y la película Serenity.', 'Firefly'),
    ('Enterprise', 'Nave insignia de la Flota Estelar, explorando la galaxia en Star Trek.', 'Star Trek'),
    ('Galactica', 'Último bastión de la humanidad, buscando la Tierra en Battlestar Galactica.', 'Battlestar Galactica'),
    ('Planet Express Ship', 'Nave de reparto intergaláctica de la empresa Planet Express en Futurama.', 'Futurama'),
    ('Moya', 'Nave espacial viva, hogar de los protagonistas en Farscape.', 'Farscape'),
    ('Lexx', 'Bio-nave espacial con forma de insecto, destruyendo planetas en Lexx.', 'Lexx'),
    ('Andromeda Ascendant', 'Potente nave de guerra de la Commonwealth, comandada por Dylan Hunt en Andromeda.', 'Andromeda'),
    ('Rocinante', 'Corbeta de guerra marciana, utilizada por la tripulación de Holden en The Expanse.', 'The Expanse'),
    ('Heart of Gold', 'Nave espacial con el Motor de Improbabilidad Infinita en The Hitchhiker''s Guide to the Galaxy.', 'The Hitchhiker''s Guide to the Galaxy'),
    ('Nostromo', 'Nave espacial comercial que transporta un xenomorfo en Alien.', 'Alien');