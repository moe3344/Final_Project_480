-- Drop the database if it exists
DROP DATABASE IF EXISTS EWR;

-- Create the database
CREATE DATABASE EWR;

-- Use the database
USE EWR;

-- Drop the table if it exists
DROP TABLE IF EXISTS FLIGHTS;

-- Create the FLIGHTS table
CREATE TABLE FLIGHTS (
    FlightID            INT NOT NULL,
    FlightStartPoint    VARCHAR(40),
    FlightDest          VARCHAR(40),
    bookedBusinessSeats      varchar(255),
     bookedComfortSeats       varchar(255),
      bookedOrdinarySeats       varchar(255),
    FlightCost          DOUBLE NOT NULL,
    FlightArrivalTime   varchar(255), -- New column for flight arrival time
    FlightLeavingTime   varchar(255), -- New column for flight leaving time
    PRIMARY KEY (FlightID)
);

-- Insert 20 instances with random data into FLIGHTS table
-- Insert 20 instances with random data into FLIGHTS table
INSERT INTO FLIGHTS (
    FlightID,
    FlightStartPoint,
    FlightDest,
    bookedBusinessSeats,
    bookedComfortSeats,
    bookedOrdinarySeats,
    FlightCost,
    FlightArrivalTime,
    FlightLeavingTime
) VALUES
    (1, 'Tokyo', 'Toronto', "1A","3A","8A", 660.0, '2023-11-22 10:00:00', '2023-11-22 14:00:00'),
    (2, 'New York', 'Paris', "1A","3A","8A", 800.0, '2023-11-23 12:00:00', '2023-11-23 18:00:00'),
    (3, 'London', 'Sydney', "1A","3A","8A", 1200.0, '2023-11-24 08:00:00', '2023-11-24 20:00:00'),
    (4, 'Beijing', 'Rio de Janeiro', "1A","3A","8A", 500.0, '2023-11-25 14:30:00', '2023-11-25 19:30:00'),
    (5, 'Mumbai', 'Cape Town', "1A","3A","8A", 600.0, '2023-11-26 09:45:00', '2023-11-26 16:30:00'),
    (6, 'Dubai', 'Los Angeles', "1A","3A","8A", 750.0, '2023-11-27 11:00:00', '2023-11-27 22:15:00'),
    (7, 'Berlin', 'Tokyo', "1A","3A","8A", 700.0, '2023-11-28 13:20:00', '2023-11-28 17:45:00'),
    (8, 'Moscow', 'San Francisco',"1A","3A","8A", 900.0, '2023-11-29 16:40:00', '2023-11-29 23:00:00'),
    (9, 'Paris', 'Hong Kong', "1A","3A","8A", 1100.0, '2023-11-30 18:15:00', '2023-11-30 21:30:00'),
    (10, 'Rome', 'Vancouver', "1A","3A","8A", 1000.0, '2023-12-01 10:30:00', '2023-12-01 15:45:00'),
    (11, 'Sydney', 'Istanbul', "1A","3A","8A", 550.0, '2023-12-02 12:45:00', '2023-12-02 16:15:00'),
    (12, 'Seoul', 'Barcelona', "1A","3A","8A", 620.0, '2023-12-03 17:00:00', '2023-12-03 21:45:00'),
    (13, 'Cairo', 'New Delhi', "1A","3A","8A", 850.0, '2023-12-04 08:20:00', '2023-12-04 13:00:00'),
    (14, 'Buenos Aires', 'Stockholm', "1A","3A","8A", 1050.0, '2023-12-05 14:30:00', '2023-12-05 18:45:00'),
    (15, 'Athens', 'Dublin', "1A","3A","8A", 670.0, '2023-12-06 11:15:00', '2023-12-06 15:30:00'),
    (16, 'Copenhagen', 'Bangkok',"1A","3A","8A", 720.0, '2023-12-07 16:40:00', '2023-12-07 21:00:00'),
    (17, 'Prague', 'Zurich',"1A","3A","8A", 880.0, '2023-12-08 19:30:00', '2023-12-08 23:45:00'),
    (18, 'Tokyo', 'Toronto',"1A","3A","8A", 660.0, '2023-12-09 08:00:00', '2023-12-09 12:00:00'),
    (19, 'New York', 'Paris',"1A","3A","8A", 800.0, '2023-12-10 14:15:00', '2023-12-10 19:30:00'),
    (20, 'London', 'Sydney',"1A","3A","8A", 1200.0, '2023-12-11 10:30:00', '2023-12-11 22:00:00');
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userID  int not null,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

   
    
    
    
DROP TABLE IF EXISTS logedusers;
CREATE TABLE logedusers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    
    password  VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    
    dueAmount int ,
    phone vARCHAR(255) ,
    address VARCHAR(255) ,
    selectedSeat VARCHAR(255) ,
    flightID int ,
    flightCost int ,
    flightDest VARCHAR(255) ,
    flightStartPoint VARCHAR(255) 
    
 	
);
