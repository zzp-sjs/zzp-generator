package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;
import ${basePackage}.model.DataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/17/上午9:12
 * @Description:
 */
public class DynamicGenerator {


    public static  void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {

        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        System.out.println(templateDir);
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        String temolateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(temolateName);

        //设置数字格式
        configuration.setNumberFormat("0.######");

//        //创建数据类型
//        DataModel dataModel = new DataModel();
//        dataModel.setAuthor("zzp");
//        dataModel.setLoop(false);
//        dataModel.setOutputText("求和结果：");

        // 文件不存在则创建文件和父目录
        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }


        //生成
        Writer out = new FileWriter(outputPath);
        System.out.println("输出目录:"+outputPath);
        template.process(model, out);

        out.close();
    }
}
