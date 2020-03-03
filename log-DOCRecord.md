=========================================================================================

    Log4j��������Ҫ��������ɣ���־��Ϣ�����ȼ�����־��Ϣ�����Ŀ�ĵأ���־��Ϣ�������ʽ��
    log4j.rootLogger=INFO, A1,...
        --INFO--ָ��־��¼�����ȼ���Log4j����ֻʹ���ĸ��������ȼ��Ӹߵ��ͷֱ���ERROR��WARN��INFO��DEBUG
        --A1----����ָ����־��Ϣ������ĸ��ط���������ͬʱָ��������Ŀ�ĵء� 
    log4j.appender.A1=org.apache.log4j.ConsoleAppender 
        --org.apache.log4j.ConsoleAppender������̨����
        --org.apache.log4j.FileAppender���ļ����� 
        --org.apache.log4j.DailyRollingFileAppender��ÿ�����һ����־�ļ����� 
        --org.apache.log4j.RollingFileAppender���ļ���С����ָ���ߴ��ʱ�����һ���µ��ļ����� 
        --org.apache.log4j.WriterAppender������־��Ϣ������ʽ���͵�����ָ���ĵط���
    log4j.appender.A1.Threshold=WARN
    log4j.appender.A1.ImmediateFlush=true
        --(1).ConsoleAppender,FileAppender,DailyRollingFileAppender,RollingFileAppender��������
            --Threshold=WARN:ָ����־��Ϣ�������Ͳ�Ρ� 
            --ImmediateFlush=true:Ĭ��ֵ��true,��ν�����е���Ϣ���ᱻ��������� 
        --���ԣ�
            --1.ConsoleAppenderѡ��:
                --Target=System.err��Ĭ��������ǣ�System.out,ָ���������̨ 
            --2.FileAppender ѡ��:
                --File=mylog.txt:ָ����Ϣ�����mylog.txt�ļ��� 
                --Append=false:Ĭ��ֵ��true,������Ϣ���ӵ�ָ���ļ��У�falseָ����Ϣ����ָ�����ļ�����
            --3.DailyRollingFileAppender ѡ�� 
                --File=mylog.txt:ָ����Ϣ�����mylog.txt�ļ��� 
                --Append=false:Ĭ��ֵ��true,������Ϣ���ӵ�ָ���ļ��У�falseָ����Ϣ����ָ�����ļ����ݡ� 
                --DatePattern=��.'yyyy-ww:ÿ�ܹ���һ���ļ�����ÿ�ܲ���һ���µ��ļ�����ȻҲ����ָ�����¡��ܡ��졢ʱ�ͷ֡�����Ӧ�ĸ�ʽ���£� 
                --  1)��.'yyyy-MM: ÿ�� 
                --  2)��.'yyyy-ww: ÿ�� 
                --  3)��.'yyyy-MM-dd: ÿ�� 
                --  4)��.'yyyy-MM-dd-a: ÿ������ 
                --  5)��.'yyyy-MM-dd-HH: ÿСʱ 
                --  6)��.'yyyy-MM-dd-HH-mm: ÿ���� 
            --4..RollingFileAppender ѡ�� 
                --File=mylog.txt:ָ����Ϣ�����mylog.txt�ļ��� 
                --Append=false:Ĭ��ֵ��true,������Ϣ���ӵ�ָ���ļ��У�falseָ����Ϣ����ָ�����ļ����ݡ� 
                --MaxFileSize=100KB: ��׺������KB, MB ������ GB. ����־�ļ�����ô�Сʱ�������Զ�����������ԭ���������Ƶ�mylog.log.1�ļ��� 
                --MaxBackupIndex=2:ָ�����Բ����Ĺ����ļ���������� 
    log4j.appender.A1.layout=org.apache.log4j.PatternLayout 
    log4j.appender.A1.layout.ConversionPattern=%-4r %-5p [%t] %37c %3x - %m%n 
        --��־�������ʽ��
            --org.apache.log4j.HTMLLayout����HTML�����ʽ���֣��� 
            --org.apache.log4j.PatternLayout����������ָ������ģʽ���� 
            --org.apache.log4j.SimpleLayout��������־��Ϣ�ļ������Ϣ�ַ������� 
            --org.apache.log4j.TTCCLayout��������־������ʱ�䡢�̡߳����ȵ���Ϣ�� 
        --4�������ʽ���� 
            --�������ļ��п���ͨ��log4j.appender.A1.layout.ConversionPattern������־�����ʽ�� 
            --������ 
            --%p: �����־��Ϣ���ȼ�����DEBUG��INFO��WARN��ERROR��FATAL, 
            --%d: �����־ʱ�������ڻ�ʱ�䣬Ĭ�ϸ�ʽΪISO8601��Ҳ���������ָ����ʽ�����磺%d{yyy MMM dd HH:mm:ss,SSS}��������ƣ�2002��10��18�� 22��10��28��921 
            --%r: �����Ӧ�������������log��Ϣ�ķѵĺ����� 
            --%c: �����־��Ϣ��������Ŀ��ͨ�������������ȫ�� 
            --%t: �����������־�¼����߳��� 
            --%l: �����־�¼��ķ���λ�ã��൱��%C.%M(%F:%L)�����,������Ŀ�����������̣߳��Լ��ڴ����е�������������Testlog4.main(TestLog4.java:10) 
            --%x: ����͵�ǰ�߳��������NDC(Ƕ����ϻ���),�����õ���java servlets�����Ķ�ͻ����̵߳�Ӧ���С� 
            --%%: ���һ����%���ַ� 
            --%F: �����־��Ϣ����ʱ���ڵ��ļ����� 
            --%L: ��������е��к� 
            --%m: ���������ָ������Ϣ,��������־������Ϣ 
            --%n: ���һ���س����з���Windowsƽ̨Ϊ��\r\n����Unixƽ̨Ϊ��\n�������־��Ϣ���� 
            --������%��ģʽ�ַ�֮��������η�����������С��ȡ�����ȡ����ı��Ķ��뷽ʽ���磺 
            --1)%20c��ָ�����category�����ƣ���С�Ŀ����20�����category������С��20�Ļ���Ĭ�ϵ�������Ҷ��롣 
            --2)%-20c:ָ�����category�����ƣ���С�Ŀ����20�����category������С��20�Ļ�����-����ָ������롣 
            --3)%.30c:ָ�����category�����ƣ����Ŀ����30�����category�����ƴ���30�Ļ����ͻὫ��߶�����ַ��ص�����С��30�Ļ�Ҳ�����пո� 
            --4)%20.30c:���category������С��20�Ͳ��ո񣬲����Ҷ��룬��������Ƴ���30�ַ����ʹ���߽�Զ�������ַ��ص���
    ===============================================================================================
    --web��ĿLog4j��־���·���������⣺
        --����������һ��web��Ŀ����һ��tomcat�����ж��ʵ����ͨ���޸�war�����Ƶ�ʵ�֣���Ȼ��ÿ��ʵ��������־�����tomcat��logsĿ¼��ʵ�����������ļ����½������ֲ鿴ÿ��ʵ����־��Ҫ��ͨ���������ٵĸĶ������ļ�������޸�ʵ��������Բ��޸�log4j�������ļ���
    ʵ�ַ�����һ��ʵ������������Ҫ���޸���war������֮��Ҫ�����������ã�
    1���޸�ÿ��ʵ������web.xml�в���webAppRootKeyΪ��ֵͬ��ͬһ��tomcat�����ж��webӦ��ʱ����ֵ��ͬ�Ļ�������ʱ�����쳣��
         <context-param>
            <param-name>webAppRootKey</param-name>
            <param-value>webApp.root</param-value>
        </context-param>
    2��log4j�����ļ���־���·���޸�
         log4j�����ļ���·������һ�������ַ�����
    ��1������·������ֱ������Ϊϵͳ����·����
    ��2�����·������
                log4j.appender.logfile.File=../logs/app.log������־��¼��tomcat�µ�logs�ļ��У�
                log4j.appender.logfile.File=logs/app.log������־��¼��tomcat��binĿ¼�µ�logs�ļ��У�
    ��3��ʹ�û����������·�����������������jvm����������Ȼ������ϵͳ���������������������ļ��еı�����
            log4j.appender.logfile.File=${user.dir}/logs/app.log��ʹ��tomcat����ʱ${user.dir}��Ӧtomcat��binĿ¼��
            log4j.appender.logfile.File=${user.home}/logs/app.log��${user.home}��Ӧ����ϵͳ��ǰ�û�Ŀ¼��
            log4j.appender.logfile.File=${webApp.root}/logs/app.log��${webApp.root}��Ӧ��ǰӦ�ø�Ŀ¼��
    
    ��ʱû�ҵ����޸�log4j���ö�ʵ����������ķ�������log4j�����ļ��п��Ի�ȡ�������������ã���������û�е�ǰӦ�õ����ƣ�����ֱ��ͨ��webApp.root����Ϊ���ڲ�ͬ��ʵ�����Ʋ�һ������������web.xml������listener����ȡӦ�����ƣ�Ȼ�����System.setProperty("contextPath", sce.getServletContext().getContextPath());�����������õ�ϵͳ��������log4jӦ�ã�����ʵ������ʱÿ��ʵ������ı������ֵ��
    ���ۣ�������Ľ��������
    1���ֶ��޸����ã��޸�war���ƺ��ֶ��޸�web.xml��log4j�����ļ���ʵ����������
    2��ͨ���������������������޸ģ���bat��maven�����޸�war������ʱ���Զ��޸ĵ�web.xml��log4j��������á�
    ===============================================================================================
    --����һ��ֱ����log4j������д����·��
    --���������½�һ��ServletContextListener��ʵ����Log4jConfigListener��Log4jConfigListener����
        [java] view plain copy
            String path = Environment.class.getResource("").getPath();  
            String webAppPath = path.substring(0, path.toUpperCase().lastIndexOf("WEB-INF/")).replaceAll("%20", " ");  
            System.setProperty("webapp",webAppPath + "logs/log.log");  
        ��log4j�����У�
        [plain] view plain copy
            log4j.appender.A2.File=${webapp}/logs/log.log  
    --����������Spring���ɣ�����web.xml������
    [html] view plain copy
            <context-param>  
                <param-name>webAppRootKey</param-name>    
                <param-value>webapp.root</param-value>    
            </context-param>   
            <context-param>  
                        <param-name>log4jConfigLocation</param-name>  
                        <param-value>/WEB-INF/config/log4j.properties</param-value>  
            </context-param>   
            <context-param>  
                        <param-name>log4jRefreshInterval</param-name>  
                        <param-value>6000</param-value>  
            </context-param>  
            <listener>  
                       <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>  
            </listener>  
            Ȼ����log4j�����������õ�webAppRootKey��Ӧ��ֵ
            [plain] view plain copy
            log4j.appender.file.File=${webapp.root}/WEB-INF/logs/log.log  
            
            =================================================================
            
    log4j.appender.R=org.apache.log4j.RollingFileAppender 
    log4j.appender.R.File=c\://tsbonlinetraininglog/tsb_web_sns.html 
    #log4j.appender.R.File=../logs/TSB_SYSTEM_WEB.log
    log4j.appender.R.MaxFileSize=2000KB 
    log4j.appender.R.MaxBackupIndex=20 
    log4j.appender.R.layout=org.apache.log4j.FormatHTMLLayout
    #log4j.appender.R.layout=org.apache.log4j.HTMLLayout 
    #log4j.appender.R.layout=org.apache.log4j.PatternLayout 
    #log4j.appender.R.layout.ConversionPattern=%d{yyyy-MM-dd HH\:mm\:ss}-%m%n
    log4j.appender.R.layout.ConversionPattern=%-d{yyyy-MM-dd HH:mm:ss}-[%p] %m%n
