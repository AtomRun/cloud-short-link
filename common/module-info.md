公共依赖包

使用Spring.factories的方式注入Bean，并且配合Properties可以做到一定的封装
例如`SmsService`，本身依赖了固定配置`SmsConfigProperties`，`RestTemplate`等实体，那么这个Bean实例化的时候就需要依赖这两个实体
于是我们可定义一个`SmsConfig`使用`@AutoConfigureAfter(RestTemplateConfig.class)`，让Config在RestTemplate之后处理
(因为需要使用RestTemplate)，并且只实现一个`Properties`和`RestTemplate`的构造方法，最终成功使用可配置参数+需要使用的RestTemplate实例化了这个Bean

为什么starter需要spring.factories?
- 假如你依赖了一个包，他标注了@Service 这种注解，期望直接被扫描到，但只有在启动类下才会被springboot扫描到，
  而依赖的包往往包名不同，这个时候就扫描不到了，需要使用factories的方式

并发量大的时候restTemplate可能会抛出超时异常
- 方法做成异步

做成异步之后几率性会出现OOM是为什么？

- 异步化接口的好处是可能快速调用，但一旦量级很大，例如异步任务执行时间长，8个线程都在处理中，那么后续任务会放在阻塞队列中
一旦任务量过大，阻塞队列已经放不下新任务的时候就会产生OOM
