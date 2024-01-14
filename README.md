# API DE CODIGOS POSTALES

## Introduccion

Esta práctica está diseñada para introducir a los programadores en el desarrollo de backend utilizando datos reales. Se espera que el participante desarrolle una API de backend capaz de gestionar y consultar información sobre los códigos postales de México, usando unicamente la peticion HTTP GET

## Base URL

La url para todos los endpoints es la siguiente `http://localhost:8080`

## Recursos disponibles

### 1. Estado

#### Obtener todos los estados 

- **Endpoint**: `/api/v1/estados`
- **Descripcion**: Obtiene mediante GET los estados en la BD
- **Respuesta**:
*(Respuesta reducida por exceso de datos)*
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
  }
  ]
}
```

### 2. Municipio

#### Obtener todos los municipios

- **Endpoint**: `/api/v1/municipios`
- **Descripcion**: Obtiene mediante GET los municipios en la BD
- **Respuesta**:
*(Respuesta reducida por exceso de datos)*
```json
{
  "error": false,
  "mensaje": "Estados encontrados : 2475",
  "object": [
    {
      "idEdo": 1,
      "idMcpio": 1,
      "municipio": "Aguascalientes"
    },
    {
      "idEdo": 1,
      "idMcpio": 2,
      "municipio": "San Francisco de los Romo"
    },
    {
      "idEdo": 1,
      "idMcpio": 3,
      "municipio": "El Llano"
    },
    {
      "idEdo": 1,
      "idMcpio": 4,
      "municipio": "Rincon de Romos"
    },
    {
      "idEdo": 1,
      "idMcpio": 5,
      "municipio": "Cosio"
    }
  ]
}
```
### Obtener los municipios de un estado

- **Endpoint**: `/api/v1/municipios/estado/{id}`
- **Descripcion**: Obtiene mediante GET los municipios en la BD filtrando por estado
- **Ejemplo**: `/api/v1/municipios/estado/16`
- **Respuesta**:
*(Respuesta reducida por exceso de datos)*
```json
{
  "error": false,
  "mensaje": "Municipios encontrados : 113",
  "object": [
    {
      "idEdo": 16,
      "idMcpio": 796,
      "municipio": "Morelia"
    },
    {
      "idEdo": 16,
      "idMcpio": 797,
      "municipio": "Huaniqueo"
    },
    {
      "idEdo": 16,
      "idMcpio": 798,
      "municipio": "Coeneo"
    },
    {
      "idEdo": 16,
      "idMcpio": 799,
      "municipio": "Quiroga"
    }
  ]
}
```

### 3. Codigo Postal

#### Obtener todos los CPs

### 4. Asentamiento

#### Obtener todos los asentamientos 

