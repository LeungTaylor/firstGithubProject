package com.ltl.lesson;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;

public class Test {

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        java.util.List<String> args = java.util.Arrays.asList(args_);
        com.aliyun.dysmsapi20170525.Client client = Test.createClient("LTAI5tL6G7tcniFDcyBKnwCd", "Kpxmz4RSbgyCbwr4NAZJqDXxQmO3DC");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers("18926748213")
                .setSignName("")
                .setTemplateCode("");
       // sendSmsRequest.setTemplateParam(null)
        // 复制代码运行请自行打印 API 的返回值
        client.sendSms(sendSmsRequest);
       
    }
}
