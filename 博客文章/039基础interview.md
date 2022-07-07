### 1，""空字符串的作用

```java
package com.neuedu.nineteen;
public class Test {
    public static void main(String[] args) {
        String s="";
        for (char  i = 'a'; i < 'd'; i++) {
            s=s+i;//输出abc
//            s=i+s;//输出cba
        }
        System.out.println(s);
    }
}
```

如题所示，当进行s=s+i的时候，s在前和s在后输出的结果是相反的。空字符串在前时是正着输出，空字符串在后是逆着输出

### 2.short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错? 

>第一种情况，s1是short类型，在计算s1=s1+1时，前边是short型，后边是int型，不能自动转换。由于没有强转，要报类型错误。
>
>第二种情况，使用了+=这个java自带的运算符，java内部会对其进行处理，所以编译通过，不会报错。

### 3.说说&和&&的区别。 

&和&&都表示与的意思，既表达式俩边都成立，结果才成立。

&&是逻辑运算符，&&有短路作用，既当表达式左边为假时，不需要计算右边，整个的结果直接为假；&没有

&是位运算符，&的左右俩边可以是布尔类型，也可以是数值；&&俩边只能是布尔类型

### 4.Integer与int的区别 

int是八大基本数据类型之一，Integer是int的封装类。

int的默认值是0，Integer的默认值是null，此时的0代表这个数赋值0，而null代表没接收到这个值

Integer提供了与整数相关的操作，int没有

### 5.==与equals的区别

从表面上看，对于基本数据类型==是判断的值是否相等；对于引用数据类型是判断是否为同一个对象

从本质上看，是看是否为一个引用地址

![img](../../../images/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L21lZXRiZXR0ZXJoYw==,size_16,color_FFFFFF,t_70.png)

![img](../../../images/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L21lZXRiZXR0ZXJoYw==,size_16,color_FFFFFF,t_70-1656922719014172.png)

equals是判断值是否相等

### 6.override(重写)和overload(重载)的区别

重载是**在一个类**中，方法名相同，参数列表不同（参数类型和参数个数）的一种现象

1.重载与返回值类型无关

2.不能通过访问修饰符进行重载

如下是重载：

```csharp
public void a(int x){



        x++;



}



public int a(int x,int y){



        return x+y;



}



protected double a(double d){



        return d;



}
```

重写是在**父子类**中，子类重写父类的方法，要求方法名与参数列表，返回值类型完全相同。子类重写父类规范要在子类的方法前加注解@Override

1.重写的返回值类型可以改，但只能是父子类

例如：

```kotlin
public Father a(Father f){



        System.out.println("aaaaa");



        return f;



    }



 



 @Override



    public Son a(Father f){



        System.out.println("bbbbbb");



        Son s=(Son)f;



        return s;



    }
```

2.重写的访问修饰符得大于等于原来的

3.不能重写私有方法

4.参数列表的顺序与类型必须一样，变量名可不同

### 7.接口与抽象类的区别

抽象类是用abstract修饰的类，抽象类不能new对象。

接口是比抽象类还抽象的“类”

**普通类：具体实现**

**抽象类：规范（抽象方法），具体实现**

**接口：规范（抽象方法）**

区别：

1.抽象类中可以有抽象方法也可以有非抽象方法，接口中只能有抽象方法

2.抽象类中可以有成员变量，接口中只能有常量，用public static final修饰，默认可不写

3.**抽象类有构造方法，接口没有构造方法**

4.抽象类中的方法的访问修饰符可以是public，protected，默认；接口中方法的访问修饰符只能是public，并且默认值是public abstract

5.抽象类中可以有静态方法，接口中不能有静态方法（JDK1.8之后接口中增加了静态方法和默认方法）。（static是类名直接调用，abstract是子类实现创建对象调用，如果一起修饰，自相矛盾了）

6.一个类可以实现多个接口，只能继承一个抽象类

### 8.JDK,JRE,JVM的联系与区别

JDK是java开发工具包，JDK包括JRE，类库，java工具

JRE是java运行环境，JRE包括JVM，JRE里有运行.class的java.exe

JVM是java虚拟机，java虚拟机在执行字节码时，把字节码解释成具体平台的机器指令执行，这也是java语言跨平台的根源，是“一次编译，到处运行”的原因

**联系**：JDK下的jre文件夹下有俩个文件夹lib和bin;在这里可以理解为bin就是jvm,lib就是类库；所以JRE=JVM+类库

