-- mysql

-- 组合两个表
select FirstName,LastName,City,State
from Person left join Address on Person.PersonId=Address.PersonId

-- 第二高的薪水
select (select distinct Salary from Employee
order by Salary desc limit 1,1)as SecondHighestSalary

-- 第N高的薪水
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N=N-1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct Salary from Employee order by Salary desc limit N,1
  );
END