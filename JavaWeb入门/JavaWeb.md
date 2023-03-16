# JavaWeb基础

**@author: Shuxin_Wang**

**@time: 2023.03.15**

--------

[toc]

---------

# 1 JavaWeb开发概述

## 1.1 服务器端应用程序

<img src="image/image-20230316104021175.png" alt="image-20230316104021175" style="zoom: 50%;" />

## 1.2 请求和响应

<img src="image/image-20230316104154293.png" alt="image-20230316104154293" style="zoom: 50%;" />

## 1.3 架构

### 1.3.1 概念

**架构其实就是项目的结构**。只不过结构这个词太小了，不适合用来描述项目这么大的东西，所以换了另一个更大的词：架构。所以当我们聊一个项目的架构时，我们聊的是项目是由哪些部分组成的。

### 1.3.2 发展演变历程

#### 单一架构

一个项目就是一个工程，这样的结构就是单一架构，也叫`all in one`。我们现在的`JavaWeb`阶段、`SSM`阶段都是学习单一架构开发技术。

#### 分布式架构

一个项目中包含很多工程，每个工程作为一个模块。模块之间存在调用关系。分布式架构阶段的技术分为两类：

- Java框架：`SpringBoot`、`SpringCloud`、`Dubbo`等等；
- 中间件：`Redis`、`ElasticSearch`、`FastDFS`、`Nginx`、`Zookeeper`、`RabbitMQ`等等；

### 1.3.3 单一架构技术体系

- 视图：用户的操作界面+数据的动态显示：
  - 前端技术：`HTML/CSS/JavaScript`；
  - 服务器端页面模板技术：`Thymeleaf`；
- 控制层：处理请求+跳转页面：
  - 服务器：`Tomcat`；
  - 控制器：`Servlet`；
  - 域对象：`request`、`session`、`servletContext`；
  - 过滤器：`Filter`；
  - 监听器：`Listener`；
  - 异步交互：`Ajax`；
- 业务逻辑层：业务逻辑计算；
- 持久化层：操作数据库；

<img src="image/image-20230316104821865.png" alt="image-20230316104821865" style="zoom:50%;" />

## 1.4 技术体系

<img src="image/image-20230316105026505.png" alt="image-20230316105026505" style="zoom:50%;" />



# 2 HTML&CSS

## 2.1 单一架构

从现在的`JavaWeb`阶段到后面学习`SSM`框架阶段都是在学习单一架构项目开发的技术。而在`JavaWeb`阶段由于重点是探讨如何实现Web开发，所以必须学习一部分前端开发的技术。本节就是让大家明确我们现在要学习的内容在整个架构体系中处于什么位置。

### 2.1.1 视图层

严格来说视图分成两层：

- 前端技术：`HTML/CSS/JavaScript`
- 服务器端页面模板技术：`Thymeleaf`

其中`HTML`、`CSS`、`JavaScript`都是工作在浏览器上的，所以它们都属于前端技术。而`Thymeleaf`是在服务器上把动态内容计算出具体数据，所以严格来说`Thymeleaf`是后端技术。

<img src="image/image-20230316105537631.png" alt="image-20230316105537631" style="zoom:50%;" />

> 这里大家会有个疑问：为什么在`视图`这个地方已经有`HTML`、`CSS`、`JavaScript`这些前端技术了，能够生成用户可以操作的界面，那为什么还需要`Thymeleaf`这样一个后端技术呢？
>
> 简单来说原因是`Thymeleaf`=`HTML+动态数据`，而`HTML`不支持动态数据，这部分需要借助`Thymeleaf`来完成。

### 2.1.2 Web2.0

`Web2.0`是相对于更早的网页开发规范而提出的新规范。`Web2.0`规范之前的网页开发并没有明确的将`HTML`、`CSS`、`JavaScript`代码**<u>分开</u>**，而是互相之间纠缠在一起，导致代码维护困难，开发效率很低。

> 在开发中我们把这样彼此纠缠、互相影响的现象称为`耦合`。而把耦合在一起的东西拆解开，让他们彼此独立出来称为`解耦`。各个组成部分独立完成自己负责的功能，和其他模块无关称为`内聚`。
>
> 将来大家经常会听到一句话：软件开发提倡 `高内聚，低耦合`。
>
> 一个软件项目只有做到了高内聚、低耦合才能算得上结构严谨，模块化程度高，有利于开发和维护。

所以`Web2.0`规范主张将网页代码分成下面三个部分：