我们利用JDK开发属于自己的java程序，javac编译成字节码，在JRE上运行这些字节码，JVM解析这些字节码，最终映射到CPU指令集或OS的系统调用

**区别**：

JDK与JRE的区别：

1.JDK有javac.exe;JRE没有

2.JDK是开发环境，JRE是运行环境

JRE与JVM的区别：

1.JVM执行.class需要JRE下lib类库的支持（尤其是rt.jar）

### 9.在java中如何跳出多层循环

利用“打标签”的形式，如：

```java
ok:  for (int i = 0; i <3 ; i++) {



            for (int j = 0; j < 4; j++) {



                for (int k = 0; k < 5; k++) {



                    break ok;



                }



            }



        }
```

### 10.String s = new String("xyz");创建了几个String Object

创建了俩个对象或一个对象，如果常量池中没有“xyz”第一次=在常量池中创建了一个字符串对象，第二次new又创建了一个字符串引用对象;如果常量池中有“xyz”,那就只是new的时候创建了一个对象。

### 11.Java有没有goto?

java中的保留字，现在在java中没有使用

### 12.Java中的String，StringBuilder，StringBuffer三者的区别?

1.String是不可变字符串，StringBuilder和StringBuffer是可变字符串

2.从运行效率看，StringBuilder>StringBuffer>String

3.StringBuilder非线程安全，StringBuffer线程安全

总结：String适合少量字符串的操作

StringBuilder适合单线程大量数据的操作

StringBuffer适合多线程大量数据的操作

### 13.静态变量和实例变量的区别？

1.静态变量用static修饰，实例变量不需要

2.静态变量是属于类的，实例变量是属于对象的

3.当一个对象把静态变量的值改了，其他对象调用时它的值也跟着变了；实例变量是独立的，一个对象修改它的值不会影响另一个对象调用它的值

### 14.switch语句能否作用在byte上，能否作用在long上，能否作用在String上? 

可以作用在byte上，因为byte能自动转为int；不能作用在long上，long转int不能自动转，需要强转；在jdk1.7以后可以作用在String上

### 15.使用final关键字修饰一个变量时，是引用不能变，还是引用的对象不能变？ 

是引用不能变，即对象的指向不能变，但引用的对象即引用里的值是可以变得，因为它又没有用final修饰。

基本数据类型的值是不能更改的 比如 final int a=1;a=2;那肯定编译也过不了。因为a是final修饰的不可改变；a原来指向1，后来指向2；a的指向变了。final int[] arr= {1,2,3}; arr[0]=2;这种是可以的。因为arr的指向并没有变 只不过它里边的值可以变。

### 16.请说出作用域public，private，protected，以及不写时的区别 

![img](../../../images/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L21lZXRiZXR0ZXJoYw==,size_16,color_FFFFFF,t_70-1656922719015173.png)

### 17.构造器Constructor是否可被override? 

构造器不能被重写，因为构造器不能被继承，但它可以重载

### 18.try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后?

会执行，首先明确一点是“finally块中的代码始终要执行”，也就是说不管怎样，它都会执行。并且在return前执行,执行finally后通过return退出。看下边的例子：

```java
public class Test {



    public static String output="";



    public static void foo(int i){



        try{



            if(i==1){



                throw new Exception();



            }



            output+="1";



        }catch(Exception e){



 



            output+="2";



            return;



        }finally{



            output+="3";



        }



        output+="4";



    }



    public static void main(String[] args) {



        foo(0);



        foo(1);



        System.out.println(output);//13423



 



    }



}
```

### 19.final, finally, finalize的区别

final修饰属性，方法，类；分别表示属性不可变，方法不可覆盖，类不可继承

finally是异常中的关键字，始终要执行的代码放在finally块中

finalize是Object的一个方法，是垃圾回收机制，重写此方法可以回收其他资源，如文件关闭。JVM不保证此方法总被调用

### 20.启动一个线程是用run()还是start()

用start（）方法，start方法内调用了run方法，如果直接调用run方法，那么就相当于没有开启线程而直接调用的run方法。

### 21.Vector和ArrayList的区别

ArrayList和Vector是基于数组的,有下标，有序，元素可重复。

Vector就是把ArrayList中的所有方法加了synchronized

所以，Vector是线程安全的，ArrayList是线程不安全的，但Collections下有静态方法，synchronizedList来代替Vector,Vector在日常中很少使用。

