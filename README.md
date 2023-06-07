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
- API Gateway bütün servislerden önceki Load Balancing'i sağlar. Bunun haricinde tek bir portta tüm servisleri birleştirebilir.

### Service Registry
- Service Registry Eureka Client kullanarak Servisleri tutabilmemizi sağlar.
<img width="1785" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/6f0c528c-5eab-40d1-abc1-b30f206ca8fa">

### User Service
- User Servisi kullanıcının CRUD işlemleri için yazılmıştır. Kullanıcı eğer kayıt olursa Adı , Soyadı , Kullanıcı Adı ve Password'u Database'de tutulur. Password masklanarak tutulur bunu da Password Encoder sağlar.

<img width="1785" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/6764d33f-b159-401c-b10e-aa23e59696ad">

### City Service
- City Servisi ise User Database'indeki Username datasını kontrol ederek , eğer User Database'inde öyle bir kullanıcı adı varsa , o kullanıcı adını kullanarak şehir oluşturulmasını sağlar. 

- Kullanıcı şehir oluşturduktan sonra , o kullanıcı kendi oluşturduğu bütün şehirleri görüntüleyebilir.

- Kullanıcı oluşturduğu şehrin hava durumunu görüntüleyebilir. Burada da City Servisinin , Weather Servisiyle iletişim kurması gerekir. Eğer kullanıcı City Database'sinde öyle bir şehir oluşturduysa Weather Servisinden şehrin hava durumunu görüntüleyebilir.

<img width="1785" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/8a77c9b6-0850-484c-88d9-4a240ba9cc7e">

### Weather Service
- Weather Servisi OpenWeatherAPI'sini API sağlayıcı olarak kullanır ek olarak kendisinin host ve portuna çevirebilmesini sağlar.

- Kendi Controller'ında aldığı şehir ismiyle , OpenWeatherAPI'sine istek atar ve o şehre ati 5 günlük 3'er saatlik hava durumunu görüntüleyebilir.

<img width="1415" alt="image" src="https://github.com/PMertcan/akbank-microservice-weatherapp/assets/135176622/378d9c5e-acea-4b8b-a2fe-95df0e7a9b4d">




