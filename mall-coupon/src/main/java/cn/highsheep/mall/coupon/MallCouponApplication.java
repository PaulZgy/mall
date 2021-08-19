package cn.highsheep.mall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 如何使用Nacos作为配置中心统一管理配置
 * 1.引入依赖
 * <dependency>
 *     <groupId>com.alibaba.cloud</groupId>
 *     <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 * </dependency>
 * 2.创建一个bootstrap.properties,配置注册中心地址
 * spring.application.name=mall-coupon
 * spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 * 3.需要给配置中心默认添加一个数据集(DataID),默认规则应用名.properties
 * 4.应用名.properties 配置想要配置的
 * 5.动态获取配置
 *      1).@RefreshScope 动态获取并刷新配置
 *      2).@value("${key}") 获取到值
 *      如果当前项目中和配置中心都存在，优先使用配置中心的
 *细节：
 * 1.命名空间：配置隔离
 * 默认：public(保留空间);默认新增的所有配置都在public空间
 *      1.开发，测试，生产:利用命名空间来做环境隔离
 *      注意：需要在bootstrap中配置，用哪个命名空间
 *      2.每一个微服务之间相互隔离配置，每一个微服务创建自己的命名空间，只加载自己命名空间下的配置
 * 2.配置集：所有配置的集合
 * 3.配置集ID：Data ID, 类似于文件名，
 * 4.配置分组: 默认所有配置集都属于DEFAULT_GROUP
 * 规则：每个微服务创建自己的命名空间，使用配置分组区分环境，dev，test，prod
 *
 * 同时加载多个配置集：
 * 1.微服务任何配置信息，配置文件都可以放在配置中心
 * 2.只需要在bootstrap.properties说明加载配置中心中的哪些文件即可
 */

@EnableDiscoveryClient
@SpringBootApplication
public class MallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallCouponApplication.class, args);
    }

}
