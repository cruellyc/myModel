KY={};
//get 请求
KY.jsonp= function(u, f, ff){
	$.ajax({
		dataType: "json",
		url: u,
		timeout: 5000,
		xhrFields: {withCredentials:true},
		crossDomain: true,
		success: function(j){if(f) f(j);},
		error: function(){
			if(ff) ff();
		}
	});
};
//post 请求
KY.jsonpost = function(u,data, f, ff){
	$.ajax({
		dataType: "json",
		type: 'POST',
		url: u,
		data: data,
		timeout: 30000,
		xhrFields: {withCredentials:true},
		crossDomain: true,
		success: function(j){
			if(f) f(j);},
		error: function(){if(ff) ff();}
	});
};
//获取url中的参数
KY.getUrlParam=function(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r != null) return unescape(r[2]); return null; //返回参数值
};