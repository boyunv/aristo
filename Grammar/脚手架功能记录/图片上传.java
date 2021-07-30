<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="description" content="使用canvas在前端压缩" />
    <meta name="description" content="web前端学习实例页面之使用canvas在前端压缩图片" />
    <meta name="keywords" content="canvas, 前端, 图片压缩, js" />
    <meta name="author" content="zf" />
    <title>上传蹄片</title>
    <link rel="stylesheet" href="../css/demo.css" type="text/css" />
    <link rel="stylesheet" href="../css/hl.css" type="text/css" />
    <style>
        #log { font-size: 12px; color: gray; }
    </style>
</head>

<body>
<div id="header">
    <a href="/" class="logo" title="回到首页">
        <img alt="zf" src="/php/image/zxx_home_logo.png" border="0" />
    </a>
</div>
<div id="main">
    <h1>使用canvas在前端压缩图片实例页面</h1>
    <a href="//www.zhangxinxu.com/wordpress/?p=6308" id="back">回到相关文章 &raquo;</a>
    <div id="body">
        <div id="effect" class="part">
            <h3>效果（400x400限制）：</h3>
            <div class="show">
                <div class="demo">
                    <p><input id="file" type="file" accept="image/gif, image/png, image/jpg, image/jpeg"></p>
                    <p id="log"></p>
                </div>
            </div>
        </div>
        <div id="code" class="part">
            <h3>代码：</h3>
            <div class="show">
                <h5>HTML代码：</h5>
                <pre name="code" class="html">
&lt;input id="file" type="file"&gt;
                </pre>
                <h5>JS代码：</h5>
                <pre name="code" class="js">
var eleFile = document.querySelector('#file');

// 压缩图片需要的一些元素和对象
var reader = new FileReader(), img = new Image();

// 选择的文件对象
var file = null;

// 缩放图片需要的canvas
var canvas = document.createElement('canvas');
var context = canvas.getContext('2d');

// base64地址图片加载完毕后
img.onload = function () {
    // 图片原始尺寸
    var originWidth = this.width;
    var originHeight = this.height;
    // 最大尺寸限制
    var maxWidth = 400, maxHeight = 400;
    // 目标尺寸
    var targetWidth = originWidth, targetHeight = originHeight;
    // 图片尺寸超过400x400的限制
    if (originWidth &gt; maxWidth || originHeight &gt; maxHeight) {
        if (originWidth / originHeight &gt; maxWidth / maxHeight) {
            // 更宽，按照宽度限定尺寸
            targetWidth = maxWidth;
            targetHeight = Math.round(maxWidth * (originHeight / originWidth));
        } else {
            targetHeight = maxHeight;
            targetWidth = Math.round(maxHeight * (originWidth / originHeight));
        }
    }

    // canvas对图片进行缩放
    canvas.width = targetWidth;
    canvas.height = targetHeight;
    // 清除画布
    context.clearRect(0, 0, targetWidth, targetHeight);
    // 图片压缩
    context.drawImage(img, 0, 0, targetWidth, targetHeight);
    // canvas转为blob并上传
    canvas.toBlob(function (blob) {
        // 图片ajax上传
        var xhr = new XMLHttpRequest();
        // 文件上传成功
        xhr.onreadystatechange = function() {
            if (xhr.status == 200) {
                // xhr.responseText就是返回的数据
            }
        };
        // 开始上传
        xhr.open("POST", 'upload.php', true);
        xhr.send(blob);
    }, file.type || 'image/png');
};

// 文件base64化，以便获知图片原始尺寸
reader.onload = function(e) {
    img.src = e.target.result;
};
eleFile.addEventListener('change', function (event) {
    file = event.target.files[0];
    // 选择的文件是图片
    if (file.type.indexOf("image") == 0) {
        reader.readAsDataURL(file);
    }
});
                </pre>
            </div>
        </div>
    </div>
</div>

