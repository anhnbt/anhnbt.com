## AnhNBT

## Development

Ứng dụng có 2 file cấu hình môi trường `production` và `development`. Mặc định chạy môi trường `development`

```
./mvn spring-boot:run
```

## Production
Đầu tiên cần build project ra file jar.
```
mvnw clean package
```

```
nohup java -jar blog-1.0.3-SNAPSHOT.jar --spring.profiles.active=prod > anhnbt.log &
```

## Actuator

- [actuator/health](http://localhost:8080/actuator/health)
- [actuator](http://localhost:8080/actuator)

## Build Bulma

```
npm install
```

```
npm run css-build
```
## Build Bootstrap
```
npm i --save-dev webpack webpack-cli webpack-dev-server
npm i --save bootstrap @popperjs/core
npm i --save-dev autoprefixer css-loader postcss-loader sass sass-loader style-loader
```

[![Made with Bulma](https://bulma.io/images/made-with-bulma.png)](https://bulma.io?utm_source=badge)