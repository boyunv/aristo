unpivot

## 1.主要功能

> `unpivot` 是`sql server`中用于快速实现列转行的函数。相比于直接通过`union`来实现列转行，使用`unpivot`可以让sql语句变得更加简洁。相对而言，理解难度会上升，可读性下降。

```SQL
create table  #tmp_a(
	customer_id int primary key,
	phone1 varchar(32),
	phone2 varchar(32),
	phone3 varchar(32)
	);


insert  into #tmp_a(customer_id,phone1,phone2,phone3)

select 1,'705-491-1111', '705-491-1110', NULL union all
select 2,'613-492-2222', NULL, NULL  union all
select 3,'416-493-3333', '416-493-3330', '416-493-3339'

--Phone1、Phone2、Phone3这些列的结果转为行上的结果，成为一列，
--并且有了新的列名为Phone

select  *  from  #tmp_a 
		unpivot(
			aristo for  boyunv in (phone1,phone2,phone3)
		)up
```

