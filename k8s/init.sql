CREATE DATABASE IF NOT EXISTS basestudent;

USE basestudent;

CREATE TABLE IF NOT EXISTS student (
    id VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    code VARCHAR(255) UNIQUE,
    program_id VARCHAR(255),
    photo VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS payment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    amount DECIMAL(10, 2),
    type VARCHAR(255),
    status VARCHAR(255),
    file VARCHAR(255),
    student_id VARCHAR(255),
    FOREIGN KEY (student_id) REFERENCES student(id)
);

-- Insérer des données d'exemple
INSERT INTO student (id, first_name, last_name, code, program_id, photo) VALUES 
('123', 'John', 'Doe', 'JD123', 'program1', 'photo1.jpg'),
('124', 'Jane', 'Doe', 'JD124', 'program2', 'photo2.jpg');

INSERT INTO payment (date, amount, type, status, file, student_id) VALUES 
('2024-11-01', 100.0, 'CASH', 'VALIDATED', 'receipt1.pdf', '123'),
('2024-11-02', 150.0, 'TRANSFER', 'CREATED', 'receipt2.pdf', '124');

