# Características:
-   **Función única** : Un rol en específico
-   **Independientes** : Propio proceso y se comunican mediante API
-   **Registro y Autodescubrimiento** : Abstrae la IP y Puerto , hostname
-   **Auto escalado y alta disponibilidad** : Depende la demanda por el tráfico (cuando se requiera) se generan nuevas instancias
-   **Resiliencia y torelarancia a fallos** : como se comporta en las fallas, en el ms en sí o al consumir otro servicio
-   **Balanceo de Cargas** : se define cual instnacia usar
-   **Configuración y entornos** : Estan montandos en diferentes ambientes
-   **API Gateway** : la puerta por donde se consume nuestro ms


# Patrones de diseño de Microservicios
-   **Config Server**: Se basa en centralizar la configuración de un ms
    -   **Servidor de Configuracion**: (Config Server) Servicio que actúa como repositorio central de configuración en archivos .properties o .yml
    -   **Microservicios(Clientes)**: Los ms se conectan al config server para obtener los parámetros de confuguración
