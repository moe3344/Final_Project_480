/* W23 Project Example Database
   2023 Barcomb
 
 Each time this file is executed, it will reset the database to the original state defined below.
 
 */

DROP DATABASE IF EXISTS EWR;
CREATE DATABASE EWR; 
USE EWR;

CREATE TABLE FLIGHTS (
    FlightID            INT NOT NULL AUTO_INCREMENT,
    FlightStartPoint    VARCHAR(40),
    FlightDest          VARCHAR(40),
    AvailableSeats      INT NOT NULL,
    FlightCost          DOUBLE NOT NULL,
    PRIMARY KEY (FlightID)
);

INSERT INTO FLIGHTS (FlightID, FlightStartPoint, FlightDest, AvailableSeats, FlightCost) VALUES

    (1,'Tokyo', 'Toronto', 25, 660.0),
    (2,'New York', 'Paris', 20, 800.0),
    (3,'London', 'Sydney', 30, 1200.0),
    (4,'Beijing', 'Rio de Janeiro', 10, 500.0),
    (5,'Mumbai', 'Cape Town', 15, 600.0),
    (6,'Dubai', 'Los Angeles', 22, 750.0),
    (7,'Berlin', 'Tokyo', 18, 700.0),
    (8,'Moscow', 'San Francisco', 27, 900.0),
    (9,'Paris', 'Hong Kong', 35, 1100.0),
    (10,'Rome', 'Vancouver', 29, 1000.0),
    (11,'Sydney', 'Istanbul', 12, 550.0),
    (12,'Seoul', 'Barcelona', 14, 620.0),
    (13,'Cairo', 'New Delhi', 26, 850.0),
    (14,'Buenos Aires', 'Stockholm', 33, 1050.0),
    (15,'Athens', 'Dublin', 16, 670.0),
    (16,'Copenhagen', 'Bangkok', 19, 720.0),
    
    (17,'Prague', 'Zurich', 23, 880.0);

