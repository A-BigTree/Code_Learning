# SpringBoot

**@author: Shuxin_Wang**

**@time: 2023.04.15**

---

[toc]

---

## 1 SpringBoot简介

### 1.1 简介

SpringBoot是一个集成了Spring技术栈的一个大整合，是一个简化了Spring应用开发的框架，可以一站式解决J2EE的开发流程。

### 1.2 特征

- `SpringBoot Starter`：他将常用的依赖分组进行了整合，将其合并到一个依赖中，这样就可以一次性添加到项目的`Maven`或`Gradle`构建中；
- 使编码变得简单，`SpringBoot`采用 `JavaConfig`的方式对Spring进行配置，并且提供了大量的注解，极大的提高了工作效率，比如`@Configuration`和`@bean`注解结合，基于`@Configuration`完成类扫描，基于`@bean`注解把返回值注入IOC容器；
- 自动配置：`SpringBoot`的自动配置特性利用了Spring对条件化配置的支持，合理地推测应用所需的bean并自动化配置他们；
- 使部署变得简单，`SpringBoot`内置了三种Servlet容器，`Tomcat`，`Jetty`，`undertow`.我们只需要一个Java的运行环境就可以跑`SpringBoot`的项目了，`SpringBoot`的项目可以打成一个jar包；

