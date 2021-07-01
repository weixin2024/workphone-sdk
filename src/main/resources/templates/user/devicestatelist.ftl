<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设备状态信息信息</title>
<!--公共的js与css文件-->
<#include "/common/common.ftl">
</head>
<body>
    <#include "/user/common/top.ftl">
	<!-- 要于顶部有距离-->
	<div class="projects-header page-header" style="margin: 30px 0 22px;">
	</div>
	<div class="container-fluid">
		<div class="row">
            <#include "/user/common/leftmenu.ftl">
			<div class="col-sm-9  col-md-10  main"  style="padding-left: 0px;">
				<ol class="breadcrumb" style="margin-top: 3px; margin-bottom: 10px">
					<li class="glyphicon glyphicon-home" aria-hidden="true"></li>
					<li class="active">设备状态列表</li>
				</ol>
				<div class="row">
					<form action="/user/device/list" id="form" method="post">
					    <div class="col-md-2">
							<input type="text" name="deviceid" value="${info.deviceid!}"
								class="form-control" placeholder="设备号"
								aria-describedby="basic-addon1">
						</div>
						
						<div class="col-md-2">
							<input type="text" name="wechatid" value="${info.wechatid!}"
								class="form-control" placeholder="wechatid"
								aria-describedby="basic-addon1">
						</div>
						
						<div class="col-md-1">
							<select class="form-control" name="accountid" >
							   <option value="" <#if info?? && info.accountid??> <#else> selected</#if> > 全部 </option>
							   <#if userList?exists>  
					                <#list userList as user>
							           <option value="${user.id!}" <#if info.accountid?? && user?? && user.id?? && user.id == info.accountid > selected</#if> > ${user.account!} </option>
					                </#list>
								</#if>  
							</select>
						</div>
						
						<div class="col-md-1">
							<select class="form-control" name="did" >
							   <option value="" <#if info?? && info.did??> <#else> selected</#if> > 全部 </option>
							   <#if departmentList?exists>  
					                <#list departmentList as dep>
							           <option value="${dep.id!}" <#if info.did?? && dep?? && dep.id?? && dep.id == info.did > selected</#if> > ${dep.name!} </option>
					                </#list>
								</#if>  
							</select>
						</div>
						
						
						
					    <div class="col-md-1">
							 <select class="form-control" name="isonline" >
							   <option value="" <#if info?? && info.isonline??> <#else> selected</#if> > 全部 </option>
							   <option value="0" <#if info?? && info.isonline?? && info.isonline == 0 > selected</#if> >已上线</option>
							   <option value="1" <#if info?? && info.isonline?? && info.isonline == 1 > selected</#if> >已下线</option>
							</select>
						</div>
					    <div class="col-md-1">
							<select class="form-control" name="islogined" >
							   <option value="" <#if info?? && info.islogined??> <#else> selected</#if> > 全部 </option>
							   <option value="0" <#if info?? && info.islogined?? && info.islogined == 0 > selected</#if> >已登录</option>
							   <option value="1" <#if info?? && info.islogined?? && info.islogined == 1 > selected</#if> >已退出</option>
							</select>
						</div>
					   
                        <div class="col-md-1">
							<select class="form-control" onchange="selectOnchang(this)">
								<option value="10" <#if pageBean.pageSize==10> selected</#if> >10条</option>
								<option value="30" <#if pageBean.pageSize==30> selected</#if> >30条</option>
								<option value="50" <#if pageBean.pageSize==50> selected</#if> >50条</option>
								<option value="100" <#if pageBean.pageSize==100> selected</#if> >100条</option>
							</select>
						</div>
						
						<div class="col-md-1">
							<button type="submit" class="btn btn-default">查询</button>
							<input type="hidden" id="pageNo" name="pageNo">
                            <input type="hidden" id="pageSize" name="pageSize" value="${pageBean.pageSize!}">
						</div>
						
                        <div class="col-md-1">
                            <button type="button" onclick="dobing()" class="btn btn-default">绑定</button>
                        </div>
                        
                        <div class="col-md-1">
                            <button type="button" onclick="toAdd()" class="btn btn-default">添加</button>
                        </div>
						
						
						  
					</form>
				</div>
				 
				<div class="table-responsive" style="border: 1px solid #ddd;margin-top: 15px;">
					<table class="table table-striped">
						<thead>
							<tr>
							    <th><input type="checkbox" id="checkAll" name="checkAll" /></th>
							    <th>所属部门</th>
								<th>所属操作员</th>
							    <th>设备号</th>
								<th>微信id</th>
								<th>微信号</th>
								<th>微信昵称</th>
								<th>手机是否在线</th>
								<th>PC是否登录</th>
                                <th align="center">操作</th>
							</tr>
						</thead>
						<tbody>
						 
                         <#if pageBean?exists>  
                            <#list pageBean.resultList as user>
								<tr>
								    <td>
								      <input type="checkbox" id="checkAll${user.id!}" value="${user.id!}" name="checkItem" />
								    </td>
								    <td>${user.dname!}</td>
									<td>${user.accountname!}</td>
								    <td>${user.deviceid!}</td>
									<td>${user.wechatid!}</td>
									<td>${user.wechatno!}</td>
									<td>${user.wechatnick!}</td>
									<td>${(user.isonline==0)?string('<font color="green">已上线</font>','<font color="red">已下线</font>')}</td>
									<td>${(user.islogined==0)?string('<font color="green">已登录</font>','<font color="red">未登录</font>')}</td>
                                    <td><#if (user.accountid)??><#else><a  href="javascript:binding(${user.id})">绑定</a>  |</#if> <a  href="/user/device/toedit/${user.id}">修改</a> | <a  href="javascript:deleteInfo(${user.id!})">删除</a></td>
								</tr>
							</#list>
                         </#if>  
						</tbody>
					</table>
				</div>
				 
				<div align="center">
					<nav>
						  <#include "/common/page.ftl">
					</nav>
				</div>
			</div>
		</div>
		
		
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							选择绑定账号
						</h4>
					</div>
					<div class="modal-body">
					        
						    <select class="form-control" onchange="selectbindno(this)">
								 <#if userList?exists>  
								         <option>请选择操作员</option>
	                                     <#list userList as info>
									        <option value="${info.id!}" >${info.account!}</option>
									     </#list>
                                  </#if> 
							</select>
							 
							<input type="hidden" id ="bindno" />
							<input type="hidden" id ="ids" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
						           关闭
						</button>
						<button type="button" onclick="bindSubmit()" class="btn btn-primary">
							提交
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		
		
	</div>

