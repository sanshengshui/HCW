##优雅的物联网架构
```
Netty
Maven
Spring
Mybatis(最少配置方案)
Druid(数据源配置 sql防注入 sql性能监控)
持续更新中 @>+++++++<@
```
[Druid](https://github.com/alibaba/druid)号称是Java语言中最好的数据库连接池
```
1 可以监控数据库访问性能，Druid内置提供了一个功能强大的StatFilter插件，能够详细统计SQL的执行性能，这对于线上分析数据库
访问性能有帮助。
2 替换DBCP和C3P0。Druid提供了一个高效，功能强大，可扩展性好的数据库连接池。
3 数据库密码加密。直接把数据库密码写在配置文件中，这是不好的行为，容易导致安全问题。DruidDruiver和DruidDataSource都支持
PasswordCallback。
4 SQL执行日志，Druid提供了不同的LogFilter,能够支持Common-Logging,Log4j和JdkLog，你可以按需要选择相应的LogFilter，监控
你应用的数据库访问情况。
5 能够提供基于Filter - Chain模式的插件体系
```
下面介绍下如何在项目中集成Druid:
<br/>
1. maven依赖
```
<dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
</dependency>
```
2. 配置web.xml
```
<!-- druid -->  
<servlet>  
    <servlet-name>DruidStatView</servlet-name>  
    <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>  
</servlet>  
<servlet-mapping>  
    <servlet-name>DruidStatView</servlet-name>  
    <url-pattern>/druid/*</url-pattern>  
</servlet-mapping>  
  
<filter>  
    <filter-name>DruidWebStatFilter</filter-name>  
    <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>  
    <init-param>  
        <param-name>exclusions</param-name>  
        <param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>  
    </init-param>  
</filter>  
<filter-mapping>  
    <filter-name>DruidWebStatFilter</filter-name>  
    <url-pattern>/*</url-pattern>  
</filter-mapping>  
```

3. spring.xml中配置druid数据源
```
<!-- 数据源druid -->  
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"   
init-method="init" destroy-method="close">  
    <property name="driverClassName" value="${jdbc.driverClassName}" />  
    <property name="url" value="${jdbc.url}" />  
    <property name="username" value="${jdbc.username}" />  
    <property name="password" value="${jdbc.password}" />  
      
     <!-- 配置初始化大小、最小、最大 -->    
    <property name="initialSize" value="${druid.pool.size.init}" />    
    <property name="minIdle" value="${druid.pool.size.min}" />     
    <property name="maxActive" value="${druid.pool.size.max}" />    
      
    <!-- 配置监控统计拦截的filters，去掉后监控界面sql无法统计 -->  
    <property name="filters" value="stat" />   
</bean>  
```