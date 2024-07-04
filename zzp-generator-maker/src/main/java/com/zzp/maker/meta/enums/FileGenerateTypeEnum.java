package com.zzp.maker.meta.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/07/04/下午8:03
 * @Description:
 */
public enum FileGenerateTypeEnum {
    DYNAMIC("动态","dynamic"),
    STATIC("静态","static");

    private final String text;

    private final String value;

    FileGenerateTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {return text;}

    public String getValue() {return value;}
}

