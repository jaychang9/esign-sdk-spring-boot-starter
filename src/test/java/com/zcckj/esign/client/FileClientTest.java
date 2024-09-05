package com.zcckj.esign.client;

import com.zcckj.common.mvc.result.Result;
import com.zcckj.esign.TestApplication;
import com.zcckj.esign.dto.res.GetFileUploadStatusRes;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class FileClientTest extends TestCase {
    @Autowired
    private FileClient fileClient;

    public void testGetFileUploadUrl() {

    }

    @Test
    public void testGetFileUploadStatus() {
        String fileId = "3f93a410b3ea4493886bccd0e0fef877";
        Result<GetFileUploadStatusRes> result = fileClient.getFileUploadStatus(fileId, false);
        if (result.getCode() != 0) {
            System.out.println(String.format("接口返回错误码:%d,错误信息:%s", result.getCode(), result.getMessage()));
        }
        System.out.println(result.getData());

    }
}