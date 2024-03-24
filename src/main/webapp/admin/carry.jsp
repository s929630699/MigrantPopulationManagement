<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <title>携带人口管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
</head>
<body class="hold-transition skin-red sidebar-mini">
<!--数据展示头部-->
<div class="box-header with-border">
    <h3 class="box-title">携带人口管理</h3>

</div>
<!--数据展示头部-->
<!--数据展示内容区-->
<div class="box-body">
    <div class="pull-left">
        <div class="form-group form-inline">
            <div class="btn-group">
                <button type="button" class="btn btn-default" title="新建" data-toggle="modal"
                        data-target="#addCarryModal" onclick="resetFrom()"> 新增携带人口信息
                </button>
            </div>
        </div>
    </div>
    <!--工具栏 数据搜索 -->
    <div class="box-tools pull-right">
        <div class="has-feedback">
            <form action="${pageContext.request.contextPath}/carry/selectCarry" method="post">
                被携带人身份证号：<input name="PID" value="${search.PID}">&nbsp&nbsp&nbsp&nbsp
                携带人身份证号：<input name="carriedID" value="${search.carriedID}">&nbsp&nbsp&nbsp&nbsp
                <input class="btn btn-default" type="submit" value="查询">
            </form>
        </div>
    </div>
    <!-- 数据表格 -->
    <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
        <thead>
        <tr>
            <th class="sorting_asc">被携带人身份证</th>
            <th class="sorting">被携带人姓名</th>
            <th class="sorting">被携带人性别</th>
            <th class="sorting">被携带人出生日期</th>
            <th class="text-center">被携带人常用住址</th>
            <th class="text-center">携带人身份证</th>
            <th class="text-center" colspan="1">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageResult.rows}" var="carry">
            <tr>
                <td>${carry.PID}</td>
                <td>${carry.person.name}</td>
                <td>${carry.person.sex}</td>
                <td>${carry.person.birth}</td>
                <td>${carry.person.address}</td>
                <td>${carry.carriedID}</td>
                <td class="text-center">
                        <%-- 删除居民信息 --%>
                    <button type="button" class="btn bg-olive btn-xs"
                            onclick="deleteCarry('${carry.PID}')"> 删除
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id = "pagination" class="pagination"></div>
    <!-- 数据表格 /-->
</div>
<!-- 数据展示内容区/ -->
<%--引入存放模态窗口的页面--%>
<jsp:include page="/admin/person_modal.jsp"></jsp:include>
</body>
<script>
    /*分页插件展示的总页数*/
    pageargs.total = Math.ceil(${pageResult.total})/pageargs.pagesize;
    /*分页插件当前的页码*/
    pageargs.cur = ${pageNum}
        /*分页插件页码变化时将跳转到的服务器端的路径*/
        pageargs.gourl = "${gourl}"
    /*保存搜索框中的搜索条件，页码变化时携带之前的搜索条件*/
    personVO.PID = "${carry.PID}"
    /*分页效果*/
    pagination(pageargs);
</script>
<!-- 添加和编辑居民信息的模态窗口 -->
<div class="modal fade" id="addCarryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 id="myModalLabel">携带人口信息</h3>
            </div>
            <div class="modal-body">
                <form id="addOrEditBook">
                    <table id="addTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>被携带人身份证</td>
                            <td><input class="form-control" placeholder="被携带人身份证" name="PID" id="PID"></td>
                        </tr>
                        <tr>
                            <td>携带人身份证</td>
                            <td><input class="form-control" placeholder="携带人身份证" name="carriedID" id="carriedID"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="portrait-sty" style="padding-left: 25px">

            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" id="aoe" disabled onclick="addCarry()">保存
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
</html>

