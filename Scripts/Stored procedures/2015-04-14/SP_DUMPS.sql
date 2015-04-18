-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sirefa
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping routines for database 'sirefa'
--
/*!50003 DROP PROCEDURE IF EXISTS `SP_ASIGNAR_ROL_USUARIO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ASIGNAR_ROL_USUARIO`(
	IN pnCodigoRol INT, -- Código que define el rol a añadir
	IN pnCodigoUsuario INT, -- Código del empleado
    IN pnAccion INT, -- Variable que determina si se agregará o eliminara un rol
    OUT pcMensajeError VARCHAR(500)
)
SP: BEGIN

	DECLARE vnContadorRol INT DEFAULT 0; -- Variable para determinar si un usuario ya cuenta con un determinado rol
	DECLARE vcTempMensajeError VARCHAR(500) DEFAULT ''; -- Variable para posibles errores no controlados
    DECLARE vcMensajeErrorServidor TEXT; -- Variable para almacenar el mensaje de error del servidor
    DECLARE vnAccionAgregar INT DEFAULT 1;
    DECLARE vnAccionEliminar INT DEFAULT 2;
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
    
		ROLLBACK;
    
		GET DIAGNOSTICS CONDITION 1 vcMensajeErrorServidor = MESSAGE_TEXT;
        SET vcTempMensajeError := CONCAT('Error: ', vcTempMensajeError, ' Error servidor: ', vcMensajeErrorServidor);
        SET pcMensajeError := vcTempMensajeError;
    
    END;  	
    
    IF pnAccion = vnAccionAgregar THEN
    
		-- Determinar si el usuario ya cuenta con el rol determinado
		SET vcTempMensajeError := 'Error al hacer SELECT COUNT de roles_usuarios';
		SELECT
			COUNT(*)
		INTO
			vnContadorRol
		FROM
			ROLES_USUARIOS
		WHERE
			idRol = pnCodigoRol
			AND idUsuario = pnCodigoUsuario;
			
		IF vnContadorRol > 0 THEN
		
			SET pcMensajeError := 'El usuario ya cuenta con este rol';
			LEAVE SP;
		
		END IF;
			
		-- Asignar rol a usuario
		SET vcTempMensajeError := 'Error al hacer asignar rol al usuario';
		INSERT INTO ROLES_USUARIOS(idRol, idUsuario)
		VALUES(pnCodigoRol, pnCodigoUsuario);
	
    ELSEIF pnAccion = vnAccionEliminar THEN
    
		DELETE FROM ROLES_USUARIOS 
        WHERE 
			ROLES_USUARIOS.idRol = pnCodigoRol
            AND ROLES_USUARIOS.idUsuario = pnCodigoUsuario;
    
    END IF;
    

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_GESTIONAR_USUARIOS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_GESTIONAR_USUARIOS`(

	-- LDeras 31/3/15

	IN pcPrimerNombre VARCHAR(50), -- Primer nombre del usuario
	IN pcSegundoNombre VARCHAR(50),  -- Segundo nombre del usuario
    IN pcPrimerApellido VARCHAR(50), -- Primer apellido del usuario
    IN pcSegundoApellido VARCHAR(50), -- Segundo apellido del usuario
	IN pdFechaNacimiento DATE, 	-- Fecha de nacimiento del usuario
	IN pcDireccion VARCHAR(50), -- Dirección del usuario
	IN pcTelefono VARCHAR(50),	-- Número de telefono
    IN pcNombreUsuario VARCHAR(45), -- Nombre de usuario
    IN pcClave VARCHAR(45), -- Clave de usuario
    OUT pcMensajeError VARCHAR(500) -- Parámetro para mensajes de error
    
)
SP:BEGIN

	DECLARE vcTempMensajeError VARCHAR(500) DEFAULT ''; -- Variable para almacenar posibles errores no controlados de servidor
    DECLARE vnCodigoUltimoInsert INT DEFAULT 0;	-- Variable para obtener el último código insertado (SELECT LAST_INSERT_ID())
    DECLARE vnContadorNombreUsuario INT DEFAULT 0; -- Variable para determinar si el nombre de usuario ya está siendo usado
    DECLARE vcMensajeErrorServidor TEXT; -- Variable para almacenar el mensaje de error del servidor
    DECLARE vnCodigoTipoEmpleadoPermanente INT DEFAULT 1;
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
    
		ROLLBACK;
    
		GET DIAGNOSTICS CONDITION 1 vcMensajeErrorServidor = MESSAGE_TEXT;
        SET vcTempMensajeError := CONCAT('Error: ', vcTempMensajeError, ' Error servidor: ', vcMensajeErrorServidor);
        SET pcMensajeError := vcTempMensajeError;
    
    END;

	
    -- Determinar si el nombre de usuario ya está siendo usado
    SET vcTempMensajeError := 'Error al seleccionar COUNT de nombre de usuario';
	SELECT
		COUNT(nombreDeUsuario)
	INTO
		vnContadorNombreUsuario
	FROM
		EMPLEADO
	WHERE
		nombreDeUsuario = pcNombreUsuario;
        
        
	-- El nombre de usuario ya está siendo usado
	IF vnContadorNombreUsuario > 0 then
    
		SET pcMensajeError := 'El nombre de usuario ya está siendo usado, intenta otro';
        LEAVE SP;
    
    END IF;
	
    -- Agregar registro a la tabla PERSONA
    SET vcTempMensajeError := 'Error al crear registro en PERSONA';
    
    INSERT INTO PERSONA(primerNombre, segundoNombre, primerApellido, segundoApellido, fechaDeNacimiento, direccion, numeroTelefono)
	VALUES(pcPrimerNombre, pcSegundoNombre, pcPrimerApellido, pcSegundoApellido, pdFechaNacimiento, pcDireccion, pcTelefono);
    
    -- Agregar registro a la tabla PERSONA
    SET vcTempMensajeError := 'Error al hacer select last_insert_id()';
    SELECT LAST_INSERT_ID()
    INTO vnCodigoUltimoInsert;
    
	-- Agregar registro a la tabla EMPLEADO
    SET vcTempMensajeError := 'Error al crear registro en EMPLEADO';
    
    INSERT INTO EMPLEADO(idPersona, nombreDeUsuario, clave, fechaIngreso, idtipoEmpleado)
    VALUES(vnCodigoUltimoInsert, pcNombreUsuario, pcClave, DATE_FORMAT(NOW(), "%Y-%m-%d"), vnCodigoTipoEmpleadoPermanente);
    

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_LOGIN` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_LOGIN`(
	IN pcNombreUsuario VARCHAR(100), -- Nombre de usuario del empleado
	IN pcClave VARCHAR(200), -- Clave de usuario del empleado
    OUT pcMensajeError VARCHAR(500)
)
SP: BEGIN

	DECLARE vnContadorUsuario INT DEFAULT 0; -- Variable para determinar si existe el usuario

	DECLARE vcTempMensajeError VARCHAR(500) DEFAULT ''; -- Variable para posibles errores no controlados
    DECLARE vcMensajeErrorServidor TEXT; -- Variable para almacenar el mensaje de error del servidor
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
    
		ROLLBACK;
    
		GET DIAGNOSTICS CONDITION 1 vcMensajeErrorServidor = MESSAGE_TEXT;
        SET vcTempMensajeError := CONCAT('Error: ', vcTempMensajeError, ' Error servidor: ', vcMensajeErrorServidor);
        SET pcMensajeError := vcTempMensajeError;
    
    END; 
    
    -- Determinar si el logueo es exitoso
	SET vcTempMensajeError := 'Error al obtener COUNT de EMPLEADO';
    
    SELECT
		COUNT(*)
	INTO
		vnContadorUsuario
	FROM
		EMPLEADO
	WHERE
		nombreDeUsuario = pcNombreUsuario 
        AND clave = BINARY(pcClave);
	
    IF vnContadorUsuario = 0 THEN
    
		SET pcMensajeError := 'Usuario o clave incorrecta';
        LEAVE SP;
    
    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_OBTENER_EMPLEADOS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_OBTENER_EMPLEADOS`(
	-- LDeras 15-04-13
    OUT pcMensajeError VARCHAR(500) -- Variable para mensajes de error
)
BEGIN

	DECLARE vcTempMensajeError VARCHAR(500) DEFAULT ''; -- Variable para posibles errores no controlados
    DECLARE vcMensajeErrorServidor TEXT; -- Variable para almacenar el mensaje de error del servidor
    
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
    
		ROLLBACK;
    
		GET DIAGNOSTICS CONDITION 1 vcMensajeErrorServidor = MESSAGE_TEXT;
        SET vcTempMensajeError := CONCAT('Error: ', vcTempMensajeError, ' Error servidor: ', vcMensajeErrorServidor);
        SET pcMensajeError := vcTempMensajeError;
    
    END;    
    
	SELECT 
		primerNombre, segundoNombre, primerApellido, segundoApellido,idPersona,
		direccion, fechaDeNacimiento
	FROM
		PERSONA
	WHERE
		idPersona IN
        (
			SELECT idPersona
            FROM EMPLEADO
        );

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_OBTENER_MEDICAMENTOS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_OBTENER_MEDICAMENTOS`(
	OUT pcMensajeError VARCHAR(500) -- Para mensajes de error
)
BEGIN

	DECLARE vcTempMensajeError VARCHAR(500) DEFAULT ''; -- Variable para posibles errores no controlados
    DECLARE vcMensajeErrorServidor TEXT; -- Variable para almacenar el mensaje de error del servidor
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
    
		ROLLBACK;
    
		GET DIAGNOSTICS CONDITION 1 vcMensajeErrorServidor = MESSAGE_TEXT;
        SET vcTempMensajeError := CONCAT('Error: ', vcTempMensajeError, ' Error servidor: ', vcMensajeErrorServidor);
        SET pcMensajeError := vcTempMensajeError;
    
    END;    

	-- Obtener medicamentos
    SET vcTempMensajeError := 'Error al obtener medicamentos';
	SELECT
		idMedicamento, nombre, idTipoMedicamento
	FROM
		MEDICAMENTO;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_OBTENER_ROLES` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_OBTENER_ROLES`(
	-- LDeras 11-04-15
    OUT pcMensajeError VARCHAR(500) -- Para mensajes de error
)
BEGIN

	DECLARE vcTempMensajeError VARCHAR(500) DEFAULT ''; -- Variable para posibles errores no controlados
    DECLARE vcMensajeErrorServidor TEXT; -- Variable para almacenar el mensaje de error del servidor
    
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
    
		ROLLBACK;
    
		GET DIAGNOSTICS CONDITION 1 vcMensajeErrorServidor = MESSAGE_TEXT;
        SET vcTempMensajeError := CONCAT('Error: ', vcTempMensajeError, ' Error servidor: ', vcMensajeErrorServidor);
        SET pcMensajeError := vcTempMensajeError;
    
    END;    
    
	-- Obtener roles
	SET vcTempMensajeError := 'Error al al obtener roles';
	SELECT
		idRol, Nombre, Descripcion
	FROM
		ROLES;   


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_OBTENER_ROLES_USUARIO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_OBTENER_ROLES_USUARIO`(
	-- LDeras 13-04-15
    IN pnCodigoEmpleado INT, -- Código de empleado
    OUT pcMensajeError VARCHAR(500) -- Para mensajes de error
)
BEGIN

	DECLARE vcTempMensajeError VARCHAR(500) DEFAULT ''; -- Variable para posibles errores no controlados
    DECLARE vcMensajeErrorServidor TEXT; -- Variable para almacenar el mensaje de error del servidor
    
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
    
		ROLLBACK;
    
		GET DIAGNOSTICS CONDITION 1 vcMensajeErrorServidor = MESSAGE_TEXT;
        SET vcTempMensajeError := CONCAT('Error: ', vcTempMensajeError, ' Error servidor: ', vcMensajeErrorServidor);
        SET pcMensajeError := vcTempMensajeError;
    
    END;    
    
	-- Obtener roles
	SET vcTempMensajeError := 'Error al al obtener roles por usuario';
	SELECT
		ROLES.idRol, ROLES.Nombre
	FROM
		ROLES INNER JOIN ROLES_USUARIOS
        ON(ROLES.idRol = ROLES_USUARIOS.idRol)
	WHERE
		ROLES_USUARIOS.idUsuario = pnCodigoEmpleado;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_OBTENER_TIPOS_MEDICAMENTO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_OBTENER_TIPOS_MEDICAMENTO`(
	-- LDeras 11-04-15
    OUT pcMensajeError VARCHAR(500) -- Para mensajes de error
)
BEGIN

	DECLARE vcTempMensajeError VARCHAR(500) DEFAULT ''; -- Variable para posibles errores no controlados
    DECLARE vcMensajeErrorServidor TEXT; -- Variable para almacenar el mensaje de error del servidor
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
    
		ROLLBACK;
    
		GET DIAGNOSTICS CONDITION 1 vcMensajeErrorServidor = MESSAGE_TEXT;
        SET vcTempMensajeError := CONCAT('Error: ', vcTempMensajeError, ' Error servidor: ', vcMensajeErrorServidor);
        SET pcMensajeError := vcTempMensajeError;
    
    END;    

	-- Obtener medicamentos
    SET vcTempMensajeError := 'Error al obtener tipos de medicamentos';
	SELECT
		idTipo_Medicamento, descripcion
	FROM
		TIPO_MEDICAMENTO;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SP_REGISTRAR_MEDICAMENTO` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_REGISTRAR_MEDICAMENTO`(
	-- LDeras 2/4/15
    IN pcNombreMedicamento VARCHAR(50),	-- Nombre del medicamento
    IN pnCodigoTipoMedicamento INT,		-- Código del tipo de medicamento
    OUT pcMensajeError VARCHAR(500)		-- Mensaje de error
)
SP: BEGIN

    DECLARE vcMensajeErrorServidor TEXT; -- Variable para almacenar el mensaje de error del servidor
    DECLARE vcTempMensajeError VARCHAR(500) DEFAULT ''; -- Variable para almacenar posibles errores no controlados de servidor
    DECLARE vnContadorNombreMedicamento INT DEFAULT 0; -- Variable para determinar si ya hay un medicamento con el nombre
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
    
		ROLLBACK;
    
		GET DIAGNOSTICS CONDITION 1 vcMensajeErrorServidor = MESSAGE_TEXT;
        SET vcTempMensajeError := CONCAT('Error: ', vcTempMensajeError, ' Error servidor: ', vcMensajeErrorServidor);
        SET pcMensajeError := vcTempMensajeError;
    
    END;
    
    -- Determinar si el nombre del medicamento ya existe
    SET vcTempMensajeError := 'Error al seleccionar nombre de medicamentos';
    
    SELECT 
		COUNT(nombre)
	INTO
		vnContadorNombreMedicamento
	FROM
		MEDICAMENTO
	WHERE
		nombre = pcNombreMedicamento;
        
	IF vnContadorNombreMedicamento > 0 THEN
    
		SET pcMensajeError := 'Ya hay un medicamento con ese nombre, inténtelo de nuevo';
		LEAVE SP;
    
    END IF;
	
    
    -- Registrar medicamento
    SET vcTempMensajeError := 'Error al insertar nuevo medicamento';

    INSERT INTO MEDICAMENTO(nombre, idTipoMedicamento)
    VALUES(pcNombreMedicamento, pnCodigoTipoMedicamento);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-14 21:31:42
