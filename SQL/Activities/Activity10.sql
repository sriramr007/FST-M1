REM   Script: Activity 10
REM   Activity 10

SELECT * FROM orders WHERE salesman_id = (SELECT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM orders WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');

SELECT COUNT(*) AS customer_count, grade FROM customers GROUP BY grade HAVING  
    grade > (SELECT AVG(grade) FROM customers WHERE city='New York');

SELECT * FROM orders WHERE salesman_id IN 
    (SELECT salesman_id FROM salesman WHERE commission = (SELECT MAX(commission) FROM salesman));

