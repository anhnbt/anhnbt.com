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
hoặc bỏ qua test

```
mvn clean package -DskipTests
```

```
nohup java -jar blog-2.0.6-SNAPSHOT.jar --spring.profiles.active=prod > anhnbt-prod-2.0.6.log &
tail -1000f /opt/anhnbt-prod-2.0.6.log
```

`Nohup` là một lệnh Unix cho phép chạy ứng dụng ngay cả khi ngắt kết nối.

`&` là **shell's backgrounding operator**
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