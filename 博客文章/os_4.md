文件管理

1.文件

> 计算机硬盘为载体,存储在计算机上的信息集合
>
> 用户进行输入和输出的基本单位
>
> 数据项--记录(数据元素)--文件
>
> 属性:标示数据的属于拿一类型,描述信息的信息
>
> opt:crud
>
> 打开文件:
>
>  1.不在文件列表
>
> > 将文件的FCB从外村调入内存区域中,在open-file中新增表目
> >
> > 在进程打开文件表新增文件表中新增表目指向对应项
>
> 2.文件已经在文件列表中
>
> > 进程打开文件夹中新增表目指向系统打开文件表对应的表项,文件计数器count++
>
> 文件系统:对文件的增删改查,维护



2.文件系统

3.逻辑结构

> 1.无结构文件---流式文件
>
> > 源程序文件,可执行文件,库函数文件
>
> > 以字节为单位
>
> > 采用读写指针来指出下一个要访问的字符
>
> 2.结构文件----记录式文件
>
> 以数据项为单位
>
> 记录长度:
>
> ​	定长记录
>
> ​    边长记录:
>
> ​			记录包含述项目不同,不同的数据项长度不同
>
> 分类:
>
> 顺序文件(eg:excel)----有序
>
> > ​	串结构:按照先后顺序进行记录
> >
> > ​	顺序结构:记录之间按照关键字有序
>
> 索引文件:
>
> > 对于边长记录文件无法实现随机存取
> >
> > - 建索引表(记录key和地址)
> > - index_table:定长记录文件
> > - 记录中那个字段建立索引表,通过那个字段快速索引(能唯一标识)
>
> 索引顺序文件
>
> > 平衡检索速度和开销
> >
> > 将顺序文件分组
> >
> > 多级索引
>
> 直接文件或散列文件
>
> > 关键字   by  散列函数映射地址



4.文件目录

> 目录项:
>
> > FCB:文件目录项,在一起的有序集合就叫做目录
> >
> > INODE:在目录检索文件时,只用到了文件名
> >
> > FCB=inode+文件名
>
> 目录结构:
>
> > 单级目录结构: 不允许重名,查找速度慢
> >
> > 两级目录结构:用户自己不允许重名不能对用户的自己的文件分类
> >
> > 多级目录
> >
> > 树形目录结构:结构清秀,方便管理维护,但是不便于共享
> >
> > 图目录结构:
> >
> >    便于共享,不便于管理
> >
> >    有向图计数器实现共享
>
> 



5.物理结构

> 文件目录实现
>
> > 线性表
> >
> > > 顺序存储
> > >
> > > 链式存储
> >
> > 散列表
> >
> > > 增,删,查(依赖散列函数,处理冲突)
>
> 文件实现
>
> > 连续分配:有外部碎片
> >
> > 链式分配:
> >
> > > 显示:
> > >
> > > 隐式:\
> > >
> > > > 文件分配表
> > > >
> > > > > FCB存放起始块浩,FAT中存放下一块号
> > > > >
> > > > > 方便文件动态扩展,外村利用率高,支持随机访问,空间开销大
> > > > >
> > > > > 在开机后就要调入内存
> > > >
> > > > 无外部碎片
> >
> > 索引分配:
> >
> > 按照index进行
> >
> > > 链接
> > >
> > > 多层索引
> > >
> > > 混合索引
>
> 文件存储空间管理
>
> > 磁盘划分
> >
> > 空闲块管理
> >
> > > 空闲表
> > >
> > > 空闲链表
> > >
> > > 位视图
> > >
> > > 成组链接:索引扇区
> >
> > 

6.文件保护

> 文件的访问类型
>
> 文件的访问控制

7.物理结构

8.文件保护

9.文件共享

> 硬链接:绝对地址
>
> 软连接:以iNode为开始

10.磁盘

> 磁盘结构
>
> 磁盘地址
>
> 分类:
>
> > 按照磁头
> >
> > > 固定头磁盘
> > >
> > > 活动头磁盘
> >
> > 按照磁盘分
> >
> > 固定头磁盘
> >
> > 可换盘磁盘
>
> 读写时间
>
> > 寻道时间TS
> >
> > 传输时间
> >
> > 启动时间
>
> 调度算法
>
> > FCFS:从前先后
> >
> > /SSTF:局部最优,会出现饥饿现象
> >
> > /SCAN:扫描到边界,然后从掉头开始扫描
> >
> > /C-SCAN:到边界,从头开始扫描
>
> 磁盘管理:
>
> > 初始化
> >
> > > 低级格式化
> > >
> > > 逻辑格式化
> >
> > 引导块: 存放自举程序
> >
> > 坏块:
> >
> > > FAT标记出,
> > >
> > > solution:用备份扇区替换坏块