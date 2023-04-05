# SpringMVC

**@author: Shuxin_Wang**

**@time: 2023.04.04**

---

[toc]

---

<img src="SpringMVC.assets/image-20230404223304169.png" alt="image-20230404223304169" style="zoom:50%;" />

# 1 SpringMVC基础操作

## 1.1 SpringMVC概述

### 1.1.1 SpringMVC优势

SpringMVC是Spring为表述层开发提供的一整套完备的解决方案。

在表述层框架历经`Strust`、`WebWork`、`Strust2`等诸多产品的历代更迭之后，目前业界普遍选择了SpringMVC作为`Java EE`项目表述层开发的**首选方案**。之所以能做到这一点，是因为SpringMVC具备如下显著优势：

- **Spring 家族原生产品**，与IOC容器等基础设施无缝对接；
- 表述层各细分领域需要解决的问题**全方位覆盖**，提供**全面解决方案**；
- **代码清新简洁**，大幅度提升开发效率；
- 内部组件化程度高，可插拔式组件**即插即用**，想要什么功能配置相应组件即可；
- **性能卓著**，尤其适合现代大型、超大型互联网项目要求；

### 1.1.2 表述层要解决的问题

- 请求映射
- 数据输入
- 视图界面
- 请求分发
- 表单回显
- 会话控制
- 过滤拦截
- 异步交互
- 文件上传
- 文件下载
- 数据校验
- 类型转换

### 1.1.3 SpringMVC代码对比

#### 基于原生Servlet API开发

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                                        throws ServletException, IOException {   
    
    String userName = request.getParameter("userName");
    
    System.out.println("userName="+userName);
    
}
```

#### 基于SpringMVC开发

```java
@RequestMapping("/user/login")
public String login(@RequestParam("userName") String userName){
    
    log.debug("userName="+userName);
    
    return "result";
}
```

## 1.2 HelloWorld

### 1.2.1 功能需求

#### 访问首页

<img src="SpringMVC.assets/image-20230405120050049.png" alt="image-20230405120050049" style="zoom:50%;" />

#### 在首页点超链接

<img src="SpringMVC.assets/image-20230405120122495.png" alt="image-20230405120122495" style="zoom:50%;" />

### 1.2.2 搭建环境

#### 导入依赖

```xml
<dependencies>
    <!-- SpringMVC -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.1</version>
    </dependency>
    
    <!-- 日志 -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.2.3</version>
    </dependency>
    
    <!-- ServletAPI -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <scope>provided</scope>
    </dependency>
    
    <!-- Spring5和Thymeleaf整合包 -->
    <dependency>
        <groupId>org.thymeleaf</groupId>
        <artifactId>thymeleaf-spring5</artifactId>
        <version>3.0.12.RELEASE</version>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.12</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

#### web.xml

```xml
<!-- 配置SpringMVC中负责处理请求的核心Servlet，也被称为SpringMVC的前端控制器 -->
<servlet>
    <servlet-name>DispatcherServlet</servlet-name>
    
    <!-- DispatcherServlet的全类名 -->
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    
    <!-- 通过初始化参数指定SpringMVC配置文件位置 -->
    <init-param>
    
        <!-- 如果不记得contextConfigLocation配置项的名称，可以到DispatcherServlet的父类FrameworkServlet中查找 -->
        <param-name>contextConfigLocation</param-name>
    
        <!-- 使用classpath:说明这个路径从类路径的根目录开始才查找 -->
        <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    
    <!-- 作为框架的核心组件，在启动过程中有大量的初始化操作要做，这些操作放在第一次请求时才执行非常不恰当 -->
    <!-- 我们应该将DispatcherServlet设置为随Web应用一起启动 -->
    <load-on-startup>1</load-on-startup>
    
</servlet>
    
<servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    
    <!-- 对DispatcherServlet来说，url-pattern有两种方式配置 -->
    <!-- 方式一：配置“/”，表示匹配整个Web应用范围内所有请求。这里有一个硬性规定：不能写成“/*”。只有这一个地方有这个特殊要求，以后我们再配置Filter还是可以正常写“/*”。 -->
    <!-- 方式二：配置“*.扩展名”，表示匹配整个Web应用范围内部分请求 -->
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

#### Spring配置文件

```xml
<!-- 自动扫描包 -->
<context:component-scan base-package="com.atguigu.mvc.handler"/>
    
