USE totales;
CREATE TABLE IF NOT EXISTS total(
	cliente VARCHAR(50),
    codigo_pedido INT,
    importe_total DECIMAL(15, 2)
);

LOAD DATA INFILE 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\exportData.csv'
INTO TABLE total 
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n';

SELECT * FROM total;