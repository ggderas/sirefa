
-- Tipo empleados
INSERT INTO TIPO_EMPLEADO(descripcion)
VALUES('Permanente');

-- Tipos de medicamento

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Antibioticos');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Ansiolíticos');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Analgésicos');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Antidiarreicos');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Antigripales');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Antihistamínicos');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Antiinflamatorios');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Antimicóticos');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Antipiréticos');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Antisépticos');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Antitusivos');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Broncodilatadores');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Axpectorantes');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Laxantes');

INSERT INTO TIPO_MEDICAMENTO(descripcion)
VALUES('Mucolíticos');


-- Roles

INSERT INTO ROLES(Nombre, Descripcion)
VALUES('Médico', 'Este usuario tiene permisos para ver las pantallas correspondientes a sus citas, pacientes');

INSERT INTO ROLES(Nombre, Descripcion)
VALUES('Administrador', 'Este usuario tiene permisos para crear usuarios, otorgar roles a usuario, actualizar información de usuarios, ver reporterías');

INSERT INTO ROLES(Nombre, Descripcion)
VALUES('Personal de farmacia', 'Tiene permisos para ver inventario de farmacia, agregar, modificar y revocar medicamentos, otorgar medicamentos por prescripcion');

INSERT INTO ROLES(Nombre, Descripcion)
VALUES('Personal de registro', 'Tiene permisos para registrar pacientes, actualizar información de pacientes y generar cita');




