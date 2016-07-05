--W4D2_Homework Ziggy

--1. List all the employees whose salaries are more than 3000.
SELECT * FROM emp WHERE sal > 3000;

--2. List all the employees whose names begin with “S”.
SELECT * FROM emp WHERE ename LIKE 'S%';

--3. List the employees whose name is “SMITH”, “ALLEN” or “FORD”.
SELECT * FROM emp WHERE ename IN ('SMITH', 'ALLEN', 'FORD');

--4. List all the employees whose department is “SALES”.
SELECT *
FROM emp
WHERE deptno IN
  (SELECT deptno FROM dept WHERE dname = 'SALES'
  );
  
--5.To get the value of average, biggest, smallest and total of each department, and order by department number.
SELECT d.dname,
  e.deptno,
  AVG(e.sal) AS "AVERAGE",
  MAX(e.sal) AS "BIGGEST",
  MIN(e.sal) AS "SMALLEST",
  SUM(e.sal) AS "TOTAL"
FROM emp e,
  dept d
WHERE d.deptno = e.deptno
GROUP BY d.dname,
  e.deptno
ORDER BY e.deptno;

--6. To get the total number of employees, whose salary is more than 3000 for each department.
SELECT d.dname,
  e.deptno,
  COUNT(e.ENAME) AS "NUM OF EMP"
FROM emp e,
  dept d
WHERE d.deptno = e.deptno
AND e.sal      > 3000
GROUP BY d.dname,
  e.deptno;
  
--7. To get the number of the average salary for each department, according to the department name in ascending order
SELECT d.dname,
  AVG(e.sal) AS "AVERAGE"
FROM emp e,
  dept d
WHERE d.deptno = e.deptno
GROUP BY d.dname
ORDER BY d.dname;

--8. List the statistics of employees who have the same salary in each department, list their department number, salary, and number of employees.
SELECT e1.deptno,
  e1.sal,
  COUNT(e1.ename) AS "NUM OF EMP"
FROM emp e1,
  emp e2
WHERE e1.ename != e2.ename
AND e1.sal      = e2.sal
GROUP BY e1.deptno,
  e1.sal; 
  
--9. List the number of employees with more than 2 employees in the same department, showing the name of the Department, the name of the area, and the number of the employees in the same department
SELECT d.dname,
  d.loc,
  COUNT(e.ename) AS "NUM OF EMP"
FROM dept d,
  emp e
WHERE d.deptno = e.deptno
GROUP BY d.dname,
  d.loc
HAVING COUNT(e.ename)>2;

--10. List the name and salary of employees whose salaries is higher than the average salary of the entire firm
SELECT ename, sal FROM emp WHERE sal >
  (SELECT AVG(sal) FROM emp
  );