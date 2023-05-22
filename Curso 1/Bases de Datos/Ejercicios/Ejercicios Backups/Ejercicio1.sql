USE jardineria;

SELECT * FROM detallepedidos;
SELECT * FROM pedidos;
SELECT * FROM clientes;

SELECT nombrecliente, p.codigopedido, importe_total
FROM clientes c INNER JOIN pedidos p INNER JOIN ((SELECT d.codigopedido, SUM(cantidad) * preciounidad AS importe_total 
										FROM detallepedidos d INNER JOIN pedidos p2 ON d.codigopedido = p2.codigopedido
                                        GROUP BY d.codigopedido)) AS importes
                                        ON c.codigocliente = p.codigocliente AND importes.codigopedido = p.codigopedido

INTO OUTFILE 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\exportData.csv' -- directorio fichero exportación
FIELDS TERMINATED BY ',' -- como se separan los campos
ENCLOSED BY '"' -- caracter que encierr los campos (se puede usar comillas)
LINES TERMINATED BY '\n';
                         
-- Encaso de tener secure-file-priv activo buscamos donde guarda MySQL los archivos
SHOW VARIABLES LIKE '%secure_file_priv';
						