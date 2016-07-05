--Homework Answers by Lance
--Answer the questions by SQL.
--(1)	List all the employees whose salaries are more than 3000.

select * 
from EMP 
where SAL > 3000;


--(2)	List all the employees whose names begin with “S”.

select * 
from EMP 
where SUBSTR(ENAME, 1, 1) = 'S';

--(3)	List the employees whose name is “SMITH”, “ALLEN” or “FORD”.

select * 
from EMP 
where ENAME = 'SMITH' 
or ENAME = 'ALLEN' 
or ENAME = 'FORD';


--(4)	List all the employees whose department is “SALES”.

select *
from EMP
where DEPTNO
in(select DEPTNO
from DEPT 
where DNAME = 'SALES');

--(5)	To get the value of average, biggest, smallest and total of each department, and order by department number.

select emp.DEPTNO,
AVG(emp.SAL) as AVERAGE_SAL
, MAX(emp.SAL) as BIGGEST_SAL
, MIN(emp.SAL) as MIN_SAL
, SUM(emp.SAL) as TOTAL_SAL 
from EMP emp, DEPT dept 
where emp.DEPTNO = dept.DEPTNO 
GROUP BY emp.DEPTNO
ORDER BY emp.DEPTNO;

--(6)	To get the total number of employees, whose salary is more than 3000 for each department.

select emp.DEPTNO,COUNT(emp.EMPNO) as TOTAL_EMP from EMP emp, DEPT dept 
where emp.SAL > 3000
and emp.DEPTNO = dept.DEPTNO 
GROUP BY emp.DEPTNO;

--(7)	TO get the number of the average salary for each department, according to the department name in ascending order

select emp.DEPTNO 
,dept.DNAME
,AVG(emp.SAL) as AVE_SAL 
from EMP emp, DEPT dept where
emp.DEPTNO = dept.DEPTNO 
GROUP BY emp.DEPTNO, dept.DNAME 
ORDER BY dept.DNAME asc;

--(8)	List the statistics of employees who have the same salary in each department, list their department number, salary, and number of employees.

select emp.DEPTNO, emp.SAL , COUNT(emp.EMPNO) as EMP_COUNT 
from EMP emp, DEPT dept
where emp.DEPTNO = dept.DEPTNO
and emp.SAL = emp.SAL
GROUP BY emp.DEPTNO, emp.SAL
ORDER BY emp.DEPTNO;


--(9)	List the number of employees with more than 2 employees in the same department, showing the name of the Department, the name of the area, and the number of the employees in the same department

select dept.DNAME, dept.LOC, COUNT(emp.EMPNO) as EMP_COUNT
from EMP emp, DEPT dept
where emp.DEPTNO = dept.DEPTNO
GROUP BY dept.DNAME, dept.LOC
having COUNT(emp.EMPNO) > 2;

--(10)	List the name and salary of employees whose salaries is higher than the average salary of the entire firm

select ENAME, SAL 
from EMP
where SAL > (select AVG(SAL) from EMP)
ORDER BY SAL ASC;





