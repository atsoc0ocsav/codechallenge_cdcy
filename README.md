Once in a while there are code challenges that require to be solved :) here is one of this cases:

The main challenge is to implement the backend fot a simple todo list.
* Use Java with any framework you'd like.
* The protocol should be JSON over HTTP.
* Any solution for persistence, as long as it doesn't abstracts SQL.

The only model object is the `TODO` as shown bellow:
```json
TODO {
  "id": TBD
  "title": String
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
{
	"id": ID,
	"completed": true
}
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
