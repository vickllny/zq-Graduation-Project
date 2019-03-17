<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>${logicName}</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" th:href="@{/layui/css/layui.css}">
    <link rel="stylesheet" th:href="@{/ztree/css/zTreeStyle.css}" type="text/css">
</head>
<body>
<div>
    <div class="layui-row">
        <div class="layui-col-md12">
            <div class="tableBox">
                <table class="layui-hide" id="table1" lay-filter="table1"></table>
            </div>
        </div>
    </div>
</div>


<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">新增</button>
    </div>
</script>

<script type="text/html" id="operation">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script th:inline="javascript">
    var base = ${r'[[${base}]]'};
</script>
<script type="text/javascript" th:src="@{/jquery/jquery-1.10.2.min.js}"></script>
<script th:src="@{/layui/layui.js}" charset="utf-8"></script>
<script th:src="@{/AjaxUtil.js}" charset="utf-8"></script>

<script>
    var table1 = null;
    layui.use(['table'], function(){
        var table = layui.table;

        var tableWidth = $('#table1').parents('.tableBox').width();
        var cols = [
            <#list columns as list>
                <#if !list.pk>
                    {field:'${list.fieldName}', title:'${list.logicName}', width:240},
                </#if>
            </#list>
            {field: 'operation', title:'操作', toolbar: '#operation', width: tableWidth-${columns?size*240}}
        ]
        table1 = table.render({
            elem: '#table1',
            url: base + '/${simpleName}/page',
            toolbar: '#toolbar',
            title: '${logicName}表',
            cols: [cols],
            page: true,
            request: {
                pageName: 'pageNumber',
                limitName: 'pageSize'
            },
            method: 'post'
        });

        //头工具栏事件
        table.on('toolbar(table1)', function(obj){
            switch(obj.event){
                case 'add':
                    var url = base + '/${simpleName}/add';
                    layer.open({
                        type: 2,
                        title: '新增',
                        area: ['650px', '450px'],
                        offset: 'auto',
                        shade: 0,
                        content: url
                    });
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(table1)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                //编辑
                var url = base + '/${simpleName}/edit?id='+data.id;
                layer.open({
                    type: 2,
                    area: ['700px', '450px'],
                    fixed: false,
                    content: url
                });
            }else if(obj.event = 'delete'){
                var url = base + '/${simpleName}/' + data.id;
                layer.confirm('确认删除此条数据?', {icon: 2, title:'提示'}, function(index){
                    AjaxUtil.del(url,function(json){
                        layer.alert(json.message);
                        if(json && json.status == 'success'){
                            table1.reload();
                        }
                    });
                    layer.close(index);
                });
            }
        });
    });
</script>

</body>
</html>