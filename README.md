# Microservicios

## Características
    * La aplicación se prepara en pequeños componentes con una responsabilidad limitada
    * Despliegue independiente
    * Protocolos ligeros de comunicación como HHTP o JSON
## Objetivos 
    * Flexible   : desacoplados
    * Resiliente : tolerante a falla
    * Escalable  : en forma horizontal o vertical
        -Horizontal : no se modifican los servidores existentes, se agrega nuevos servidores al balanceador
        -Vertical   : redimensiona un servidor existente
    * Auto-Scaling  : Redimensionar los recursos de acuerdo a la demanda de la aplicación 
## Modelos de Cloud Computing
    * Infrastructure as a Service (IaaS) : El proveedor cuenta con la infrastructura como servidores, almacenamiento, redes
       -Los clientes no tienen que gestionar, mantener ni actualizar su propia infraestructura de centro de datos, pero son los responsables del sistema operativo, middleware, máquinas virtuales y cualquier aplicación o dato. 
    * Platform as a Service (PaaS) : Se provee una plataforma que permite a los usuarios enfocarse en el desarrollo ( bd, hosting, kafka , clusters)
       -Los clientes todavía tienen que escribir el código y gestionar sus datos y aplicaciones, el proveedor de servicios en la nube se encarga del entorno de creación y despliegue de aplicaciones. 
    * Software as a Service (SaaS) : Permite a los usuario utilizar una aplicación en especifico sin tenes que desplegarla o mantenerla
       -La mayoría de las aplicaciones de SaaS se accede directamente a través de un navegador web, Los clientes no tienen que descargar ni instalar nada en sus dispositivos.
    * Container as a Service (CaaS) : Modelo intermedio ente IaaS y PaaS, con CaaS se puede desplegar ms de  una forma ligera a través de contenedores virtuales portables
       -Los clientes aún tienen que escribir el código y gestionar sus datos y aplicaciones. Sin embargo, el entorno para crear e implementar aplicaciones en contenedores lo gestiona y mantiene el proveedor de servicios en la nube
    * Functions as a Service (FaaS) : Serverless Architecture , ejecutar código con  necesidad de mantener ningún tipo de servidor

## Características
    * Dimensionamiento : Determinar el tamaño de un microservicio, delimitar
    * Administración de ubicaciones : Un microservicio debe de ser simple de ubicar, iniciar, apagar.
    * Resilencia : Debe de tolerar fallas  y en caso que no, debe de fallar rápido para poder redigirir el tráfico, que hacer cuando un ms falla
    * Replicable : Misma versión del código, para que las respuestas de neogicio sean las mismas
    * Escalables : El acomplamiento en la comunicación debe de ser mínima para un rápido crecimiento o decremento
