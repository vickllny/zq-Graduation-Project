/**
 * 关闭当前窗口
 * 
 * @returns
 */
function closeCurrentIframe(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}
/**
 * 初始化菜单树
 * 
 * @param url
 * @returns
 */
function initMenuTree(url){
	AjaxUtil.syncGet(url,function(json){
		buildMenuTree(json);
	});
}
function buildMenuTree(json){
	var html = '';
	$.each(json,function(index,value){
		if(value.pid === '#'){
			html += doBuildMenuTree(value, json, index == 0);
		}
	})
	$("#menuTree").append(html);
}
function doBuildMenuTree(data, json, isFirst){
	var html = '';
	var haveChild = false;
	$.each(json,function(index,value){
		if(data.id == value.pid){
			haveChild = true;
			return false;
		}
	})
	if(!haveChild){
		return html;
	}
	html += isFirst?'<li class="layui-nav-item layui-nav-itemed">':'<li class="layui-nav-item">';
	html += '<a href="'+getUrl(data.url)+' target="stage">'+data.name+'<span class="layui-nav-more"></span></a>';
	// dl
	var ddHtml = '';
	$.each(json,function(index,value){
		if(data.id == value.pid){
			ddHtml += '<dd><a href="'+base+value.url+'" target="stage">'+value.name+'</a>';
			ddHtml += doBuildMenuTree(value, json);
			ddHtml += '</dd>';
		}
	})
	if(ddHtml){
		html += '<dl class="layui-nav-child">';
		html += ddHtml;
		html += '</dl>';
	}
	html += '</li>';
	return html;
}
function getUrl(url){
	if(!url || url == '#'){
		return "#";
	}
	return base + url;
}
/**
 * 格式化时间戳
 * @param datetime
 * @param fmt
 * @returns
 */
function formatDate(datetime,fmt) {
	if (parseInt(datetime)==datetime) {
		if (datetime.length==10) {
		  datetime=parseInt(datetime)*1000;
		} else if(datetime.length==13) {
		  datetime=parseInt(datetime);
		}
	}
	datetime = new Date(datetime);
	var o = {
		"M+" : datetime.getMonth()+1,                 // 月份
		"d+" : datetime.getDate(),                    // 日
		"h+" : datetime.getHours(),                   // 小时
		"m+" : datetime.getMinutes(),                 // 分
		"s+" : datetime.getSeconds(),                 // 秒
		"q+" : Math.floor((datetime.getMonth()+3)/3), // 季度
		"S"  : datetime.getMilliseconds()             // 毫秒
	};   
	if(/(y+)/.test(fmt))  {
		fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));   
	} 
	for(var k in o){
		if(new RegExp("("+ k +")").test(fmt)){
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
			return fmt;
		}
	} 
}