# API DE CODIGOS POSTALES

## Introduccion

Esta práctica está diseñada para introducir a los programadores en el desarrollo de backend utilizando datos reales. Se espera que el participante desarrolle una API de backend capaz de gestionar y consultar información sobre los códigos postales de México, usando unicamente la peticion HTTP GET

## Base URL

La url para todos los endpoints es la siguiente `http://localhost:8080`

## Recursos disponibles

### 1. Estado

#### Obtener todos los estados 

- **Endpoint**: `/api/v1/estados`
- **Descripcion**: Get details of a user by providing the user ID.
- **Ejemplo**: `/users/123`
- **Respuesta**:
```json 
{
  "error": false,
  "mensaje": "Estados encontrados :32",
  "object": [
  {
  "idEdo": 1,
  "estado": "Aguascalientes"
  },
  {
  "idEdo": 2,
  "estado": "Baja_California"
  },
  {
  "idEdo": 3,
  "estado": "Baja_California_Sur"
  },
  {
  "idEdo": 4,
  "estado": "Campeche"
  },
  {
  "idEdo": 5,
  "estado": "Coahuila_de_Zaragoza"
  },
  {
  "idEdo": 6,
  "estado": "Colima"
  },
  {
  "idEdo": 7,
  "estado": "Chiapas"
  },
  {
  "idEdo": 8,
  "estado": "Chihuahua"
  },
  {
  "idEdo": 9,
  "estado": "Distrito Federal"
  },
  {
  "idEdo": 10,
  "estado": "Durango"
  },
  {
  "idEdo": 11,
  "estado": "Guanajuato"
  },
  {
  "idEdo": 12,
  "estado": "Guerrero"
  },
  {
  "idEdo": 13,
  "estado": "Hidalgo"
  },
  {
  "idEdo": 14,
  "estado": "Jalisco"
  },
  {
  "idEdo": 15,
  "estado": "Mexico"
  },
  {
  "idEdo": 16,
  "estado": "Michoacan_de_Ocampo"
  },
  {
  "idEdo": 17,
  "estado": "Morelos"
  },
  {
  "idEdo": 18,
  "estado": "Nayarit"
  },
  {
  "idEdo": 19,
  "estado": "Nuevo_Leon"
  },
  {
  "idEdo": 20,
  "estado": "Oaxaca"
  },
  {
  "idEdo": 21,
  "estado": "Puebla"
  },
  {
  "idEdo": 22,
  "estado": "Queretaro"
  },
  {
  "idEdo": 23,
  "estado": "Quintana_Roo"
  },
  {
  "idEdo": 24,
  "estado": "San_Luis_Potosi"
  },
  {
  "idEdo": 25,
  "estado": "Sinaloa"
  },
  {
  "idEdo": 26,
  "estado": "Sonora"
  },
  {
  "idEdo": 27,
  "estado": "Tabasco"
  },
  {
  "idEdo": 28,
  "estado": "Tamaulipas"
  },
  {
  "idEdo": 29,
  "estado": "Tlaxcala"
  },
  {
  "idEdo": 30,
  "estado": "Veracruz_de_Ignacio_de_la_Llave"
  },
  {
  "idEdo": 31,
  "estado": "Yucatan"
  },
  {
  "idEdo": 32,
  "estado": "Zacatecas"
  }
  ]
  }
```



### 2. Municipio

#### Obtener todos los municipios

### 3. Codigo Postal

#### Obtener todos los CPs

### 4. Asentamiento

#### Obtener todos los asentamientos 