### 22.System.out.println()分别代表什么？

System.out.println()是我们日常使用最多的输出语句，其中System是一个类，out是这个类中的一个静态常量对象，是PrintStream类型的，println()是PrintStream类的方法，用于输出。

### 23.比较throw和throws

throws是声明异常的关键字，其后是一个异常类，比如throws IOException

throw是抛出异常的关键字，其后跟着一个异常对象,比如throw new IOException()

### 24.垃圾回收的原理和优点

垃圾回收是一个低级别的线程运行，在不知情的情况下对堆内存中的闲置的或者长期没使用的对象进行回收。

**优点**：

1）不需要考虑内存管理；

2）防止内存泄漏，有效的管理内存；

3）对象不再有作用域的问题，只有对象的引用存在作用域；

4）程序员不能实时的对某个对象或所有对象调用垃圾回收器

### 25.super.getClass()方法调用 

```scala
 import java.util.Date; 



 public class Test extends Date {



 public static void main(String[] args) { 



        new Test().test(); 



 }   



   public void test() { 



        System.out.println(super.getClass().getName());  



    } 



}
```

输出的结果是**Test**

原因：由于**getClass()**在Object类中定义成了**final**，子类不能覆盖该方法，所以，在 test方法中调用super.getClass().getName()方法，等效于调用getClass().getName()方法，所以，super.getClass().getName()方法返回的也应该是Test。

如果想得到父类的名称，应该用如下代码：

 getClass().getSuperClass().getName(); 

### 26.sleep() 和 wait() 有什么区别? 

1）sleep是Thread类下的方法；wait是Object下的方法

2）sleep是使线程休眠，不释放锁；wait是使线程等待，释放锁

sleep让出的是cpu,如果此时代码是加锁的，那么即使让出了CPU,其他线程也无法运行，因为没有得到锁；wait是让自己暂时等待，让出同步锁，等待其他线程执行完了，再来执行自己

3）调用sleep进入阻塞状态；调用wait进入就绪状态

### 27.线程的基本概念、线程的基本状态以及状态之间的关系 

线程是执行和调度的基本单位，是进程中一个执行过程，一个进程有多个线程，线程间共享内存，如果是单核CPU，那么CPU一会访问a线程，一会访问b线程，线程之间切换很快，给人的感觉是他们在同步执行。

线程的**基本状态**分为：新生状态，就绪状态，运行状态，阻塞状态，死亡状态

**关系**：调用start()方法线程转为就绪状态

调用wait()方法线程转为就绪状态

调用sleep()方法线程转为阻塞状态

就绪，运行之间是相互转换的

### 28.Collection 和 Collections的区别

Collection是集合的最顶层接口，这个接口下有List和Set俩个子接口

Collections是针对集合的一个帮助类，里边有很多静态方法，用于集合的搜索排序等

### 29.两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对? 

如果是在hashMap中不对，反之这句话是对的。

如果对象保存在hashMap或hashSet中，那么她们的值相等，hashCode也一定相等

如果没有保存在hashMap或hashSet中，那么与hashCode没什么关系了，她们的hashCode值可以不等

### 30.说出一些常用的类，包，接口，请各举5个 

常用的类：String，Arrays,Collections,System,Integer,BufferedReader,BufferedWriter,

常用的包：util,io,sql,awt,list,lang

常用的接口：List,Map,Set,Serializable,Comparable,Runnable

### 31.PreparedStatement与Statement的区别

PreparedStatement是预编译语句执行者，数据库对sql语句进行预编译；Statement是执行时对sql语句进行编译

Statement存在sql注入的问题，PreparedStatement解决了这个问题

PreparedStatement的执行效率比Statement高

PreparedStatement中使用？占位符，设置参数更方便

### 32.Java中的HashMap的工作原理是什么？

HashMap的原理是：数组+链表。

HashMap类有一个叫Entry的内部类。这个Entry类包含了key-value作为实例变量。根据key的hashcode方法计算出hash值来决定具体在哪个位置，如果这个位置有值，则调用equals方法进行判断，如果equals相等则替换，如果equals不等则追加到链表后。

在1.7采用头插法，元素每次插入到链表头部，当扩容时，会发生链表反转，容易产生循环链表，多线程情况下可能发生死锁。

在1.8采用尾插法，元素每次插入到链表尾部，扩容不会发生反转，解决了死锁问题。数组+链表+红黑树。当链表长度超过8时转为红黑树。