<!-- Thymeleaf视图解析器 -->
<bean id="viewResolver" class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
    <property name="order" value="1"/>
    <property name="characterEncoding" value="UTF-8"/>
    <property name="templateEngine">
        <bean class="org.thymeleaf.spring5.SpringTemplateEngine">
            <property name="templateResolver">
                <bean class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
    
                    <!-- 视图前缀 -->
                    <property name="prefix" value="/WEB-INF/templates/"/>
    
                    <!-- 视图后缀 -->
                    <property name="suffix" value=".html"/>
                    <property name="templateMode" value="HTML5"/>
                    <property name="characterEncoding" value="UTF-8" />
                </bean>
            </property>
        </bean>
    </property>
</bean>
```

#### logback.xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration debug="true">
    <!-- 指定日志输出的位置，ConsoleAppender表示输出到控制台 -->
    <appender name="STDOUT"
              class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!-- 日志输出的格式 -->
            <!-- 按照顺序分别是：时间、日志级别、线程名称、打印日志的类、日志主体内容、换行 -->
            <pattern>[%d{HH:mm:ss.SSS}] [%-5level] [%thread] [%logger] [%msg]%n</pattern>
            <charset>UTF-8</charset>
        </encoder>
    </appender>

    <!-- 设置全局日志级别。日志级别按顺序分别是：TRACE、DEBUG、INFO、WARN、ERROR -->
    <!-- 指定任何一个日志级别都只打印当前级别和后面级别的日志。 -->
    <root level="INFO">
        <!-- 指定打印日志的appender，这里通过“STDOUT”引用了前面配置的appender -->
        <appender-ref ref="STDOUT" />
    </root>

    <!-- 根据特殊需求指定局部日志级别，可也是包名或全类名。 -->
    <logger name="com.atguigu" level="DEBUG" />

</configuration>
```

### 1.2.3 代码实现

#### 实现访问首页

```java
@Slf4j
@Controller
public class Demo01HelloHandler {

    // @RequestMapping注解在请求地址和Java方法之间建立映射关系
    @RequestMapping("/")
    public String showPortal() {
        return "portal";
    }

}
```

#### portal.html编写超链接

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
    
    <h1>首页</h1>
    
    <!-- 以后我们会越来越倾向于用一句话来作为请求的URL地址，在这样的一句话中使用“/”分隔各个单词 -->
    <!-- say hello to spring mvc -->
    <!-- /say/hello/to/spring/mvc -->
    <a th:href="@{/say/hello/to/spring/mvc}">HelloWorld</a><br/>
    
</body>
</html>
```

#### 目标页面target.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>目标页面</title>
</head>
<body>
    
    <h1>目标页面</h1>
    
    <a th:href="@{/}">回首页</a>
    
</body>
</html>
```

#### 声明handler方法

```java
// 以后我们会越来越倾向于用一句话来作为请求的URL地址
// 在这样的一句话中使用“/”分隔各个单词
@RequestMapping("/say/hello/to/spring/mvc")
public String sayHello() {
    
    // 方法内部打印日志，证明 SpringMVC 确实调用了这个方法来处理请求
    log.debug("我是 SpringMVC 的 Hello world。");
    
    return "target";
}
```

### 1.2.4 整套流程解析

<img src="SpringMVC.assets/image-20230405153314220.png" alt="image-20230405153314220" style="zoom:50%;" />

## 1.3 `@RequestMapping`注解

### 1.3.1 匹配方式说明

#### 精确匹配

在`@RequestMapping`注解指定URL地址时，**不使用任何通配符**，按照请求地址进行精确匹配。

```HTML
<a th:href="@{/say/hello/to/spring/mvc}">HelloWorld</a><br/>
```

```Java
@RequestMapping("/say/hello/to/spring/mvc")
```

#### 模糊匹配

在`@RequestMapping`注解指定URL地址时，通过使用通配符，匹配多个类似的地址。

```HTML
<h3>测试@RequestMapping注解匹配方式</h3>
<a th:href="@{/fruit/apple}">@RequestMapping模糊匹配[apple]</a><br/>
<a th:href="@{/fruit/orange}">@RequestMapping模糊匹配[orange]</a><br/>
<a th:href="@{/fruit/banana}">@RequestMapping模糊匹配[banana]</a><br/>
```

```Java
@RequestMapping("/fruit/*")
```

单层匹配和多层匹配：

