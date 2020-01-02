<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <title></title>
    <script src="static/js/jquery-3.4.1.js" type="text/javascript"></script>
</head>
<body>
<center>
<h3>${look.title}</h3>

          <p>发表于:${look.reporttime?string('yyyy-MM-dd HH:mm:ss')}</p>
    <p>${look.content}</p>
   <p>读者回应：</p>
    <div class="bb">
    <#list look1 as rs>
    <p>发表于:${rs.replytime?string('yyyy-MM-dd HH:mm:ss')}</p>
    <p>${rs.contents}</p>
    </#list>
    </div>
<p>快速回复（字数200字以内）</p>
    <#--<p>回复时间<input name="saleend"></p>-->
    <p >回复内容<textarea  rows="3" cols="20" name="contents" >

</textarea></p>
   <#-- <p>回复时间<input name="replytime"></p>-->
    <p><input type="text" style="display:none" name="infoid" value="${look.id}"/></p>
    <p><input type="button" value="增加"></p>
<a href="/xiugai?id=${look.id}">返回首页</a>

</center>
<script type="text/javascript">
    $(function(){
      /*  $(".bb").css("background-color","blue")*/
        $("[name='replytime']").blur(function(){
            var replytime=$(this).val();
            if(replytime==""){
                alert("回复时间不可为空");
            }
        })


        $("[type='button']").click(function(){

          /*  var replytime=$("[name='replytime']").val();*/
            var infoid=$("[name='infoid']").val();
            var contents=$("[name='contents']").val();
            $.get("/add","&infoid="+infoid+"&contents="+contents,function(data) {
                if(data=="true"){
                    alert("添加成功");
                    location.href="/hello"
                }else{
                    alert("添加失败");
                    location.href="/hello"
                }
            })

        })
    })
</script>
</body>
</html>