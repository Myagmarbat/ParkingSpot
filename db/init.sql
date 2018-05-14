DROP USER 'user'@'%';

CREATE USER 'user'@'%' IDENTIFIED BY 'user';
GRANT ALL PRIVILEGES ON spotsystem.* TO 'user'@'%';
FLUSH PRIVILEGES;


drop table `spotsystem.alien`
CREATE TABLE `spotsystem.alien` (
`aid` int(10) unsigned NOT NULL auto_increment,
`aname` varchar(50) NOT NULL,
`tech` varchar(50) NOT NULL,
`description` varchar(255),
PRIMARY KEY (`aid`),
UNIQUE KEY `aid` (`aid`)
)

INSERT INTO spotsystem.alien (aname, tech, description) 
	VALUES ('test1', '1', '2')