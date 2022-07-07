# 本地文件上传至远程已有仓库

因为国内,就用`Gitee`来进行举例

## 1.核心代码命令

```shell
##这个命令查看每一步执行状态是否成功,后面会经常用到
git  status
##若失败,执行
git init 
##再进行
git status
##OK-->执行
git  add .
##查看状态
git status
##提交代码的说明--你为什么提交这串代码
git commit  -m "你要上传的原因"
##查看上传的状态
git status
##查看你要上传的分支
git branch
##选择或者新建一个分支上传(这里我以新建一个分支来说明下)
git checkout -b new_test_branch
##在此查看分支
git branch
##OK-->选择要上传的分支
git  remote add origin  https://gitee.com/****/***.git  ##这个地址就是你自己的gitee地址(自己拷贝粘贴)
##向云端上传当前所创建的分支,你想要上传的文件
git push -u origin 选择你要上传的分支(eg:new_test_branch)


```

![image-20220414085314100](https://s2.loli.net/2022/04/14/TRedL4iyAmu1JzZ.png)

![image-20220414085447877](https://s2.loli.net/2022/04/14/fhLFWKYArqiyp1w.png)

提交的时候,如果没有配置本地SSH与gitee的秘钥,要手动写自己用户名和密码

![image-20220414085526854](https://s2.loli.net/2022/04/14/V2XqEWhgJfLSYHo.png)













































