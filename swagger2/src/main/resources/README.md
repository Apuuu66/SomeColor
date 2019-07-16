1. 引入依赖
```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
```

2. 写配置类、写api
3. 启动并访问 http://localhost:8080/swagger-ui.html


jpa默认创建表为myisam引擎

新增 hibernate.properties

` hibernate.dialect.storage_engine=innodb`