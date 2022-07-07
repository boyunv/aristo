# SQLSERVER实现三元运算符的效果



> 最近在写SQL的查询时,突然想用三元运算符的效果实现,总结下
>
> 很遗憾，SQL server中并没有这个功能，三元运算符是什么呢？

## 三元运算符的语法:

> 【条件* **?** 满足返回值 **:** 不满足返回值**】**
>
> ```java
> --举例:
> if(a>b?true:false)
> ```
>
> 

## SQL的实现方法:

### **（1）使用CASE WHEN 组合**(最原始的方法)

```SQL
--原始方法   
SELECT (CASE WHEN 1=1 THEN 'TRUE' ELSE 'FALSE' END)
```

![image-20220506111732038](C:/Users/zhaofan/AppData/Roaming/Typora/typora-user-images/image-20220506111732038.png)

 

### **（2）：使用Iff 函数：**

**注意!**这个函数是`sqlserver 2012` 之后新增的,你的数据库如果**不是**2012 以后,乖乖使用上面的`case when`；

```SQL
--IFF函数(我最喜欢这种,简便、整洁)
--TRUE
SELECT  IIF(1=1,N'成功啦!',N'还在成功的路上,加油!')
--FALSE
SELECT  IIF(1>1,N'成功啦!',N'还在成功的路上,加油!')
```

![image-20220506112516435](C:/Users/zhaofan/AppData/Roaming/Typora/typora-user-images/image-20220506112516435.png)