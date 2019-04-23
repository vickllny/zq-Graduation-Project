var AjaxUtil = {
	/**
	 * 异步post
	 * @param url
	 * @param callback
	 * @param data
	 */
	post : function(url,callback,data){
		$.post(url,data,callback);
	},
	/**
	 * 同步post
	 * @param url
	 * @param callback
	 * @param data
	 * @param errorCallback
	 * @returns
	 */
	syncPost : function(url,data,callback,errorCallback){
		$.ajax({
			url : url,
			type : 'post',
			async : false,
			data : data,
			dataType : 'json',
			success : callback,
			error : errorCallback
		})
	},
	/**
	 * 异步get
	 * @param url
	 * @param callback
	 * @returns
	 */
	get : function(url,callback){
		$.get(url, callback);
	},
	/**
	 * 同步get
	 * @param url
	 * @param callback
	 * @param errorCallback
	 * @returns
	 */
	syncGet : function(url,callback,errorCallback){
		$.ajax({
			url : url,
			type : 'get',
			async : false,
			dataType : 'json',
			success : callback,
			error : errorCallback
		})
	},
	/**
	 * delete
	 * @param url
	 * @param callback
	 * @param errorCallback
	 * @returns
	 */
	del : function(url,callback,errorCallback){
		$.ajax({
			url : url,
			type : 'delete',
			async : false,
			dataType : 'json',
			success : callback,
			error : errorCallback
		})
	},
	/**
	 * put
	 * @param url
	 * @param data
	 * @param callback
	 * @param errorCallback
	 * @returns
	 */
	put : function(url,data,callback,errorCallback){
		$.ajax({
			url : url,
			type : 'put',
			async : false,
			data: data,
			dataType : 'json',
			success : callback,
			error : errorCallback
		})
	}
}