### 33.线程的sleep()方法和yield()方法有什么区别？

1）sleep()会给比它优先级低的线程机会，yield()方法只会给跟它同等级或比它优先级高的线程机会

2）执行sleep后进入阻塞状态，执行yield后进入就绪

3）sleep方法声明抛出InterruptedException异常，yield没有声明抛出任何异常

4）sleep比yield方法具有更好的移植性

### 34.什么是序列化，如何实现序列化?

序列化机制（包括序列化和反序列化）的**本质**是用流将对象读到内存和写入外存。

序列化机制的**意义**就是将对象脱离程序运行独立存在

**应用场景**是在RMI（远程方法调用）中应用，即通过网路或跨平台传输对象，而RMI是javaEE开发基础，所以javaEE要求传递的参数与返回值都实现序列化机制

序列化是用流**将java对象转成二进制**写入硬盘或网络

反序列化是用流**将二进制数据转为java对象**写入内存

实现序列化需要实现Serializable或Externalizable接口，如果某个成员变量是引用数据类型，那么要求该引用类也是可序列化的。如果类中每个成员变量不想被序列化，可以用transient关键字修饰。

序列化通常与IO中的ObjectInputStream（readObject方法）和ObjectOutputStream（writeObject方法）搭配使用

### 35.什么是单例模式？

单例模式是指一个类只创建一个实例。

单例模式是经常用到的一种设计模式，它分为饿汉式、懒汉式、静态内部类、枚举

饿汉式：在类加载时就创建本类对象为私有静态常量，构造方法写成私有的，使用共有静态方法代替构造方法获取到这个单例

懒汉式：在饿汉式的基础上给静态方法加synchronized，在方法里判断本类对象是否为空，为空时创建。

静态内部类：将单例放在静态内部类中，避免在类加载的时候就创建对象，然后用静态方法代替私有构造

