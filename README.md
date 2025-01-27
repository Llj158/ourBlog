# ourBlog

## 1、介绍

### 1.1、项目简介

Vue+Spring Boot 前后端分离博客系统。

  **[项目网站](http://111.229.31.179)**

  **需求分析与设计报告在word中**

### 1.2、主要功能
-	用户注册，登录，登出
-	使用markdown方法编辑输入文章
-	文章上传，可设置文章分类、标tag 
-	文章可归档整理，按日期、标签、分类分页查看
-	根据点击次数添加热度功能
-	个性化，主题背景切换
-	评论系统
-	个性化，主题背景切换

## 2、软件架构

### 2.1、后端技术

| **技术**     | **说明**                           |
| ------------ | ---------------------------------- |
| maven        | 项目管理和构建自动化工具           |
| MyBatis-Plus | 代码生成器、性能分析插件、自动填充 |
| Spring Web   | Spring Framework的Web模块          |
| Lombok       | 简化对象封装工具                   |
| jwt          | 身份验证和信息交换                 |

### 2.2、前端技术

| **技术**   | **说明**                       |
| ---------- | ------------------------------ |
| Vue.js     | 响应式和组件化特性构建用户界面 |
| Element UI | 提供美观、实用的界面元素       |
| Spring Web | Spring Framework的Web模块      |
| Lombok     | 简化对象封装工具               |
| jwt        | 身份验证和信息交换             |

## **3、使用说明**


### **3.1、依赖配置**

**用maven配置后端起步依赖，测试jdk版本为11可供参考**



### **3.2、数据库配置**

**ourBlog.sql导入数据库，后端项目的`application.yml`中配置你的数据库配置。**

```yml
  datasource:
    url: jdbc:mysql://# {本地的IP地址}:3306/{数据库名字}?useUnicode=true&characterEncoding=UTF-8&serverTimeZone=UTC
    username: #数据库用户名
    password: #数据库连接密码
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### **前端运行**

依次在项目终端执行:
```
npm install

npm run dev  (本地运行)

npm run build (打包)
```