- 结构：由`HTML`实现，负责管理网页的内容。将来网页上不管是静态还是动态的数据都是填写到HTML的标签里；
- 表现：由`CSS`实现，负责管理网页内容的表现形式。比如：颜色、尺寸、位置、层级等等。也就是给数据穿上一身漂亮的衣服；
- 行为：由`JavaScript`实现，负责实现网页的动态交互效果。比如：轮播图、表单验证、鼠标滑过显示下拉菜单、鼠标滑过改变背景颜色等等；

## 2.2 HTML简介

### 2.2.1 超文本语言

**<u>超文本标记语言（Hyper Text Markup Language，HTML）</u>**文件本质上是文本文件，而普通的文本文件只能显示字符。但是HTML技术则通过HTML标签把其他网页、图片、音频、视频等各种多媒体资源引入到当前网页中，让网页有了非常丰富的呈现方式，这就是超文本的含义——本身是文本，但是呈现出来的最终效果超越了文本

<img src="image/image-20230316110450706.png" alt="image-20230316110450706" style="zoom: 50%;" />

### 2.2.2 标记语言

说HTML是一种『标记语言』是因为它不是向Java这样的『编程语言』，因为它是由一系列『标签』组成的，没有常量、变量、流程控制、异常处理、IO等等这些功能。HTML很简单，每个标签都有它固定的含义和确定的页面显示效果。

标签是通过一组尖括号+标签名的方式来定义的：

```html
<p>
    HTML is a very popular fore-end technology.
</p>
```

这个例子中使用了一个`p`标签来定义一个段落，`<p>`叫**『开始标签』**，`</p>`叫**『结束标签』**。开始标签和结束标签一起构成了一个完整的标签。开始标签和结束标签之间的部分叫**『文本标签体』**，也简称**『标签体』**。

有时候标签还带有**<u>属性</u>**：

```html
<a href="http://www.xxx.com">
    show detail
</a>
```

`href="http://www.xxx.com"`就是属性，`href`是**『属性名』**，`"http://www.xxx.com"`是**『属性值』**。

还有一种标签是**<u>单标签</u>**：

```html
<input type="text" name="username" />
```

### 2.2.3 Hello World

<img src="image/image-20230316111057397.png" alt="image-20230316111057397" style="zoom:50%;" />

### 2.2.4 HTML文件结构

#### 文档类型声明

HTML文件中第一行的内容，用来告诉浏览器当前HTML文档的基本信息，其中最重要的就是当前HTML文档遵循的语法标准。这里我们只需要知道HTML有4和5这两个大的版本，`HTML4`版本的文档类型声明是：

```html
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
```

`HTML5`版本的文档类型声明是：

```html
<!DOCTYPE html>
```

现在主流的技术选型都是使用`HTML5`，之前的版本基本不用了。

#### 根标签

`html`标签是整个文档的根标签，所有其他标签都必须放在html标签里面。上面的文档类型不能当做普通标签看待。

> 所谓『根』其实是『树根』的意思。在一个树形结构中，根节点只能有一个。

#### 头部

`head`标签用于定义文档的头部，其他头部元素都放在head标签里。头部元素包括`title`标签、`script`标签、`style`标签、`link`标签、`meta`标签等等。

#### 主体

`body`标签定义网页的主体内容，在浏览器窗口内显示的内容都定义到`body`标签内。

#### 注释

HTML注释的写法是：

```html
<!-- 注释内容 -->
```

注释的内容不会显示到浏览器窗口内，是开发人员用来对代码内容进行解释说明。

### 2.2.5 HTML语法规则

- 根标签有且只能有一个；
- 无论是双标签还是单标签都必须正确关闭；
- 标签可以嵌套但不能交叉嵌套；
- 注释不能嵌套；
- 属性必须有值，值必须加引号，单引号或双引号均可；
- 标签名不区分大小写但建议使用小写；

## 2.3 使用HTML展示文章

以文章的组织形式展示数据是HTML最基本的功能了，网页上显示的文章在没有做任何CSS样式设定的情况下如下图所示：

<img src="image/image-20230316112332980.png" alt="image-20230316112332980" style="zoom:50%;" />

本节我们要学习的HTML标签如下表：

| 标签名称 | 功能                   |
| -------- | ---------------------- |
| `h1~h6`  | 1级标题~6级标题        |
| `p`      | 段落                   |
| `a`      | 超链接                 |
| `ul/li`  | 无序列表               |
| `img`    | 图片                   |
| `div`    | 定义一个前后有换行的块 |
| `span`   | 定义一个前后无换行的块 |

