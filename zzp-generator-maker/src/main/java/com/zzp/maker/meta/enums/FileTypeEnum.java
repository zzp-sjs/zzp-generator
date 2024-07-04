package com.zzp.maker.meta.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/07/04/下午7:57
 * @Description:
 */
public enum FileTypeEnum {
    DIR("目录","dir"),
    FILE("文件","file");

    private final String text;

    private final String value;

    FileTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {return text;}

    public String getValue() {return value;}
}
