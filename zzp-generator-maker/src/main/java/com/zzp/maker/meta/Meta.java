package com.zzp.maker.meta;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/21/下午12:40
 * @Description:
 */
@NoArgsConstructor
@Data
public class Meta {
    private String name;
    private String description;
    private String basePackage;
    private String version;
    private String author;
    private String createTime;
    private FileConfigDTO fileConfig;
    private ModelConfig modelConfig;

    @NoArgsConstructor
    @Data
    public static class FileConfigDTO {
        private String inputRootPath;
        private String outputRootPath;
        private String sourceRootPath;
        private String type;
        private List<FileConfig> files;

        @NoArgsConstructor
        @Data
        public static class FileConfig {
            private String groupKey;
            private String groupName;
            private String type;
            private String condition;
            private List<FileInfo> files;
            private String inputPath;
            private String outputPath;
            private String generateType;

            @NoArgsConstructor
            @Data
            public static class FileInfo {
                private String inputPath;
                private String outputPath;
                private String type;
                private String generateType;
            }
        }
    }

    @NoArgsConstructor
    @Data
    public static class ModelConfig {
        private List<ModelsDTO> models;

        @NoArgsConstructor
        @Data
        public static class ModelsDTO {
            private String fieldName;
            private String type;
            private String description;
            private Object  defaultValue;
            private String abbr;
            private String groupKey;
            private String groupName;
            private String condition;
            private List<ModelInfo> models;

            @NoArgsConstructor
            @Data
            public static class ModelInfo {
                private String fieldName;
                private String type;
                private String description;
                private String defaultValue;
                private String abbr;
            }
        }
    }
}
