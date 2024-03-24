<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>健康管理</title>
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
            <form action="${pageContext.request.contextPath}/health/searchHealth" method="post">
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
                                onclick="findHealthByIDCard('${person.IDCard}','search')"> 查看
                        </button>
<%--
                            <%-- 编辑居民信息 --%>
                        <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#searModal"
                                onclick="findHealthByIDCard('${person.IDCard}','edit')"> 编辑
                        </button>


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
                <form id="addOrEditHealthdata">

                    <table id="addOrEditTab" class="table table-bordered table-striped" width="800px">
                        <%--图书的id,不展示在页面--%>
                        <span><input type="hidden" id="lhid" name="id"></span>
                        <tr>
                            <td>姓名</td>
                            <td><input class="form-control" placeholder="姓名" name="name" id="hlname" readonly></td>
                            <td>性别</td>
                            <td><input class="form-control" placeholder="性别" name="gender" id="hlgender" readonly></td>
                        </tr>
                        <tr>
                            <td>年龄</td>
                            <td><input class="form-control" placeholder="出版社" name="age" id="hlage" readonly></td>
                            <td>身份证号</td>
                            <td><input class="form-control"  name="idCard" id="hlidCard" readonly></td>

                        </tr>
                        <tr>
                            <td>血型</td>
                            <td><select class="form-control" id="hlblood"readonly name="bloodType" >
                                <option value="">--请选择--</option>
                                <option value="A">A</option>
                                <option value="B">B</option>
                                <option value="O">O</option>
                                <option value="AB">AB</option>
                            </select></td>
                            <td>健康状况</td>
                            <td><select class="form-control" id="hlstatus" readonly name="healthStatus" >
                                <option value="">--请选择--</option>
                                <option value="健康">健康</option>
                                <option value="轻微疾病">轻微疾病</option>
                                <option value="中度疾病">中度疾病</option>
                                <option value="重大疾病">重大疾病</option>
                            </select></td>

                        </tr>
                        <tr>

                            <td>医保</td>
                            <td>
                                <select class="form-control" id="hlinsurance" readonly name="medicalInsurance" >
                                    <option value="">--请选择--</option>
                                    <option value="未参保">未参保</option>
                                    <option value="省外参保">省外参保</option>
                                    <option value="省内非本地参保">省内非本地参保</option>
                                    <option value="本地参保">本地参保</option>
                                </select>
                            </td>
                            <td>慢性疾病</td>
                            <td><input class="form-control" placeholder="疾病说明" readonly name="chronicContidion" id="hlchronic"></td>

                        </tr>
                        <tr>
                            <td>备注<br/></td>
                            <td colspan="3"><input class="form-control" readonly placeholder="其他说明" name="notes" id="hlnotes"></td>
                        </tr>

                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" id="savehealth" data-dismiss="modal" disabled aria-hidden="true"  onclick="addOrEdithl()">保存
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