### 2.3.1 标签标题

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>这是一级标题</h1>
    <h2>这是二级标题</h2>
    <h3>这是三级标题</h3>
    <h4>这是四级标题</h4>
    <h5>这是五级标题</h5>
    <h6>这是六级标题</h6>
</body>
</html>
```

==**<u>注意：标题标签前后有换行。</u>**==

### 2.3.2 段落标签

```html
<p>There is clearly a need for CSS to be taken seriously by graphic artists. The Zen Garden aims to excite, inspire, and encourage participation. To begin, view some of the existing designs in the list. Clicking on any one will load the style sheet into this very page. The code remains the same, the only thing that has changed is the external .css file. Yes, really.</p>
```

==**<u>注意：标题标签前后有换行。</u>**==

### 2.3.3 超链接

```html
<a href="page02-anchor-target.html">点我跳转到下一个页面</a>
```

点击后跳转到`href`属性指定的页面

### 2.3.4 路径

在整个Web开发技术体系中，**路径**是一个贯穿始终的重要概念。凡是需要获取另外一个资源的时候都需要用到路径。要想理解路径这个概念，我们首先要认识一个概念：**『文件系统』**。

#### 文件系统

Windows系统和Linux系统的文件系统有很大差别，为了让我们编写的代码不会因为从Windows系统部署到了Linux系统而出现故障，实际开发时不允许使用**物理路径**。

> 物理路径举例：
>
> `D:\aaa\pro01-HTML\page01-article-tag.html`
>
> `D:\aaa\pro01-HTML\page02-anchor-target.html`

幸运的是不管是Windows系统还是Linux系统环境下，目录结构都是**树形结构**，编写路径的规则是一样的。

所以我们**以项目的树形目录结构为依据**来编写路径就不用担心操作系统平台发生变化之后路径错误的问题了。有了这个大前提，我们具体编写路径时有两种具体写法：

- 相对路径；
- 绝对路径（建议使用）；

#### 相对路径

**相对路径都是以*『当前位置』*为基准**来编写的。假设我们现在正在浏览a页面，想在a页面内通过超链接跳转到z页面。

<img src="image/image-20230316130959212.png" alt="image-20230316130959212" style="zoom:50%;" />

那么按照相对路径的规则，我们现在所在的位置是`a.html`所在的b目录；`z.html`并不在b目录下，所以我们要从b目录出发，向上走，进入b的父目录——c目录；c目录还是不行，继续向上走，进入c的父目录——d目录；在从d目录向下经过两级子目录——e目录、f目录才能找到`z.html`。

所以整个路径的写法是：

```html
<a href="../../e/f/z.html">To z.html</a>
```

可以看到使用相对路径有可能会很繁琐，而且在后面我们结合了在服务器上运行的Java程序后，相对路径的基准是有可能发生变化的，所以**不建议使用相对路径**。

#### 绝对路径

测试绝对路径的前提是通过IDEA的内置服务器访问我们编写的HTML页面——这样访问地址的组成结构才能和我们以后在服务器上运行的Java程序一致。

绝对路径要求必须是以**『正斜线』**，测试开头在端口号后面的位置代表的是**『服务器根目录』**，从这里开始我们就是在服务器的内部查找一个具体的Web应用。

所以编写绝对路径时就从这个位置开始，**按照目录结构找到目标文件**即可。拿前面相对路径中的例子来说，我们想在a.html页面中通过超链接访问z.html。此时路径从正斜线开始，和a.html自身所在位置没有任何关系：

```html
<a href="/d/e/f/z.html">To z.html</a>
```

### 2.3.5 换行

```html
<p>
    We would like to see as much CSS1 as possible. CSS2 should be limited to widely-supported elements only. The css Zen Garden is about functional, practical CSS and not the latest bleeding-edge tricks viewable by 2% of the browsing public.<br/>The only real requirement we have is that your CSS validates.
</p>
```

### 2.3.6 无序列表

```html
<ul>
    <li>Apple</li>
    <li>Banana</li>
    <li>Grape</li>
</ul>
```

### 2.3.7 图片

`src`属性用来指定图片文件的路径，这里同样按我们前面说的使用**『绝对路径』**。

```html
<img src="/aaa/pro01-HTML/./images/mi.jpg"/>
```

### 2.3.8 块

**『块』**并不是为了显示文章内容的，而是为了方便结合CSS对页面进行布局。块有两种，div是前后有换行的块，span是前后没有换行的块。

把下面代码粘贴到HTML文件中查看他们的区别：

```html
<div style="border: 1px solid black;width: 100px;height: 100px;">This is a div block</div>
<div style="border: 1px solid black;width: 100px;height: 100px;">This is a div block</div>

