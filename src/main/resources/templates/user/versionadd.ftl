<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>维护版本控制信息</title>
<!--公共的js与css文件-->
<#include "/common/common.ftl">
 
</head>
<body>
	<#include "/user/common/top.ftl">
	<!-- 要于顶部有距离-->
    <div class="projects-header page-header" style="margin: 30px 0 22px;" > </div>
	<div class="container-fluid">
       <div class="row">
	        <#include "/user/common/leftmenu.ftl">
            <div class="col-sm-9 col-md-10  main">
          <ol class="breadcrumb" style="margin-top: 3px;margin-bottom: 10px">
	      <li class="glyphicon glyphicon-home" aria-hidden="true"></li>
		  <li class="active">维护版本控制信息</li>
	  </ol>
	<div class="row">
	 
  <div class="projects-header page-header" style="margin: 3px 0 6px;"></div>
  
<div class="panel panel-default">
<div class="panel-body">
   <div style="padding: 8px;margin: 8px" class="row">
								 
		<form novalidate="novalidate" method="post"  id="form" role="form" class="order-form">
			   
               <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
					   <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">* 版本名称</span></div>
					   <div class="col-md-5">
					     <input type="text"  value="${entity.version!}" name="version" id="version" aria-describedby="basic-addon1" placeholder="填写版本名称" class="form-control"> 
					   </div>
					   <div class="col-md-3"></div>
			   </div>  
			   
			   <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
					   <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">* 版本号</span></div>
					   <div class="col-md-5">
					     <input type="text"  value="${entity.vernumber!}" name="vernumber" id="vernumber" aria-describedby="basic-addon1" placeholder="填写版本号" class="form-control"> 
					   </div>
					   <div class="col-md-3"></div>
			   </div> 
			   
			   <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
					   <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">* APP包名</span></div>
					   <div class="col-md-5">
					     <input type="text"  value="${entity.packagename!}" name="packagename" id="packagename" aria-describedby="basic-addon1" placeholder="填写APP包名" class="form-control"> 
					   </div>
					   <div class="col-md-3"></div>
			   </div>   
			   
			   <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
					   <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">*  填写内容</span></div>
					   <div class="col-md-5">
					     <input  id="content" readonly name="packageurl" value="${entity.packageurl!}" placeholder="APP软件网络地址，请点击上传文件，上传后自动填充" class="form-control" />
					   </div>
					   <div class="col-md-3"></div>
			   </div>
			   
			   <div class="col-md-12" style="height:120px" >
			           <div id="fileDiv">
				           <div class="col-md-2"></div>
	                       <div class="col-md-2">
	                       <span style="text-align: right;color: #666;  padding: 8px"> 上传文件</span></div>
	                       <div class="col-md-5">
	                         <button  id ="uploadButton1"  type="button" style="margin-left:60px"  class="btn btn-default"> 点击浏览文件  </button>
	                         <input type="file" id="fileToUpload1" style="visibility: hidden;"/>
	                       </div>
	                       <div class="col-md-3">
	                       <lable></lable>
	                       </div>
                       </div>
               </div>
			   
			    
                
               <div class="col-md-12">
                        <input type="hidden" id="id" name="id" value="${entity.id!}"/>
                        <div class="col-md-4"></div>
			            <div class="col-md-4" id="flabel"></div>
			            <div class="col-md-4"></div>
               </div>
			    
			   <div style="padding: 8px;padding-bottom: 10px;margin: 8px">
			        <div style="text-align: center;" class="col-md-12">
				        <button   type="button" onclick="submitForm()" class="btn btn-success">提交</button> 
				        <button   type="button" onclick="javascript:history.go(-1)" style="margin-left:30px" class="btn btn-default">返回</button>
				    </div>
			   </div>
			   
		</form>
	</div>
     
</div></div>
 
 <script>
  
 function submitForm(){
     if($('#version').val() && $('#vernumber').val() && $('#packagename').val() && $('#content').val()){
		 var targetUrl ="";
		 if($('#id').val()){
	         targetUrl = "/user/version/edit"; 
	     }else{
	         targetUrl = "/user/version/add"; 
	     }
		 var data1 = $("#form").serialize(); 
	     $.ajax({
		    type:'post',  
		    cache:false, 
		    url:targetUrl, 
		    data:data1,  
		    success:function(res){  
		       if(res == 'success'){
		           location.href="/user/version/list";
		       }else{
		          $("#flabel").html("<font color='red'>失败</font>");
		       }
		    },   
	        error : function() {   
	            alert("异常！");   
	        }  
	     })
	 }else{
	    $("#flabel").html("<font color='red'>所有参数都不能为空!</font>");
	 }
     
 }
 
 
 $(function() {
  
	$('#uploadButton1').click(function(){
		$('#fileToUpload1').click()
	});

	$('#fileToUpload1').change(function(){
		var formdata = new FormData();
		url = "${uploadUrl!}";
		var fileObj = $(this).get(0).files;
		 
		formdata.append("myfile", fileObj[0]);
		jQuery.ajax({
			url : url,
			type : 'post',
			data : formdata,
			cache : false,
			contentType : false,
			processData : false,
			dataType : "json",
			success : function(res) {
				if (res.bizCode == 0) {
					$("#content").val(res.data.url); 
					alert("成功！");
				}else{
					alert("上传失败!");
				} 
			}
		});
	})
})
  
 </script>
</body>
</html>