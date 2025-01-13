# Conectar OPEN AI con SPRINGBOOT

Este repositorio es únicamente para probar la conexión con la API de Open Ai.

---

### Pasos para configurar el proyecto:

1. Copiar el archivo `application.properties.example` y cambiar el nombre a `application.properties`:
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```

2. Abrir el archivo `application.properties` y editar los valores con tus propias configuraciones:
   ```properties
    #Application Name
    spring.application.name =

    # API Url
    OPEN_AI_URL = https://api.openai.com/v1/chat/completions

    # API Key
    OPEN_AI_KEY =
   ```

---

## Recursos Utilizados


- [Documentación oficial de OpenAI](https://platform.openai.com/docs/overview)
- [Video: "Conectando Spring Boot con ChatGPT para usar los servicios vía API"](https://www.youtube.com/watch?v=u-Y2eTiXKVs)
- [Video: "Integrate ChatGPT with Spring Boot"](https://www.youtube.com/watch?v=Z7yBs3zPfsg)
- [Video: "Consumir API de OPEN AI"](https://www.youtube.com/watch?v=BRagxhJVrxw)
- [Lista de reproducción: "Aprende Inteligencia Artificial"](https://www.youtube.com/playlist?list=PL-Ogd76BhmcC_E2RjgIIJZd1DQdYHcVf0)



