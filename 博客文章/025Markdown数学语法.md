## 1.基本格式

### 1.行内公式

> 以 `$` 开头，以 `$` 结尾。
>
> eg: $a^b$

```java
$a^b$
```

### 2.块级公式--行间公式

> 以`$$`开头,`$$`结尾
>
> $$a^b$$

```java
$$a^b$$
```

### 3.角标

> 上标:  `^`    表示后面的内容的右上角       $a^b$
>
> 下标:  `_`    表示后面的内容的右下角       $a_b$     

**常用的公式总结:**

|         数学公式         |        Markdown语法        |
| :----------------------: | :------------------------: |
|          $a^b$           |          `$a^b$`           |
|   $\sum_{n=1}^N{6y^n}$   |   `$\sum_{n=1}^N{6y^n}$`   |
|  $\prod_{n=1}^N{6x^n}$   |  `$\prod_{n=1}^N{6x^n}$`   |
| $\int^6_0{f(x)}{\rm d}x$ | `$\int^6_0{f(x)}{\rm d}x$` |
|  $\lim_{x\to+\infty}x$   |  `$\lim_{x\to+\infty}x$`   |

不码了....

![image-20220524150456635](../../../images/image-20220524150456635.png)

## 4整体内容

> 数据的运算的多项式   写在`{}`中
>
> eg:   $\frac{e^x+1}{arctanx+lnf(x)}$

```java
$\frac{e^x+1}{arctanx+lnf(x)}$
```

### 5.多行公式

格式如下:公式显示在中间

> $$
> \begin{split}
> 	x=&a-b-d \\
> 
>    y= &f-s-h  \\
> 
> \end{split}
> $$

```markdown
##语法
$$
\begin{split}
	x=&a-b-d \\

   y= &f-s-h  \\

\end{split}
$$
```

> 解释:
>
> 1. `\\`:表示换行
> 2. `&`:表示上下哪个位置`对齐`，需要在两行需要对齐的位置都加上这个符号
> 3. `\tag{1}`:表示对公式的`手动编号`是1
> 4. `split`:是一个公式环境，用于一个公式拆分成多行的情形,类似的还有`equation`,`align`
> 5. `*`:表示不自动编号，不加星号会自动编号。

> `equation`:(CSDN的Mark不支持!)
>
> 格式:
> $$
> \begin{equation} 
>     g(x)=$\prod_{i=1,j=2}^n{(x_j-x_i)}$
> \end{equation}
> $$

```java
$$
\begin{equation} 
    g(x)=$\prod_{i=1,j=2}^n{(x_j-x_i)}$
\end{equation}
$$
```

> `align`  (csdn支持aligned)
>
> $$ \begin{align*}     &x = a + b + c\\    &y = a + b \end{align*} $$

```java
$$ \begin{align*}     &x = a + b + c\\    &y = a + b \end{align*} $$
```

### 6.分段函数

> 基本格式:
> $$
> y=\begin{cases}
>     -x,\quad x\leq 0\\
>     x, \quad x>0
>   \end{cases}
> $$

```java
$$
y=\begin{cases}
    -x,\quad x\leq 0\\
    x, \quad x>0
  \end{cases}
$$
```

### 7.定界符

> 就是 `()`、`[]`、`{}`等，可以通过 `big`、`Big`、`bigg`、`Bigg`等调整大小，但是[推荐](#)用 `$\left(内容\right)$` 调整大小
>
> **基本格式:**
>
> $\left(\frac{a+b}{b-a}\right)$

```java
$\left(\frac{a+b}{b-a}\right)$
```

### 8.矩阵

> $$
> \begin{bmatrix}
>     1 & 2 & 3 \\
>     4 & 5 & 6 \\
>     7 & 8 & 9
> \end{bmatrix}
> $$

```java
$$
\begin{bmatrix}
    1 & 2 & 3 \\
    4 & 5 & 6 \\
    7 & 8 & 9
\end{bmatrix}
$$

```

![image-20220524153641746](../../../images/image-20220524153641746.png)

### 9.空格

![image-20220524153704631](../../../images/image-20220524153704631.png)

```java

```

## 语法汇总:

|        **描述**         |            **数学公式**            |           **Markdown格式**           |
| :---------------------: | :--------------------------------: | :----------------------------------: |
|          累加           |       $\sum_{n=1}^N {3x^n}$        |       `$\sum_{n=1}^N {3x^n}$`        |
|          累乘           |       $\prod_{n=1}^N{3x^n}$        |       `$\prod_{n=1}^N{3x^n}$`        |
|          开方           |          $\sqrt[5]{100}$           |          `$\sqrt[5]{100}$`           |
|          积分           |      $\int^5_1{f(x)}{\rm d}x$      |      `$\int^5_1{f(x)}{\rm d}x$`      |
|        二重积分         |     $\iint^5_1{f(x)}{\rm d}x$      |     `$\iint^5_1{f(x)}{\rm d}x$`      |
|          无穷           |              $\infty$              |              `$\infty$`              |
|          极限           |       $\lim_{n\to+\infty}n$        |       `$\lim_{n\to+\infty}n$`        |
|          加减           |                 ±                  |               `$\pm$`                |
|          点乘           |              $\cdot$               |              `$\cdot$`               |
|           乘            |                 ×                  |              `$\times$`              |
|           除            |               $\div$               |               `$\div$`               |
|         右箭头          |           $\rightarrow$            |           `$\rightarrow$`            |
|         上箭头          |             $\uparrow$             |             `$\uparrow$`             |
|         左箭头          |            $\leftarrow$            |            `$\leftarrow$`            |
|         下箭头          |            $\downarrow$            |            `$\downarrow$`            |
| 用于带下标序列的省略号  |              $\ddots$              |              `$\ddots$`              |
|         省略号          |              $\ddots$              |              `$\ddots$`              |
|       垂直省略号        |              $\ddots$              |              `$\ddots$`              |
|        斜省略号         |              $\ddots$              |              `$\ddots$`              |
|          分数           |        $\frac{分子}{分母}$         |        `$\frac{分子}{分母}$`         |
|          alpha          |              $\alpha$              |              `$\alpha$`              |
|          beta           |              $\beta$               |              `$\beta$`               |
|          gamma          |              $\gamma$              |              `$\gamma$`              |
|         lambda          |             $\lambda$              |             `$\lambda$`              |
|          theta          |              $\theta$              |              `$\theta$`              |
|           pi            |               $\pi$                |               `$\pi$`                |
|          Delta          |              $\Delta$              |              `$\Delta$`              |
|          Sigma          |              $\Sigma$              |              `$\Sigma$`              |
| 可以通过`\rm`来取消斜体 | $f(x)$` `$\rm f(x)$` `${\rm f}(x)$ | `$f(x)$` `$\rm f(x)$` `${\rm f}(x)$` |
|          花体           |  $\mathcal{abc}$ $\mathscr{abc}$   |  `$\mathcal{abc}$ $\mathscr{abc}$`   |
|                         |                                    |                                      |













































