package com.zzp.maker.model;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/16/下午3:02
 * @Description:
 */

import lombok.Data;

/**
 * 动态模板配置
 */
@Data
public class   DataModel {

    /**
     *是否生成循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author = " zzp";

    /**
     * 输出信息
     */
    private String outputText = "sum = ";

//    public boolean isLoop() {
//        return loop;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public String getOutputText() {
//        return outputText;
//    }
//
//    public void setLoop(boolean loop) {
//        this.loop = loop;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void setOutputText(String outputText) {
//        this.outputText = outputText;
//    }
}
