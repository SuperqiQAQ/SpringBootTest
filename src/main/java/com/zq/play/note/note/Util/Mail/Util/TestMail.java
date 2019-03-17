package com.zq.play.note.note.Util.Mail.Util;


import com.zq.play.note.note.Util.Mail.Util.core.MailSender;
import com.zq.play.note.note.Util.Mail.Util.enums.MailContentTypeEnum;

import java.util.ArrayList;


public class TestMail {
    public static void main(String[] args) throws Exception
    {
        new MailSender()
                .title("测试SpringBoot发送邮件")
                .content("简单文本内容发送")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{
                    add("471684203@qq.com");
                }})
                .send();
    }
}
