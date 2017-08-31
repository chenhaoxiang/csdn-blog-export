---
layout: post
title: "【Spring】Spring高级话题-@Enable   注解的工作原理"
date: 2016-12-09 09:11:37 +0800
comments: true
categories:❷ Java大学之行,----- ⑥、框架/第三方工具,----- ----- Spring
tags: [spring,工作,注解,Enable]
keyword: 陈浩翔, 谙忆
description: 转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




@EnableAspectJAutoProxy

@EnableAspectJAutoProxy注解 激活Aspect自动代理

 aop:aspectj-autoproxy/>

开启对AspectJ自动代理的支持。

在用到AOP的自动代理的时候用，如果你理解了Java的 
---


转载请注明出处：http://blog.csdn.net/qq_26525215
本文源自【大学之旅_谙忆的博客】




@EnableAspectJAutoProxy

@EnableAspectJAutoProxy注解 激活Aspect自动代理

 aop:aspectj-autoproxy/>

开启对AspectJ自动代理的支持。

在用到AOP的自动代理的时候用，如果你理解了Java的
<!-- more -->
----------

<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


##@EnableAspectJAutoProxy 
@EnableAspectJAutoProxy注解 激活Aspect自动代理
```
 <aop:aspectj-autoproxy/>
```
开启对AspectJ自动代理的支持。

在用到AOP的自动代理的时候用，如果你理解了Java的动态代理，很容易的就会熟悉AOP的自动代理的。

##@EnableAsync

@EnableAsync注解开启异步方法的支持。
这个相信大家都比较熟悉的。对于异步应该都理解的。
不太熟悉的，可以看这篇博客:-有示例
<a href="http://blog.csdn.net/qq_26525215/article/details/53214185" target='_blank'>【Spring】Spring高级话题-多线程-TaskExecutor </a>

##@EnableScheduling

@EnableScheduling注解开启计划任务的支持。

也就是字面上的意思，开启计划任务的支持！
一般都需要@Scheduled注解的配合。

详情见此博客:
<a href="http://blog.csdn.net/qq_26525215/article/details/53543816" target='_blank'>【Spring】Spring高级话题-计划任务-@EnableScheduling  </a>

##@EnableWebMVC

@EnableWebMVC注解用来开启Web MVC的配置支持。

也就是写Spring MVC时的时候会用到。

##@EnableConfigurationProperties

@EnableConfigurationProperties注解是用来开启对@ConfigurationProperties注解配置Bean的支持。

也就是@EnableConfigurationProperties注解告诉Spring Boot 使能支持@ConfigurationProperties

##@EnableJpaRepositories
@EnableJpaRepositories注解开启对Spring Data JPA Repostory的支持。

Spring Data JPA 框架，主要针对的就是 Spring 唯一没有简化到的业务逻辑代码，至此，开发者连仅剩的实现持久层业务逻辑的工作都省了，唯一要做的，就只是声明持久层的接口，其他都交给 Spring Data JPA 来帮你完成！

简单的说，Spring Data JPA是用来持久化数据的框架。

##@EnableTransactionManagement

@EnableTransactionManagement注解开启注解式事务的支持。

注解@EnableTransactionManagement通知Spring，@Transactional注解的类被事务的切面包围。这样@Transactional就可以使用了。

##@EnableCaching

@EnableCaching注解开启注解式的缓存支持


通过这些简单的@Enable*可以开启一项功能的支持，从而避免自己配置大量的代码，很大程度上降低了使用难度。

我们一起来观察下这些@Enable*注解的源码，可以发现所有的注解都有一个@Import注解。

@Import注解是用来导入配置类的，这也就是说这些自动开启的实现其实是导入了一些自动配置的Bean。

这些导入配置方式主要分为以下三种类型。

#@Import注解导入配置方式的三种类型

##第一类：直接导入配置类

```
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.springframework.scheduling.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SchedulingConfiguration.class})
@Documented
public @interface EnableScheduling {
}
```


直接导入配置类SchedulingConfiguration，这个类注解了@Configuration，且注册了一个scheduledAnnotationProcessor的Bean，源码如下：


