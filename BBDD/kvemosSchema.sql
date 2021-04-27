-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 05-12-2020 a las 16:14:15
-- Versión del servidor: 8.0.21
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `kvemos`
--
CREATE DATABASE IF NOT EXISTS `kvemos` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `kvemos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id_admin` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_admin`) VALUES
(2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documental`
--

CREATE TABLE `documental` (
  `id_documental` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `documental`
--

INSERT INTO `documental` (`id_documental`) VALUES
(21),
(22),
(23),
(24),
(25),
(26),
(27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id_genero` int NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id_genero`, `nombre`) VALUES
(4, 'Acción'),
(3, 'Ciencia Ficción'),
(2, 'Comedia'),
(1, 'Drama'),
(5, 'Thriller');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guardar`
--

CREATE TABLE `guardar` (
  `id_registrado` int NOT NULL,
  `id_prod` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `guardar`
--

INSERT INTO `guardar` (`id_registrado`, `id_prod`) VALUES
(1, 2),
(1, 16),
(1, 17),
(1, 21),
(1, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `id_prod` int NOT NULL,
  `id_plataforma` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`id_prod`, `id_plataforma`) VALUES
(1, 1),
(6, 1),
(7, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(16, 1),
(21, 1),
(26, 1),
(27, 1),
(2, 2),
(6, 2),
(7, 2),
(13, 2),
(14, 2),
(15, 2),
(16, 2),
(18, 2),
(19, 2),
(22, 2),
(26, 2),
(27, 2),
(32, 2),
(3, 3),
(6, 3),
(8, 3),
(9, 3),
(16, 3),
(17, 3),
(23, 3),
(26, 3),
(27, 3),
(4, 4),
(6, 4),
(8, 4),
(16, 4),
(18, 4),
(19, 4),
(24, 4),
(26, 4),
(27, 4),
(5, 5),
(6, 5),
(8, 5),
(9, 5),
(16, 5),
(20, 5),
(25, 5),
(26, 5),
(27, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id_pais` int NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id_pais`, `nombre`) VALUES
(1, 'España'),
(2, 'Francia'),
(3, 'Alemania'),
(4, 'Inglaterra'),
(5, 'USA'),
(6, 'Canada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id_pelicula` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id_pelicula`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(32);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plataforma`
--

CREATE TABLE `plataforma` (
  `id_plataforma` int NOT NULL,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `plataforma`
--

INSERT INTO `plataforma` (`id_plataforma`, `nombre`) VALUES
(1, 'Amazon Prime Video'),
(2, 'Disney+'),
(3, 'Movistar+ Lite'),
(4, 'Netflix'),
(5, 'Rakuten TV');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_audiovisual`
--

CREATE TABLE `producto_audiovisual` (
  `id_prod` int NOT NULL,
  `titulo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `titulo_original` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  `estreno` int DEFAULT NULL,
  `media_puntuacion` float NOT NULL DEFAULT '0',
  `edad_minima` int DEFAULT NULL,
  `sinopsis` longtext COLLATE utf8_spanish_ci,
  `caratula` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `id_genero` int NOT NULL,
  `id_pais` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto_audiovisual`
--

INSERT INTO `producto_audiovisual` (`id_prod`, `titulo`, `titulo_original`, `duracion`, `estreno`, `media_puntuacion`, `edad_minima`, `sinopsis`, `caratula`, `id_genero`, `id_pais`) VALUES
(1, 'Dune', 'Dune', 170, 1986, 1, 16, 'Por orden imperial, la familia Atreides debe hacerse cargo de la explotacion del desértico planeta Arrakis, también llamado \"Dune\". Es el único planeta donde se encuentra la especia, una potente droga que es indispensable para los vuelos espaciales. Antes el planeta había sido gobernado por los Harkonen, cuyo despotismo había dejado una huella indeleble en la población. Cuando, con el beneplácito del emperador, los Harkonen atacan el planeta para recuperar el poder perdido, Paul, el hijo del duque Leto Atreides, tiene que huir al desierto. Allí, además de afrontar múltiples peligros, se le presenta una oportunidad de derrocar a los Harkonen.', 'dune.png', 3, 5),
(2, 'Tenet', 'Tenet', 150, 2020, 2, 16, 'Armado con tan solo una palabra –Tenet– el protagonista de esta historia deberá pelear por la supervivencia del mundo entero en una misión que le lleva a viajar a través del oscuro mundo del espionaje internacional, y cuya experiencia se desdoblará más allá del tiempo lineal.', 'tenet.png', 5, 4),
(3, 'Amélie', 'Le fabuleux destin d´Amélie Poulain', 120, 2001, 0, 12, 'Amelie no es una chica como las demás. Ha visto a su pez de colores deslizarse hacia las alcantarillas municipales, a su madre morir en la plaza de Nôtre-Dame y a su padre dedicar todo su afecto a un gnomo de jardín. De repente, a los veintidós años, descubre su objetivo en la vida: arreglar la vida de los demás. A partir de entonces, inventa toda clase de estrategias para intervenir en los asuntos de los demás: su portera, que se pasa los días bebiendo vino de Oporto; Georgette, una estanquera hipocondríaca, o \"el hombre de cristal\", un vecino que sólo ve el mundo a través de la reproducción de un cuadro de Renoir', 'amelie.png', 2, 2),
(4, 'Drive', 'Drive', 100, 2011, 0, 16, 'Durante el día, Driver (Ryan Gosling) trabaja en un taller y es conductor especialista de cine, pero, algunas noches de forma esporádica, trabaja como chófer para delincuentes.', 'drive.png', 1, 5),
(5, 'Alien, el octavo pasajero', 'Alien', 116, 1979, 3, 18, 'De regreso a la Tierra, la nave de carga Nostromo interrumpe su viaje y despierta a sus siete tripulantes. El ordenador central, MADRE, ha detectado la misteriosa transmisión de una forma de vida desconocida, procedente de un planeta cercano aparentemente deshabitado. La nave se dirige entonces al extraño planeta para investigar el origen de la comunicación.', 'alien.png', 3, 5),
(6, 'El padrino', 'The Godfather', 175, 1972, 0, 18, 'América, años 40. Don Vito Corleone (Marlon Brando) es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York. Tiene cuatro hijos: Connie (Talia Shire), el impulsivo Sonny (James Caan), el pusilánime Fredo (John Cazale) y Michael (Al Pacino), que no quiere saber nada de los negocios de su padre.', 'padrino.png', 1, 5),
(7, 'El padrino. Parte II', 'The Godfather: Part II', 200, 1974, 0, 18, 'Continuación de la historia de los Corleone por medio de dos historias paralelas: la elección de Michael como jefe de los negocios familiares y los orígenes del patriarca, Don Vito Corleone, primero en su Sicilia natal y posteriormente en Estados Unidos, donde, empezando desde abajo, llegó a ser un poderosísimo jefe de la mafia de Nueva York.', 'padrinoParteDos.png', 1, 5),
(8, 'Doce hombres sin piedad', '12 Angry Men', 95, 1957, 0, 16, 'Los doce miembros de un jurado deben juzgar a un adolescente acusado de haber matado a su padre. Todos menos uno están convencidos de la culpabilidad del acusado. El que disiente intenta con sus razonamientos introducir en el debate una duda razonable que haga recapacitar a sus compañeros para que cambien el sentido de su voto.', 'doceHombres.png', 1, 5),
(9, 'La lista de Schindler', 'Schindler´s List', 195, 1993, 0, 18, 'Oskar Schindler (Liam Neeson), un empresario alemán de gran talento para las relaciones públicas, busca ganarse la simpatía de los nazis de cara a su beneficio personal. Después de la invasión de Polonia por los alemanes en 1939, Schindler consigue, gracias a sus relaciones con los altos jerarcas nazis, la propiedad de una fábrica de Cracovia.', 'schindler.png', 1, 5),
(10, 'Cadena perpetua', 'The Shawshank Redemption', 142, 1994, 0, 16, 'Acusado del asesinato de su mujer, Andrew Dufresne (Tim Robbins), tras ser condenado a cadena perpetua, es enviado a la cárcel de Shawshank. Con el paso de los años conseguirá ganarse la confianza del director del centro y el respeto de sus compañeros de prisión, especialmente de Red (Morgan Freeman), el jefe de la mafia de los sobornos.', 'cadenaPerpetua.png', 1, 5),
(11, 'Luces de la ciudad', 'City Lights', 81, 1931, 0, 0, 'Un pobre vagabundo (Charles Chaplin) pasa mil y un avatares para conseguir dinero y ayudar a una pobre chica ciega (Virginia Cherrill) de la que se ha enamorado.', 'lucesCiudad.png', 2, 5),
(12, 'Pulp Fiction', 'Pulp Fiction', 153, 1994, 0, 16, 'Jules y Vincent, dos asesinos a sueldo con no demasiadas luces, trabajan para el gángster Marsellus Wallace. Vincent le confiesa a Jules que Marsellus le ha pedido que cuide de Mia, su atractiva mujer. Jules le recomienda prudencia porque es muy peligroso sobrepasarse con la novia del jefe. Cuando llega la hora de trabajar, ambos deben ponerse \"manos a la obra\". Su misión: recuperar un misterioso maletín.', 'pulpFiction.png', 5, 5),
(13, 'M, el vampiro de Düsseldorf', 'M', 111, 1931, 0, 0, 'Un asesino de niñas tiene atemorizada a toda la ciudad. La policía lo busca frenética y desesperadamente, deteniendo a cualquier persona mínimamente sospechosa. Por su parte, los jefes del hampa, furiosos por las redadas que están sufriendo por culpa del asesino, deciden buscarlo ellos mismos.', 'mVampiro.png', 5, 3),
(14, 'La evasión', 'Le trou', 113, 1960, 0, 12, 'Manu, Roland, Jo y Vosselin comparten celda en la prisión francesa de La Santé. Los cuatro han pensado un elaborado método para escapar de la prisión, pero cuando están a punto de ejecutarlo, les asignan un nuevo compañero de celda, al que no saben si comunicarle o no sus planes.', 'laEvasion.png', 1, 2),
(15, 'El verdugo', 'El verdugo', 90, 1963, 0, 16, 'José Luis, el empleado de una funeraria, proyecta emigrar a Alemania para convertirse en un buen mecánico. Su novia es hija de Amadeo, un verdugo profesional. Cuando éste los sorprende en la intimidad, los obliga a casarse. Ante la acuciante falta de medios económicos de los recién casados, Amadeo, que está a punto de jubilarse, trata de persuadir a José Luis para que solicite la plaza que él va a dejar vacante, lo que le daría derecho a una vivienda. José Luis acaba aceptando la propuesta de su suegro con el convencimiento de que jamás se presentará la ocasión de ejercer tan ignominioso oficio.', 'elVerdugo.png', 1, 5),
(16, 'Juego de tronos', 'GOT', 45, 2011, 0, 12, 'La historia se desarrolla en un mundo ficticio de carácter medieval donde hay Siete Reinos. Hay tres líneas argumentales principales: la crónica de la guerra civil dinástica por el control de Poniente entre varias familias nobles que aspiran al Trono de Hierro; la creciente amenaza de \"los otros\", seres desconocidos que viven al otro lado de un inmenso muro de hielo que protege el Norte de Poniente; y el viaje de Daenerys Targaryen, la hija exiliada del rey que fue asesinado en una guerra civil anterior, y que pretende regresar a Poniente para reclamar sus derechos dinásticos.', 'got.png', 1, 5),
(17, 'Frasier', 'Frasier', 264, 1993, 0, 9, 'El doctor Frasier Crane es un estirado psiquiatra que, tras su divorcio, se traslada de Boston a Seattle para llevar un programa-consultorio de radio.', 'frasier.png', 2, 5),
(18, 'Los Soprano', 'The Sopranos', 86, 1999, 5, 16, 'Crónica de la vida cotidiana y de las aventuras personales y profesionales de una familia mafiosa que vive en Nueva Jersey.', 'soprano.png', 1, 5),
(19, 'Bajo escucha', 'The Wire', 60, 2002, 0, 18, 'En los barrios bajos de Baltimore, se investiga un asesinato relacionado con el mundo de las drogas. Un policía es el encargado de detener a los miembros de un importante cártel.', 'theWire.png', 1, 5),
(20, 'Black Mirror', 'Black Mirror', 0, 2011, 2, 16, 'Serie antológica creada por Charlie Brooker (\"Dead Set\") que muestra el lado oscuro de la tecnología y cómo esta afecta y puede alterar nuestra vida, a veces con consecuencias tan impredecibles como aterradoras.', 'blackMirror.png', 3, 4),
(21, 'Apocalipsis: La Segunda Guerra Mundial', 'Apocalypse: La 2ème Guerre Mondiale', 300, 2009, 0, 18, 'Documental francés de más de 5 horas sobre la II Guerra Mundial, en color', 'apocalipsis.png', 1, 2),
(22, 'Cosmos', 'Cosmos', 60, 1980, 0, 12, 'Tras el enorme éxito mundial de su libro \"Cosmos\", el carismático astrónomo y divulgador científico norteamericano Carl Sagan (1934-1996) lleva sus teorías y explicaciones sobre el conocimiento del Universo', 'cosmos.png', 3, 5),
(23, 'Planeta azul II', 'Blue Planet II', 7, 2017, 0, 0, '´Blue Planet ll´ se centra más en la influencia del ser humano en los océanos, la polución y el cambio climático. Esta serie incluye fragmentos jamás vistos antes en un documental.', 'planetaAzul.png', 1, 4),
(24, 'Ingeniería Romana', 'Ingeniería Romana', 100, 2015, 4, 0, 'El acueducto de Nimes, el teatro de Cartagena o los magníficos monumentos de Roma son algunas de las infraestructuras que permiten comprender los desafíos a los que se enfrentaron los ingenieros romanos.', 'ingenieriaRomana.png', 1, 4),
(25, 'Human', 'Human', 2, 2015, 0, 0, 'Compuesta de imágenes y de testimonios, la película del fotógrafo y cineasta Yann Arthus-Bertrand retrata la humanidad de hoy en día.', 'human.png', 4, 2),
(26, 'Nuestro planeta', 'Our Planet', 50, 2019, 3, 0, 'Comparte el esplendor de ese extraordinario lugar al que llamamos hogar. Nuestro planeta se ha rodado con lo último en tecnología de ultra alta definición en más de 50 países. De las selvas más exóticas a los océanos más profundos, admira todo aquello que tenemos en común. Con Sir David Attenborough como narrador en la versión original y Penélope Cruz en la versión doblada, mientras que Salma Hayek se encarga del doblaje de la versión mexicana.', 'nuestroPlaneta.png', 4, 4),
(27, 'The War', 'The War', 15, 2007, 0, 16, 'Un documental de 15 horas, en siete partes, que trata sobre los destinos de los estadounidenses durante la Segunda Guerra Mundial.', 'theWar.png', 1, 5),
(32, 'PRUEBA CON PLATAFORMAS', 'Tenet', 150, 2020, 0, 16, 'Armado con tan solo una palabra –Tenet– el protagonista de esta historia deberá pelear por la supervivencia del mundo entero en una misión que le lleva a viajar a través del oscuro mundo del espionaje internacional, y cuya experiencia se desdoblará más allá del tiempo lineal.', 'tenet.png', 5, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntuar`
--

CREATE TABLE `puntuar` (
  `id_registrado` int NOT NULL,
  `id_prod` int NOT NULL,
  `puntuacion` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `puntuar`
--

INSERT INTO `puntuar` (`id_registrado`, `id_prod`, `puntuacion`) VALUES
(1, 1, 1),
(1, 2, 2),
(1, 18, 5),
(4, 5, 4),
(5, 20, 2),
(5, 24, 4),
(5, 26, 3),
(6, 5, 2);

--
-- Disparadores `puntuar`
--
DELIMITER $$
CREATE TRIGGER `calcular_media` AFTER INSERT ON `puntuar` FOR EACH ROW UPDATE producto_audiovisual 
    SET media_puntuacion = (SELECT AVG(puntuacion) from puntuar where id_prod = new.id_prod)
    WHERE id_prod = NEW.id_prod
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrado`
--

CREATE TABLE `registrado` (
  `id_registrado` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `registrado`
--

INSERT INTO `registrado` (`id_registrado`) VALUES
(1),
(3),
(4),
(5),
(6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serie`
--

CREATE TABLE `serie` (
  `id_serie` int NOT NULL,
  `capitulos` int DEFAULT NULL,
  `temporadas` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `serie`
--

INSERT INTO `serie` (`id_serie`, `capitulos`, `temporadas`) VALUES
(16, 73, 8),
(17, 264, 11),
(18, 86, 6),
(19, 60, 5),
(20, 25, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `passwd` char(20) COLLATE utf8_spanish_ci NOT NULL,
  `token` text COLLATE utf8_spanish_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `email`, `passwd`, `token`) VALUES
(1, 'usuario@kvemos.com', 'Usuario123', NULL),
(2, 'admin@kvemos.com', 'Admin123', NULL),
(3, 'avioc@kvemos.com', 'Alicia123', NULL),
(4, 'alfonso@kvemos.com', 'Kvemos123', NULL),
(5, 'joseantonio@kvemos.com', 'Kvemos123', NULL),
(6, 'xavi@kvemos.com', 'Kvemos123', NULL);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_doc_mas_votadas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_doc_mas_votadas` (
`id` int
,`titulo` varchar(45)
,`votos` bigint
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_mejores_documentales`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_mejores_documentales` (
`id` int
,`titulo` varchar(45)
,`media` float
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_mejores_peliculas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_mejores_peliculas` (
`id` int
,`titulo` varchar(45)
,`media` float
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_mejores_series`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_mejores_series` (
`id` int
,`titulo` varchar(45)
,`media` float
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_pel_mas_votadas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_pel_mas_votadas` (
`id` int
,`titulo` varchar(45)
,`votos` bigint
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_ser_mas_votadas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_ser_mas_votadas` (
`id` int
,`titulo` varchar(45)
,`votos` bigint
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_usuarios_mas_activos`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_usuarios_mas_activos` (
`id` int
,`email` varchar(50)
,`puntuados` bigint
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_doc_mas_votadas`
--
DROP TABLE IF EXISTS `vista_doc_mas_votadas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vista_doc_mas_votadas`  AS SELECT DISTINCT `pr`.`id_prod` AS `id`, `pr`.`titulo` AS `titulo`, (select count(0) from `puntuar` where (`puntuar`.`id_prod` = `pr`.`id_prod`) group by `puntuar`.`id_prod`) AS `votos` FROM ((`documental` `d` join `producto_audiovisual` `pr` on((`d`.`id_documental` = `pr`.`id_prod`))) join `puntuar`) WHERE ((select count(0) from `puntuar` where (`puntuar`.`id_prod` = `pr`.`id_prod`) group by `puntuar`.`id_prod`) >= 1) ORDER BY `votos` DESC LIMIT 0, 10 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_mejores_documentales`
--
DROP TABLE IF EXISTS `vista_mejores_documentales`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vista_mejores_documentales`  AS SELECT DISTINCT `p`.`id_prod` AS `id`, `p`.`titulo` AS `titulo`, `p`.`media_puntuacion` AS `media` FROM (`documental` join `producto_audiovisual` `p` on((`documental`.`id_documental` = `p`.`id_prod`))) ORDER BY `p`.`media_puntuacion` DESC LIMIT 0, 10 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_mejores_peliculas`
--
DROP TABLE IF EXISTS `vista_mejores_peliculas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vista_mejores_peliculas`  AS SELECT DISTINCT `p`.`id_prod` AS `id`, `p`.`titulo` AS `titulo`, `p`.`media_puntuacion` AS `media` FROM (`pelicula` join `producto_audiovisual` `p` on((`pelicula`.`id_pelicula` = `p`.`id_prod`))) ORDER BY `p`.`media_puntuacion` DESC LIMIT 0, 10 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_mejores_series`
--
DROP TABLE IF EXISTS `vista_mejores_series`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vista_mejores_series`  AS SELECT DISTINCT `p`.`id_prod` AS `id`, `p`.`titulo` AS `titulo`, `p`.`media_puntuacion` AS `media` FROM (`serie` join `producto_audiovisual` `p` on((`serie`.`id_serie` = `p`.`id_prod`))) ORDER BY `p`.`media_puntuacion` DESC LIMIT 0, 10 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_pel_mas_votadas`
--
DROP TABLE IF EXISTS `vista_pel_mas_votadas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vista_pel_mas_votadas`  AS SELECT DISTINCT `pr`.`id_prod` AS `id`, `pr`.`titulo` AS `titulo`, (select count(0) from `puntuar` where (`puntuar`.`id_prod` = `pr`.`id_prod`) group by `puntuar`.`id_prod`) AS `votos` FROM ((`pelicula` `p` join `producto_audiovisual` `pr` on((`p`.`id_pelicula` = `pr`.`id_prod`))) join `puntuar`) WHERE ((select count(0) from `puntuar` where (`puntuar`.`id_prod` = `pr`.`id_prod`) group by `puntuar`.`id_prod`) >= 1) ORDER BY `votos` DESC LIMIT 0, 10 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_ser_mas_votadas`
--
DROP TABLE IF EXISTS `vista_ser_mas_votadas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vista_ser_mas_votadas`  AS SELECT DISTINCT `pr`.`id_prod` AS `id`, `pr`.`titulo` AS `titulo`, (select count(0) from `puntuar` where (`puntuar`.`id_prod` = `pr`.`id_prod`) group by `puntuar`.`id_prod`) AS `votos` FROM ((`serie` `s` join `producto_audiovisual` `pr` on((`s`.`id_serie` = `pr`.`id_prod`))) join `puntuar`) WHERE ((select count(0) from `puntuar` where (`puntuar`.`id_prod` = `pr`.`id_prod`) group by `puntuar`.`id_prod`) >= 1) ORDER BY `votos` DESC LIMIT 0, 10 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_usuarios_mas_activos`
--
DROP TABLE IF EXISTS `vista_usuarios_mas_activos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `vista_usuarios_mas_activos`  AS SELECT DISTINCT `u`.`id_usuario` AS `id`, `u`.`email` AS `email`, (select count(0) from `puntuar` `t` where (`t`.`id_registrado` = `u`.`id_usuario`) group by `t`.`id_registrado`) AS `puntuados` FROM (`usuario` `u` join `puntuar` `p`) WHERE (`u`.`id_usuario` = `p`.`id_registrado`) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indices de la tabla `documental`
--
ALTER TABLE `documental`
  ADD PRIMARY KEY (`id_documental`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id_genero`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indices de la tabla `guardar`
--
ALTER TABLE `guardar`
  ADD PRIMARY KEY (`id_registrado`,`id_prod`),
  ADD KEY `fk_id_prod_idx` (`id_prod`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`id_prod`,`id_plataforma`),
  ADD KEY `fk_id_plataforma_idx` (`id_plataforma`),
  ADD KEY `fk_id_prod_idx` (`id_prod`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id_pais`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id_pelicula`);

--
-- Indices de la tabla `plataforma`
--
ALTER TABLE `plataforma`
  ADD PRIMARY KEY (`id_plataforma`),
  ADD UNIQUE KEY `nombre_UNIQUE` (`nombre`);

--
-- Indices de la tabla `producto_audiovisual`
--
ALTER TABLE `producto_audiovisual`
  ADD PRIMARY KEY (`id_prod`),
  ADD KEY `fk_id_genero_idx` (`id_genero`),
  ADD KEY `fk_id_pais_idx` (`id_pais`);

--
-- Indices de la tabla `puntuar`
--
ALTER TABLE `puntuar`
  ADD PRIMARY KEY (`id_registrado`,`id_prod`),
  ADD KEY `fk_id_prod_idx` (`id_prod`),
  ADD KEY `fk_id_registrado_idx` (`id_registrado`);

--
-- Indices de la tabla `registrado`
--
ALTER TABLE `registrado`
  ADD PRIMARY KEY (`id_registrado`);

--
-- Indices de la tabla `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`id_serie`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id_genero` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `id_pais` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `plataforma`
--
ALTER TABLE `plataforma`
  MODIFY `id_plataforma` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `producto_audiovisual`
--
ALTER TABLE `producto_audiovisual`
  MODIFY `id_prod` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `fk_id_usuario` FOREIGN KEY (`id_admin`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `documental`
--
ALTER TABLE `documental`
  ADD CONSTRAINT `fk_id_prod_documental` FOREIGN KEY (`id_documental`) REFERENCES `producto_audiovisual` (`id_prod`);

--
-- Filtros para la tabla `guardar`
--
ALTER TABLE `guardar`
  ADD CONSTRAINT `fk_id_prod_guard` FOREIGN KEY (`id_prod`) REFERENCES `producto_audiovisual` (`id_prod`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_id_registrado_guard` FOREIGN KEY (`id_registrado`) REFERENCES `registrado` (`id_registrado`) ON DELETE CASCADE;

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `fk_id_plataforma_oferta` FOREIGN KEY (`id_plataforma`) REFERENCES `plataforma` (`id_plataforma`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_id_prod_oferta` FOREIGN KEY (`id_prod`) REFERENCES `producto_audiovisual` (`id_prod`) ON DELETE CASCADE;

--
-- Filtros para la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD CONSTRAINT `fk_id_prod_pelicula` FOREIGN KEY (`id_pelicula`) REFERENCES `producto_audiovisual` (`id_prod`);

--
-- Filtros para la tabla `producto_audiovisual`
--
ALTER TABLE `producto_audiovisual`
  ADD CONSTRAINT `fk_id_genero` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`),
  ADD CONSTRAINT `fk_id_pais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`);

--
-- Filtros para la tabla `puntuar`
--
ALTER TABLE `puntuar`
  ADD CONSTRAINT `fk_id_prod_punt` FOREIGN KEY (`id_prod`) REFERENCES `producto_audiovisual` (`id_prod`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_id_registrado_punt` FOREIGN KEY (`id_registrado`) REFERENCES `registrado` (`id_registrado`) ON DELETE CASCADE;

--
-- Filtros para la tabla `registrado`
--
ALTER TABLE `registrado`
  ADD CONSTRAINT `fk_id_usuario_reg` FOREIGN KEY (`id_registrado`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `serie`
--
ALTER TABLE `serie`
  ADD CONSTRAINT `fk_id_prod_serie` FOREIGN KEY (`id_serie`) REFERENCES `producto_audiovisual` (`id_prod`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
