# NEU-zhehang
NEU实训-哲航调查问卷

---
The main branch only contains the 2nd week's missions. Please turn to branch 'exp' for further missions.
---

# 项目简介
东北大学计算机/软件学院实训项目，调查问卷

## 关键词
> Java
> 
> SpringBoot
> 
> Redis
> 
> MySQL
>
> Maven
> 
---

## 配置环境
以下命令只用于检查环境是否配置正确，如不满足，请查找相关资料进行配置

默认在Windows下开发。
笔者用的是IDEA2023版本，其他版本未测试，但应该都可以。
### Java8
```bash
java -version
```
结果返回含有`java version "1.8.0_xxx"`即可
### Maven
```bash
mvn -v
```
结果返回含有`Apache Maven x.x.x`即可
### MySQL
```bash
mysql -V
```
结果返回含有`mysql  Ver x.x.x`即可
### Redis (此项为Copilot自动生成，等第四周的再确定)
```bash
redis-cli -v
```
结果返回含有`redis server x.x.x`即可

---

## 下载后需要修改哪些？
### 1. 项目配置
>src/main/resources/application.yml

spring.datasource.url: jdbc:mysql://localhost:3306/<这里改成你自己的数据库名称>\
spring.datasource.username: <这里改成你自己的数据库用户名>\
spring.datasource.password: <这里改成你自己的数据库密码>

**注意不要将自己的信息上传**\
**注意不要将自己的信息上传**\
**注意不要将自己的信息上传**

>src/main/resources/mybatis-config.xml

```xml
<configuration>
    <environments default = "development">
        <property name = "url" 
                  value = "jdbc:mysql://localhost:3306/<数据库名称>"/>
        <property name = "username" value = "<数据库用户名>"/>
        <property name = "password" value = "<数据库密码>"/>
    </environments>
</configuration>
```

### 2. 数据库表结构
>src/main/resources/mapper/*Mapper.xml

这写xml文件里有sql查询语句，需要根据自己的数据库表结构进行修改

如果你不想改，可以直接按我的数据库改你的数据库。

#### user_info
```sql
create table user_info(
      ID varchar(255) primary key,
      username varchar(255),
      password varchar(255),
      start_time datetime,
      stop_time datetime,
      status varchar(255),
      created_by varchar(255),
      creation_date datetime,
      last_update_by varchar(255),
      last_update_date datetime
      );
```

#### project_info
```sql
create table project_info(
    ID varchar(255) primary key,
    userId varchar(255),
    projectName varchar(255),
    projectContent varchar(255),
    createdBy varchar(255),
    creationDate datetime,
    lastUpdatedBy varchar(255),
    lastUpdateDate datetime
    );
```

### 3. log文件
>logs/info.log

一定要自己跑Test来生成。

如果Test实在跑不起来，那就要改log的时间。格式如下：

```
YYYY-MM-DD HH:MM:SS[ LEVEL ]>>MESSAGE
```
**说明：**

> `MM`和`DD`是两位数，如果你的月份或日期是个位数，那么就要在前面加个`0`。`HH:MM:SS`同理。

> `LEVEL`有`INFO`、`WARN`、`ERROR`三种，分别对应不同的日志级别。目前生成的都是`INFO`

> `MESSAGE`是你想要记录的信息，可以是任意字符串。建议改一改。

## 打包

由于打包文件的.jar文件可以看到其修改时间，所以要自己打包。

在IDEA的右侧有个Maven Projects，点开后有个Lifecycle，点开后有个package，双击即可。

打包后的文件在target文件夹下。demo-0.0.1-SNAPSHOT.jar
