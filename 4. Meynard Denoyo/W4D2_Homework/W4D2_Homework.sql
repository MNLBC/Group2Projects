SELECT * FROM emp;
SELECT * FROM dept;

--1
SELECT * FROM emp WHERE sal > 3000;

--2
SELECT * FROM emp WHERE ename LIKE 'S%';

--3
SELECT * FROM emp WHERE ename IN ('SMITH','ALLEN','FORD');

--4
SELECT e.empno,
  e.ename,
  d.dname
FROM emp e
LEFT OUTER JOIN dept d
ON e.deptno   = d.deptno
WHERE d.dname = 'SALES';

--5
SELECT TO_CHAR(AVG(e.sal),'FM9999999.00') AS AVG_SALARY,
  MIN(e.sal)                              AS MIN_SALARY,
  MAX(e.sal)                              AS MAX_SALARY,
  SUM(e.sal)                              AS SUM_SALARY,
  d.dname
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
GROUP BY d.dname;

--6
SELECT COUNT(e.ename) AS NUMBER_OF_EMPLOYEES,
  d.dname
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
AND e.sal   > 3000
GROUP BY d.dname;

--7
SELECT TO_CHAR(AVG(e.sal),'FM9999999.00') AS AVG_SALARY,
  d.dname
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
GROUP BY d.dname
ORDER BY AVG(e.sal);

--8
SELECT d.deptno,
  a.sal,
  COUNT(a.ename) AS NUMBER_OF_EMPLOYEES
FROM emp a
INNER JOIN emp b
ON a.sal = b.sal
INNER JOIN dept d
ON a.deptno  = d.deptno
AND a.ename != b.ename
GROUP BY d.deptno,
  a.sal;

--9
SELECT d.dname,
  d.loc,
  COUNT(e.ename) AS NUMBER_OF_EMPLOYEES
FROM emp e
INNER JOIN dept d
ON e.deptno           = d.deptno
HAVING COUNT(e.ename) > 2
GROUP BY d.dname,
  d.loc;
  
--10
SELECT ename, sal FROM emp WHERE sal >
  (SELECT AVG(sal) FROM emp
  );