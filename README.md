## 当前实现
### 生活服务开放能力
#### 门店管理
- 门店信息查询
- 门店信息更新
#### 团购核销
- 验券准备
- 验券
- 撤销核销
- 券状态查询
- 券状态批量查询
#### 团购对账
- 验券历史查询
- 账单详细查询
#### 团购对账
- 验券历史查询
- 账单详细查询
#### 会员接入
- 会员数据更新

## 开始使用
1.pom文件中引入下面依赖
```xml
<dependency>
  <groupId>com.github.fengws</groupId>
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
