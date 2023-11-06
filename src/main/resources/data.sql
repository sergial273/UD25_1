DROP table IF EXISTS `articulos`;
DROP TABLE IF EXISTS `fabricante`;



CREATE TABLE `fabricante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `articulos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `precio` int(250) DEFAULT NULL,
  `fabricante` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fabricantes_fk` FOREIGN KEY (`fabricante`) REFERENCES `fabricante` (`id`) on delete cascade on update cascade
);


-- Para la tabla `fabricante`
INSERT INTO `fabricante` (nombre) VALUES
('Fabricante 1'),
('Fabricante 2'),
('Fabricante 3'),
('Fabricante 4'),
('Fabricante 5');

-- Para la tabla `articulos`
INSERT INTO `articulos` (nombre, precio, fabricante) VALUES
('Video 1', 100, 1),
('Video 2', 150, 2),
('Video 3', 200, 3),
('Video 4', 120, 4),
('Video 5', 180, 5);


