# Weather App Microservice Project

## Project Architecture
![weatherapp-archtitecture](https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/11e0c405-9583-416a-a7da-92955f700e9e)

## Project Documentation
Proje kapsamında 3 adet mikroservis yazılmıştır.
- API Gateway Service
- Service Registry
- User Service
- City Service 
- Weather Service

### API Gateway
- API Gateway bütün servislerden önceki yetkilendirme görevini üstleniyor.

### Service Registry
- Service Registry Eureka Client kullanarak Servisleri tutabilmemizi sağlar , servis iletişimini tek bir yerden yapmamızı sağlar ve load balancer görevi yapar.
<img width="1785" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/6f0c528c-5eab-40d1-abc1-b30f206ca8fa">

### User Service
- User Servisi kullanıcının CRUD işlemleri için yazılmıştır. Kullanıcı eğer kayıt olursa Adı , Soyadı , Kullanıcı Adı ve Password'u Database'de tutulur. Password masklanarak tutulur bunu da Password Encoder sağlar.

<img width="1785" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/6764d33f-b159-401c-b10e-aa23e59696ad">

<img width="1316" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/18306271-5d9c-4b96-aeaf-789dc94f4113">

### City Service
- City Servisi ise User Database'indeki Username datasını kontrol ederek , eğer User Database'inde öyle bir kullanıcı adı varsa , o kullanıcı adını kullanarak şehir oluşturulmasını sağlar. 

- Kullanıcı şehir oluşturduktan sonra , o kullanıcı kendi oluşturduğu bütün şehirleri görüntüleyebilir.

- Kullanıcı oluşturduğu şehrin hava durumunu görüntüleyebilir. Burada da City Servisinin , Weather Servisiyle iletişim kurması gerekir. Eğer kullanıcı City Database'sinde öyle bir şehir oluşturduysa Weather Servisinden şehrin hava durumunu görüntüleyebilir.

<img width="1785" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/8a77c9b6-0850-484c-88d9-4a240ba9cc7e">

<img width="1316" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/20559d16-05bd-43a0-a2ba-1c37549e9f3d">

<img width="1148" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/f0358a79-4a68-4cf1-858b-98f24b94031e">

<img width="1148" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/58049bd2-f37e-4a1f-bc52-e2fe97cd814c">

<img width="1148" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/fc1ed1e4-2ed3-4d7f-ac80-0e99dc365fc6">

### Weather Service
- Weather Servisi OpenWeatherAPI'sini API sağlayıcı olarak kullanır ek olarak kendisinin host ve portuna çevirebilmesini sağlar.

- Kendi Controller'ında aldığı şehir ismiyle , OpenWeatherAPI'sine istek atar ve o şehre ati 5 günlük 3'er saatlik hava durumunu görüntüleyebilir.

<img width="1415" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/ca6819e6-e39f-424f-a9d7-0613a3578081">

<img width="1148" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/94df46a9-78a0-414f-b56b-120abe3caf28">






