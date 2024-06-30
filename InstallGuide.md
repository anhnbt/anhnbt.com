# 

```shell
# Cập nhật danh sách gói
apt update
# Nâng cấp các gói đã cài đặt
apt upgrade
```

## Cài đặt OpenJDK 17

```shell
# Cài đặt OpenJDK 17
apt install openjdk-17-jdk openjdk-17-jre
# Lấy đường dẫn của Java
update-alternatives --config java
# Mở và sửa tệp .bashrc 
vim ~/.bashrc
# Thêm dòng sau vào cuối tệp .bashrc
export JAVA_HOME='/usr/lib/jvm/java-17-openjdk-amd64'
# export PATH=$JAVA_HOME/bin:$PATH
# Lưu lại và cập nhật tệp .bashrc:
source ~/.bashrc
```

## Cài đặt Apache Maven

```shell
# Tải xuống Apache Maven:
wget https://dlcdn.apache.org/maven/maven-3/3.9.8/binaries/apache-maven-3.9.8-bin.tar.gz
# Giải nén tệp đã tải xuống:
tar -xvf apache-maven-3.9.8-bin.tar.gz
# Di chuyển thư mục đã giải nén vào /opt:
sudo mv apache-maven-3.9.8 /opt/
# Đặt biến môi trường M2_HOME trong tệp .bashrc:
vim ~/.bashrc
# Thêm các dòng sau vào cuối tệp .bashrc:
export M2_HOME='/opt/apache-maven-3.9.8'
export PATH=$M2_HOME/bin:$PATH
# Tải lại tệp .bashrc để áp dụng các thay đổi:
source ~/.bashrc

```

## Cài đặt MySQL

```shell
sudo apt update
sudo apt install mysql-server
# Kiểm tra trạng thái MySQL
sudo systemctl status mysql
# Chạy chương trình bảo mật MySQL
sudo mysql_secure_installation
#Đặt mật khẩu cho tài khoản root
#Loại bỏ người dùng ẩn danh
#Vô hiệu hóa đăng nhập root từ xa
#Xóa cơ sở dữ liệu thử nghiệm
#Tải lại các bảng quyền

# Đăng nhập MySQL
mysql
# Tạo tài khoản người dùng anhnbt và đặt mật khẩu:
CREATE USER 'anhnbt'@'localhost' IDENTIFIED BY 'KhoaiTay@2019';
# Cấp quyền cho tài khoản anhnbt:
GRANT ALL PRIVILEGES ON *.* TO 'anhnbt'@'localhost' WITH GRANT OPTION;
# Tải lại các bảng quyền để áp dụng thay đổi:

```

## Cài nginx


```shell
sudo apt update
# Cài đặt Nginx:
sudo apt install nginx
# Kiểm tra trạng thái Nginx để đảm bảo nó đang chạy:
sudo systemctl status nginx
# Khởi động Nginx nếu nó chưa được khởi động
sudo systemctl start nginx
# Cấu hình tường lửa để cho phép lưu lượng HTTP và HTTPS (nếu cần):
sudo ufw allow 'Nginx Full'
sudo ufw reload
# Cho phép kết nối SSH:
sudo ufw allow ssh
```

## 

```shell
# Mở tệp cấu hình cho trang web mới:
sudo vim /etc/nginx/sites-available/anhnbt.com

server {
    listen 80;
    server_name anhnbt.com;
    return 301 $scheme://www.anhnbt.com$request_uri;
}

server {
    listen 80;
    server_name www.anhnbt.com;

    location / {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
}

# Lưu tệp và tạo liên kết đến sites-enabled:
sudo ln -s /etc/nginx/sites-available/anhnbt.com /etc/nginx/sites-enabled/


sudo vim /etc/nginx/sites-available/api.anhnbt.com
server {
    listen 80;
    server_name api.anhnbt.com;

    location / {
        proxy_pass http://localhost:5000;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
}
sudo ln -s /etc/nginx/sites-available/api.anhnbt.com /etc/nginx/sites-enabled/

```