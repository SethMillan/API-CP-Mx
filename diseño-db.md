# Planificacion de la db y del proyecto

**13-15 Dic:** Planificación detallada de la estructura de la base de datos y del proyecto.

**13 Dic** -> Investigación sobre la normalización de DB y diseño de la DB segun las reglas de normalizacion, revision de buenas practicas para mejorar los commits, revision de formato MD

**14 Dic** -> Repaso de Git y GitHub para llevar una estructura organizada

**15 Dic** -> Investigacion de la creacion de APIS, con micronaut, sprignboot u otros lenguajes diferentes a java

## Diseño de la estructura de la DB

|ID Estado | Estado |
|----------|--------|
|    1     |  Mich  |
|    2     |Jalisco |

Conectada con...

|ID Municipio | Municipio | ID Estado |
|-------------|-----------|-----------|
|    1        |  Morelia  |     1     |
|    2        | Zitacuaro |     1     |

Conectada con...

|ID CP |   CP   | ID Municipio |
|------|--------|--------------|
|  1   | 12312  |       1      |
|  2   | 345234 |       2      |

Conectada con...

|ID Colonia |   Colonia   | ID CP |
|-----------|-------------|-------|
|     1     |      a      |   1   |
|     2     |      b      |   2   |
