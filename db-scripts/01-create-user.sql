CREATE USER 'avaliacao'@'localhost' IDENTIFIED BY 'avaliacao';

GRANT ALL PRIVILEGES ON *.* TO 'avaliacao'@'localhost';

ALTER USER 'avaliacao'@'localhost' IDENTIFIED WITH mysql_native_password BY 'avaliacao';