-  `/*`：只能匹配URL地址中的一层，如果想准确匹配两层，那么就写“`/*/*`”以此类推；
- `/**`：可以匹配URL地址中的多层。 

其中所谓的一层或多层是指一个URL地址字符串被`/`划分出来的各个层次 这个知识点虽然对于`@RequestMapping`注解来说实用性不大，但是将来配置拦截器的时候也遵循这个规则。

### 1.3.2 在类级别标记

#### 超链接的HTML标签

```html
<h3>测试@RequestMapping注解标记在类上</h3>
<a th:href="@{/user/login}">用户登录</a><br/>
<a th:href="@{/user/register}">用户注册</a><br/>
<a th:href="@{/user/logout}">用户退出</a><br/>
```

#### 仅在标记方法上的`@RequestMapping`注解

```java
@RequestMapping("/user/login")
@RequestMapping("/user/register")
@RequestMapping("/user/logout")
```

#### 分别标记类和方法上

在类级别：抽取各个方法上@RequestMapping注解地址中前面重复的部分

```Java
@RequestMapping("/user")
```

在方法级别：省略被类级别抽取的部分

```Java
@RequestMapping("/login")
@RequestMapping("/register")
@RequestMapping("/logout")
```

### 1.3.3 附加请求方式

#### 请求方式

HTTP 协议定义了八种请求方式，在 SpringMVC 中封装到了下面这个枚举类：

```Java
public enum RequestMethod {

  GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE

}
```

#### 注解附加请求方式

```html
<h3>测试@RequestMapping注解限定请求方式</h3>
<a th:href="@{/emp}">同地址GET请求</a><br/>
<form th:action="@{/emp}" method="post">
    <button type="submit">同地址POST请求</button>
</form>
<br/>
```

处理 GET 请求：

```Java
@RequestMapping(value = "/emp", method = RequestMethod.GET)
public String empGet() {
    
    log.debug("GET 请求");
    
    return "target";
}
```

处理 POST 请求：

```Java
@RequestMapping(value = "/emp", method = RequestMethod.POST)
public String empPost() {
    
    log.debug("POST 请求");
    
    return "target";
}
```

#### 进阶版

| 原版                                                         | 进阶版               |
| ------------------------------------------------------------ | -------------------- |
| @RequestMapping(value = "/emp", <br />method = RequestMethod.GET) | @GetMapping("/emp")  |
| @RequestMapping(value = "/emp", <br />method = RequestMethod.POST) | @PostMapping("/emp") |




除了 `@GetMapping`、`@PostMapping`还有下面几个类似的注解：

- `@PutMapping`
- `@DeleteMapping`
- `@PatchMapping`

另外需要注意：进阶版的这几个注解是从 4.3 版本才开始有，低于 4.3 版本无法使用。

## 1.4 获取请求参数

### 1.4.1 一名一值

#### 超链接

```html
<a th:href="@{/param/one/name/one/value(userName='tom')}">一个名字一个值的情况</a><br/>
```

#### `@RequestParam`注解

```java
@RequestMapping("/param/one/name/one/value")
public String oneNameOneValue(
        // 使用@RequestParam注解标记handler方法的形参
        // SpringMVC 会将获取到的请求参数从形参位置给我们传进来
        @RequestParam("userName") String userName
) {
    
    log.debug("获取到请求参数：" + userName);
    
    return "target";
}
```

#### 省略注解

```java
@RequestMapping("/param/one/name/one/value")
public String oneNameOneValue(
        // 当请求参数名和形参名一致，可以省略@RequestParam("userName")注解
        // 但是，省略后代码可读性下降而且将来在SpringCloud中不能省略，所以建议还是不要省略
        String userName
) {
    
    logger.debug("★获取到请求参数：" + userName);
    
    return "target";
}
```

#### 关闭请求参数必需

required 属性设置为 false 表示这个请求参数可有可无：

```Java
@RequestParam(value = "userName", required = false)
```

#### 参数设置默认值

使用`defaultValue`属性给请求参数设置默认值：

```Java
@RequestParam(value = "userName", required = false, defaultValue = "missing")
```

此时`required`属性可以继续保持默认值：

```Java
@RequestParam(value = "userName", defaultValue = "missing")
```

### 1.4.2 一名多值

#### 表单

