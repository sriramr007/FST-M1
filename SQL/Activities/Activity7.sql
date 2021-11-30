REM   Script: Activity 7
REM   Activity 7

SELECT SUM(purchase_amount) AS total_amount FROM orders;

SELECT AVG(purchase_amount) AS average_amount FROM orders;

SELECT MAX(purchase_amount) AS maximum_amount FROM orders;

SELECT MIN(purchase_amount) AS minimum_amount FROM orders;

SELECT COUNT(salesman_id) AS total_salesman FROM orders;

