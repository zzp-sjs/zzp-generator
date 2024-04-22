package com.zzp.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/22/上午8:52
 * @Description:
 */
public class MetaManger {


    private static volatile Meta meta;

    private MetaManger() {
        //私有构造函数，防止外部实例化
    }

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManger.class) {
                if (meta == null) {
                    meta =initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        //todo 校验配置文件，处理默认值，
        return newMeta;
    }

}
