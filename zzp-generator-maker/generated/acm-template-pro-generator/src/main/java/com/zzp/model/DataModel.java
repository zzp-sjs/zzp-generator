package com.zzp.model;

import lombok.Data;

/**
 *数据模型
 */
@Data
public class DataModel {
     /**
      *是否生成循环
      */
    private boolean   loop  = false;
     /**
      *用于生成核心模板文件
      */
    private MainTemplate  ;
}