[设计模式--单例模式_渣渣的成长之路-CSDN博客](https://blog.csdn.net/meetbetterhc/article/details/97262218)

### 36.对象的深拷贝与浅拷贝

对象的深拷贝是在拷贝时把这个对象复制一份，如果这个对象所属的类中有引用数据类型，也会将引用该类复制一份，以达到深度克隆，这样的话，一个改变了它的值不会影响另一个

实现深拷贝的方法：

- 覆盖Object的clone方法
- 通过序列化方式实现深拷贝 

对象的浅克隆是在拷贝时把这个对象复制一份，但如果这个对象所属的类中有引用数据类型，这个引用还指向原来的引用。

例如：从A拷贝一份B，如果是深克隆，A和B是俩个独立的对象，只不过一模一样。如果是浅克隆，如果A中有引用类型，那么B中此引用类型和A中此引用类型指向的是同一块地址。

### 37.java8新特性有哪些？

lambda表达式

函数式接口

重复注解

接口中的默认方法和静态方法

stream

### 38.什么是反射

反射是在运行时动态的获取类的信息，获取Class对象有三种方法：类名.class、对象名.getClass()、Class.forName(“权限定名”)

获取到类对象后可以用newInstance()创建对象，Class类中API提供了获取属性、方法、构造器的方法。

### 39.JVM内存结构

JVM内存结构包括：堆、虚拟机栈、本地方法栈、程序计数器、方法区

堆：存放new的对象，是内存中最大的一块区域

虚拟机栈：就是我们平时所说的栈，用来存放基本数据类型和对象的引用

本地方法栈：与虚拟机栈相同，只不过是为native方法服务的

程序计数器：用来标记程序运行到哪一行

方法区也叫永久代，存放类的信息。在jdk1.6及以前，常量池在方法区里，常量池用于存放静态变量和字面量；在jdk1.7，常量池从方法区中分离出来，在内存中开辟了一段空间作为常量池；在jdk1.8，取消了方法区，取而代之的是元数据区。

### 40.面向对象的特征

面向对象有三大特征：封装、继承、多态

封装是将重复利用的代码包装起来，以便其他处引用，提高了代码的可重用性

继承是发生在父子类之间的，子类继承父类开放权限的所有代码，其实继承破坏了封装性

多态是在不改变程序的代码的情况下，在程序运行时动态的绑定代码，使程序出现多种状态

多态的体现是继承、重写、父类引用指向子类对象

### 41.String下有哪些方法？

substring():截取字符串

split():分割字符串

valueOf():将其他类型转为字符串类型

trim():去掉字符串前后空格

indexOf():返回第一次出现该字符的索引

length():长度

concat():拼接

startsWith():以……开始

endsWith():以什么结束

……

### 42.如何避免死锁？

①避免给同一线程多次加锁

②主副线程的加锁顺序一致

③使用定时锁

④死锁检测

### 43.Lock与synchronized的区别？

①synchronized是关键字；Lock是接口

②synchronized在发生异常后会自动释放锁；Lock不会

③Lock有trylock方法看是否获得锁；synchronized没有

④synchronized是修饰代码块、方法获得锁的；Lock是通过ReetrantLock类加锁的

⑤synchronized是悲观锁；Lock是乐观锁

### 44.乐观锁与悲观锁的区别？

悲观锁是将锁给一个线程，其他线程等待这个线程释放锁

乐观锁是先进行业务处理，最后一步更新数据时再加锁

①悲观锁适合于写频繁；乐观锁适合于读取频繁

②悲观锁是先加锁后进行业务逻辑；乐观锁是先进行业务逻辑再加锁

### 45.静态方法有什么缺点？

静态方法是属于类的，可以直接利用类名.直接调用，但静态方法不能自动销毁，它的执行效率比实例化要高。

### 46.hashCode相等，equals一定相等吗？

不一定。hashCode相等是指哈希值相等，而值不一定相等。

比如1和5这俩个数都在0这个位置上，那么它们的哈希值相等，但这俩个数不相等。

![img](../../../images/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L21lZXRiZXR0ZXJoYw==,size_16,color_FFFFFF,t_70-1656922719015174.png)

### 47.List与Set的区别

List和Set都是Collection接口下的接口。

①List中元素可重复，有序，有下标；Set中元素无序，不可重复

②List的查找快，增删慢；Set的查找慢，增删快

### 48.成员变量与局部变量的区别？

①成员变量的作用域是在类中；局部变量的作用域是在方法中

②成员变量可以不赋初值；局部变量必须赋初值

### 49.ArrayList删除指定的元素怎么删？

（1）用普通for循环，并且在循环中i--

```csharp
//加入删除元素b



for (int i = 0; i < al.size(); i++) { 



    if (al.get(i) == "b") { 



    al.remove(i); 



    i--; //一定要记着i--,因为每次删除完一个元素，后边的元素会往前挪



} 



}
```

（2）用一个List 记录要删除的数据,最后在原集合中removeAll(List)；

（3）用迭代器自带的remove方法

### 50.**Iterator与ListIterator的区别**

(1)Iterator遍历set和list；ListIterator只能遍历list

(2)Iterator只能向后遍历，ListIterator既能向前遍历，也能向后遍历

(3)ListIterator比Iterator方法多，比如增加元素

### 51.Java是如何实现多线程的？

（1）继承Thread类，重写run方法，调用这个类的start方法

（2）实现Runnable接口

（3）实现Callable接口，重写call方法，搭配FutureTask类使用

### 52.synchronized的原理

在JDK1.6以前，sync是重量级锁。

重量级锁有一个等待队列，想要抢占锁的线程都进入等待队列中，当线程A获得到共享资源，其他线程进入阻塞状态，当线程A释放锁时，其他线程被唤醒。

这个过程很消耗操作系统，因此sync的效率很低。

在JDK1.6之后，sync应用了锁升级。

起初是无状态的，jvm启动4s后开启偏向锁，当某个线程来竞争，要判断当前锁是否可重新偏向，如果不能，就升级为轻量级锁，当自璇无法获取到锁，就会升级为重量级锁。

### 53.IO与NIO的区别

1. IO是单向的，NIO是双向的
2. IO是面向流的，NIO是面向缓冲区（块）的
3. IO是阻塞，NIO是非阻塞

### 54.类加载的时机

1. 创建类实例
2. 反射
3. 访问类变量，为类变量赋值
4. 调用类方法
5. 初始化子类时，其父类也会被初始化
6. 标注为主启动类，执行main方法

### 55.类加载的步骤

加载、连接、初始化；其中连接包括验证、准备、解析，每个阶段做的事情分别如下：

- 加载：将编译后的.class文件加载到JVM，并创建一个Class对象
- 验证：验证.class文件格式是否规范、也有安全层面的验证、验证类的元信息，字节码，符号引用
- 准备：为类的静态变量分配内存，赋默认值
- 解析：将符号引用转为直接引用
- 初始化：为静态变量赋初始值