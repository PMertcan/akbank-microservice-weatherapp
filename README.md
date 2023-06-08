# Weather App Microservice Project

## Project Architecture
![image](https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/406643c3-057a-4810-9234-4c59ef2dacd9)

## Project Documentation
Proje kapsamında 3 adet mikroservis yazılmıştır.
- API Gateway Service
- Service Registry
- User Service
- City Service 
- Weather Service

### API Gateway
- API Gateway bütün servislerden önceki yetkilendirme görevini üstleniyor ve buradaki port ile tüm servislere aynı port üzerinden ulaşabiliyorum.

<img width="901" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/549bf406-a0d1-46b2-a30d-bb5d6484060b">

### Service Registry
- Service Registry Eureka Client kullanarak Servisleri tutabilmemizi sağlar ve load balancer görevi yapar.
- 
<img width="1789" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/6f9d1cb8-0316-4140-b31a-bce26793302f">

### User Service
- User Servisi kullanıcının CRUD işlemleri için yazılmıştır. Kullanıcı eğer kayıt olursa Adı , Soyadı , Kullanıcı Adı ve Password'u Database'de tutulur. Password masklanarak tutulur bunu da Password Encoder sağlar.

<img width="1789" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/3909b5f3-20c2-44f8-8161-d614716e8ea8">

<img width="1387" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/21d15507-f7bd-4d7e-9e41-53e26ef1202c">

### City Service
- City Servisi ise User Database'indeki Username datasını kontrol ederek , eğer User Database'inde öyle bir kullanıcı adı varsa , o kullanıcı adını kullanarak şehir oluşturulmasını sağlar. 

- Kullanıcı şehir oluşturduktan sonra , o kullanıcı kendi oluşturduğu bütün şehirleri görüntüleyebilir.

- Kullanıcı oluşturduğu şehrin hava durumunu görüntüleyebilir. Burada da City Servisinin , Weather Servisiyle iletişim kurması gerekir. Eğer kullanıcı City Database'sinde öyle bir şehir oluşturduysa Weather Servisinden şehrin hava durumunu görüntüleyebilir.

<img width="1792" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/5b64def9-1455-48c6-abd5-37dc5a19ab8f">

<img width="1222" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/4f7bdb02-9fa0-4e67-87ad-c495be071e65">


### Weather Service
- Weather Servisi OpenWeatherAPI'sini API sağlayıcı olarak kullanır ek olarak kendisinin host ve portuna çevirebilmesini sağlar.

- Kendi Controller'ında aldığı şehir ismiyle , OpenWeatherAPI'sine istek atar ve o şehre ait 5 günlük 3'er saatlik hava durumunu görüntüleyebilir.

<img width="1222" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/60bd74e1-d2a9-4e3c-b89f-6057a6fd5195">


### Asynchronous Communication (Kafka)
Weather Servisine bir istek atıldığı zaman , Weather Servisi , City Servisine istenilen şehrin datalarını Queue şeklinde iletebiliyor.

### Techs
- Spring Boot
- MySQL
- Eureka Server
- MapStruct
- Swagger
- Maven
- REST Assured
- JUnit
- Kafka





