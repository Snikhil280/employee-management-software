-- Department table
CREATE TABLE department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT,
    deleted BOOLEAN DEFAULT FALSE,
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(500)
);

-- Designation table
CREATE TABLE designation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT,
    deleted BOOLEAN DEFAULT FALSE,
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(500)
);

-- Employee table
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT,
    deleted BOOLEAN DEFAULT FALSE,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    department_id INT NOT NULL,
    designation_id INT NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES department(id),
    CONSTRAINT fk_employee_designation FOREIGN KEY (designation_id) REFERENCES designation(id)
);
