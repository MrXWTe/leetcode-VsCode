--
-- @lc app=leetcode.cn id=176 lang=mysql
--
-- [176] 第二高的薪水
--
# Write your MySQL query statement below
select max(Salary) as SecondHighestSalary from Employee
where Salary<(select max(Salary) from Employee);

