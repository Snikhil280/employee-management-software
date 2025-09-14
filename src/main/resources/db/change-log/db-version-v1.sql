-- Department table
CREATE TABLE IF NOT EXISTS departments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT,
    deleted BOOLEAN DEFAULT FALSE,
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(500)
);

-- roles table
CREATE TABLE IF NOT EXISTS roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT,
    deleted BOOLEAN DEFAULT FALSE,
    name VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(500)
);

-- Employee table
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT,
    deleted BOOLEAN DEFAULT FALSE,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    department_id INT NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT fk_employee_department FOREIGN KEY (department_id) REFERENCES departments(id)
);

-- Employee_Role junction table
CREATE TABLE IF NOT EXISTS employee_roles (
    employee_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (employee_id, role_id),
    CONSTRAINT fk_employee_role_employee FOREIGN KEY (employee_id) REFERENCES employees(id),
    CONSTRAINT fk_employee_role_role FOREIGN KEY (role_id) REFERENCES roles(id)
);
