<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <title></title>
    <script src="static/js/jquery-3.4.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            $("tr:even").css("background-color","blue")
        })
                </script>
</head>
<body>
<center>
    <table align="center">
        <thead>
        <tr>
            <td>序号</td>
            <td>标题</td>
            <td>回复/查看</td>
            <td>发表时间</td>
            <td>最新回复</td>
          <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <#list inPageDto.data as s>
            <tr>
                <td>${s.id}</td>
                <td>${s.title}</td>
                <td>${s.replycount}/${s.viewcount}</td>

                <td>${s.reporttime?string('yyyy-MM-dd HH:mm:ss')}</td>
                <td>${s.lastposttime?string('yyyy-MM-dd HH:mm:ss')}</td>

               <td> <a href="/xiangqing?id=${s.id}">详情</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
    <div>


                <span><a href="hello?pageNo=1">首页</a></span>
             <#if inPageDto.hasPreviousPage==true>
                 <span>
                     <a href="hello?pageNo=${inPageDto.pageNo-1}">
                         <span aria-hidden="true">上一页</span>
                     </a>
                 </span>
             </#if>
                <#list 1..maxCount as page_Num>
                    <#if page_Num==(inPageDto.pageNo)>
                        <span ><a href="#">${page_Num}</a></span>
                    </#if>
                    <#if page_Num!=(inPageDto.pageNo)>
                        <span ><a href="/hello?pageNo=${page_Num}">${page_Num}</a></span>
                    </#if>
                </#list>
                <#if inPageDto.hasNextPage==true>
                    <span>
                        <a href="/hello?pageNo=${inPageDto.pageNo+1}">
                            <span aria-hidden="true">下一页</span>
                        </a>
                    </span>
                </#if>
                <span><a href="/hello?pageNo=${maxCount}">末页</a></span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span><span aria-hidden="true">当前第:${inPageDto.pageNo}页,总共:${maxCount}页,总共:${inPageDto.total}条记录</span></span>


    </div>

</center>
</body>
</html>