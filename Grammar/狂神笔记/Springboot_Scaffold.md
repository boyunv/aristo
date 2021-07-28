# Springboot_Scaffold

## 1.Swagger

### 1.配置swagger

#### Swagger的bean实例配置Docket

在配置此参数的时候:首先采用的是点击看源码------当中的APInfo和DocumentationType来进行

*描述*:Docket的信息配置--

![image-20210728205050696](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728205050696.png)

![image-20210728205435731](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728205435731.png)

#### (2),让swagger配置扫描指定的接口

Docket.select()

![image-20210728210824459](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728210824459.png)

#### 配置是否启动swagger

![image-20210728211116874](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728211116874.png)

#### Thinking:

我只希望我的swagger在生产环境中使用,在发布的时候不使用

- 判断是否为生产环境  flag=false

- 注入enable( flag)

- 怎么获取生产环境的值?

- > ![image-20210728212410003](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728212410003.png)

#### 配置API文档分组

```java
.groupeName("柏韵")
```

##### 如何配置多个分组

建立多个Docket

> ![image-20210728213324164](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728213324164.png)

##### 实体类配置

![image-20210728213925460](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728213925460.png)

![image-20210728214127115](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728214127115.png)

![image-20210728214336296](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728214336296.png)

![image-20210728214616889](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728214616889.png)

###### 配置核心

![image-20210728215343273](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728215343273.png)

![image-20210728215446096](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728215446096.png)

![image-20210728215629088](C:\Users\BoYunV\AppData\Roaming\Typora\typora-user-images\image-20210728215629088.png)

