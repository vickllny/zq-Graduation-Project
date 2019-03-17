<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>${logicName}编辑</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" th:href="@{/layui/css/layui.css}">
    <link rel="stylesheet" th:href="@{/core/css/cyType.css}">
    <link rel="stylesheet" th:href="@{/core/css/cyStyle.css}">
    <link rel="stylesheet" th:href="@{/ztree/css/zTreeStyle.css}" type="text/css">
    <link rel="stylesheet" th:href="@{/core/css/base.css}">
</head>
<body>
<div>
    <form class="layui-form layui-form-pane">
        <div class="f-layout-m">
        <#list columns as list>
            <#if list.pk>
            <input type="hidden" name="id" th:value="${r'${bean?.id}'}">
            <#else>
            <div class="layui-form-item">
                <label class="layui-form-label">${list.logicName}</label>
                <div class="layui-input-block">
                    <input type="text" name="${list.fieldName}" th:value="${r'${bean?.'}${list.fieldName}}" lay-verify="required" autocomplete="off" placeholder="${list.logicName}" class="layui-input">
                </div>
            </div>
            </#if>
        </#list>
        </div>
        <div class="f-layout-b-btn">
            <button class="layui-btn layui-btn-normal" type="button" lay-submit lay-filter="save">保存</button>
            <button class="layui-btn layui-btn-primary" type="button" onclick="closeCruuentIframe()">取消</button>
        </div>
    </form>
</div>

<script th:inline="javascript">
    var base = ${r'[[${base}]]'};
</script>

<script type="text/javascript" th:src="@{/jquery/jquery-1.10.2.min.js}"></script>
<script th:src="@{/layui/layui.js}" charset="utf-8"></script>
<script type="text/javascript" th:src="@{/ztree/js/jquery.ztree.all.min.js}"></script>
<script th:src="@{/core/js/dropDownTool.js}" type="text/javascript" charset="utf-8"></script>
<script th:src="@{/AjaxUtil.js}" charset="utf-8"></script>
<script th:src="@{/common.js}" charset="utf-8"></script>


<script>
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(save)', function(data){
            var $this = $(this);
            data = data.field;
            var type = $("input[name='id']").val()? 'put' : 'post';
            save($this,function(data){
                $.ajax({
                    url : base + '/${simpleName}',
                    type : type,
                    dataType : 'json',
                    async : false,
                    data : data,
                    success : function (json) {
                        layer.alert(json.message,function(){
                            if(json && json.status == 'success'){
                                parent.table1.reload();
                                closeCruuentIframe();
                            }
                        });
                    }
                })
            },data);
        });
    });
    function save($this,doSave,data) {
        $this.addClass("layui-btn-disabled");
        $this.attr('disabled','disabled');
        var index = layer.load(1);
        doSave(data);
        layer.close(index);
        $this.removeAttr("disabled");
        $this.removeClass("layui-btn-disabled");
    }
</script>
</body>
</html>