-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-12-2016 a las 07:09:59
-- Versión del servidor: 5.1.41
-- Versión de PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `concesionario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `automovil`
--

CREATE TABLE IF NOT EXISTS `automovil` (
  `idauto` bigint(20) NOT NULL AUTO_INCREMENT,
  `precioauto` float NOT NULL,
  `cantidadauto` int(11) NOT NULL,
  `nombreAuto` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `precioventa` float NOT NULL,
  PRIMARY KEY (`idauto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=14 ;

--
-- Volcar la base de datos para la tabla `automovil`
--

INSERT INTO `automovil` (`idauto`, `precioauto`, `cantidadauto`, `nombreAuto`, `precioventa`) VALUES
(1, 1100, 5, 'toyota', 1405),
(2, 13000, 6, 'ferrari', 18000),
(3, 5000, 12, 'vmw', 7500),
(4, 1000, 3, 'susuki', 1600),
(5, 2000, 42, 'ford', 3000),
(6, 1200, 11, 'chevrolet', 1355),
(7, 1300, 3, 'Honda', 1500),
(8, 600, 4, 'fiat', 930),
(9, 700, 6, 'mercedez', 840),
(10, 800, 30, 'renault', 1200),
(11, 777, 21, 'volvo', 1165.5),
(13, 1200, 2, 'TOYOTAW', 1440);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE IF NOT EXISTS `caja` (
  `idcaja` bigint(20) NOT NULL AUTO_INCREMENT,
  `idVentaCompra` bigint(20) NOT NULL,
  `tipoVentaCompra` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `dinero` float NOT NULL,
  PRIMARY KEY (`idcaja`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `caja`
--

INSERT INTO `caja` (`idcaja`, `idVentaCompra`, `tipoVentaCompra`, `fecha`, `dinero`) VALUES
(1, 142, 1, '2016-01-13', 1200),
(2, 143, 1, '2016-01-13', 1405),
(3, 144, 1, '2016-01-20', 1165.5),
(4, 145, 1, '2016-03-22', 3000),
(5, 146, 1, '2016-04-02', 930);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `idclie` int(25) NOT NULL AUTO_INCREMENT,
  `ciclie` int(11) NOT NULL,
  `nombreclie` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `apellidosclie` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `cuentaclie` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `bancoclie` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `telefonoclie` int(11) NOT NULL,
  `direccionclie` varchar(20) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`idclie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idclie`, `ciclie`, `nombreclie`, `apellidosclie`, `cuentaclie`, `bancoclie`, `telefonoclie`, `direccionclie`) VALUES
(1, 8813, 'Juan', 'Lopez', 'BU-123', 'Banco Union', 4435, 'av oquendo'),
(2, 8814, 'Cesar', 'Orteo', 'visa-653', 'BNB', 426, 'av panamericana');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE IF NOT EXISTS `compra` (
  `idcompra` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombreprov` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `nitprov` int(11) NOT NULL,
  `cantidadcomp` int(11) NOT NULL,
  `montocomp` float NOT NULL,
  `fechacomp` date NOT NULL,
  `idauto` bigint(20) NOT NULL,
  PRIMARY KEY (`idcompra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=1 ;

--
-- Volcar la base de datos para la tabla `compra`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_vehiculos`
--

CREATE TABLE IF NOT EXISTS `compra_vehiculos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `NIT` int(20) NOT NULL,
  `ID_Auto` int(20) NOT NULL,
  `Costo_Unitario` float NOT NULL,
  `Cantidad` int(20) NOT NULL,
  `Precio_de_venta` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Volcar la base de datos para la tabla `compra_vehiculos`
--

INSERT INTO `compra_vehiculos` (`id`, `Nombre`, `NIT`, `ID_Auto`, `Costo_Unitario`, `Cantidad`, `Precio_de_venta`) VALUES
(1, 'migi', 0, 0, 0, 0, 0),
(2, 'migi', 0, 0, 0, 0, 0),
(3, 'migi', 0, 0, 0, 0, 0),
(4, 'migi', 0, 0, 0, 0, 0),
(5, 'obsidian', 123, 1, 100, 1, 10),
(6, 'obsidian corp', 123, 1, 100, 1, 10),
(7, 'obsidian corp 1', 123, 1, 100, 1, 10),
(8, 'obsidian corp 2', 123, 1, 100, 1, 10),
(9, 'obsidian corp 3', 123, 1, 100, 1, 10),
(10, 'obsidian corp 3', 123, 1, 100, 10, 10),
(11, 'jorge', 12, 1, 900.89, 2, 1081.07),
(12, 'jorge', 12, 1, 900.89, 2, 1081.07),
(13, 'jorge', 12, 1, 900.89, 3, 1081.07),
(14, 'jose', 12, 1, 900.89, 1, 1081.07),
(15, 'jose', 12, 1, 900.89, 2, 1081.07),
(16, 'manuel', 1, 1, 900.89, 3, 1081.07),
(17, 'ed', 2, 1, 900.89, 3, 1081.07),
(18, 'river', 222, 1, 900.89, 4, 1351.33),
(19, 'juan', 234, 1, 900.89, 3, 1081.07),
(20, 'maria', 1231, 1, 900.89, 3, 1081.07),
(21, 'Juanma', 1234, 1, 900.89, 4, 1081.07),
(22, 'pedro', 1242, 1, 900.89, 2, 1081.07),
(23, 'jose', 123, 1, 900.89, 2, 1081.07),
(24, 'dasniel', 111, 2, 13000, 3, 15600),
(25, 'manue', 2222, 5, 2000, 4, 2400),
(26, 'joses', 2112, 6, 1200, 2, 1800),
(27, 'Basdasd', 1234567, 7, 0, 3, 0),
(28, 'river', 1212121, 8, 0, 6, 0),
(29, 'boca', 1212121, 9, 0, 1, 0),
(30, 'zcxvzvc', 121212, 9, 0, 2, 0),
(31, 'sdfsdf', 121212, 9, 700, 3, 840),
(32, 'nueva chicago', 123344, 10, 800, 6, 1200),
(33, 'san lorenzo', 12333, 11, 777, 2, 1165.5),
(34, 'EDEUARDO', 12321, 13, 1200, 2, 1440);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE IF NOT EXISTS `cuenta` (
  `nro` int(25) NOT NULL,
  `ci` int(25) NOT NULL,
  `saldo` int(25) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcar la base de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`nro`, `ci`, `saldo`, `tipo`, `id`) VALUES
(56, 32, 8000, 'l', 3),
(78, 23, 1000, 'l', 4),
(45, 78, 500, 'A', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `idEmp` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `Apellidos` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `sueldo` float NOT NULL,
  `ci` int(9) NOT NULL,
  `correo` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `tipo` varchar(20) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`idEmp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=7 ;

--
-- Volcar la base de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmp`, `Nombre`, `Apellidos`, `sueldo`, `ci`, `correo`, `tipo`) VALUES
(2, 'Davor', 'Heredia', 3500, 77766655, 'davor@gmail.com', 'CAJERO'),
(3, 'Edilberto', 'Heredia', 3500, 13464623, 'ej@gmail.com', 'R HUMANOS'),
(4, 'Richard', 'Fuentes', 10000, 1311111, 'Correo electrÃ³nico', 'VENDEDOR'),
(5, 'maykol', 'vallejos', 10000, 1112223, 'maykol@gmail.com', 'VENDEDOR'),
(6, 'WALDO', 'GIMENES', 3500, 1111111, 'asa@gmail.com', 'GERENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagocliente`
--

CREATE TABLE IF NOT EXISTS `pagocliente` (
  `idpago` bigint(20) NOT NULL AUTO_INCREMENT,
  `cicliente` bigint(20) NOT NULL,
  `montopago` float NOT NULL,
  `fechapago` date NOT NULL,
  PRIMARY KEY (`idpago`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=4 ;

--
-- Volcar la base de datos para la tabla `pagocliente`
--

INSERT INTO `pagocliente` (`idpago`, `cicliente`, `montopago`, `fechapago`) VALUES
(1, 1, 100, '2010-11-16'),
(2, 1, 100, '2010-11-16'),
(3, 1, 100, '2010-11-16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventacontado`
--

CREATE TABLE IF NOT EXISTS `ventacontado` (
  `idVentaContado` bigint(20) NOT NULL AUTO_INCREMENT,
  `idEmp` bigint(20) NOT NULL,
  `idAuto` bigint(20) NOT NULL,
  `precio` float NOT NULL,
  `nombre` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `apellidos` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `ci` int(10) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idVentaContado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=147 ;

--
-- Volcar la base de datos para la tabla `ventacontado`
--

INSERT INTO `ventacontado` (`idVentaContado`, `idEmp`, `idAuto`, `precio`, `nombre`, `apellidos`, `ci`, `fecha`) VALUES
(1, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-10-06'),
(2, 4, 1, 9, 'jose', 'manuel', 1234567, '2016-11-10'),
(3, 4, 1, 9, 'jose', 'canseco', 1234567, '2016-10-11'),
(4, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-10-06'),
(5, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-10-06'),
(6, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-10-06'),
(7, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-10-06'),
(8, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-10-06'),
(9, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-10-06'),
(10, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-10-06'),
(11, 4, 1, 9, 'eduard', 'pere', 1234567, '2016-10-11'),
(12, 4, 1, 9, 'ASASAS', 'ASASASASAS', 1234567, '2016-10-11'),
(13, 4, 1, 900.89, 'as', 'asasa', 1234567, '2016-10-11'),
(14, 4, 1, 900.89, 'jose', 'jose', 1111111, '2016-11-19'),
(15, 4, 1, 900.89, 'chino', 'sana', 2222222, '2016-11-19'),
(16, 4, 1, 900.89, 'edu', 'malo', 89898989, '2016-11-19'),
(17, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-11-19'),
(18, 0, 0, 888.32, 'COCO', 'MARTINEZ', 0, '2016-11-19'),
(19, 4, 1, 900.89, 'erqr', 'qwegadg', 8888888, '2016-11-19'),
(20, 4, 6, 1200, 'edu', 'pere', 1122112, '2016-11-19'),
(21, 6, 11, 1165.5, 'Edwin', 'Guzman', 5555556, '2016-11-19'),
(22, 4, 6, 0, 'eduardo', 'perez juarez', 21342131, '2016-11-22'),
(23, 4, 10, 0, 'Gustavo', 'Torres', 1234567, '2016-10-10'),
(24, 4, 10, 0, 'Gustavo', 'Torres', 1234567, '2016-10-10'),
(25, 4, 10, 0, 'Gustavo', 'Torres', 1234567, '2016-12-20'),
(26, 4, 10, 0, 'Gustavo', 'Torres', 1234567, '2016-12-20'),
(27, 4, 10, 0, 'Gustavo', 'Torres', 1234567, '2016-12-20'),
(28, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-12-20'),
(29, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-12-20'),
(30, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-12-20'),
(31, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-12-20'),
(32, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-12-20'),
(33, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-12-20'),
(34, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(35, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(36, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(37, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(38, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(39, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(40, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(41, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(42, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(43, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(44, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(45, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(46, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(47, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(48, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(49, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(50, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(51, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(52, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(53, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(54, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(55, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(56, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(57, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(58, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(59, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(60, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(61, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(62, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(63, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(64, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(65, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(66, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(67, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(68, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(69, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(70, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(71, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(72, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(73, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(74, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(75, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(76, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(77, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(78, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(79, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(80, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(81, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(82, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(83, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(84, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(85, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(86, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(87, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(88, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(89, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(90, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(91, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(92, 4, 2, 18000, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(93, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(94, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(95, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(96, 4, 2, 18000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(97, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(98, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(99, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(100, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(101, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(102, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(103, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(104, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(105, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(106, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(107, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(108, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(109, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(110, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(111, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(112, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(113, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(114, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(115, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(116, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(117, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(118, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(119, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(120, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(121, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(122, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(123, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(124, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(125, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(126, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(127, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(128, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(129, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(130, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(131, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(132, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(133, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(134, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(135, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(136, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(137, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(138, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(139, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(140, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(141, 4, 8, 930, 'Gustavo', 'Torres', 1234567, '2016-04-02'),
(142, 4, 10, 1200, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(143, 4, 1, 1405, 'Gustavo', 'Torres', 1234567, '2016-01-13'),
(144, 4, 11, 1165.5, 'Gustavo', 'Torres', 1234567, '2016-01-20'),
(145, 4, 5, 3000, 'Gustavo', 'Torres', 1234567, '2016-03-22'),
(146, 4, 8, 930, 'Gustavo', 'Torres', 1234567, '2016-04-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventacredito`
--

CREATE TABLE IF NOT EXISTS `ventacredito` (
  `idventcred` bigint(20) NOT NULL AUTO_INCREMENT,
  `cuota` int(11) NOT NULL,
  `estadoventcred` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `deudaventcred` float NOT NULL,
  `idclie` bigint(20) NOT NULL,
  PRIMARY KEY (`idventcred`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `ventacredito`
--

INSERT INTO `ventacredito` (`idventcred`, `cuota`, `estadoventcred`, `deudaventcred`, `idclie`) VALUES
(1, 20091116, 'cancelado', 0, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
