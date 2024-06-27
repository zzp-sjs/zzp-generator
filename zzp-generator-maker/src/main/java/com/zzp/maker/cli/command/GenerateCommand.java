package com.zzp.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.zzp.maker.generator.file.DynamicFileGenerator;
import com.zzp.maker.generator.file.FileGenerator;
import com.zzp.maker.model.DataModel;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zzp
 * @Date: 2024/04/18/下午4:56
 * @Description:
 */

@CommandLine.Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-l","--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private Boolean loop;

    @CommandLine.Option(names = {"-a","--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    private String author = "zzp";

    @CommandLine.Option(names = {"-o","--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
    private String outputText = "sum =";

    public Integer call() throws Exception {
        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        System.out.println("配置信息:" + dataModel);
        FileGenerator.doGenerate(dataModel);
        return 0;
    }
}
