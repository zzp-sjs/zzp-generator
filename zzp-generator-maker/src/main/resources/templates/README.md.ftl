# ${name}

> ${description}
>
> 作者：${author}
>
> 基于[程序员鱼皮](https://yuyuanweb.feishu.cn/wiki/Abldw5WkjidySxkKxU2cQdAtnah) 的 [鱼籽代码生成器0项目](https://github.com/liyupi/yuzi-generator)制作，感谢您的使用！

可以通过命令行交互输入的方式动态生成想要的代码

## 使用说明

执行项目根目录下的脚本文件：

>generator <命令> <选项参数>

示例命令：

>generator generated <#list modelConfig.models as modelInfo>-${modelInfo.abbr} </#list>

## 参数说明

<#list modelConfig.models as modelInfo>
${modelInfo?index + 1})${modelInfo.fieldName}<br />
类型：${modelInfo.type}<br />
描述：${modelInfo.description}<br />
默认值：${modelInfo.defaultValue?c}<br />
缩写：${modelInfo.abbr}<br />

</#list>