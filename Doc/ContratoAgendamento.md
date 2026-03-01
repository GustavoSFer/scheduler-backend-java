## [POST] /agendamentos

[Body] - Enum pago: `PAGO, CANCELADO, ESTORNADO, PENDENTE`
```
{
  "dataAgendamento": "2026-03-17T14:30:00",
  "valor": 50.00,
  "pessoa": 1,
  "pago": "PENDENTE" (opcional, se não for fornecido, o valor padrão será PENDENTE)
}
```

[Response]
```
{
	"id": 5,
	"dataAgendamento": "2026-03-17T14:30:00",
	"valor": 50,
	"pessoa": {
		"id": 1,
		"nome": "Gustavo Fernandes",
		"email": "Gustavo@gmail.com",
		"telefone": "119658954112"
	},
	"pago": "PENDENTE"
}
```

## [PUT] /agendamentos/{id}

[Body]
```
{
  "pago": "CANCELADO"
}
```

[Response]
```
{
	"id": 1,
	"dataAgendamento": "2026-02-15T14:30:00",
	"valor": 150.75,
	"pessoa": 1,
	"pago": "CANCELADO"
}
```

## [GET] /agendamentos
[Response]
```
[
	{
		"id": 1,
		"dataAgendamento": "2026-02-15T14:30:00",
		"valor": 150.75,
		"pessoa": 1,
		"pago": "PAGO"
	},
	{
		"id": 2,
		"dataAgendamento": "2026-02-10T14:30:00",
		"valor": 50,
		"pessoa": 1,
		"pago": "PAGO"
	},
	{
		"id": 3,
		"dataAgendamento": "2026-02-17T14:30:00",
		"valor": 50,
		"pessoa": 1,
		"pago": "PAGO"
	},
	{
		"id": 4,
		"dataAgendamento": "2026-03-17T14:30:00",
		"valor": 50,
		"pessoa": 1,
		"pago": "PENDENTE"
	}
]
```

## [GET] /agendamentos/{id}
[Response]
```
{
	"id": 1,
	"dataAgendamento": "2026-02-15T14:30:00",
	"valor": 150.75,
	"pessoa": 1,
	"pago": "PAGO"
}
```

## [GET - HOJE] /agendamentos/today
[Response]
```
[
	{
		"id": 3,
		"dataAgendamento": "2026-02-17T14:30:00",
		"valor": 50,
		"pessoa": 1,
		"pago": "PAGO"
	}
]
```

## [GET - FILTRO DATA] /agendamentos/filterData
[Query Params]
- `dataAgendamentoInicio`: Data de início 2026-01-17T14:30:00
- `dataAgendamentoFim`: Data de fim 2026-02-17T14:30:00

[Response]
```
[
	{
		"id": 1,
		"dataAgendamento": "2026-02-15T14:30:00",
		"valor": 150.75,
		"pessoa": 1,
		"pago": "ESTORNADO"
	},
	{
		"id": 2,
		"dataAgendamento": "2026-02-10T14:30:00",
		"valor": 50,
		"pessoa": 1,
		"pago": "PAGO"
	},
	{
		"id": 3,
		"dataAgendamento": "2026-02-17T14:30:00",
		"valor": 50,
		"pessoa": 1,
		"pago": "PAGO"
	},
	{
		"id": 4,
		"dataAgendamento": "2026-03-17T14:30:00",
		"valor": 50,
		"pessoa": 1,
		"pago": "PENDENTE"
	}
]
```