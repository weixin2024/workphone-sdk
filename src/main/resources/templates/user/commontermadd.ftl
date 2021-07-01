<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>维护部门公共术语信息</title>
<!--公共的js与css文件-->
<#include "/common/common.ftl">
<style>
.fileDivStyle{
  display:none
}
</style>
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
		  <li class="active">维护部门公共术语</li>
	  </ol>
	<div class="row">
	 
  <div class="projects-header page-header" style="margin: 3px 0 6px;"></div>
  
<div class="panel panel-default">
<div class="panel-body">
   <div style="padding: 8px;margin: 8px" class="row">
								 
		<form novalidate="novalidate" method="post"  id="form" role="form" class="order-form">
			   
			   <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
			           <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">* 所属部门</span></div>
			           <div class="col-md-5">
							<select class="form-control" name="did"  id="did">
							   <option value="" <#if entity?? && entity.did??> <#else> selected</#if> > -选择所属部门-  </option>
							   <#if departmentList?exists>  
					                <#list departmentList as info>
							           <option value="${info.id!}" <#if info.id?? && entity?? && entity.did?? && info.id == entity.did > selected</#if> > ${info.name!} </option>
					                </#list>
								</#if>  
							</select>
						</div>
					   <div class="col-md-3"></div>
			   </div>
			    
			   <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
			           <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">* 所属术语分组</span></div>
			           <div class="col-md-5">
							<select class="form-control" name="tid"  id="tid">
							   <option value="" <#if entity?? && entity.tid??> <#else> selected</#if> > -选择术语分组-  </option>
							   <#if commontermTypeList?exists>  
					                <#list commontermTypeList as info>
							           <option value="${info.id!}" <#if info.id?? && entity?? && entity.tid?? && info.id == entity.tid > selected</#if> > ${info.name!} </option>
					                </#list>
								</#if>  
							</select>
						</div>
					   <div class="col-md-3"></div>
			   </div> 
			    
			    
			   
			   <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
                       <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">* 术语类型</span></div>
                       <div class="col-md-5">
                                <select class="form-control" id="ctype" name="ctype" onchange="selectOnchang(this)" <#if entity?? && entity.ctype??> disabled="disabled"  </#if>>
                                    <option value="" >-选择术语类型-</option>
									<option value="1" <#if entity?? && entity.ctype?? && entity.ctype==1> selected</#if> >文本类型</option>
									<option value="2" <#if entity?? && entity.ctype?? && entity.ctype==2> selected</#if> >图片类型</option>
									<option value="3" <#if entity?? && entity.ctype?? && entity.ctype==3> selected</#if> >视频类型</option>
									<option value="4" <#if entity?? && entity.ctype?? && entity.ctype==4> selected</#if> >语音类型</option>
									<option value="5" <#if entity?? && entity.ctype?? && entity.ctype==5> selected</#if> >其他文件类型</option>
								</select>
                       </div>
                       <div class="col-md-3"></div>
               </div>
               
                <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
					   <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">* 术语标题</span></div>
					   <div class="col-md-5">
					     <input type="text" id="name" value="${entity.name!}" name="name" aria-describedby="basic-addon1" placeholder="填写术语标题" class="form-control"> 
					   </div>
					   <div class="col-md-3"></div>
			   </div>  
			   
			   <div class="col-md-12" style="height:110px">
			           <div class="col-md-2"></div>
					   <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">*  填写内容</span></div>
					   <div class="col-md-5">
					     <textarea class="form-control" rows="4"  id="content" name="content" placeholder="填写内容">${entity.content!}</textarea>
					   </div>
					   <div class="col-md-3"></div>
			   </div>
			   
			   <div class="col-md-12" style="height:120px" >
			           <div id="fileDiv" >
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
 
  function selectOnchang(obj){
	  var value = obj.options[obj.selectedIndex].value;
	  if(value && value >1){
	    $("#content").attr("readonly","readonly");
	    $("#fileDiv").removeClass("fileDivStyle");
	  }else{
	    $("#content").removeAttr("readonly");
	    $("#fileDiv").addClass("fileDivStyle");
	  }
  }
 
 function submitForm(){
     if($('#name').val() && $('#ctype').val() && $('#did').val() && $('#tid').val() && $('#content').val() ){
		 var targetUrl ="";
		 if($('#id').val()){
	         targetUrl = "/user/commonterm/edit"; 
	     }else{
	         targetUrl = "/user/commonterm/add"; 
	     }
		 var data1 = $("#form").serialize(); 
	     $.ajax({
		    type:'post',  
		    cache:false, 
		    url:targetUrl, 
		    data:data1,  
		    success:function(res){  
		       if(res == 'success'){
		           location.href="/user/commonterm/list";
		       }else{
		          $("#flabel").html("<font color='red'>失败</font>");
		       }
		    },   
	        error : function() {   
	            alert("异常！");   
	        }  
	     })
	 }else{
	    $("#flabel").html("<font color='red'>部门名称、术语分组第不能为空!</font>");
	 }
     
 }
 
 $(function() {
 
	if($("#id").val() && $("#ctype").val()==1){
	     $("#fileDiv").remove();
	}
 
	$('#uploadButton1').click(function(){
		$('#fileToUpload1').click()
	});

	$('#fileToUpload1').change(function(){
		var formdata = new FormData();
		url = "${uploadUrl!}";
		var fileObj = $(this).get(0).files;
		
		var ctype = $("#ctype").val();
		if(ctype==4){
		   var value=$("#fileToUpload1").val();
		   var suffix = value.substr(value.lastIndexOf("."));
		   if(suffix.toLowerCase()==".amr"){
		      formdata.append("isAmrToMp3", "false");
		   }
		   if(suffix.toLowerCase()==".mp3"){
		      formdata.append("isMp3ToAmr", "true");
		   }
		}
		
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