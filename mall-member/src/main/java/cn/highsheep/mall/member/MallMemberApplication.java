package cn.highsheep.mall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 远程调用服务
 * 1.引入open-feign
 * 2.编写接口，告诉springCloud这个接口需要调用远程服务
 *  1).声明接口的每一个方法都是调用哪个远程服务的哪个请求
 * 3.开启远程调用功能
 */
@EnableFeignClients(basePackages = "cn.highsheep.mall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class MallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallMemberApplication.class, args);
    }

}
