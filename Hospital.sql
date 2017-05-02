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
  `IdCita` bigint(20) NOT NULL AUTO_INCREMENT,
  `Fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `IdPaciente` bigint(20) DEFAULT NULL,
  `IdMedico` bigint(20) DEFAULT NULL,
  `IdConsultorio` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`IdCita`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hospital.cita: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
INSERT INTO `cita` (`IdCita`, `Fecha`, `IdPaciente`, `IdMedico`, `IdConsultorio`) VALUES
	(2, '2017-04-20 16:27:24', 4, 14, 4);
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;

-- Volcando estructura para tabla hospital.consultorio
CREATE TABLE IF NOT EXISTS `consultorio` (
  `IdConsultorio` bigint(20) NOT NULL AUTO_INCREMENT,
  `Departamento` varchar(50) DEFAULT NULL,
  `Piso` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdConsultorio`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hospital.consultorio: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `consultorio` DISABLE KEYS */;
INSERT INTO `consultorio` (`IdConsultorio`, `Departamento`, `Piso`) VALUES
	(6, 'neurologia', '1'),
	(7, 'CARDIOLOGia', '3');
/*!40000 ALTER TABLE `consultorio` ENABLE KEYS */;

-- Volcando estructura para tabla hospital.departamento
CREATE TABLE IF NOT EXISTS `departamento` (
  `IdDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hospital.departamento: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` (`IdDepartamento`, `Nombre`) VALUES
	(2, 'Cardiologia'),
	(3, 'Neurologia');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;

-- Volcando estructura para tabla hospital.especialidad
CREATE TABLE IF NOT EXISTS `especialidad` (
  `IdEspecialidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdEspecialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hospital.especialidad: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `especialidad` DISABLE KEYS */;
INSERT INTO `especialidad` (`IdEspecialidad`, `Nombre`) VALUES
	(2, 'Cardiologia'),
	(3, 'Neurologia'),
	(4, 'Ginecologia'),
	(5, 'Dermatologia');
/*!40000 ALTER TABLE `especialidad` ENABLE KEYS */;

-- Volcando estructura para tabla hospital.historial
CREATE TABLE IF NOT EXISTS `historial` (
  `IdHistorial` int(11) NOT NULL AUTO_INCREMENT,
  `NombreHistorial` varchar(250) DEFAULT NULL,
  `IdReceta` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdHistorial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hospital.historial: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;

-- Volcando estructura para tabla hospital.medico
CREATE TABLE IF NOT EXISTS `medico` (
  `IdMedico` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(250) DEFAULT NULL,
  `Apellido` varchar(250) DEFAULT NULL,
  `IdEspecialidad` bigint(20) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `Correo` varchar(250) DEFAULT NULL,
  `Direccion` varchar(250) DEFAULT NULL,
  `Cedula` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdMedico`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hospital.medico: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` (`IdMedico`, `Nombre`, `Apellido`, `IdEspecialidad`, `Telefono`, `Correo`, `Direccion`, `Cedula`) VALUES
	(20, 'Jose', 'Alberto', 5, 28172192, 'jose@gmail.com', 'casa de jose', 'cjaji2'),
	(23, 'mamam', 'mamam', 1, 222, 'mompo', 'mopmpomo', 'pommop'),
	(25, 'Jorge', 'Gomez', 1, 1234, 'jorgemedico@gmail.com', 'casa de jorge', 'DSA1'),
	(26, 'kkp', 'kpkp', 2, 99, 'kko@gmail.com', 'kook', 'kookop');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;

-- Volcando estructura para tabla hospital.paciente
CREATE TABLE IF NOT EXISTS `paciente` (
  `IdPaciente` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(250) DEFAULT NULL,
  `Apellido` varchar(250) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `Correo` varchar(250) DEFAULT NULL,
  `Direccion` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`IdPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hospital.paciente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` (`IdPaciente`, `Nombre`, `Apellido`, `Telefono`, `Correo`, `Direccion`) VALUES
	(7, 'JOSE2', 'JUAN2', 222, 'josejuan2@gmail.com', 'casa de juan2'),
	(8, 'LUIS', 'HERNANDEZ', 12345, 'LUIS@GMAIL.COM', 'CASA DE LUIS');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;

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

-- Volcando datos para la tabla hospital.receta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