<span style="border: 1px solid black;width: 100px;height: 100px;">This is a span block</span>
<span style="border: 1px solid black;width: 100px;height: 100px;">This is a span block</span>
```

### 2.3.9 实体

在HTML文件中，`<`、`>`等等这样的符号已经被赋予了特定含义，不会作为符号本身显示到页面上，此时如果我们想使用符号本身怎么办呢？那就是使用HTML实体来转义。

<img src="image/image-20230316132125891.png" alt="image-20230316132125891" style="zoom:50%;" />

资料来源：[W3School](https://www.w3school.com.cn/html/html_entities.asp)

## 2.4 表格标签

`table`：标签是表格标签

- `border`：设置表格标签；
- `width`：设置表格宽度；
- `height`：设置表格高度；
- `align`：设置表格相对于页面的对齐方式；
- `cellspacing`：设置单元格间距；

`tr`：是行标签；

`th`：是表头标签；

`td`：是单元格标签；

- `align`：设置单元格文本对齐方式；

`b`：是加粗标签；

### 2.4.1 普通表格

**<u>做一个带表头的，三行，三列的表格，并显示边框:</u>**

```html
<table align="center" border="1" width="300" height="300" cellspacing="0">
  <tr>
    <th>1.1</th>
    <th>1.2</th>
    <th>1.3</th>
  </tr>
  <tr>
    <td>2.1</td>
    <td>2.2</td>
    <td>2.3</td>
  </tr>
  <tr>
    <td>3.1</td>
    <td>3.2</td>
    <td>3.3</td>
  </tr>
</table>
```

### 2.4.2 跨行跨列表格

`colspan`：属性设置跨列；

`rowspan`：属性设置跨行；

```html
<table align="center" width="500" height="500" cellspacing="0" border="1">
  <tr>
    <td colspan="2">1.1</td>
    <td>1.3</td>
    <td>1.4</td>
    <td>1.5</td>
  </tr>
  <tr>
    <td rowspan="2">2.1</td>
    <td>2.2</td>
    <td>2.3</td>
    <td>2.4</td>
    <td>2.5</td>
  </tr>
  <tr>
    <td>3.2</td>
    <td>3.3</td>
    <td>3.4</td>
    <td>3.5</td>
  </tr>
  <tr>
    <td>4.1</td>
    <td>4.2</td>
    <td>4.3</td>
    <td colspan="2" rowspan="2">4.4</td>
  </tr>
  <tr>
    <td>5.1</td>
    <td>5.2</td>
    <td>5.3</td>
  </tr>
</table>
```

###   2.4.3 `iframe`框架标签

`ifarme`标签可以在页面上开辟一个小区域显示一个单独的页面`ifarme`和`a`标签组合使用的步骤:

1. 在`iframe`标签中使用`name`属性定义一个名称；
2. 在`a`标签的`target`属性上设置`iframe`的`name`的属性值；

```html
<iframe src="html_test0.html" width="500" height="400" name="abc"></iframe>
<br/>
<ul>
  <li><a href="html_test0.html" target="abc">Hellow world</a></li>
</ul>
```



## 2.5 HTML表单收集数据

### 2.5.1 什么是表单

在项目开发过程中，凡是需要用户填写的信息都需要用到表单。

### 2.5.2 `form`标签

在HTML中我们使用`form`标签来定义一个表单。而对于`form`标签来说有两个最重要的属性：`action`和`method`。

```html
<form action="/aaa/pro01-HTML/page05-form-target.html" method="post">
    
