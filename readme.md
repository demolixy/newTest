java的NIO的学习 

首先我们应该知道为什么使用nio

1 就是我们以前的io操作主要是通过阻塞的方式来实现的，这中方式浪费了很多的资源   所以在jdk1.4之后我们使用nio来操作io，这里的核心就是使用缓冲区

2 常见的几种的nio的数据的格式   就是我们的java中的几种基本格式的数据  但是没有boolean

3 学习nio，首先需要学习几种常量  position limit capacity