DROP TABLE IF EXISTS activities;
DROP TABLE IF EXISTS routines;
DROP TABLE IF EXISTS routine_types;

CREATE TABLE routine_types (
                               id SERIAL PRIMARY KEY,
                               name VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE routines (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(80) NOT NULL,
                          routine_type_id INT NOT NULL REFERENCES routine_types(id) ON DELETE RESTRICT
);

CREATE TABLE activities (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(120) NOT NULL,
                            routine_id INT NOT NULL REFERENCES routines(id) ON DELETE RESTRICT,
                            activity_type VARCHAR(20) NOT NULL CHECK (activity_type IN ('WELLNESS','PRODUCTIVITY')),

    -- wellness fields
                            minutes INT NULL CHECK (minutes IS NULL OR minutes > 0),
                            intensity VARCHAR(10) NULL,

    -- productivity fields
                            difficulty INT NULL CHECK (difficulty IS NULL OR (difficulty >= 1 AND difficulty <= 5)),
                            focus_area VARCHAR(60) NULL
);

-- sample inserts
INSERT INTO routine_types(name) VALUES ('Morning'), ('Evening');

INSERT INTO routines(name, routine_type_id) VALUES
                                                ('Glow Up Morning', 1),
                                                ('Calm Evening', 2);

INSERT INTO activities(name, routine_id, activity_type, minutes, intensity, difficulty, focus_area) VALUES
                                                                                                        ('Stretching', 1, 'WELLNESS', 10, 'low', NULL, NULL),
                                                                                                        ('Plan Day', 1, 'PRODUCTIVITY', NULL, NULL, 3, 'planning');
