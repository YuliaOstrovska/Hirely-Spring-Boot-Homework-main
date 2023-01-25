CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL,
    base_salary NUMERIC(10, 2) NOT NULL,
    employment_date TIMESTAMP NOT NULL
);

