## 项目说明
1. 当前项目JDK版本最低支持为`JDK1.8`
2. 为简化代码、提高代码可阅读性，项目中使用了`lombok`插件
3. 开发文档参考[【开发文档wiki】](https://gitee.com/fwens/douyin-java-sdk/wikis/Home)

## 当前实现
### 生活服务开放能力
#### 门店管理
- 门店信息查询（已实现）
- 门店信息更新（未实现）
- 查询匹配关系（已实现）
#### 团购核销
- 验券准备（已实现）
- 验券（已实现）
- 撤销核销（已实现）
- 券状态查询（已实现）
- 券状态批量查询（已实现）
#### 团购对账
- 验券历史查询（已实现）
- 账单详细查询（已实现）
#### 会员接入
- 会员数据更新（已实现）
#### 外卖
- 拒绝接单接口（未实现）
- 商家取消订单接口（未实现）
- 确认订单接口（未实现）
- 订单查询接口（未实现）
- 商家同意/拒绝退款接口（未实现）
- 自配送-回传配送信息接口（未实现）

### 抖音小程序

## 开始使用
- 关于接口详细信息参考[【抖音开放平台官方文档】](https://partner.open-douyin.com/docs/resource/zh-CN/dop/develop/openapi/list)

1.在pom文件中引入下面依赖
```xml
<dependency>
    <groupId>io.github.fengwensheng100</groupId>
    <artifactId>douyin-java-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

2.通过下面方式生成一个douYinService对象并创建配置文件
```java
DouYinConfig config = new DouYinConfig();
config.setClientKey("xxx");
config.setClientSecret("xxx");
DouYinService douYinService = new DouYinService(config);
```

3.获取token，调用抖音其他接口时需要传入，需要开发者自行缓存
```java
String douYinToken = douYinService.getDouYinLifeService().getDouYinToken();
```

4.调用抖音其他接口，以团购验券准备接口为例
```java
BaseResp<CertificatePrepareResp> certificatePrepareRespBaseResp = douYinService.getDouYinCouponService().certificatePrepareByCode("150000000000000", douYinToken);
```

- SpringBoot接入douyin-java-sdk


1.在pom文件中引入下面依赖
```xml
<dependency>
    <groupId>io.github.fengwensheng100</groupId>
    <artifactId>douyin-java-life-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

2.properties配置参数
```java
dy.life.client-key=xxx
dy.life.client-secret=xxx
```

3.通过IOC容器注入DouYinService对象即可开始使用
```java
@Autowired
DouYinService douYinService;
douYinService.getClientToken();
```

