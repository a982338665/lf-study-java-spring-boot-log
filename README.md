# spring-boot-log
log日志打印


**1.日志打印注意事项：**

    1.文件命名：projectName_logName_logType.log 【项目-名称-作用】
    2.保留时长：一般建议15天
    3.常见日志级别：
        DEBUG级别:记录调试程序相关的信息。
        INFO级别:记录程序正常运行有意义的信息。
        WARN级别:记录可能会出现潜在错误的信息。
        ERROR级别:记录当前程序出错的信息，需要被关注处理。
        Fatal级别：表示出现了严重错误，程序将会中断执行。建议在项目中使用这四种级别，重大灾难信息，比如数据库无法连接等需要立即处理的问题
        bussiness: 打印重要业务的日志，比如抢购成功、订单创建成功的相关信息、删除用户等
    4.日志打印：使用占位符-防止字符串连接浪费资源
        错误：logger.debug("id="+id+",user="+user)
        正确：logger.debug("id={},user={}",id,user)
    5.避免生产环境出现debug打印：-影响程序
    6.保证日志记录信息完整性：
        logger.error("rabbitmq {},{}",e.getMessage(),e)
    7.定义logger变量为静态，避免每次都重新创建-否则可能导致OOM
        private static final Logger logger = LoggerFactory.getLogger(XX.class);
    8.正确使用日志级别
    9.推荐使用slf4j+logback组合
        logback库里自身就已经实现了slf4j的接口，就无需引入多余的适配器了，而且logback也具有更多的优点，建议新项目可以使用这个组合。
        还有一点需要注意，当引入slf4j后，要注意其实际使用的日志库是否是由我们引入的，也有可能会使用了我们第三方依赖包所带入的日志库，
        这样就可能会导致我们的日志失效。
    10.日志的聚合分析
       日志的聚合可以把位于不同服务器之间的日志统一起来分析处理，如今ELK技术栈亦或者的EFG(fluentd+elasticsearch+grafana)
       等都是一些比较成熟的开源解决方案   
       拿ELK来说，可以在我们的服务器上直接通过logstash来读取应用打印的日志文件，或者也可以在我们项目中的日志配置文件里配置好相关的socket信息，
       打印的时候直接把日志信息输出至logstash。再交由elasticsearch存储，kibana展示。 
    11.日志文件分开打印，便于查看和抓取日志：info.log,debug.log...
    12.ELK日志收集预警：
        error级别日志3分钟预警，发送邮件
        warn级别日志10分钟预警，发送邮件
    
**2.logback:**
    
    ogback可以使用logstash-logback-encoder来打印json格式日志：
        <dependency>
            <groupId>net.logstash.logback</groupId>
            <artifactId>logstash-logback-encoder</artifactId>
            <version>4.5.1</version>
        </dependency>
    ** logback.xml配置：**
        <appender name="LOGSTASH" class="ch.qos.logback.core.rolling.RollingFileAppender">
            <file>${LOG_HOME}/log.json</file>
            <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                <fileNamePattern>${LOG_HOME}/log.json.%d{yyyy-MM-dd}</fileNamePattern>
                <maxHistory>7</maxHistory>
            </rollingPolicy>
            <encoder class="net.logstash.logback.encoder.LoggingEventCompositeJsonEncoder">
                <jsonFactoryDecorator class="com.sq.proxy.config.MyJsonFactoryDecorator" />
                <providers>
                    <timestamp>
                        <pattern>yyyy-MM-dd'T'HH:mm:ss.SSSZZ</pattern>
                    </timestamp>
                    <pattern>
                        <pattern>{"level":"%level","service":"${springAppName:-}","host":"%ip","pid":"${PID:-}","thread":"%thread","class":"%logger{40}:%L","message": "%message"},</pattern>
                    </pattern>
                </providers>
            </encoder>
        </appender>
    logger.error("getBalanceHint() 异常:{}", ExceptionUtils.getFullStackTrace(e));

**3.使用@Slf4j注解打印日志-lombok：pers.li.common.slf4j.Slf4jTest**
    
    1.引入注解：
        <!--可以引入日志 @Slf4j注解-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
    2.idea安装lombok
    3.打印：