</form>
```

#### `action`属性

用户在表单里填写的信息需要发送到服务器端，对于Java项目来说就是交给Java代码来处理。那么在页面上我们就必须正确填写服务器端的能够接收表单数据的地址。

==**<u>这个地址要写在form标签的action属性中。</u>**==但是现在暂时我们还没有服务器端环境，所以先借用一个HTML页面来当作服务器端地址使用。

#### `method`属性

在`form`标签中`method`属性用来定义提交表单的**『请求方式』**。`method`属性只有两个可选值：`get`或`post`，没有极特殊情况的话使用post即可。

『请求方式』可见《计算机网络-自顶向下》HTTP协议中查看。

### 2.5.3 `name`和`value`

在用户使用一个软件系统时，需要一次性提交很多数据是非常正常的现象。我们肯定不能要求用户一个数据一个数据的提交，而肯定是所有数据填好后一起提交。那就带来一个问题，服务器怎么从众多数据中识别出来收货人、所在地区、详细地址、手机号码……？

很简单，**给每个数据都起一个『名字』**，发送数据时用**『名字』**携带对应的数据，接收数据时通过**『名字』**获取对应的数据。

在各个具体的表单标签中，我们通过**『name属性』**来给数据起**『名字』**，通过**『value属性』**来保存要发送给服务器的**『值』**。

但是名字和值之间既有可能是**『一个名字对应一个值』**，也有可能是**『一个名字对应多个值』**。

这么看来这样的关系很像我们Java中的Map，而事实上在服务器端就是使用Map类型来接收请求参数的。具体的是类型是：**`Map<String,String[]>`**。

`name`属性就是Map的键，`value`属性就是Map的值。

有了上面介绍的基础知识，下面我们就可以来看具体的表单标签了。

### 2.5.4 单行文本框

```html
<label>
    个性签名：
    <input type="text" name="signal"/>
</label><br/>
```

### 2.5.5 密码框

```html
<label>
    密码：
    <input type="password" name="secret"/>
</label><br/>
```

### 2.5.6 单选框

```html
<label>
    你最喜欢的季节是：
    <input type="radio" name="season" value="spring"/>春天
    <input type="radio" name="season" value="summer" checked="checked"/>夏天
    <input type="radio" name="season" value="autumn"/>秋天
    <input type="radio" name="season" value="winter"/>冬天
</label>

<br/><br/>
<label>
    你最喜欢的动物是：
    <input type="radio" name="animal" value="tiger"/>路虎
    <input type="radio" name="animal" value="horse" checked="checked"/>宝马
    <input type="radio" name="animal" value="cheetah"/>捷豹
</label>
```

- `name`属性相同的`radio`为一组，组内互斥；
- 当用户选择了一个`radio`并提交表单，这个`radio`的`name`属性和`value`属性组成一个键值对发送给服务器；
- 设置`checked="checked"`属性设置默认被选中的`radio`；

### 2.5.7 多选框

```html
<label>
    你最喜欢的球队是：
    <input type="checkbox" name="team" value="Brazil"/>巴西
    <input type="checkbox" name="team" value="German" checked="checked"/>德国
    <input type="checkbox" name="team" value="France"/>法国
    <input type="checkbox" name="team" value="China" checked="checked"/>中国
    <input type="checkbox" name="team" value="Italian"/>意大利
</label>
```

### 2.5.8 下拉列表

```html
<label>
你喜欢的运动是：
<select name="interesting">
  <option value="swimming">游泳</option>
  <option value="running">跑步</option>
  <option value="shooting" selected="selected">射击</option>
  <option value="skating">溜冰</option>
</select>
</label>
```

- 下拉列表用到了两种标签，其中`select`标签用来定义下拉列表，而`option`标签设置列表项；
- `name`属性在`select`标签中设置；
- `value`属性在`option`标签中设置；
- `option`标签的标签体是显示出来给用户看的，提交到服务器的是`value`属性的值；
- 通过在`option`标签中设置`selected="selected"`属性实现默认选中的效果；

### 2.5.9 按钮

```html
<label>
    <button type="button">普通按钮</button>
    <button type="reset">重置按钮</button>
    <button type="submit">提交按钮</button>
</label>
```

| 类型     | 功能                                             |
| -------- | ------------------------------------------------ |
| 普通按钮 | 点击后无效果，需要通过JavaScript绑定单击响应函数 |
| 重置按钮 | 点击后将表单内的所有表单项都恢复为默认值         |
| 提交按钮 | 点击后提交表单                                   |

### 2.5.10 表单隐藏域

```html
<label>
    <input type="hidden" name="userId" value="2233"/>
</label>
```

通过表单隐藏域设置的表单项不会显示到页面上，用户看不到。但是提交表单时会一起被提交。用来设置一些需要和表单一起提交但是不希望用户看到的数据，例如：用户id等等。

### 2.5.11 多行文本框

```html
<label>
    自我介绍：<textarea name="desc"></textarea>
