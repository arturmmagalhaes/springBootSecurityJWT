Tive problemas com o Cors, fiz os teste com o Postman.

breakpoints:

localhost:8080/api/auth/login
body: {
    "nome": "Admin",
    "email": "admin@admin",
    "senha": "admin"
}

atualizar
PUT localhost:8080/api/docs/:id
body: {
    "nome": "Atividade2",	
	"atributos": "atributos",
	"data": "12/10/2020",
	"codigo": "001",
	"resumo": "resumo",
	"idUsuario": 1
}
header: TOKEN

Listagem
GET localhost:8080/api/docs
header: TOKEN

Inserir
POST localhost:8080/api/docs
body: {
    "nome": "Atividade",	
	"atributos": "atributos",
	"data": "12/10/2020",
	"codigo": "001",
	"resumo": "resumo",
	"idUsuario": 1
}
header: TOKEN

Delete
localhost:8080/api/docs/:id
header: TOKEN
