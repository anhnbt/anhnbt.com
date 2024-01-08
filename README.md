# AnhNBT

## System Requirements

| Phần mềm         | Phiên bản                                           |
| ---------------- | --------------------------------------------------- |
| JDK              | 11                                                  |
| Maven            | 3.9+                                                |
| MySQL or MariaDB | MySQL Community Server 8.2.0 or MariaDB Server 11.x |

Ứng dụng có 2 file cấu hình môi trường `production` và `development`. Mặc định chạy môi trường `development`.

## Hướng dẫn build

Đầu tiên cần build project ra file `.jar`.

```shell
mvnw clean package
```

hoặc bỏ qua test

```shell
mvn clean package -DskipTests
```

Sau khi build thành công. Sao chép tệp `blog-<version>-SNAPSHOT.jar` trong thư mục `target` lên server vào thư mục `/opt`.

Chạy dự án:

```shell
nohup java -jar blog-2.0.9-SNAPSHOT.jar --spring.profiles.active=prod > anhnbt-prod-2.0.9.log &
```

- `nohup` là một lệnh Unix cho phép chạy ứng dụng ngay cả khi ngắt kết nối.

- `&` là **shell's backgrounding operator**

Xem logs theo thời gian thực:

```shell
tail -1000f /opt/anhnbt-prod-2.0.9.log
```

## Build Bulma

```shell
npm install
```

```shell
npm run css-build
```
