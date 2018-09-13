# The problem
Once in a while there are code challenges that require to be solved 😜 here is one of these cases:

The main challenge is to implement the backend for a simple todo list.
* Use Java with any framework you'd like.
* The protocol should be JSON over HTTP.
* Any solution for persistence, as long as it doesn't abstracts SQL.

The only model object is the `TODO` as shown bellow:
```json
TODO {
  "id": TBD,
  "title": String,
  "completed": Boolean
}
```

The API should implement the following endpoints:
```
GET    /                          # Lists all TODOs
PUT    /                          # Create a new TODO

GET    /todo/:id                  # Get TODO
PATCH  /todo/:id                  # Update TODO
DELETE /todo/:id                  # Delete TODO
```

## Example inputs/outputs
These are the expected inputs and outputs for each operation.

### Operation:
`GET    /                          # Lists all TODOs`
#### Input:
N/A
#### Output:
```json
[
	{
		"id": ID,
		"title": "Buy milk",
		"completed": false
	},
	{
		"id": ID,
		"title": "Buy apples",
		"completed": true
	}
	...
]
```

### Operation:
* `GET    /?q=completed              # Lists all completed TODOs`
#### Input:
Query parameter `q` with value `completed`
#### Output:
```json
[
	{
		"id": ID,
		"title": "Buy apples",
		"completed": true
	},
	...
]
```

### Operation:
`PUT    /                          # Create a new TODO`
#### Input:
```json
{
	"title": "Buy milk",
	"completed": false
}
```
#### Output:
```json
{
	"id": ID,
	"title": "Buy milk",
	"completed": false
}
```

### Operation:
`GET    /todo/:id                  # Get TODO`
#### Input:
N/A
#### Output:
```json
{
	"id": ID,
	"title": "Buy milk",
	"completed": false
}
```

### Operation:
`PATCH  /todo/:id                  # Update TODO`
#### Input:
```json
{
	"id": ID,
	"completed": true
}
```
#### Output:
```json
{
	"id": ID,
	"title": "Buy milk",
	"completed": true
}
```

### Operation:
`DELETE /todo/:id                  # Delete TODO`
#### Input:
N/A
#### Output:
```json
{
	"id": ID
}
```
---
# The solution
In order to solve the proposed problem, [Spring Boot](http://spring.io/projects/spring-boot) framework was used to implement the server. Additionally it was used [Spring Data JPA](https://projects.spring.io/spring-data-jpa/) as a clean and logic way to organize the access to the database information (still missing the DTO objects, I know...), and without abstracting SQL. Finally, it was also used [HirakiCP](https://github.com/brettwooldridge/HikariCP) which is a high performance JDBC connection pool ready to handle a couple (!) of connections. Of course it is a overkill, but you never now tommorows day!

For database purposes it was used [PostgreSQL](https://www.postgresql.org) which can pretty much handle the job. Additionally the databases and table creation scripts are included [here](codechallenge_cdcy/tree/master/codechallenge_cdcy-repo/db) so you can configure the database as needed. They can be executed making use of the following command:
```sh
psql -U postgres -a -f "codechallenge_cdcy-repo\db\Create Database.sql"
psql -U postgres -d codechallenge_cdcy -a -f "codechallenge_cdcy-repo\db\Create Database.sql"
```
For the test script... well it is the same command!

Finally, the project was developed using Maven, so it should execution should be pretty straight forward.
For the lazy ones:
```sh
cd codechallenge_cdcy-web
mvn complile
```
