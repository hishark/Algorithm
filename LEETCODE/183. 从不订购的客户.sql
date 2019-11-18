select customers.name as 'Customers'
from customers
where customers.id not in(
    select CustomerId from orders
);