```html
<form th:action="@{/param/one/name/multi/value}" method="post">
    请选择你最喜欢的球队：
    <input type="checkbox" name="team" value="Brazil"/>巴西
    <input type="checkbox" name="team" value="German"/>德国
    <input type="checkbox" name="team" value="French"/>法国
    <input type="checkbox" name="team" value="Holland"/>荷兰
    <input type="checkbox" name="team" value="Italian"/>意大利
    <input type="checkbox" name="team" value="China"/>中国
    <br/>
    <input type="submit" value="保存"/>
</form>
```

#### handler方法

```java
@RequestMapping("/param/one/name/multi/value")
public String oneNameMultiValue(
    
        // 在服务器端 handler 方法中，使用一个能够存储多个数据的容器就能接收一个名字对应的多个值请求参数
        @RequestParam("team") List<String> teamList
        ) {
    
    for (String team : teamList) {
        logger.debug("team = " + team);
    }
    
    return "target";
}
```

### 1.4.3 表单对应模型

#### 表单

```html
<form th:action="@{/emp/save}" method="post">
    姓名：<input type="text" name="empName"/><br/>
    年龄：<input type="text" name="empAge"/><br/>
    工资：<input type="text" name="empSalary"/><br/>
    <input type="submit" value="保存"/>
</form>
```

#### 处理方法

```java
@RequestMapping("/param/form/to/entity")
public String formToEntity(
    
        // SpringMVC 会自动调用实体类中的 setXxx() 注入请求参数
        Employee employee) {
    
    logger.debug(employee.toString());
    
    return "target";
}
```

#### POST请求乱码问题

到 web.xml 中配置 CharacterEncodingFilter 即可：

```XML
<!-- 配置过滤器解决 POST 请求的字符乱码问题 -->
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    
    <!-- encoding参数指定要使用的字符集名称 -->
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
    
    <!-- 请求强制编码 -->
    <init-param>
        <param-name>forceRequestEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
        
    <!-- 响应强制编码 -->
    <init-param>
        <param-name>forceResponseEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

> 注1：在较低版本的 SpringMVC 中，`forceRequestEncoding`属性、`forceResponseEncoding`属性没有分开，它们是一个`forceEncoding`属性。这里需要注意一下；
>
> 注2：由于`CharacterEncodingFilter`是通过`request.setCharacterEncoding(encoding)`来设置请求字符集，所以在此操作前不能有任何的`request.getParameter()`操作。在设置字符集之前获取过请求参数，那么设置字符集的操作将无效。

### 1.4.4 表单对应实体类包含级联属性

#### 实体类

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String stuName;
    private School school;
    private List<Subject> subjectList;

}
```

#### 表单

```html
<!-- 提交数据的表单 -->
<form th:action="@{/param/cascad}" method="post">
    stuName：<input type="text" name="stuName" value="tom"/><br/>
    school.schoolName:<input type="text" name="school.schoolName" value="atguigu"/><br/>
    subjectList[0].subjectName:<input type="text" name="subjectList[0].subjectName" value="java"/><br/>
    subjectList[1].subjectName:<input type="text" name="subjectList[1].subjectName" value="php"/><br/>
    subjectList[2].subjectName:<input type="text" name="subjectList[2].subjectName" value="javascript"/><br/>
    subjectList[3].subjectName:<input type="text" name="subjectList[3].subjectName" value="css"/><br/>
    subjectList[4].subjectName:<input type="text" name="subjectList[4].subjectName" value="vue"/><br/>
    <input type="submit" value="保存"/>
</form>
```

#### 处理方法

```java
@RequestMapping("/param/form/to/nested/entity")
public String formToNestedEntity(
    
        // SpringMVC 自己懂得注入级联属性，只要属性名和对应的getXxx()、setXxx()匹配即可
        Student student) {
    
    logger.debug(student.toString());
    
    return "target";
}
```

### 1.4.5 要发送的数据是List

#### 额外封装一层

```java
public class EmployeeParam {
    
    private List<Employee> employeeList;
    ……
```

#### 表单

```html
直接发送 List&lt;Employee&gt;：<br/>
<form th:action="@{/param/list/emp}" method="post">
    1号员工姓名：<input type="text" name="employeeList[0].empName" /><br/>
    1号员工年龄：<input type="text" name="employeeList[0].empAge" /><br/>
    1号员工工资：<input type="text" name="employeeList[0].empSalary" /><br/>
    2号员工姓名：<input type="text" name="employeeList[1].empName" /><br/>
    2号员工年龄：<input type="text" name="employeeList[1].empAge" /><br/>
    2号员工工资：<input type="text" name="employeeList[1].empSalary" /><br/>
    <button type="submit">保存</button>
</form>
```

