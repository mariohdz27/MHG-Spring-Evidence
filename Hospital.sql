-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.17-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para hospital
CREATE DATABASE IF NOT EXISTS `hospital` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hospital`;

-- Volcando estructura para tabla hospital.cita
CREATE TABLE IF NOT EXISTS `cita` (
  `IdCita` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `IdPaciente` int(11) DEFAULT NULL,
  `IdMedico` int(11) DEFAULT NULL,
  `IdConsultorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdCita`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla hospital.consultorio
CREATE TABLE IF NOT EXISTS `consultorio` (
  `IdConsultorio` int(11) NOT NULL AUTO_INCREMENT,
  `IdDepartamento` int(11) DEFAULT NULL,
  `Piso` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdConsultorio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla hospital.departamento
CREATE TABLE IF NOT EXISTS `departamento` (
  `IdDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla hospital.especialidad
CREATE TABLE IF NOT EXISTS `especialidad` (
  `IdEspecialidad` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(250) DEFAULT NULL,
  `IdDepartamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdEspecialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla hospital.historial
CREATE TABLE IF NOT EXISTS `historial` (
  `IdHistorial` int(11) NOT NULL AUTO_INCREMENT,
  `NombreHistorial` varchar(250) DEFAULT NULL,
  `IdReceta` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdHistorial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla hospital.medico
CREATE TABLE IF NOT EXISTS `medico` (
  `IdMedico` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(250) DEFAULT NULL,
  `Apellido` varchar(250) DEFAULT NULL,
  `IdEspecialidad` int(11) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `Correo` varchar(250) DEFAULT NULL,
  `Direccion` varchar(250) DEFAULT NULL,
  `Cedula` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdMedico`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla hospital.paciente
CREATE TABLE IF NOT EXISTS `paciente` (
  `IdPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(250) DEFAULT NULL,
  `ApellidoPaterno` varchar(250) DEFAULT NULL,
  `ApellidoMaterno` varchar(250) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `Correo` varchar(250) DEFAULT NULL,
  `Direccion` varchar(250) DEFAULT NULL,
  `NSS` varchar(250) DEFAULT NULL,
  `Sexo` varchar(250) DEFAULT NULL,
  `TipoSangre` varchar(250) DEFAULT NULL,
  `Alergias` varchar(250) DEFAULT NULL,
  `FechaNacimiento` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`IdPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla hospital.receta
CREATE TABLE IF NOT EXISTS `receta` (
  `IdReceta` int(11) NOT NULL AUTO_INCREMENT,
  `IdCita` int(11) DEFAULT NULL,
  `Peso` varchar(250) DEFAULT NULL,
  `Presion` varchar(250) DEFAULT NULL,
  `Talla` varchar(250) DEFAULT NULL,
  `Temperatura` varchar(250) DEFAULT NULL,
  `Diagnostico` varchar(250) DEFAULT NULL,
  `Observacion` varchar(250) DEFAULT NULL,
  `Prescripcion` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdReceta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
