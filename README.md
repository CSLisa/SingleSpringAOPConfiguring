# SingleSpringAOPConfiguring
SpringAOP的简单测试，AOP（Aspect-Oriented Programming面向切面编程），即在不改变源程序的基础上为代码片段增加新的功能

        <1>代理对象
        
                 在技术业务框架中依据业务需求通过反射调用原对象的方法的对象称为
                 代理对象。也就是说, 通过代理对象来调用原对象的方法.
          <2>连接点
          
                 就是原对象方法.
                 
          <3>切入点(pointcut)
          
                 是对应用程类组件方法的所有需要进行插入切面的切入点的集合统称.
                 
          <4>增强处理--通过技术业务框架中的继承和重写来实现
          
                 代理对象方法前后都可以插入代码，这些代码就是增强处理.
                 常用的增强处理
                 
                 public void beforeService(JoinPoint joinPoint)
                 
                 public void after()
                 
                 public void afterReturning(Object returnVal)
                 
                 public void afterThrowing(Exception ex)
                 
                 public Boolean around(ProceedingJoinPoint pjp) 
                 
          <5>织入(Weaving)
          
                 把切面（aspect）连接到其它的应用程序类型或者对象上，并创建一个
                 被通知（advised）的对象的行为.
                 
                 织入(Weaving)的分类
                 
                     spring实现aop是依赖两种技术,一种是jdk动态代理,被切入的类需
                     要实现接口,如果在配置文件中不指明实现什么接口,spring会自动
                     搜索其实现接口并织入advice,别一种是借助动态修改类的技术,使
                     用cglib动态地扩展类来实现切面,cglib可以实现字节码级地修改,
                     执行效率比jdk动态代理要高,但创建实例时没有前者快.默认情况
                     下,使用jdk动态代理
                     
          <6> AOP（Aspect-Oriented Programming面向切面编程）
               /*
               1)概念的内涵
               
               2)举例说明
               
               */
               
               1)概念的内涵
               
                     面向切面编程，即在不改变原程序的基础上为代码段增加新的功能。
                     实现方法是创建已有未有职能的反射生命周期框架下的动态调用代 
                     理设计模式。通过预编译方式和运行期动态代理实现程序功能的统
                      一维护的一种技术概念。AOP是OOP的延续，利用AOP可以对
                     业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦
                     合度降低，提高程序的可重用性，同时提高了开发的效率。
                     
              2)举例说明
              
                     将日志记录，性能统计，安全控制，事务处理，异常处理等代码从
                     业务逻辑代码中划分出来，通过对这些行为的分离，我们希望可以
                     将它们独立到非指导业务逻辑的方法中，进而改变这些行为的时候
                     不影响业务逻辑的代码。
