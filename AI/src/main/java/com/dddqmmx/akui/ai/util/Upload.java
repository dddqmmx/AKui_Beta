package com.dddqmmx.akui.ai.util;

import net.mamoe.mirai.contact.AudioSupported;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.message.data.Audio;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Upload {
    public static Image getImage(File file, Contact contact){
        return ExternalResource.uploadAsImage(file,contact);
    }
    public static Image getImage(InputStream inputStream, Contact contact){
        return ExternalResource.uploadAsImage(inputStream,contact);
    }
    public static Audio getAudio(InputStream inputStream, Group group){
        Audio audio = null;
        ExternalResource resource = null;
        try {
            resource= ExternalResource.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (resource != null) {
                audio = group.uploadAudio(resource); // 上传文件得到语音实例
            }
        } finally {
            try {
                resource.close(); // 保证资源正常关闭
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return audio;
    }
}
