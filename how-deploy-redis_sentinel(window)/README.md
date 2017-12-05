<h1>redis sentinel部署(Windows下实现)</h1>
<h3>一.准备条件</h3>

```
1.操作系统:win10
2.redis版本:redis-3.2.100
```
<h3>二.下载redis并解压</h3>

<h4>1.下载</h4>
由于redis官方并不支持windows操作系统，所以官网上是下不到的，需要到gitlab上下载，下载地址如下：<br/>

```
https://github.com/MicrosoftArchive/redis/releases
```
<h4>2.解压</h4>
将下载后的zip文件解压到本地磁盘，注意解压到的目录不能有中文和特殊字符，否则会出现很多奇葩的问题。解压后的目录如下：<br/>
<p align="center"><img src ="download.png" alt="download" /></p>
<h3>三.HA配置</h3>
我们采用一主(master)二从(slave)三sentinel的架构模式来做演示<br/>

```
master ip:127.0.0.1 port:6379
slave1 ip:127.0.0.1 port:6380
slave2 ip:127.0.0.1 port:6381
```
<h3>四.新建和修改配置文件</h3>
<h4>1.修改redis.conf配置文件</h4>
由于我们采用的是一主二从三sentinel的模式，所以我们需要6个配置文件，拷贝2份redis.conf配置文件，分别命名为redis6380.conf<br/>
和redis6381.conf，其中修改redis.conf配置文件的如下几个参数：<br/>

```
port 6379
bind 127.0.0.1
```
修改redis6380.conf配置文件的如下几个参数：<br/>

```
port 6380
bind 127.0.0.1
slaveof 127.0.0.1 6379  // 设置master服务器为6379
```
同理修改redis6381.conf配置文件<br/>
<h4>2.创建并修改sentinel.conf</h4>
该模式使用了3sentinel，所以我们需要复制3份sentinel.conf配置文件，并分别命名为sentinel26479.conf和sentinel26579.conf,<br/>
其中修改sentinel.conf配置文件中的如下几个参数：<br/>

```
port 26379 // 当前Sentinel服务运行的端口
sentinel monitor mymaster 127.0.0.1 6379 2 
sentinel down-after-milliseconds mymaster 5000
sentinel parallel-syncs mymaster 1
sentinel failover-timeout mymaster 15000
```
同理，修改另外的两个配置文件<br/>
配置文件说明：<br/>

```
1. port :当前Sentinel服务运行的端口
2.sentinel monitor mymaster 127.0.0.1 6379 2:Sentinel去监视一个名为mymaster的主redis实例，这个主实例的IP地址为本机地址127.0.0.1，端口号为6379，而将这个主实例判断为失效至少需要2个 Sentinel进程的同意，只要同意Sentinel的数量不达标，自动failover就不会执行
3.sentinel down-after-milliseconds mymaster 5000:指定了Sentinel认为Redis实例已经失效所需的毫秒数。当 实例超过该时间没有返回PING，或者直接返回错误，那么Sentinel将这个实例标记为主观下线。只有一个 Sentinel进程将实例标记为主观下线并不一定会引起实例的自动故障迁移：只有在足够数量的Sentinel都将一个实例标记为主观下线之后，实例才会被标记为客观下线，这时自动故障迁移才会执行
4.sentinel parallel-syncs mymaster 1：指定了在执行故障转移时，最多可以有多少个从Redis实例在同步新的主实例，在从Redis实例较多的情况下这个数字越小，同步的时间越长，完成故障转移所需的时间就越长
5.sentinel failover-timeout mymaster 15000：如果在该时间（ms）内未能完成failover操作，则认为该failover失败
```





