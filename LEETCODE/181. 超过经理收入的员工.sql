select a.Name as 'Employee'
from Employee as a, Employee as b
where a.ManagerId = b.Id and a.Salary > b.Salary