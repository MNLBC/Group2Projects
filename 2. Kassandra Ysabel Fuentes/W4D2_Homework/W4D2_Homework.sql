--1
SELECT * FROM emp WHERE sal > 3000;


--2
SELECT empno, ename FROM emp WHERE ename LIKE 'S%';


--3
SELECT empno, ename FROM emp WHERE ename IN ('SMITH', 'ALLEN', 'FORD');


--4
SELECT a.ename,
  b.deptno
FROM emp a,
  dept b
WHERE a.deptno=b.deptno
AND b.DNAME   ='SALES';


--5
SELECT b.dname,
  AVG(a.sal) AS ave_salary,
  MIN(a.sal) AS min_salary,
  MAX(a.sal) AS max_salary,
  SUM(a.sal) AS total
FROM emp a
INNER JOIN dept b
ON a.deptno=b.deptno
GROUP BY b.dname;


--6
SELECT COUNT(empno) "Salary more than 3000" 
FROM emp a, dept b
WHERE a.deptno=b.deptno
and a.sal > 3000;


--7
SELECT b.dname,
  AVG(a.sal) AS ave_salary
FROM emp a
INNER JOIN dept b
ON a.deptno=b.deptno
GROUP BY b.dname;


--8
SELECT a.deptno,
  a.sal,
  COUNT(a.deptno)
FROM emp a,
  emp b
WHERE a.sal  =b.sal
AND a.empno != b.empno
GROUP BY a.deptno,
  a.sal;
  
  
--9
SELECT c.dname,
  c.loc,
  COUNT(a.empno)
FROM emp a,
  dept c
WHERE a.deptno        = c.deptno
HAVING COUNT(a.empno) > 2
GROUP BY c.dname,
  c.loc;
  
  
--10
SELECT ename, sal FROM emp WHERE sal >
  (SELECT AVG(sal) FROM emp
  );