# Springboot的自动注解

## 1.自动配置

Pom.xml

```xml
springboot-boot-dependencies:核心依赖在父工程中
```

启动表

- ```xml
  <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter</artifactId>
              <version>2.5.2</version>
  </dependency>
  ```

- ```
  spring-boot-starter-web:自动导入web的相关依赖
  ```

- 也就是提前将一些需要用到的场景进行封装在父依赖中

(3)主程序

```java	
//标注他是一个springboot的启动类
@SpringBootApplication

public class SbPracticeApplication {

    public static void main(String[] args) {
        //将springboot的应用启动
        SpringApplication.run(SbPracticeApplication.class, args);
    }

}
```

```java
@SpringBootConfiguration
	@Configuration:spring的配置类
        @Component:说明这是一个spring组件
            

@EnableAutoConfiguration:自动配置
    @EnableAutoConfiguration:自动配置包
        @AutoConfigurationPackage
        	@Import(AutoConfigurationPackages.Registrar.class):自动扫描导入包
        @Import(AutoConfigurationImportSelector.class):自动配置导入选择
        	
        
```

```java
//获取所有的配置
List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);

//获取候选的配置
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
		List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
				getBeanClassLoader());
		Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you "
				+ "are using a custom packaging, make sure that file is correct.");
		return configurations;
	}
```

```c++
META-INF/spring.factories:

```

![image-20210628221604427](C:\Users\Sineva\AppData\Roaming\Typora\typora-user-images\image-20210628221604427.png)

结论:

所有的Springboot配置都在扫描时加载,spring.factory的所有配置类都在这里面但不一定会生效,要判断条件是否成立;

顾名思义:导入相应的star,就会产生相应的启动器,有了启动器,我们的自动装配就会生效,也就是配置成功

## 当中SpringBoot的自动配置步骤:

1. Springboot在启动的时候,从类路径/MET-INF/spring.factories获取指定值
2. 讲这些自动配置的类导入容器,自动配置就会生效,帮我进行自动配置
3. 省去以前自动配置的繁琐步骤
4. 整合javaee,解决方案和自动配置东西在spring-boot-autoconfigure-2.2.0.RELEASE.jar包中
5. 将所有需要导入的组件,以类名方式的返回,这些组件也相应的被加载到容器中
6. 当然,容器中也会存在许多xxxAutoConfiguration文件(@bean),类容器导入这个场景所需要的所有组件,并自动配置@Configuration,@JavaConfig
7. 自动配置类,免去手动编写文件的一些工作

​		

