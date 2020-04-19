select Email from
(select Email, count(Email) as cnt 
from Person
group by Email) as temp
where cnt > 1;