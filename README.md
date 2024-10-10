# e签宝SDK Spring Boot Starter

```properties
esign.baseUrl=沙箱或生产api地址(默认是https://smlopenapi.esign.cn)
esign.appId=appId
esign.appSecret=appSecret

```

# 使用
maven
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