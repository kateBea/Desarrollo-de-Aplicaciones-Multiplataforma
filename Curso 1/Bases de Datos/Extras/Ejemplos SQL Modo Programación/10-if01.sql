use curso;

DROP PROCEDURE IF EXISTS if01;
DELIMITER //
CREATE PROCEDURE if01()
BEGIN	
	DECLARE edad tinyint unsigned default 47;
    IF edad <=12 then
		select 'niño';
	elseif edad <=30 then
		select 'joven';
	else
		select 'adulto';
    end if;
END//
DELIMITER ;
CALL if01(); 