</body>
 <script type="text/javascript">
  function gotoPage(pageNo){
     $('#pageNo').val(pageNo)
     $('#pageSize').val()
	 $('#form').submit();
  }
  
 
  function selectOnchang(obj){
	  var value = obj.options[obj.selectedIndex].value;
	  $('#pageSize').val(value);
  }
  
   //checkbox全选全不选
  $("#checkAll").click(function(){ 
     if(this.checked){ 
        $("input[name='checkItem']:checkbox").prop('checked',true);   
     }else{   
        $("input[name='checkItem']:checkbox").prop('checked',false);    
     }   
  }); 

  //添加
  function toAdd(){
    location.href="/user/device/toadd";
  } 
  
    //删除
  function deleteInfo(id){
      var res=confirm("真的要删除该条记录吗?")
	  if(id && res){
	       location.href="/user/device/delete/"+id;
	  }
  }
  
  
   //选择所属账号
  function selectbindno(obj){
	  var value = obj.options[obj.selectedIndex].value;
	  $('#bindno').val(value);
  } 
  
  //选择账号后提交
  function bindSubmit(){
      var bindno = $('#bindno').val();
      var ids = $('#ids').val();
      if(bindno && ids){
            $.ajax({
	            type: 'POST',
	            dataType: 'json',
	            url:'/user/device/binding',
	            data:{accountid:bindno,ids:ids},
	            success:function(result){
			         if(result==true){
			             location.href="/user/device/list";
			             $('#myModal').modal('hide');
			         }
			    }
		    });
      }else{
         alert("请选择！");
      }
  }  
  
  //单条数据绑定
  function binding(id){
     $('#ids').val(id);
     $('#myModal').modal('show');
  }
  
  //批量绑定
  function dobing(){
        //1、勾选
        var adIds = "";  
        $("input:checkbox[name=checkItem]:checked").each(function(i){  
            if(0==i){  
                adIds = $(this).val();  
            }else{  
                adIds += (","+$(this).val());  
            }  
        });  
        if(adIds==""){
           alert("请选择！");
           return;
        }  
        //2、弹框
        binding(adIds); 
  }
  
  
  
</script>
</html>