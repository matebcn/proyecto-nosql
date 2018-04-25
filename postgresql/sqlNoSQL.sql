--https://www.compose.com/articles/faster-operations-with-the-jsonb-data-type-in-postgresql/

CREATE TABLE alumnos (  
  id serial NOT NULL,
  nombre text,
  apellido text,
  mail text,
  active int,
  caracteristicas jsonb
);


INSERT INTO alumnos VALUES (1, 'Luis', 'Vecino', 'vecino@luis.gll', 1, '{"pelo":"calvo","ojos":"marrones", "nacionalidad": "gallego"}');  
INSERT INTO alumnos VALUES (2, 'Daniel', 'Pare', 'pare@daniel.cat', 1,  '{"pelo":"castaño","ojos":"marrones", "nacionalidad": "cat"}');  
INSERT INTO alumnos VALUES (3, 'Ricart', 'Valira', 'valira@ricart.es',1,'{"pelo":"canoso","ojos":"verdes", "nacionalidad": "cat"}');  
INSERT INTO alumnos VALUES (4, 'Miguel', 'Mate', 'mate@miguel.ovn',  1, '{"pelo":"moreno","ojos":"celestes", "nacionalidad": "ovni"}');  


