# YyBlog
This is a blog that a small java programmer is making.<br>
这是渊鱼的个人博客<br>
===============
### 出于想要使用完全没有接触过的框架技术来制作一个个人博客，刚好又刚了解到springboot框架发现其进行开发十分方便，就开始制作该博客
* 使用后端框架：SpringBoot、Spring、SpringMVC、MyBatis<br>
* 使用前端框架：Bootstrap、Layui<br>
* 使用页面模板：Thymeleaf<br>
* 开发工具使用：IDEA、Git<br>
* 开发环境：Tomcat8、JDK1.8、MySQL5.5、Redis、Nginx<br>
### 博客实现功能<br>
    用户的登录注册并且通过redis缓存控制用户的单点登录和登录保持
    用户查看博客留言博客根据分类筛选博客(可能会加入直接根据标题筛选博客但是不想加 因为怕写页面麻烦)
    后台实现了用户、博客、分类、友链、评论的管理，均可以对其进行相应操作
    使用了反向代理技术，不是为了负载均衡只是为了上传图片回显方便点，Nginx简单学习使用也不是很难可以试一下的
    如果后期支撑不下去会配置一下负载均衡
    后面有时间准备研究一下shiro添加一下后台权限管理(先给自己挖个坑不着急填)    
