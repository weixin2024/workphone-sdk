<div >
	<ul class="pagination pagination-right">
		<#if pageBean.pageNo !=1>
		   <li class="prev "><a href="javascript:gotoPage(${pageBean.pageNo - 1})">上一页</a></li>
		<#else>
		   <li class="prev disabled"><a href="javascript:void(0)">上一页</a></li>
		</#if> 
		
				<li class="next"><a style="background-color:#eee;" href="javascript:gotoPage(${pageBean.pageNo!})">${pageBean.pageNo!}</a></li>
		<#if pageBean.pageNo+1 lte pageBean.pageTotal >
		   <li class="next"><a href="javascript:gotoPage(${pageBean.pageNo+1!})">${pageBean.pageNo+1!}</a></li>
		</#if>
		<#if pageBean.pageNo+2 lte pageBean.pageTotal >
		   <li class="next"><a href="javascript:gotoPage(${pageBean.pageNo+2!})">${pageBean.pageNo+2!}</a></li>
		</#if>
		<#if pageBean.pageNo+3 lte pageBean.pageTotal >
		   <li class="next"><a href="javascript:gotoPage(${pageBean.pageNo+3!})">${pageBean.pageNo+3!}</a></li>
		</#if>
		<#if pageBean.pageNo+4 lte pageBean.pageTotal >
		   <li class="next"><a href="javascript:gotoPage(${pageBean.pageNo+4!})">${pageBean.pageNo+4!}</a></li>
		</#if>
		<#if pageBean.pageNo+5 lte pageBean.pageTotal >
		   <li class="next"><a href="javascript:gotoPage(${pageBean.pageNo+5!})">${pageBean.pageNo+5!}</a></li>
		</#if>
		<#if pageBean.pageNo+6 lte pageBean.pageTotal >
		   <li class="next"><a href="javascript:gotoPage(${pageBean.pageNo+6!})">${pageBean.pageNo+6!}</a></li>
		</#if>
		
		<#if pageBean.pageNo != pageBean.pageTotal >
		   <li class="next"><a href="javascript:gotoPage(${pageBean.pageNo + 1})">下一页</a></li>
		<#else>
		   <li class="next disabled"><a href="javascript:void(0)">下一页</a></li>
		</#if>
	</ul>
</div>


