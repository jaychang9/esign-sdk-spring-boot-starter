package com.zcckj.esign.client;

import junit.framework.TestCase;
import okhttp3.MediaType;
import org.junit.Test;

import java.io.IOException;

public class FileUploadClientTest extends TestCase {

    @Test
    public void testUpload() throws IOException {
        String uploadUrl = "https://esignoss.esign.cn/1111564182/28d8de57-575b-46c8-aeea-b5817305ad11/CTS%E5%BB%BA%E5%BA%97%E5%90%88%E5%90%8C%E5%A5%BD%E8%BF%90-%E5%9B%9B%E6%96%B9.docx?Expires=1725518542&OSSAccessKeyId=STS.NTo7MJFcC3cH3tF4WdQ6nrg5r&Signature=Nj%2FdE0NpcPoSBxwq4YClW3JTHSo%3D&callback-var=eyJ4OmZpbGVfa2V5IjoiJDFiZjNlN2IwLTFkMzMtNGRjNy05MmE1LWQ5MDlmNTk0NjkyZCQyNjk1MjQyMDkzIn0%3D%0A&callback=eyJjYWxsYmFja1VybCI6Imh0dHA6Ly9zbWx0YXBpLnRzaWduLmNuL2FueWRvb3IvZmlsZS1zeXN0ZW0vY2FsbGJhY2svYWxpb3NzIiwiY2FsbGJhY2tCb2R5IjogIntcIm1pbWVUeXBlXCI6JHttaW1lVHlwZX0sXCJzaXplXCI6ICR7c2l6ZX0sXCJidWNrZXRcIjogJHtidWNrZXR9LFwib2JqZWN0XCI6ICR7b2JqZWN0fSxcImV0YWdcIjogJHtldGFnfSxcImZpbGVfa2V5XCI6JHt4OmZpbGVfa2V5fX0iLCJjYWxsYmFja0JvZHlUeXBlIjogImFwcGxpY2F0aW9uL2pzb24ifQ%3D%3D%0A&security-token=CAISxAJ1q6Ft5B2yfSjIr5fafPf%2Bq7xihKGjMVL30FcxXblCnaKekDz2IHtKdXRvBu8Xs%2F4wnmxX7f4YlqB6T55OSAmcNZEoAgrBEff7MeT7oMWQweEurv%2FMQBqyaXPS2MvVfJ%2BOLrf0ceusbFbpjzJ6xaCAGxypQ12iN%2B%2Fm6%2FNgdc9FHHPPD1x8CcxROxFppeIDKHLVLozNCBPxhXfKB0ca0WgVy0EHsPnvm5DNs0uH1AKjkbRM9r6ceMb0M5NeW75kSMqw0eBMca7M7TVd8RAi9t0t1%2FIVpGiY4YDAWQYLv0rda7DOltFiMkpla7MmXqlft%2BhzcgeQY0pc%2FW6e6mGuXYk9O0y3LOgrwHrfzP5Pz64mb0D9IlrH5MKhPFcJ32zfmYri%2Fc6nijvg476h2NFFsjzb6wdvVPpnKqsr48ztMPdOKcQdpz0agAFUfrHPX2Ae4PaJSvuYssmACP4SxHglwXFZ%2Byo4suXBKa3pt1puZrivdYD7SDlT5T%2BBdBXwTLCFjphSuCj5lKulMdidKWqeYW3GmYVe0QaDQkBvxm4V8XqUSGqTX9UlBBSqHBYjhQ40s7GJtEadcnhOlu1D%2Fin7Uj2PbSB2rDzX0CAA";
        MediaType mediaType = MediaType.parse("application/octet-stream");
        String filePath = "E:\\WorkTemp\\项目发版文件\\202409优化\\e签宝\\abc.docx";
        String upload = FileUploadClient.upload(mediaType, uploadUrl, filePath);
        System.out.println(upload);
    }
}