<script>
    // 写log方法，演示辅助，与主逻辑无关
    var log = function (info) {
        document.getElementById('log').innerHTML += (info + '<br>');
    };

    var eleFile = document.querySelector('#file');

    if (window.FormData) {
        // 压缩图片需要的一些元素和对象
        var reader = new FileReader(), img = new Image();

        // 选择的文件对象
        var file = null;

        // 缩放图片需要的canvas
        var canvas = document.createElement('canvas');
        var context = canvas.getContext('2d');

        // base64地址图片加载完毕后
        img.onload = function () {
            // 图片原始尺寸
            var originWidth = this.width;
            var originHeight = this.height;

            log('图片原尺寸是：' + [originWidth, originHeight].join('x'));

            // 计算出目标压缩尺寸
            var maxWidth = 400, maxHeight = 400;

            // 目标尺寸
            var targetWidth = originWidth, targetHeight = originHeight;

            if (originWidth > maxWidth || originHeight > maxHeight) {
                // 图片尺寸超过400x400的限制
                if (originWidth / originHeight > maxWidth / maxHeight) {
                    // 更宽，按照宽度限定尺寸
                    targetWidth = maxWidth;
                    targetHeight = Math.round(maxWidth * (originHeight / originWidth));
                } else {
                    targetHeight = maxHeight;
                    targetWidth = Math.round(maxHeight * (originWidth / originHeight));
                }

                log('超过400x400的限制，图片大小限制为' + [targetWidth, targetHeight].join('x'));
            } else {
                log('图片尺寸较小，不压缩');
            }

            canvas.width = targetWidth;
            canvas.height = targetHeight;

            // 清除画布
            context.clearRect(0, 0, targetWidth, targetHeight);

            // 图片压缩
            context.drawImage(img, 0, 0, targetWidth, targetHeight);

            log('图片blob形式ajax上传，当前进度<span id="percent"></span>');
            // 转为blob并上传
            canvas.toBlob(function (blob) {
                // 图片ajax上传
                var xhr = new XMLHttpRequest();
                // 显示进度的元素
                var elePercent = document.getElementById('percent');
                // 上传文件名
                var filename = encodeURIComponent(file.name).replace(/%/g, '');

                // 上传中
                xhr.upload.addEventListener("progress", function(e) {
                    elePercent.innerHTML = Math.round(100 * e.loaded / e.total) / 100 + '%';
                }, false);

                // 文件上传成功或是失败
                xhr.onreadystatechange = function(e) {
                    if (xhr.readyState == 4) {
                        if (xhr.status == 200) {
                            // 100%进度
                            elePercent.innerHTML = '100%';

                            // 显示上传成功后的图片地址
                            var response = xhr.responseText;

                            if (/^\/\//.test(response)) {
                                response = response.split(filename)[0] + filename;
                                log('图片上传成功，地址是：<a href="'+ response +'" target="_blank">'+ response +'</a>');
                            } else {
                                log(response);
                            }
                        }
                    }
                };

                // 开始上传
                xhr.open("POST", '../201109/upload.php', true);
                xhr.setRequestHeader("FILENAME", encodeURIComponent(filename));
                xhr.send(blob);
            }, file.type || 'image/png');
        };

        // 文件base64化，以便获知图片原始尺寸
        reader.onload = function(e) {
            // 图片尺寸
            img.src = e.target.result;
        };
        eleFile.addEventListener('change', function (event) {
            file = event.target.files[0];

            if (file.type.indexOf("image") == 0) {
                log('已选择图片'+ file.name +'，大小为'+ Math.round(1000 * file.size / (1024*1024)) / 1000 +'M。');

                reader.readAsDataURL(file);
            } else {
                log('选择的文件非图片，到此为止。');
            }
        });
    }
</script>

<!-- 以下脚本无关紧要 -->
<script type="text/javascript" src="../js/hl_all.js"></script>
<script type="text/javascript">
    DlHighlight.HELPERS.highlightByName("code", "pre");
</script>
<div id="footer">
    Designed &amp; Powerd by <a href="/">zhangxinxu</a><br />
    Copyright© 张鑫旭-鑫空间-鑫生活<br>
    <a href="http://www.miibeian.gov.cn/" target="_blank">鄂ICP备09015569号</a>
</div>
<div class="bota">
    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <!-- 728x90, 大型横幅广告 -->
    <ins class="adsbygoogle"
         style="display:inline-block;width:728px;height:90px"
         data-ad-client="ca-pub-0090627341039040"
         data-ad-slot="4686885989"></ins>
</div>
<script>
    (adsbygoogle = window.adsbygoogle || []).push({});
</script>
<script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-11205167-1']);
    _gaq.push(['_trackPageview']);

    (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = '//www.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();
</script>
</div>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?48d8e938d5365a4cb0fc9e65d945018e";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<script>
    (function(){
        var bp = document.createElement('script');
        var curProtocol = window.location.protocol.split(':')[0];
        if (curProtocol === 'https'){
            bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
        }
        else{
            bp.src = 'http://push.zhanzhang.baidu.com/push.js';
        }
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(bp, s);
    })();
</script>
</body>
</html>
