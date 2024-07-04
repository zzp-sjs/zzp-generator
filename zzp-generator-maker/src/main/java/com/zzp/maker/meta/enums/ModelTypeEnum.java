package com.zzp.maker.meta.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/07/04/下午8:05
 * @Description:
 */
public enum ModelTypeEnum {
    STRING("字符串","String"),
    BOOLEAN("布尔","boolean");

    private final String text;

    private final String value;

    ModelTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {return text;}

    public String getValue() {return value;}
}

