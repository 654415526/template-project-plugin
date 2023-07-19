# 插件说明
支持IDEA版本201.*-232.*
# 插件安装
1.下载插件
[template-project-plugin-1.0.0-RELEASE.zip](https://yb1k37.yuque.com/attachments/yuque/0/2023/zip/28882781/1688448272180-8bc20b5d-113c-4473-b3ca-a99e2d454808.zip)


2.安装插件
plugins->setting->Install Plugin from Disk...
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688355251654-faf43751-06ca-4178-9785-79e15a137578.png#averageHue=%23393c41&clientId=u6a1272bd-84de-4&from=paste&height=707&id=u37d9a732&originHeight=1414&originWidth=1956&originalType=binary&ratio=2&rotation=0&showTitle=false&size=396438&status=done&style=none&taskId=uc96332b0-5ea3-491b-be92-3451080265b&title=&width=978)
选中刚下载的文件
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688355309984-98779bd6-dffb-4df4-b5af-97d2e396fb9e.png#averageHue=%232b2b29&clientId=u6a1272bd-84de-4&from=paste&height=442&id=u9e617781&originHeight=884&originWidth=1586&originalType=binary&ratio=2&rotation=0&showTitle=false&size=248927&status=done&style=none&taskId=u7465c773-dc37-4919-bf05-1ca362a3dda&title=&width=793)
apply之后重启IDEA
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688355381156-ca70f392-2db0-4138-82a2-0cefeb808251.png#averageHue=%23393c40&clientId=u6a1272bd-84de-4&from=paste&height=709&id=ued0d2a71&originHeight=1418&originWidth=1954&originalType=binary&ratio=2&rotation=0&showTitle=false&size=326833&status=done&style=none&taskId=uaf66142a-7b7f-44ff-94e6-9955d93a3c0&title=&width=977)
重启之后在New Project中出现Pixel Project即安装成功
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688355658988-c3beac99-5895-438f-ab7c-196972fbd7d3.png#averageHue=%233f4144&clientId=u6a1272bd-84de-4&from=paste&height=661&id=uf179f97c&originHeight=1322&originWidth=1604&originalType=binary&ratio=2&rotation=0&showTitle=false&size=206796&status=done&style=none&taskId=udced167d-99c4-4ed2-b7d1-ee801857e96&title=&width=802)

# 插件使用
1.设置项目基本信息
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688356120244-b9de3e27-2f62-4128-923b-34cd01d40ea2.png#averageHue=%233f4144&clientId=u6a1272bd-84de-4&from=paste&height=662&id=ude833970&originHeight=1324&originWidth=1600&originalType=binary&ratio=2&rotation=0&showTitle=false&size=251319&status=done&style=none&taskId=u5c0457c9-1764-42c7-8d01-bb796ae9d90&title=&width=800)
2.添加项目需要的依赖
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688356199178-1a678f65-b612-402e-8739-66ef48718c0e.png#averageHue=%233d4042&clientId=u6a1272bd-84de-4&from=paste&height=662&id=ued790c93&originHeight=1324&originWidth=1596&originalType=binary&ratio=2&rotation=0&showTitle=false&size=169640&status=done&style=none&taskId=u58a28fa3-4ca6-407a-9116-481cc360f28&title=&width=798)
3.找到主pom.xml ,使用Add as Maven Project添加为maven项目
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688360226272-82886764-3484-49b3-9204-b0dbf5ae2f39.png#averageHue=%234f4c43&clientId=ucacde560-b86a-4&from=paste&height=739&id=ub5703cb4&originHeight=1478&originWidth=2046&originalType=binary&ratio=2&rotation=0&showTitle=false&size=410628&status=done&style=none&taskId=u9650a235-6155-4e19-bb64-fcd6048f0ff&title=&width=1023)
4.多个sdk则在项目中设置一致即可
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688360553270-78abbb10-875d-472f-b897-e165e624cbb0.png#averageHue=%2342444a&clientId=u2667a670-661f-4&from=paste&height=504&id=u6f345c33&originHeight=1008&originWidth=2504&originalType=binary&ratio=2&rotation=0&showTitle=false&size=322945&status=done&style=none&taskId=u13b08d17-26f3-49bf-8050-49cd906396c&title=&width=1252)
5.设置maven
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28882781/1688360711127-89374b20-891a-4681-8ce3-fef15001fba3.png#averageHue=%233f4246&clientId=u2667a670-661f-4&from=paste&height=706&id=ufdc2e739&originHeight=1412&originWidth=1964&originalType=binary&ratio=2&rotation=0&showTitle=false&size=304114&status=done&style=none&taskId=u114a332f-dada-496c-a5f4-230dc90d4bf&title=&width=982)
5.启动工程，出现Undertow started on port(s) 8080 (http) with context path ''即成功
 DUBBO service start failed, cause:java.lang.RuntimeException: no DUBBOServicePublisher.java service to exported错误原因是在starter的pom.xml中添加了uhomed-dubbo-consumer
