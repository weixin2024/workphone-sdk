<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>组织机构信息</title>
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
					<li class="active">组织机构列表</li>
				</ol>
				<div class="row">
					<form action="/user/department/list" id="form" method="post">
						 
						<div class="col-md-2">
							<input type="text" name="name"
								value="${info.name!}" class="form-control"
								placeholder="部门名称" aria-describedby="basic-addon1">
						</div>
						  
                        <div class="col-md-2">
							 <select class="form-control" onchange="selectOnchang(this)">
								<option value="10" <#if pageBean.pageSize==10> selected</#if> >10条</option>
								<option value="30" <#if pageBean.pageSize==30> selected</#if> >30条</option>
								<option value="50" <#if pageBean.pageSize==50> selected</#if> >50条</option>
								<option value="100" <#if pageBean.pageSize==100> selected</#if> >100条</option>
							</select>
						</div>
						 
                        <div class="col-md-1">
							<button type="submit" class="btn btn-default">查询</button>
						</div>
						 
						<div class="col-md-1">
                            <button type="button" onclick="toAdd()" class="btn btn-default">添加</button>
                        </div>
						 
                        <div class="col-md-6">
                           <input type="hidden" id="pageNo" name="pageNo">
                           <input type="hidden" id="pageSize" name="pageSize" value="${pageBean.pageSize!}">
                        </div>
                        
					</form>
				</div>
				 
				<div class="table-responsive" style="border: 1px solid #ddd;margin-top: 15px;">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>部门名称</th>
								<th>上级部门</th>
                                <th>创建时间</th>
								<th align="center">操作</th>
							</tr>
						</thead>
						<tbody>
						
                         <#if pageBean?exists>  
                            <#list pageBean.resultList as info>
								<tr>
								    <td>${info.name!}</td>
									<td>${info.pname!}</td>
                                    <td>${info.create_time?string('yyyy-MM-dd HH:mm:ss')!}</td>
									<td><a href="/user/department/toedit/${info.id}">修改</a> | <a  href="javascript:deleteInfo(${info.id})">删除</a></td>
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
		 
	</div>

</body>
 <script type="text/javascript">
  //分页 
  function gotoPage(pageNo){
     $('#pageNo').val(pageNo)
     $('#pageSize').val()
	 $('#form').submit();
  }
  //每页显示多少行
  function selectOnchang(obj){
	  var value = obj.options[obj.selectedIndex].value;
	  $('#pageSize').val(value);
  }
 

  //添加
  function toAdd(){
    location.href="/user/department/toadd";
  } 
  
  //删除
  function deleteInfo(id){
      var res=confirm("真的要删除该条记录吗?")
	  if(res){
	       location.href="/user/department/delete/"+id;
	  }
  }
   
</script>
</html>