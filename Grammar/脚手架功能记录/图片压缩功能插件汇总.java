背景
最近用到前端压缩图片的技术，虽说可以参考原理自己写，但是前辈花了很大精力写出来的插件可以帮助我们避免很多坑，直接拿来用吧。

插件1 compression.js
优点：使用简单，参数只有输入图片，压缩比例，输出图片。很少的代码量即可实现压缩和预览的效果。

<title>前端图片压缩</title>
<meta charset="utf-8">
<script src="jquery.min.js"></script>
<script type="text/javascript" src="compression.js"></script>
<style>
        #img{
	width: 100px;
	height: 50px;
	text-align: center;
	line-height: 50px;
	border: 1px solid #434343;
        }
   </style>
</head>
<body>
<P>当前压缩比例 0.5</P>
<div id="img">上传图片</div>
<br>
<p id="zz"></p>
<img id="jg" src="">
<script type="text/javascript">
    	 window.onload = function() {
			  var dd = new compression({
					domId:"img", // 上传图片的Dom 目前只支持id；
					type:"jpg", // 压缩后保存图片的类型，目前支持 jpeg , png   参数：jpeg png
					fidelity: .5,  // 压缩比例 (0,1]
					imgFile:function(base64){
						// alert(base64)  // 压缩好的回调
						$("#zz").text("以下为压缩后的图片");
						$("#jg").attr("src",base64);	
					}
			 })
    	 }
    </script>
</body>
</html> 

插件2 image-compressor
测试连接：https://xkeshi.github.io/image-compressor/
github: https://github.com/xkeshi/image-compressor

插件3 localResizeIMG
github 2000star作品
https://github.com/think2011/localResizeIMG

插件4 混沌传奇写的插件，有学习意义
文章： https://juejin.im/post/5a9759a16fb9a0635b5360b3

我最后选用的插件
compressorjs
https://github.com/fengyuanchen/compressorjs/blob/master/README.md#options
理由：
代码风格简洁，作者chenfengyuan有数个star破千的前端项目，实例很强。虽然点赞不如localResizeIMG（中国人比较多吧），但是使用起来确实很方便。下面一篇博客我会把我的使用案例分享出来。请到我的博客找这片文章，会告诉你如何使用。
