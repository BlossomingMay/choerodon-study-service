# choerodon-study-service
Java第五次测试



### spring cloud & c7n framework考核说明
本次考核由于未知原因配了3个小时VPN无效，只能在本地开启服务进行开发，**系统为：mac OS 10.14.5，**。解决方案百度没有，Google为[这个](https://apple.stackexchange.com/questions/333337/macos-cannot-connect-to-openvpn-using-shimo-kext-error)，但是第一步下载 tun/tap 就无法安装。只得作罢。

### 运行说明
1. 把注册中心由本地改成提供的
> defaultZone: http://register-server.pveruntimedev.svc.cluster.local:8000/eureka

![](http://ww1.sinaimg.cn/large/006tNc79gy1g5mhr7gkp0j31bs0kgq75.jpg)
2. 手动添加mgmt_route
![](http://ww2.sinaimg.cn/large/006tNc79gy1g5mi09egw0j30fq0cmagj.jpg)
![](./images/1564815653582.png)
3. 在提供的数据库建立本服务的数据库

``` sql
CREATE DATABASE 25697_study_service DEFAULT CHARACTER SET utf8mb4;
GRANT ALL PRIVILEGES ON todo_service.* TO choerodon@'%';
FLUSH PRIVILEGES;
```

4. 数据库建立之后建立表格

**执行本项目下的init-local-database.sh**


### 完成说明
* 附加题未完成。
* 使用feign访问猪⻮⻥的iam-service的api，在本地的iam服务--》成功获取数据
* 按照猪⻮⻥的目录结构，编写mapper、service、controller，实现可以查询上面插入数据
库的数据的接口--》完成

### 目录结构
![](http://ww1.sinaimg.cn/large/006tNc79gy1g5mhnd5r4ej30ng0teaci.jpg)

### 本地测试结果
**列出两个查询的，插入只能执行一次，不然主键冲突会报错**

这两个命令是本地测试用postman的，如果注册成功就可以直接在swaggee页面测试了

> localhost:28080/v1/organizations/fromiam/1

执行了上面这个请求之后可以在本服务数据库看到成功增加了一条数据，表明feign成功了
![](http://ww2.sinaimg.cn/large/006tNc79gy1g5mir760hsj32ge07mthz.jpg)

> localhost:28080/v1/organizations/1

![](http://ww2.sinaimg.cn/large/006tNc79gy1g5mhod151mj30rw114dkf.jpg)

> localhost:28080/v1/users/1/info


![](http://ww3.sinaimg.cn/large/006tNc79gy1g5mi973imyj30ti0zowjl.jpg)