</label>
```

`textarea`没有`value`属性，如果要设置默认值需要写在开始和结束标签之间。

## 2.6 CSS的简单应用

### 2.6.1 设置CSS样式的方式

#### 在HTML标签内设置

仅对当前标签有效

```html
<div style="border: 1px solid black;width: 100px; height: 100px;">&nbsp;</div>
```

#### 在head标签内设置

对当前页面有效

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CSS Test</title>
  <style>
    .one {
      border: 1px solid black;
      width: 100px;
      height: 100px;
      background-color: lightgreen;
      margin-top: 5px;
    }
  </style>
</head>
<body>
<div style="border: 1px solid black;width: 100px; height: 100px;">&nbsp;</div>
    
<div class="one">&nbsp;</div>
<div class="one">&nbsp;</div>
<div class="one">&nbsp;</div>
</body>
</html>
```

#### 引入外部CSS样式文件

**<u>编辑CSS文件</u>**

```css
.two {
  border: 1px solid black;
  width: 100px;
  height: 100px;
  background-color: yellow;
  margin-top: 5px;
}
```

**<u>引入外部CSS文件</u>**

在需要使用这个CSS文件的HTML页面的`head`标签内加入：

```html
<link rel="stylesheet" type="text/css" href="/aaa/pro01-HTML/style/example.css" />
```

于是下面HTML代码的显示效果是：

```html
<div class="two">&nbsp;</div>
<div class="two">&nbsp;</div>
<div class="two">&nbsp;</div>
```

### 2.6.2 CSS代码语法

- CSS样式由选择器和声明组成，而声明又由属性和值组成；
- 属性和值之间用冒号隔开；
- 多条声明之间用分号隔开；
- 使用`/* ... */`声明注释；

<img src="image/image-20230316195215282.png" alt="image-20230316195215282" style="zoom:50%;" />

### 2.6.3 CSS选择器

#### 标签选择器

HTML代码：

```html
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
```

CSS代码：

```css
p {
    color: blue;
    font-weight: bold;
}
```

#### `id`选择器

HTML代码：

```html
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
<p id="special">Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
```

CSS代码：

```css
#special {
    font-size: 20px;
    background-color: aqua;
}
```

#### 类选择器

HTML代码：

```html
<div class="one">&nbsp;</div>
<div class="one">&nbsp;</div>
<div class="one">&nbsp;</div>
```

CSS代码：

```css
.one {
    border: 1px solid black;
    width: 100px;
    height: 100px;
    background-color: lightgreen;
    margin-top: 5px;
}
```



# 3 JavaScript

## 3.1 JavaScript简介

### 3.1.1 起源

在**1995**年时，由**Netscape**公司的**Brendan Eich**，在网景导航者浏览器上首次设计实现而成。Netscape在最初将其脚本语言命名为LiveScript，因为Netscape与Sun合作，网景公司管理层希望它外观看起来像Java，因此取名为JavaScript。

### 3.1.2 特征

#### 脚本语言

JavaScript是一种解释型的脚本语言。不同于C、C++、Java等语言先编译后执行, JavaScript不会产生编译出来的字节码文件，而是在程序的运行过程中对源文件逐行进行解释。

#### 基于对象

JavaScript是一种基于对象的脚本语言，它不仅可以创建对象，也能使用现有的对象。但是面向对象的三大特性：『封装』、『继承』、『多态』中，JavaScript能够实现封装，可以模拟继承，不支持多态，所以它不是一门面向对象的编程语言。

#### 弱类型

JavaScript中也有明确的数据类型，但是声明一个变量后它可以接收任何类型的数据，并且会在程序执行过程中根据上下文自动转换类型。

#### 事件驱动

JavaScript是一种采用事件驱动的脚本语言，它不需要经过Web服务器就可以对用户的输入做出响应。

#### 跨平台性

`JavaScript`脚本语言不依赖于操作系统，仅需要浏览器的支持。因此一个`JavaScript`脚本在编写后可以带到任意机器上使用，前提是机器上的浏览器支持`JavaScript`脚本语言。目前`JavaScript`已被大多数的浏览器所支持。

## 3.2 Hello World

### 3.2.1 功能效果图

<img src="image/image-20230316200420808.png" alt="image-20230316200420808" style="zoom: 50%;" />

### 3.2.2 代码实现

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>JS: Hello world!</title>
</head>
<body>
<!-- 在HTML代码中定义一个按钮 -->
<button type="button" id="helloBtn">SayHello</button>
</body>
<!-- 在script标签中编写JavaScript代码 -->
<script type="text/javascript">

  // document对象代表整个HTML文档
  // document对象调用getElementById()方法表示根据id查找对应的元素对象
  var btnElement = document.getElementById("helloBtn");

  // 给按钮元素对象绑定单击响应函数
  btnElement.onclick = function(){
    // 弹出警告框
    alert("hello");
  };
