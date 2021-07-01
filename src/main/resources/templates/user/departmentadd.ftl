<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>组织机构信息维护</title>
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
		  <li class="active">组织机构信息维护</li>
	  </ol>
	<div class="row">
	 
  <div class="projects-header page-header" style="margin: 3px 0 6px;"></div>
  
<div class="panel panel-default">
<div class="panel-body">
   <div style="padding: 8px;margin: 8px" class="row">
								 
		<form novalidate="novalidate" method="post"  id="form" role="form" class="order-form">
			    <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
					   <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px">* 部门名称</span></div>
					   <div class="col-md-5">
					     <input type="text" id="name" value="${entity.name!}" name="name" aria-describedby="basic-addon1" placeholder="部门名称" class="form-control"> 
					   </div>
					   <div class="col-md-3"></div>
			   </div> 
			    <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
			           <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px"> 上级部门</span></div>
			           <div class="col-md-5">
							<select class="form-control" name="pid"  id="pid">
							   <option value="" <#if entity?? && entity.pid??> <#else> selected</#if> > -选择上级部门-  </option>
							   <#if departmentList?exists>  
					                <#list departmentList as info>
							           <option value="${info.id!}" <#if info.id?? && entity?? && entity.pid?? && info.id == entity.pid > selected</#if> > ${info.name!} </option>
					                </#list>
								</#if>  
							</select>
							
						</div>
					   <div class="col-md-3"></div>
			   </div>
			   
               <div class="col-md-12" style="height:50px">
			           <div class="col-md-2"></div>
					   <div class="col-md-2"><span style="text-align: right;color: #666;  padding: 8px"> 备注信息</span></div>
					   <div class="col-md-5">
					     <input type="text" id="description" name="description" value="${entity.description!}" aria-describedby="basic-addon1" placeholder="填写备注信息" class="form-control"> 
					   </div>
					   <div class="col-md-3"></div>
			   </div>
               <div class="col-md-12">
                        <input type="hidden" id="id" name="id" value="${entity.id!}"/>
                        <div class="col-md-4"></div>
			            <div class="col-md-4" id="flabel"></div>
			            <div class="col-md-4"></div>
               </div>
			    
			   <div style="padding: 8px;padding-bottom: 10px;margin: 8px">
			        <div style="text-align: center;" class="col-md-12">
			           <button   type="button" onclick="submitForm()" class="btn btn-success">提交表单</button>
				    </div>
			   </div>
			   
		</form>
	</div>
     
</div></div>
 
 <script>
 function submitForm(){ 
     if($('#name').val()){
		 var targetUrl ="";
		 if($('#id').val()){
	         targetUrl = "/user/department/edit"; 
	     }else{
	         targetUrl = "/user/department/add"; 
	     }
		 var data1 = $("#form").serialize(); 
	     $.ajax({
		    type:'post',  
		    cache:false, 
		    url:targetUrl, 
		    data:data1,  
		    success:function(res){  
		       if(res == 'success'){
		           location.href="/user/department/list";
		       }else{
		          $("#flabel").html("<font color='red'>失败</font>");
		       }
		    },   
	        error : function() {   
	            alert("异常！");   
	        }  
	     })
	 }else{
	    $("#flabel").html("<font color='red'>部门名称不能为空!</font>");
	 }
     
 }
 </script>
</body>
</html>