## AnhNBT

## Development

Ứng dụng có 2 file cấu hình môi trường `production` và `development`.

```
java -Dspring.profiles.active=development -jar blog-1.0.1-SNAPSHOT.jar
```

## Production
```
nohup java -jar blog-1.0.1-SNAPSHOT.jar --spring.profiles.active=production > anhnbt.log &
```

## Actuator

- [actuator/health](http://localhost:8080/actuator/health)
- [actuator](http://localhost:8080/actuator)

## Build

```
npm install
```

```
npm run css-build
```

```
./mvn spring-boot:run
```

```
mvnw clean package
```

[![Made with Bulma](https://bulma.io/images/made-with-bulma.png)](https://bulma.io?utm_source=badge)