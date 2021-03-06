> 业务需求：前端有多个按钮，多个用户同时点击，同一时刻只能有1个执行业务逻辑，其他线程阻塞等待。



1. 准备两个浏览器，模拟两个管理员登入一个页面

![测试可重入锁.png](https://github.com/YuJianVan/ReentrantLockDemo/blob/main/%E5%9B%BE%E7%89%87/%E6%B5%8B%E8%AF%95%E5%8F%AF%E9%87%8D%E5%85%A5%E9%94%81.png?raw=true)



service层模拟执行业务逻辑，线程等待3秒。先后点击两个页面中的按钮

结果：

~~~
2022-06-22 10:52:00 code=1  tid=38 comes in
2022-06-22 10:52:01 code=2  tid=39 comes in
2022-06-22 10:52:03 38 finished
2022-06-22 10:52:04 39 finished
~~~

可见，两个线程同时执行了业务逻辑，不符合需求



#### 解决方法

service层的实现类的业务逻辑方法使用可重入锁ReentrantLock

结果：

~~~
2022-06-22 10:57:50 code=1  tid=43 comes in
2022-06-22 10:57:53 43 finished
2022-06-22 10:57:53 code=2  tid=42 comes in
2022-06-22 10:57:56 42 finished
~~~

可见每一个线程都间隔了三秒才相继执行，达到了需求