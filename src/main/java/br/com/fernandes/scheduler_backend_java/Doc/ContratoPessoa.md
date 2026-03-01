## [POST] /pessoas

[Body]
```
{
	"nome": "Gustavo Fernandes",
	"telefone": "119658954112",
	"email": "Gustavo@gmail.com"
}
```

[Response]
```
{
	"id": 1,
	"nome": "Gustavo Fernandes",
	"email": "Gustavo@gmail.com",
	"telefone": "119658954112"
}
```

## [GET] /pessoas
[Response]
```
[
	{
		"id": 1,
		"nome": "Gustavo Fernandes",
		"email": "Gustavo@gmail.com",
		"telefone": "119658954112"
	}
]
```

## [GET] /pessoas/{id}
[Response]
```
{
	"id": 1,
	"nome": "Gustavo Fernandes",
	"email": "Gustavo@gmail.com",
	"telefone": "119658954112"
}
```

## [PUT] /pessoas/{id}
[Body]
```
{
	"nome": "Gustavo Santos",
	"telefone": "119658954112",
	"email": "Gustavo@gmail.com"
}
```

[Response]
```
{
	"id": 1,
	"nome": "Gustavo Santos",
	"email": "Gustavo@gmail.com",
	"telefone": "119658954112"
}
```

## [DELETE] /pessoas/{id}
[Response]
```
Statud code 204 No Content
```