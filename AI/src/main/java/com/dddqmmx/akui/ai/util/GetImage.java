package com.dddqmmx.akui.ai.util;

import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;
import java.io.InputStream;

public class GetImage {
    public static Image get(File file, Contact contact){
        return ExternalResource.uploadAsImage(file,contact);
    }
    public static Image get(InputStream inputStream, Contact contact){
        return ExternalResource.uploadAsImage(inputStream,contact);
    }
}
