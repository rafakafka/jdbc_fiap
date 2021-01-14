# fiap-persistence-ecommerce-jdbc
Trabalho de Persistente

Adicionar Cliente 

http://localhost:8080/client/v1/add

payload
{
	"name": "Catarina Jones",
	"documentNumber":"879879667679",
	"birthDate": "1979-04-01T00:00:00-03:00",
	"address": [{
		"street": "Rua tres",
		"number": "42 B",
		"neighborhood": "Vila Matarazzo",
		"city":"São Paulo",
		"state":"São Paulo",
		"zipCode": "123445-009"
	}]
}

Adicionar um endereço ao cliente

http://localhost:8080/client/v1/add/{clientId}/address

payload
{
	"street": "Rua teste",
	"number": "42 B",
	"neighborhood": "Vila Matarazzo",
	"city":"São Paulo",
	"state":"São Paulo",
	"zipCode": "123445-009"
}

Adicionar produto

http://localhost:8080/product/v1/save

payload

{
	"name": "Geladeira",
	"quantity": "10",
	"actualUnitValue": 1055.32
}