#### 处理方法

```java
@RequestMapping("/param/list/emp")
public String saveEmpList(
        // SpringMVC 访问这里实体类的setEmployeeList()方法注入数据
        EmployeeParam employeeParam
) {
    
    List<Employee> employeeList = employeeParam.getEmployeeList();
    
    for (Employee employee : employeeList) {
        logger.debug(employee.toString());
    }
    
    return "target";
}
```

## 1.5 `@CookieValue`注解

### 1.5.1 作用

获取当前请求中的Cookie数据。

### 1.5.2 用法

```java
@RequestMapping("/request/cookie")
public String getCookie(
    
        // 使用 @CookieValue 注解获取指定名称的 Cookie 数据
        // name 或 value 属性：指定Cookie 名称
        // defaultValue 属性：设置默认值
        @CookieValue(value = "JSESSIONID", defaultValue = "missing") String cookieValue,
    
        // 形参位置声明 HttpSession 类型的参数即可获取 HttpSession 对象
        HttpSession session
) {
    
    log.debug("cookieValue = " + cookieValue);
    
    return "target";
}
```

## 1.6 页面跳转控制

### 1.6.1 准备工作

- 准备一个地址在前后缀范围之外的页面；
- 让这个页面能够成功访问；

#### 创建范围之外的页面`outter.html`

```html
<body>
    
    <h1>范围之外页面</h1>
    
</body>
```

很多时候我们创建静态资源文件时，IDEA并不会自动帮我们放在构建目录下，进而就会导致部署到服务器上运行的时候没有这个文件，此时需要我们自己手动构建。

#### 配置SpringMVC配置文件

```xml
<mvc:annotation-driven/>
<mvc:default-servlet-handler/>
```

### 1.6.2 使用指令

#### 转发指令

```java
@RequestMapping("/test/forward/command")
public String forwardCommand() {
    
    // 需求：要转发前往的目标地址不在视图前缀指定的范围内，
    // 通过返回逻辑视图、拼接前缀后缀得到的物理视图无法达到目标地址
    
    // 转发到指定的地址：
    return "forward:/outter.html";
}
```

#### 重定向指令

```java
@RequestMapping("/test/redirect/command")
public String redirectCommand() {
    
    // 重定向到指定的地址：
    // 这个地址由 SpringMVC 框架负责在前面附加 contextPath，所以我们不能加，我们加了就加多了
    // 框架增加 contextPath 后：/demo/outter.html
    // 我们多加一个：/demo/demo/outter.html
    return "redirect:/outter.html";
}
```

### 1.6.3 指令处理在源码中的位置

#### 所在的类

- `org.thymeleaf.spring5.view.ThymeleafViewResolver`

#### 所在方法

<img src="SpringMVC.assets/image-20230405175731217.png" alt="image-20230405175731217" style="zoom:50%;" />

## 1.7 获取原生Servlet API对象

### 1.7.1 原生Servlet API

- `HttpServletRequest`
- `HttpServletResponse`
- `HttpSession`
- `ServletContext`

原生：最原始的、本真的，没有经过任何的加工、包装和处理。

API：直接翻译过来是应用程序接口的意思。对我们来说，提到 API 这个词的时候，通常指的是在某个特定的领域，已经封装好可以直接使用的一套技术体系。很多时候，特定领域的技术规范都是对外暴露一组接口作为这个领域的技术标准，然后又在这个标准下有具体实现。

### 1.7.2 可以直接拿到对象

#### 创建超链接

```html
<a th:href="@{/original/api/direct}">可以直接得到的三个</a><br/>
```

#### 处理方法

```java
@RequestMapping("/original/api/direct")
public String getOriginalAPIDirect(
        
        // 有需要使用的 Servlet API 直接在形参位置声明即可。
        // 需要使用就写上，不用就不写，开发体验很好，这里给 SpringMVC 点赞
        HttpServletRequest request,
        HttpServletResponse response,
        HttpSession session
) {
    
    logger.debug(request.toString());
    logger.debug(response.toString());
    logger.debug(session.toString());
    
    return "target";
}
```

`ServletContext`对象没法通过形参声明的方式直接获取，如果非要在形参位置声明`ServletContext`类型的变量，那么会抛出异常。

### 1.7.3 获取`ServletContext`

通过