```
/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.scheduling.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.scheduling.config.TaskManagementConfigUtils;

/**
 * {@code @Configuration} class that registers a {@link ScheduledAnnotationBeanPostProcessor}
 * bean capable of processing Spring's @{@link Scheduled} annotation.
 *
 * <p>This configuration class is automatically imported when using the
 * @{@link EnableScheduling} annotation. See {@code @EnableScheduling}'s javadoc
 * for complete usage details.
 *
 * @author Chris Beams
 * @since 3.1
 * @see EnableScheduling
 * @see ScheduledAnnotationBeanPostProcessor
 */
@Configuration
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class SchedulingConfiguration {

	@Bean(name = TaskManagementConfigUtils.SCHEDULED_ANNOTATION_PROCESSOR_BEAN_NAME)
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public ScheduledAnnotationBeanPostProcessor scheduledAnnotationProcessor() {
		return new ScheduledAnnotationBeanPostProcessor();
	}

}

```

##第二类：依据条件选择配置类

EnableAsync 注解核心代码：
```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AsyncConfigurationSelector.class)
public @interface EnableAsync {
	Class<? extends Annotation> annotation() default Annotation.class;
	boolean proxyTargetClass() default false;
	AdviceMode mode() default AdviceMode.PROXY;
	int order() default Ordered.LOWEST_PRECEDENCE;

}

```

AsyncConfigurationSelector通过条件来选择需要导入的配置类，
AsyncConfigurationSelector的根接口为ImportSelector，这个接口需要重写selectImports方法，在此方法内进行事先条件判断。

在下面的源码中，若adviceMode为PORXY，则返回ProxyAsyncConfiguration这个配置类。
若activeMode为ASPECTJ，则返回AspectJAsyncConfiguration配置类。
源码如下：

```
public class AsyncConfigurationSelector extends AdviceModeImportSelector<EnableAsync> {

	private static final String ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME =
			"org.springframework.scheduling.aspectj.AspectJAsyncConfiguration";

	/**
	 * {@inheritDoc}
	 * @return {@link ProxyAsyncConfiguration} or {@code AspectJAsyncConfiguration} for
	 * {@code PROXY} and {@code ASPECTJ} values of {@link EnableAsync#mode()}, respectively
	 */
	@Override
	public String[] selectImports(AdviceMode adviceMode) {
		switch (adviceMode) {
			case PROXY:
				return new String[] { ProxyAsyncConfiguration.class.getName() };
			case ASPECTJ:
				return new String[] { ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME };
			default:
				return null;
		}
	}

}

```

##第三类：动态注册Bean

```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AspectJAutoProxyRegistrar.class)
public @interface EnableAspectJAutoProxy {
	boolean proxyTargetClass() default false;
}

```

AspectJAutoProxyRegistrar 事先了ImportBeanDefinitionRegistrar接口，ImportBeanDefinitionRegistrar的作用是在运行时自动添加Bean到已有的配置类，通过重写方法：
```
@Override
	public void registerBeanDefinitions(
			AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry)
```

其中，AnnotationMetadata参数用来获得当前配置类上的注解；
BeanDefinittionRegistry参数用来注册Bean。
源码如下：

```
class AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * Register, escalate, and configure the AspectJ auto proxy creator based on the value
	 * of the @{@link EnableAspectJAutoProxy#proxyTargetClass()} attribute on the importing
	 * {@code @Configuration} class.
	 */
	@Override
	public void registerBeanDefinitions(
			AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);

		AnnotationAttributes enableAJAutoProxy =
				AnnotationConfigUtils.attributesFor(importingClassMetadata, EnableAspectJAutoProxy.class);
		if (enableAJAutoProxy.getBoolean("proxyTargetClass")) {
			AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
		}
	}

}

```


本文章由<a href="https://chenhaoxiang.github.io/">[谙忆]</a>编写， 所有权利保留。 
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://blog.csdn.net/qq_26525215'><font color="green">http://blog.csdn.net/qq_26525215</font></a><br><br>
本文源自<strong>【<a href='http://blog.csdn.net/qq_26525215' target='_blank'>大学之旅_谙忆的博客</a>】</strong></p>
</blockquote>


本文章由<a href="http://chenhaoxiang.cn/">[谙忆]</a>编写， 所有权利保留。 
欢迎转载，分享是进步的源泉。
<blockquote cite='陈浩翔'>
<p background-color='#D3D3D3'>转载请注明出处：<a href='http://chenhaoxiang.cn'><font color="green">http://chenhaoxiang.cn</font></a><br><br>
本文源自<strong>【<a href='http://chenhaoxiang.cn' target='_blank'>人生之旅_谙忆的博客</a>】</strong></p>
</blockquote>
