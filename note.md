

## oss
### oss配置
1. 引入oss-starter
2. 配置key, endpoint相关信息
3. 使用OSSClient进行相关操作

### oss问题
1. @Autowired 用于OssClient报错
    * 原因是OssClient自动配置是将Oss这个接口注入容器，而OssClient是实现类，所以不行。(具体可看OssContextAutoConfiguration)
    * 将OssClient改为Oss，或者用@Resource(因为注入名字为ossClient)

## JSR303校验
1. 给Bean添加校验注解(javax.validation.constraints)，并定义自己的message提示
2. 在Controller中的方法参数前加上@Valid
3. 后面紧跟BindingResult，返回校验的结果(可选)
4. 抛出异常，统一处理(MallExceptionControllerAdvice)
5. 分组校验
    1). @Null(message = "新增不能指定id", groups = {AddGroup.class}) 
    给校验注解标注什么情况需要进行校验
    2). @Validated({AddGroup.class})
    3). 默认没有指定分组的校验注解@NotBlank，在分组校验情况下不生效，只会在@Validated生效
6. 自定义校验
    1). 编写一个自定义的校验注解
    2). 编写一个自定义的校验器(实现ConstraintValidator)
    3). 关联自定义的校验注解和校验器 @Constraint(validatedBy = { ListValueConstraintValidator.class /*可以指定多个不同的校验器，适配不同的校验器})


## 统一的异常处理
@RestControllerAdvice
1. 编写异常处理类，使用 @RestControllerAdvice
2. 使用@ExceptionHandler标注方法可以处理的异常

## 在Entity中加不是数据库中的字段，要加注解@TableField(exist = false)

## 整合Mybatis-Plus
    1)、导入依赖
    2)、配置
        1.配置数据源
            1)、导入数据库驱动
            2)、在application.yml配置数据源相关信息
        2.配置Mybatis-Plus
            1)、使用@MapperScan
            2)、告诉Mybatis-Plus，sql映射文件位置
            
    在dao里面写sql语句，建议给变量加上@Param注解指定名称
    void deleteBatchRelation(@Param("entities") List<AttrAttrgroupRelationEntity> entities);
    <delete id="deleteBatchRelation">
        DELETE FROM `pms_attr_attrgroup_relation` WHERE 
        <foreach collection="entities" item="item" separator=" OR "> //分隔符前后要有空格
            (attr_id=#{item.attrId} AND attr_group_id=#{item.attrGroupId})
        </foreach>
    </delete>
            
### 配置分页插件
    @Configuration
    @EnableTransactionManagement //开启事务
    @MapperScan("cn.highsheep.mall.product.dao")
    public class MybatisConfig {...}
    
### Controller Service
1. Controller：只用来处理请求，接受和检验数据
2. Service：接受Controller传来的数据进行业务处理
3. Controller接收Service处理完的数据，封装页面指定的vo

## 远程调用

双方在注册中心配置，请求方写一个接口(接口上配置@FeignClient)，接口方法签名和被请求方一样；

1. CouponFeignService.saveSpuBounds(spuBoundTo)
    1) @RequestBody将对象转为json
    2) 找到mall-coupon服务，给/coupon/spubounds/save发送请求；将上一步转的json放在请求体位置，发送请求。
    3) 对方服务收到请求。请求体里有json数据。
        (@RequestBody SpuBoundsEntity spuBounds)，将请求体中的json转为SpuBoundsEntity
    只要json数据模型是兼容的，双方服务无需使用同一个to
    
## 整合ElasticSearch
1. 导入依赖
2. 编写配置，给容器中注入一个RestHighLevelClient
3. [参照Api](https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high.html)

## sku在es中存储模型分析
1. p128
2. es中index=false,表示检索是不用
3. doc_value=false,表示聚合时不用
4. es中用来做冗余的， index和doc_value都等于false

## es扁平化处理
1. 当数组中存的是对象时，es会进行扁平化处理
2. 防止扁平化处理，在存的对象中声明类型为nested
3. p129

## Feign调用机制
1. 构造请求数据，将对象转换为json
2. 发送请求进行执行（执行成功解码相应数据）
3. 执行请求会有重试机制