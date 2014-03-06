Coding assignment for LiftOff
————————————————————————————

Data Models:

User
———
- username
- password
- userGroup

Delivery
———————
- id
- description
- source
- destination
- status
- timestamp
- username (FK)

API endpoints:

/user (Access methods: GET, POST)
/user/{id} (Access methods: GET)

/delivery (Access methods: GET) - list of deliveries

/delivery/{id} (Access methods: GET, PUT, DELETE)

/delivery/since/{noOfDays} (Access methods: GET) - list of deliveries.
noOfDeliveries in {“1”, “7”, “30”}

/delivery/status/{status} (Access methods: GET) - list of deliveries.


TODO:
1. Handle the user authentication in a better way using spring security. Currently a very crude form of authentication is implemented.
2. Tests need to be written, there are no tests currently.
3. SQL query written for the scenario - “Admin views deliveries based on time interval”. Might fail for different databases. Needs to be written in HQL or a better design needs to be implemented.

