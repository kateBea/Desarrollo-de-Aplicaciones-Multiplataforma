/*
* Examen de Programación.
* Ejecuta este fichero para disponer de la base de datos a la que debe conectarse la aplicación que debes crear
*/

drop database if exists exProg3Ev;
create database exProg3Ev character set utf8mb4 collate utf8mb4_bin;
use exProg3Ev;
--
-- Estructura tabla `employees`
--

drop table if exists employees;
CREATE TABLE IF NOT EXISTS employees (
  EMPLOYEE_ID integer NOT NULL DEFAULT '0',
  FIRST_NAME varchar(50) DEFAULT NULL,
  LAST_NAME varchar(50) NOT NULL,
  EMAIL varchar(25) NOT NULL,
  PHONE_NUMBER varchar(20) DEFAULT NULL,
  HIRE_DATE date DEFAULT NULL,  
  SALARY decimal(8,2) DEFAULT NULL,
  COMMISSION_PCT decimal(2,2) DEFAULT NULL,  
  PRIMARY KEY (EMPLOYEE_ID),
  UNIQUE KEY EMP_EMAIL_UK (EMAIL)  
);

--
-- Insertando datos `employees`
--

INSERT INTO employees (EMPLOYEE_ID,FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, SALARY, COMMISSION_PCT) VALUES
('100', 'Steven', 'King', 'skin@gnal.com', '515.123.4567', '1987-06-17', '24000.00', '0.00'),
('101', 'Neena', 'Kochhar', 'ko@gmail.com', '515.123.4568', '1987-06-18',  '17000.00', '0.00'),
('102', 'Lex', 'De Haan', 'lexgmail.com', '515.123.4569', '1987-06-19',  '17000.00', '0.00'),
('103', 'Alex', 'Hunold', 'alex@gmail.com', '590.423.4567', '1987-06-20', '9000.00', '0.00'),
('104', 'Bruce', 'Ernst', 'bruce@gmail.es', '590.423.4568', '1987-06-21',  '6000.00', '0.00'),
('105', 'David', 'Austin', 'austin@gmail.es', '590.423.4569', '1987-06-22',  '4800.00', '0.00'),
('106', 'Valli', 'Patab', 'pat@gmail.es', '590.423.4560', '1987-06-23', '4800.00', '0.00'),
('107', 'Diana', 'Lorentz', 'lont@gmail.com', '590.423.5567', '1987-06-24', '4200.00', '0.00');

select * from employees;
