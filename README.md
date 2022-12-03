## Dự án Blog

## Running Spring Boot Application 
```./mvn spring-boot:run```

## Cấu hình chạy project với file env
java -jar blog-1.0.1-SNAPSHOT.jar --spring.profiles.active=development

## Chạy project trên môi trường production
nohup java -jar blog-1.0.1-SNAPSHOT.jar --spring.profiles.active=production > anhnbt.log &

## Actuator

- [actuator/health](http://localhost:8080/actuator/health)
- [actuator](http://localhost:8080/actuator)

## Build CSS
```
npm run css-build
```

## [Persistent Login (Remember-Me) Schema](https://docs.spring.io/spring-security/site/docs/5.5.8/reference/html5/#persistent-login-remember-me-schema)
```
create table persistent_logins (
    username varchar(64) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
);
```

[![Made with Bulma](https://bulma.io/images/made-with-bulma.png)](https://bulma.io?utm_source=badge)