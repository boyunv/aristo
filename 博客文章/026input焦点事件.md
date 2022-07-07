# input标签事件总结

> 最近在维护MES相关的系统,好家伙,接手就来个BUG,前端的关于`input`输入框的输入内容的输入内容事件失效的问题,
>
> 正好进行学习并汇总

## 一、在`Html`中`input`输入框相关事件写法：

***常用的事件总结***

|       事件        | 功能                                                         |
| :---------------: | :----------------------------------------------------------- |
| `onfocus`（常用） | input标签`获取焦点`事件                                      |
| `onblur`（常用）  | input`失去焦点`事件（触发条件：`先获取`焦点，`再失去`焦点触发） |
|    `onchange`     | input`失去焦点`并且它的`value`值发生`变化`时触发             |
|     `oninput`     | input框`输入过程中`value值`改变时`[实时触发](#)，换句话说就是  [没输入一个字符都会触发]() |
|     `onclick`     | input标签`type="button"`时的点击事件                         |
|    `onkeydown`    | input框输入时键盘按钮`按下事件`                              |
|     `onkeyup`     | input框输入时键盘按钮`抬起事件`，触发`onkeyup`事件之前一定触发`onkeydown`事件 |
|    `onselect`     | input标签内容选中时`触发`事件                                |
|                   |                                                              |



`JavaScript`**语法**：

> **JS绑定事件写法：**

```java
document.getElementByTagName(‘input’).onfocus = function();

$("#XXX").onchange(){  }
```



## 二、vue中监听input标签事件

> vue中监听iinput标签事件的写法与H5+js的写法有些不同。

### input实时监听事件

> 实时监听事件为`v-on:input方法`

```JavaScript
//比如回车
<input @keyup.enter="xxx()">
    
    
---一般的
<!--HTML页面方法-->
<input type="text" v-model.trim="inputVal" @input="resetinputVal" />

<!--js方法 -->   
let regRule = /[\u4e00-\u9fa5]|[<>&'"\\]/g;
data: {
	inputVal: '',
},
methods: {
	// 重置号码
	resetinputVal(e) {
		let val = e.target.value
		let value = val.replace(regRule, '')
		this.inputVal = value
		this.$forceUpdate()
	},
}




```

> //实时监听input值的变化，停⽌输⼊300ms后去请求，⽽不是时时请求数据(**可以不看,自己学习博客记录**)

```JavaScript
data: {
	timeout: null,
},
watch: {
    inputVal(curVal, oldVal) {
        // 实现input连续输⼊，只发⼀次请求
        clearTimeout(this.timeout);
        this.timeout = setTimeout(() => {
          this.getAPI(curVal);
        }, 300);
    }
},
methods: {
	// 请求接口
	getAPI(curVal) {},
}
```



```java
//input获取焦点事件：
<input type=“text” placeholder=“请输入” @blur=“xxx()”>
```

```java
//input失去焦点事件：
<input type=“text” placeholder=“请输入” @focus=“xxx()”>
```

> //限制小数位

```JavaScript
<input type="number" @keydown="keydownFn" v-model="inputVal">
//Vue 限制input输入 小数点后两位number
    keydownFn(event) {
    // 通过正则过滤小数点后两位
    // event.target.value = (event.target.value.match(/^\d*(\.?\d{0,1})/g)[0]) || null    //只能为正数
       event.target.value = (event.target.value.match(/\-?\d+\.?\d{0,1}/g)[0]) || null       //可以为负数
    
},
/Vue 限制input输入 小数点后一位number
    keydownFn(event){
    const arr = event.target.value.split('.');
    if(arr.length == 2 && arr[1].length > 1){       //有至少两位小数
        event.target.value = arr[0] + '.' + arr[1].substr(0,1);
        this.$message({
            message: '只允许一位小数',
            type: 'warning'
        });
     }else if(arr.length == 1){      //没有小数
        event.target.value = arr[0]
     }else if(arr.length == 2 && arr[1].length == 1){        //只有一位小数
        event.target.value = arr[0] + '.' + arr[1];
     }
},

```

