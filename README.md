# e签宝SDK Spring Boot Starter

```properties
esign.baseUrl=沙箱或生产api地址(默认是https://smlopenapi.esign.cn)
esign.appId=appId
esign.appSecret=appSecret

```

# 使用
```xml
<dependency>
  <groupId>cn.jaychang</groupId>
  <artifactId>esign-sdk-spring-boot-starter</artifactId>
  <version>1.0.0</version>
</dependency>
```

```java

@Autowired
private AuthClient authClient;


/**
 * 获取个人认证&授权页面链接
 */
@Test
public void getPsnAuthUrl() {
        GetPersonAuthReq req = new GetPersonAuthReq();
        PersonAuthConfig psnAuthConfig = new PersonAuthConfig();
        psnAuthConfig.setPsnAccount("135xxxx8219");

        PersonAuthConfig.PsnInfo psnInfo = new PersonAuthConfig.PsnInfo();
        psnInfo.setPsnMobile("135xxxx8219").setPsnName("张三").setPsnIDCardType("CRED_PSN_CH_IDCARD").setPsnIDCardNum("34xxxx199xxxx2xxx5");
        psnAuthConfig.setPsnInfo(psnInfo);

        PersonAuthConfig.PsnAuthPageConfig psnAuthPageConfig = new PersonAuthConfig.PsnAuthPageConfig();
        psnAuthPageConfig.setPsnDefaultAuthMode("PSN_MOBILE3").setPsnAvailableAuthModes(Arrays.asList("PSN_MOBILE3"))
        .setPsnEditableFields(Arrays.asList("IDCardNum","mobile"));
        psnAuthConfig.setPsnAuthPageConfig(psnAuthPageConfig);

        req.setPsnAuthConfig(psnAuthConfig);
        req.setClientType("ALL");
        req.setNotifyUrl("回调url");

        R<GetPersonAuthRes> result = authClient.getPsnAuthUrl(req);
        if (!result.isSuccess()) {
            System.out.println(String.format("请求接口报错:%s", result.getMessage()));
            return;
        }
        System.out.println(JsonUtils.toJsonString(result.getData()));

}


```

# 打印请求响应日志
```properties
logging.level.cn.jaychang.esign.client = error
retrofit.global-log.log-strategy = BODY
retrofit.global-log.aggregate = true
```

```shell
Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : --> POST https://openapi.esign.cn/v3/psn-auth-url http/1.1

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : Content-Type: application/json; charset=UTF-8

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : Content-Length: 445

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : X-Tsign-Open-App-Id: 5xxxxxxxxx

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : X-Tsign-Open-Auth-Mode: Signature

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : X-Tsign-Open-Ca-Signature: yN0kQNcJsBAjEzRS6pGhKmVWqohCb7x/qlgw8rUyshU=

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : X-Tsign-Open-Ca-Timestamp: 1728518429980

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : Accept: */*

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : Content-MD5: WhHIzQ6kJLugB4UaC7WLkQ==

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : 

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : {"psnAuthConfig":{"psnAccount":"135xxxxx501","psnInfo":{"psnName":"李xx","psnIDCardNum":"4110xxxx91xxxx622X","psnIDCardType":"CRED_PSN_CH_IDCARD","psnMobile":"135xxxxx501"},"psnAuthPageConfig":{"psnDefaultAuthMode":"PSN_MOBILE3"}},"authorizeConfig":{"authorizedScopes":["get_psn_identity_info","psn_initiate_sign","manage_psn_resource","psn_sign_file_storage"]},"notifyUrl":"https://test.abc.com/api/xxx-esign/esign/unify/callback"}

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:29.980  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : --> END POST (445-byte body)

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.269  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : <-- 200 OK https://openapi.esign.cn/v3/psn-auth-url (289ms)

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.269  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : Server: openresty

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.269  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : Date: Thu, 10 Oct 2024 00:00:30 GMT

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.269  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : Content-Type: application/json;charset=UTF-8

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.269  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : Transfer-Encoding: chunked

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.270  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : Connection: keep-alive

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.270  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : X-Tsign-Elapse-Time: 199

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.270  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : X-Application-Context: application

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.270  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : X-Tsign-Trace-Id: 10120031164T343T17285184300694557

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.270  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : 

Oct 10, 2024 @ 08:00:30.000	2024-10-10 08:00:30.270  INFO 7 --- [0880-thread-199] c.g.l.r.s.boot.log.LoggingInterceptor    : {"code":0,"message":"成功","data":{"authFlowId":"OF-317bxxxxxx080xxx","authUrl":"https://h5.esign.cn/auth/h5/index?authFlowId=OF-317bxxxxxx080xxx&clientType=ALL&appId=5xxxxxxxxxx","authShortUrl":"https://t.esign.cn/xxxlasjdf"}}
```