</script>
</html>
```

## 3.3 JavaScript基本语法

### 3.3.1 代码嵌入方式

#### HTML文档内

- JavaScript代码要写在`script`标签内；
- `script`标签可以写在文档内的任意位置；
- 为了能够方便查询或操作HTML标签（元素）`script`标签可以写在`body`标签后面；

可以参考简化版的HelloWorld

```html
<!-- 在HBuilderX中，script标签通过打字“sc”两个字母就可以直接完整生成 -->
<script type="text/javascript">
	// 下面是同样实现HelloWorld功能的简化版代码
	document.getElementById("helloBtn").onclick = function() {
		alert("Hello simple");
	};
</script>
```

#### 引入外部JS文档

在script标签内通过src属性指定外部xxx.js文件的路径即可。但是要注意以下两点：

- 引用外部JavaScript文件的`script`标签里面不能写JavaScript代码；
- 先引入，再使用；
- ==**<u>`script`标签不能写成单标签</u>**==；

引入方式如下：

```html
<body>
</body>
<!-- 使用script标签的src属性引用外部JavaScript文件，和Java中的import语句类似 -->
<!-- 引用外部JavaScript文件的script标签里面不能写JavaScript代码 -->
<!-- 引用外部JavaScript文件的script标签不能改成单标签 -->
<!-- 外部JavaScript文件一定要先引入再使用 -->
<script src="/pro02-JavaScript/scripts/outter.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	// 调用外部JavaScript文件中声明的方法
	showMessage();
</script>
```

### 3.3.2 声明和使用变量

#### 数据类新

**<u>基本数据类型：</u>**

- 数值型：JavaScript不区分整数、小数；
- 字符串：JavaScript不区分字符、字符串；单引号、双引号意思一样；
- 布尔型：`true`、`false`；
  - 在JavaScript中，其他类型和布尔类型的自动转换；
  - `true`：非零的数值，非空字符串，非空对象；
  - `false`：零，空字符串，null，undefined；

**<u>引用类型：</u>**

- 关键字：`var`；

- 数据类型：JavaScript变量可以接收任意类型的数据；

- 标识符：严格区分大小写；

- 变量使用规则

  - 如果使用了一个没有声明的变量，那么会在运行时报错

    `Uncaught ReferenceError: b is not defined`；

  - 如果声明一个变量没有初始化，那么这个变量的值就是`undefined`；

### 3.3.3 函数

#### 内置函数

内置函数：系统已经声明好了可以直接使用的函数。

**<u>弹出警告框</u>**

```javascript
alert("警告框内容");
```

**<u>弹出确认框</u>**

用户点击『确定』返回true，点击『取消』返回false

```js
var result = confirm("老板，你真的不加个钟吗？");
if(result) {
	console.log("老板点了确定，表示要加钟");
}else{
	console.log("老板点了取消，表示不加钟");
}
```

**<u>在控制台打印日志</u>**

```js
console.log("日志内容");
```

#### 声明函数

写法1：

```js
function sum(a, b) {
    return a+b;
}
```

写法2：

```js
var total = function(a, b) {
    return a+b;
};
```

写法2可以这样解读：声明一个函数，相当于创建了一个『函数对象』，将这个对象的『引用』赋值给变量`total`。最后加的分号不是给函数声明加的，而是给整体的赋值语句加的分号。

#### 调用函数

JavaScript中函数本身就是一种对象，函数名就是这个**『对象』**的**『引用』**。而调用函数的格式是：**函数引用()**。

```js
function sum(a, b) {
	return a+b;
}

var result = sum(2, 3);
console.log("result="+result);
```

```js
var total = function() {
    return a+b;
}

