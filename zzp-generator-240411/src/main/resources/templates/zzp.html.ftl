<!DOCTYPE html>
<html>
<head>
    <title>zzp946</title>
</head>
<body>
<h1>欢迎来到ZZP乐园</h1>
<ul>
    <#list menuItems as item>
        <li><a href="${item.url}">${item.lable}</a></li>
    </#list>
</ul>
<#-- -->
<footer>
    ${currentYear} unbelievablezZZP All Right Reserved.
</footer>
</body>
</html>