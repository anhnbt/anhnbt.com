## Dự án Blog

## Cấu hình chạy project với file env
java -jar blog-1.0.1-SNAPSHOT.jar --spring.profiles.active=development

## Chạy project trên môi trường production
nohup java -jar blog-1.0.1-SNAPSHOT.jar --spring.profiles.active=production > anhnbt.log &

## Actuator

http://localhost:8080/actuator

## Build CSS
```
npm run css-build
```

[![Made with Bulma](https://bulma.io/images/made-with-bulma.png)](https://bulma.io?utm_source=badge)