var totalResult = total(3,6);
console.log("totalResult="+totalResult);
```

### 3.3.4 对象

JavaScript中没有『类』的概念，对于系统内置的对象可以直接创建使用。

#### 使用`new`关键字创建对象

```js
// 创建对象
var obj01 = new Object();
// 给对象设置属性和属性值
obj01.stuName = "tom";
obj01.stuAge = 20;
obj01.stuSubject = "java";
// 在控制台输出对象
console.log(obj01);
```

#### 使用`{}`创建对象

```js
// 创建对象
var obj02 = {
    "soldierName":"john",
    "soldierAge":35,
    "soldierWeapon":"gun"
};
// 在控制台输出对象
console.log(obj02);
```

#### 给对象设置函数属性

```js
// 创建对象
var obj01 = new Object();
// 给对象设置属性和属性值
obj01.stuName = "tom";
obj01.stuAge = 20;
obj01.stuSubject = "java";
obj01.study = function() {
	console.log(this.stuName + " is studying");
};
// 在控制台输出对象
console.log(obj01);
// 调用函数
obj01.study();
```

```js
// 创建对象
var obj02 = {
	"soldierName":"john",
	"soldierAge":35,
	"soldierWeapon":"gun",
	"soldierShoot":function(){
		console.log(this.soldierName + " is using " + this.soldierWeapon);
	}
};

// 在控制台输出对象
console.log(obj02);
// 调用函数
obj02.soldierShoot();
```

#### `this`关键词

this关键字只有两种情况：

- 在函数外面：`this`关键字指向`window`对象（代表当前浏览器窗口）；
- 在函数里面：`this`关键字指向调用函数的对象；

```js
// 直接打印this
console.log(this);
// 函数中的this
// 1.声明函数
function getName() {
	console.log(this.name);
}
// 2.创建对象
var obj01 = {
	"name":"tom",
	"getName":getName
};
var obj02 = {
	"name":"jerry",
	"getName":getName
};
// 3.调用函数
obj01.getName();
obj02.getName();
```

### 3.3.5 数组

#### 使用`new`关键字创建数组

```js
// 1.创建数组对象
var arr01 = new Array();
// 2.压入数据
arr01.push("apple");
arr01.push("orange");
arr01.push("banana");
arr01.push("grape");
// 3.遍历数组
for (var i = 0; i < arr01.length; i++) {
	console.log(arr01[i]);
}
// 4.数组元素反序
arr01.reverse();
for (var i = 0; i < arr01.length; i++) {
	console.log(arr01[i]);
}
// 5.数组元素拼接成字符串
var arrStr = arr01.join(",");
console.log(arrStr);
// 6.字符串拆分成数组
var arr02 = arrStr.split(",");
for (var i = 0; i < arr02.length; i++) {
	console.log(arr02[i]);
}
// 7.弹出数组中最后一个元素
var ele = arr01.pop();
console.log(ele);
```

#### 使用`[]`创建数组

```js
// 8.使用[]创建数组
var arr03 = ["cat","dog","tiger"];
console.log(arr03);
```

### 3.3.6 JSON

#### JSON格式的用途

在开发中凡是涉及到**『跨平台数据传输』**，JSON格式一定是首选。

#### JSON格式的说明

- JSON数据两端要么是**`{}`**，要么是**`[]`**；
- **`{}`**定义JSON对象；
- **`[]`**定义JSON数组；
- JSON对象的格式是：

```json
{key:value,key:value,...,key:value}
```

- JOSN数组的格式是：

```json
[value,value,...,value]
```

- `key`的类型固定是字符串
- `value`的类型可以是：
  - 基本数据类型
  - 引用类型：JSON对象或JSON数组

正因为JSON格式中value部分还可以继续使用JSON对象或JSON数组，所以JSON格式是可以**『多层嵌套』**的，所以JSON格式不论多么复杂的数据类型都可以表达。

```json
{
	"stuId":556,
	"stuName":"carl",
	"school":{
		"schoolId":339,
		"schoolName":"atguigu"
	},
	"subjectList":[
		{
			"subjectName":"java",
			"subjectScore":50
		},
		{
			"subjectName":"PHP",
			"subjectScore":35
		},
		{
			"subjectName":"python",
			"subjectScore":24
		}
	],
	"teacherMap":{
		"aaa":{
			"teacherName":"zhangsan",
			"teacherAge":20
		},
		"bbb":{
			"teacherName":"zhangsanfeng",
			"teacherAge":108
		},
		"ccc":{
			"teacherName":"zhangwuji",
			"teacherAge":25
		}
	}
}
```

#### JSON对象和JSON字符串互转

JSON对象→JSON字符串：

```js
var jsonObj = {"stuName":"tom","stuAge":20};
var jsonStr = JSON.stringify(jsonObj);
console.log(typeof jsonObj); // object
console.log(typeof jsonStr); // string
```

JSON字符串→JSON字对象：

```js
jsonObj = JSON.parse(jsonStr);
console.log(jsonObj); // {stuName: "tom", stuAge: 20}
```

