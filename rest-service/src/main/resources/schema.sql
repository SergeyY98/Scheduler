CREATE TABLE doctors (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT uuid_generate_v4(),
    full_name VARCHAR(255) NOT NULL,
    -- Другие поля по необходимости
);

CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    uuid UUID DEFAULT uuid_generate_v4(),
    full_name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    -- Другие поля по необходимости
);

CREATE TABLE appointments (
    id SERIAL PRIMARY KEY,
    doctor_id INT REFERENCES doctors(id),
    patient_id INT REFERENCES patients(id),
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    -- Другие поля по необходимости
);