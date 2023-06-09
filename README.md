# EXP 分支

可以在这里讨论：[discussions](https://github.com/Mr-Z2001/NEU-zhehang/discussions/3)

## 功能计数

- [x] 创建问卷
- [x] 发布问卷
- [x] 答卷页面
- [x] 数据统计

## 运行方式

``` sh
$ mvn clean package
$ java -jar .\target\demo-0.0.1-SNAPSHOT.jar
```

## 数据库组织

数据库名称：myweb

可以从 dump.txt 中恢复 mysql 数据库。

|名称|数据库用途|
| --- | --- |
| `ans_info`    |答案信息|
| `form_info`   |问卷信息|
| `project_info`|项目信息|
| `user_info`   |用户信息|

前两个表定义：

``` sql
CREATE TABLE form_info(
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    projectId VARCHAR(255),
    formName VARCHAR(255),
    formType VARCHAR(255),
    formInfo VARCHAR(255),
    formContent VARCHAR(255),
    startTime DATETIME,
    endTime DATETIME,
    createdBy VARCHAR(255),
    creationDate DATETIME,
    lastUpdatedBy VARCHAR(255),
    lastUpdateDate DATETIME
);
```

``` sql
CREATE TABLE ans_info(
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    projectId VARCHAR(255),
    formId VARCHAR(255),
    ansContent VARCHAR(255),
    createdBy VARCHAR(255),
    creationDate DATETIME
);
```

解决字符问题：

``` sql
alter database myweb character set utf8;
```

## 特殊说明

比较自由的改动了一些原来的内容，所以如果有什么问题，可以从每一个 `*Mapper.xml` 里找到数据库对应设计。

额外增加了 `chart.js` 用于展示统计数据。