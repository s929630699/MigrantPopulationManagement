<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>就业档案管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
    <style>
        #tab td,button{
            line-height: 110px;
            vertical-align: center;
        }
    </style>
</head>

<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->
<div class="box-header with-border">
    <h3 class="box-title">就业档案管理</h3>
</div>
<div class="box-body">
    <!--工具栏 数据搜索 -->
    <div class="box-tools pull-right">
        <div class="has-feedback">
            <form action="${pageContext.request.contextPath}/employee/searchEmployee" method="post">
                姓名：<input name="name" value="${search.name}">&nbsp&nbsp&nbsp&nbsp
                身份证号：<input name="IDCard" value="${search.IDCard}">&nbsp&nbsp&nbsp&nbsp
                <input class="btn btn-default" type="submit" value="查询">
            </form>
        </div>
    </div>
    <!--工具栏 数据搜索 /-->
    <!-- 数据列表 -->
    <div class="table-box" style="">
        <!--数据表格-->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
            <thead>
            <tr>
                <th class="sorting_asc">身份证号</th>
                <th class="sorting">姓名</th>
                <th class="sorting">性别</th>
                <th class="sorting">出生日期</th>
                <th class="text-center">常用住址</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageResult.rows}" var="person">
                <tr>
                    <td>${person.IDCard}</td>
                    <td>${person.name}</td>
                    <td>${person.sex}</td>
                    <td>${person.birth}</td>
                    <td>${person.address}</td>
                    <td class="text-center">
                            <%-- 查看居民信息 --%>
                        <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#searModal"
                                onclick="findEmployeeByIDCard('${person.IDCard}','search')"> 查看
                        </button>
<%--                                <button style="margin-top: 45px" type="button" class="btn bg-olive btn-xs" data-toggle="modal"--%>
<%--                                        data-target="#addOrEditEmployment" onclick="findEmployeeByIDCard('${person.IDCard}','search')"> 查看--%>
<%--                                </button>--%>
                            <%-- 编辑居民信息 --%>
                        <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#searModal"
                                onclick="findEmployeeByIDCard('${person.IDCard}','edit')"> 编辑
                        </button>

                            <%-- 删除居民信息 --%>

                            <%--                    <c:if test="${book.status ==1 ||book.status ==2}">--%>
                            <%--                        <button type="button" class="btn bg-olive btn-xs" disabled="true">借阅</button>--%>
                            <%--                    </c:if>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!--数据表格/-->
        <%--分页插件--%>
        <div id="pagination" class="pagination"></div>
    </div>
    <!-- 数据列表 /-->

</div>
<!-- /.box-body -->
<div class="modal fade" id="searModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 id="myModalLabel">就业管理</h3>
            </div>
            <div class="modal-body">
                <form id="addOrEditEmploymentdata">

                    <table id="addOrEditTab" class="table table-bordered table-striped" width="800px">
                        <%--图书的id,不展示在页面--%>
                        <span><input type="hidden" id="emid" name="id"></span>
                        <tr>
                            <td>姓名</td>
                            <td><input class="form-control" placeholder="姓名" name="name" id="emname" readonly></td>
                            <td>性别</td>
                            <td><input class="form-control" placeholder="性别" name="gender" id="emgender" readonly></td>
                        </tr>
                        <tr>
                            <td>年龄</td>
                            <td><input class="form-control" placeholder="出版社" name="age" id="emage" readonly></td>
                            <td>身份证号</td>
                            <td><input class="form-control"  name="idCard" id="emidCard" readonly></td>

                        </tr>
                        <tr>
                            <td>就业情况</td>
                            <td><select class="form-control" id="emstatus" name="status" readonly>
                                <option value="">--请选择--</option>
                                <option value="已就业">已就业</option>
                                <option value="未就业">未就业</option>
                                <option value="失业">失业</option>
                            </select></td>
                            <td>薪资</td>
                            <td><select class="form-control" id="salary" name="salary" readonly>
                                <option value="">--请选择--</option>
                                <option value="3000以下">3000以下</option>
                                <option value="3000-5000">3000-5000</option>
                                <option value="5000-8000">5000-8000</option>
                                <option value="8000以上">8000以上</option>
                            </select></td>

                        </tr>
                        <tr>


                            <td>公司名称</td>
                            <td><input class="form-control"readonly placeholder="公司名称" name="companyName" id="companyName" ></td>
                            <td>公司地址</td>
                            <td><input class="form-control"readonly placeholder="公司地址" name="companyAddress" id="companyAddress" ></td>

                        </tr>
                        <tr>
                            <td>备注<br/></td>
                            <td colspan="3"><input class="form-control"readonly placeholder="其他说明" name="notes" id="emnotes"></td>
                        </tr>

                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" id="saveemployee" onclick="addOrEditem()">保存
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    /*分页插件展示的总页数*/
    pageargs.total = Math.ceil(${pageResult.total}/pageargs.pagesize);
    /*分页插件当前的页码*/
    pageargs.cur = ${pageNum}
        /*分页插件页码变化时将跳转到的服务器端的路径*/
        pageargs.gourl = "${gourl}"
    /*保存搜索框中的搜索条件，页码变化时携带之前的搜索条件*/
    personVO.name = "${person.name}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>