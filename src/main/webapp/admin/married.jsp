<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>婚配管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
</head>

<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->
<div class="box-header with-border">
    <h3 class="box-title">婚配信息</h3>
</div>
<div class="box-body">
    <!--工具栏 数据搜索 -->
    <div class="box-tools pull-right">
        <div class="has-feedback">
            <table>
                <tr>
                    <td>
                        <form action="${pageContext.request.contextPath}/married/searchMarried" method="post">
                            姓名：<input name="ownName" value="${married.ownName}">&nbsp&nbsp&nbsp&nbsp
                            身份证号：<input name="PID" value="${married.PID}">&nbsp&nbsp&nbsp&nbsp
                            <input class="btn btn-default" type="submit" value="查询">
                        </form>
                    </td>
                    <td>
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建" data-toggle="modal"
                                            data-target="#addMarriedModal"> 新增
                                    </button>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <!--工具栏 数据搜索 /-->
    <!-- 数据列表 -->
    <div class="table-box">
        <!-- 数据表格 -->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
            <thead>
            <tr>
                <th class="sorting">结婚证ID</th>
                <th class="sorting">持证人身份证号</th>
                <th class="sorting_asc">持证人姓名</th>
                <th class="sorting">配偶身份证号</th>
                <th class="sorting">一胎孩子身份证号</th>
                <th class="sorting">二胎孩子身份证号</th>
                <th class="sorting">三胎孩子身份证号</th>
                <th class="text-center">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageResult.rows}" var="married">
                <tr>
                    <td> ${married.ID}</td>
                    <td> ${married.PID}</td>
                    <td> ${married.ownName}</td>
                    <td> ${married.spouse}</td>
                    <td> ${married.kid1}</td>
                    <td> ${married.kid2}</td>
                    <td> ${married.kid3}</td>
                    <td class="text-center">
<%--                        <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"--%>
<%--                                data-target="#editModal" onclick="findWarningPersonByIDCard('${warning_person.IDCard}','edit')"> 编辑--%>
<%--                        </button>--%>
                        <button type="button" class="btn bg-olive btn-xs" data-toggle="modal"
                                data-target="#marriedModal" onclick="findMarriedByID('${married.ID}','${married.PID}','${married.spouse}','${married.kid1}','${married.kid2}','${married.kid3}')"> 查看
                        </button>
                        <button type="button" class="btn bg-olive btn-xs"
                                onclick="delMarried('${married.ID}')"> 删除
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
    <!--数据列表/-->
</div>
<!-- /.box-body -->
<%--引入存放模态窗口的页面--%>
<jsp:include page="person_modal.jsp"></jsp:include>
<!-- 结婚信息的模态窗口 -->
<div class="modal fade" id="marriedModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <span><input type="hidden" id="kid1Id" name="kid1Id"></span>
    <span><input type="hidden" id="kid2Id" name="kid2Id"></span>
    <span><input type="hidden" id="kid3Id" name="kid3Id"></span>
    <div class="modal-dialog" style="width: 720px">
        <div class="modal-content" >
            <div class="modal-header" style="background-color: darkred">
                <h3 id="myModalLabel" style="text-align: center;color: white">结婚信息</h3>
            </div>
            <div class="modal-body">
                <form id="marriedInfo">
                    <span><input type="hidden" id="perID" name="id"></span>
                    <table id="marriedTab" class="table table-bordered table-striped" width="1000px">
                        <tr>
                            <%--     照片1    --%>
                            <td colspan="2"><img src="../img/user.jpg" id="ownPhoto" width="100px" height="130px" style="float: right; margin-right: 50px"></td>
                            <%--     结婚日期    --%>
                            <td style="padding-top: 60px"><input style="text-align: center" class="form-control"readonly placeholder="结婚日期" name="Date" id="marriedDate"></td>
                            <%--     照片2    --%>
                            <td colspan="2"><img src="../img/user.jpg" id="spousePhoto" width="100px" height="130px" style="float: right; margin-right: 50px"></td>
                        </tr>

                        <tr>
                            <td colspan="2"><input class="form-control" style="text-align: center" readonly placeholder="持证人姓名" name="sex" id="ownName"></td>
                            <td style="text-align: center">姓名</td>
                            <td colspan="2"><input class="form-control" style="text-align: center" readonly placeholder="配偶姓名" name="birth" id="spouseName"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input class="form-control" style="text-align: center" readonly placeholder="持证人身份证号" name="address" id="ownIDCard"></td>
                            <td style="text-align: center">身份证号<br/></td>
                            <td colspan="2"><input class="form-control" style="text-align: center" readonly placeholder="配偶身份证号" name="warn_type" id="spouseIDCard"></td>
                        </tr>

                        <tr>
                            <td colspan="5" style="text-align: center">子女一：</td>
                        </tr>
                        <tr id="kid1Info" style="display: none" class="kid1Info">
                                <td style="text-align: center">姓名：</td>
                                <td><input style="text-align: center" class="form-control" readonly placeholder="子女一姓名" name="kid1Name" id="kid1Name"></td>
                                <td style="text-align: center">身份证号：</td>
                                <td><input style="text-align: center" class="form-control" readonly placeholder="子女一身份证号" name="kid1IDCard" id="kid1IDCard"></td>
                                <td><button type="button" class="btn bg-olive btn-xs"  data-toggle="modal"
                                            data-target="#KidModal" onclick="findKidByIDCard(1)"> 查看
                                </button>
                                </td>
                        </tr>
                        <tr style="display: none" id="kid1But" class="kid1But">
                            <td colspan="5" style="text-align: center"><button type="button" class="btn bg-olive btn-xs"  data-toggle="modal"
                                        data-target="#addKidModal" onclick="addCarried()"> 添加</button></td>
                        </tr>

                        <tr>
                            <td colspan="5" style="text-align: center">子女二：</td>
                        </tr>
                        <tr  id="kid2Info" style="display: none">
                            <td style="text-align: center">姓名：</td>
                            <td><input style="text-align: center" class="form-control" readonly placeholder="子女二姓名" name="kid2Name" id="kid2Name"></td>
                            <td style="text-align: center">身份证号：</td>
                            <td><input style="text-align: center" class="form-control" readonly placeholder="子女二身份证号" name="kid2IDCard" id="kid2IDCard"></td>
                            <td><button type="button" class="btn bg-olive btn-xs"  data-toggle="modal"
                                        data-target="#KidModal" onclick="findKidByIDCard(2)"> 查看
                            </button>
                            </td>
                        </tr>
                        <tr style="display: none" id="kid2But">
                            <td colspan="5" style="text-align: center">
                                <button type="button" class="btn bg-olive btn-xs"  data-toggle="modal"
                                        data-target="#addKidModal" onclick="addCarried()"> 添加</button></td>
                        </tr>
                        <tr>
                            <td colspan="5" style="text-align: center">子女三：</td>
                        </tr>
                        <tr  id="kid3Info" style="display: none">
                            <td style="text-align: center">姓名：</td>
                            <td><input style="text-align: center" class="form-control" readonly placeholder="子女三姓名" name="kid3Name" id="kid3Name"></td>
                            <td style="text-align: center">身份证号：</td>
                            <td><input style="text-align: center" class="form-control" readonly placeholder="子女三身份证号" name="kid3IDCard" id="kid3IDCard"></td>
                            <td><button type="button" class="btn bg-olive btn-xs"  data-toggle="modal"
                                        data-target="#KidModal" onclick="findKidByIDCard(3)"> 查看
                                </button>
                            </td>
                        </tr>
                        <tr style="display: none" id="kid3But">
                            <td colspan="5" style="text-align: center">
                                <button type="button" class="btn bg-olive btn-xs"  data-toggle="modal"
                                        data-target="#addKidModal" onclick="addCarried()"> 添加</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true" onclick="winRefresh()">关闭</button>
            </div>
        </div>
    </div>
</div>
<%--添加结婚信息的模态窗口--%>
<div class="modal fade" id="addMarriedModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 id="addMarriedLabel">添加结婚信息</h3>
            </div>
            <div class="modal-body">
                <form id="addMarried">
                    <span><input type="hidden" id="marriedID" name="marriedID"></span>
                    <table id="addMarriedTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td><input class="form-control" style="text-align: center" readonly placeholder="姓名" name="addOwnName" id="addOwnName"></td>
                            <td colspan="2" style="text-align: center">双方姓名</td>
                            <td><input class="form-control" style="text-align: center" readonly placeholder="姓名" name="addSpouseName" id="addSpouseName"></td>
                        </tr>
                        <tr>
                            <td><input class="form-control" style="text-align: center" placeholder="身份证号" name="PID" id="PID"></td>
                            <td colspan="2" style="text-align: center">双方身份证号</td>
                            <td><input class="form-control" style="text-align: center" placeholder="身份证号" name="spouse" id="spouse"></td>
                        </tr>
                        <tr>
                            <td><input class="form-control" style="text-align: center" readonly placeholder="住址" name="addOwnAdd" id="addOwnAdd"></td>
                            <td colspan="2" style="text-align: center">常用住址</td>
                            <td><input class="form-control" style="text-align: center" readonly placeholder="住址" name="addSpouseAdd" id="addSpouseAdd"></td>
                        </tr>
                        <tr>
                            <td><input class="form-control" style="text-align: center" readonly placeholder="出生日期" name="addOwnBir" id="addOwnBir"></td>
                            <td colspan="2" style="text-align: center">出生日期</td>
                            <td><input class="form-control" style="text-align: center" readonly placeholder="出生日期" name="addSpouseBir" id="addSpouseBir"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true" id="add"  onclick="add()">新增
                </button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="KidModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 style="font-size: 35px; float: left; margin-top: 50px;margin-left: 150px">子女信息</h3>
                <img src="../img/user.jpg" id="kPortrait" width="100px" height="130px" style="float: right; margin-right: 50px">
            </div>
            <div class="modal-body">
                <form id="searchKid">
                    <table id="searchKidTab" class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>姓名</td>
                            <td><input class="form-control" readonly name="name" id="kName"></td>
                            <td>身份证</td>
                            <td><input class="form-control" readonly name="IDCard" id="kIDCard"></td>
                        </tr>
                        <tr>
                            <td>性别</td>
                            <td><input class="form-control" readonly name="sex" id="kSex"></td>
                            <td>生日</td>
                            <td><input class="form-control" readonly name="birth" id="kBirth"></td>
                        </tr>
                        <tr>
                            <td>电话号码</td>
                            <td><input class="form-control" readonly name="tel" id="kTel"></td>
                            <td>民族</td>
                            <td><input class="form-control" readonly name="nation" id="kNation"></td>
                        </tr>
                        <tr>
                            <td>地址</td>
                            <td><input class="form-control" readonly name="address" id="kAddress"></td>
                            <td>携带人</td>
                            <td><input class="form-control" readonly name="carriedID" id="kCarriedID"></td>
                        </tr>
                        <tr>
                            <td>邮箱</td>
                            <td><input class="form-control" readonly name="email" id="kEmail"></td>
                            <td>学历</td>
                            <td><input class="form-control" readonly name="education" id="kEducation"></td>
                        </tr>
                        <tr>
                            <td>政治面貌</td>
                            <td><input class="form-control" readonly name="political" id="kPolitical"></td>
                            <td>婚姻状况</td>
                            <td><input class="form-control" readonly name="isMarry" id="kIsMarry"></td>
                        </tr>
                        <tr>
                            <td>年龄</td>
                            <td><input class="form-control" readonly name="age" id="kAge"></td>
                            <td>户籍地址</td>
                            <td><input class="form-control" readonly name="domicileplace" id="kDomicileplace"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addKidModal" tabindex="-1" role="dialog" aria-labelledby="addKidLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 id="addKidLabel" style="font-size: 35px; float: left; margin-top: 50px;margin-left: 150px">居民信息</h3>
            </div>
            <div class="modal-body">
                <form id="addKid">
                    <table class="table table-bordered table-striped" width="800px">
                        <tr>
                            <td>姓名</td>
                            <td><input class="form-control" placeholder="姓名" name="name" id="name"></td>
                            <td>身份证号</td>
                            <td><input class="form-control" placeholder="身份证号" name="IDCard" id="IDCard"></td>
                        </tr>
                        <tr>
                            <td>性别</td>
                            <td><input class="form-control" placeholder="性别" name="sex" id="sex"></td>
                            <td>生日</td>
                            <td><input class="form-control" placeholder="生日" name="birth" id="birth"></td>
                        </tr>
                        <tr>
                            <td>电话号码</td>
                            <td><input class="form-control" placeholder="电话号码" name="tel" id="tel"></td>
                            <td>民族</td>
                            <td><input class="form-control" placeholder="民族" name="nation" id="nation"></td>
                        </tr>
                        <tr>
                            <td>地址</td>
                            <td><input class="form-control" placeholder="地址" name="address" id="address"></td>
                            <td>宗教信仰</td>
                            <td><input class="form-control" placeholder="宗教信仰" name="religion" id="religion"></td>
                        </tr>
                        <tr>
                            <td>邮箱</td>
                            <td><input class="form-control" placeholder="邮箱" name="email" id="email"></td>
                            <td>学历</td>
                            <td><input class="form-control" placeholder="学历" name="education" id="education"></td>
                        </tr>
                        <tr>
                            <td>政治面貌</td>
                            <td><input class="form-control" placeholder="政治面貌" name="political" id="political"></td>
                            <td>婚姻状况</td>
                            <td><input class="form-control" placeholder="婚姻状况" name="isMarry" id="isMarry"></td>
                        </tr>
                        <tr>
                            <td>年龄</td>
                            <td><input class="form-control" placeholder="年龄" name="age" id="age"></td>
                            <td>户籍地址</td>
                            <td><input class="form-control" placeholder="户籍地址" name="domicileplace" id="domicileplace"></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center">携带人身份证号</td>
                            <td colspan="2"><input style="text-align: center" class="form-control" placeholder="携带人身份证号" name="carriedID" id="carriedID"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="portrait-sty" style="padding-left: 25px">

                <%--上传头像，通过人脸识别判定是不是预警人员--%>
                <form target="form" id="addPortrait" method="post" enctype="multipart/form-data">
                    <span style="float: left;font-size: 15px;" >头像:&nbsp;&nbsp;&nbsp;</span>
                    <input style="float: left" type="file" name="photo_url" id="photo_url">
                    <input class="btn btn-success" type="reset" value="清空">
                    <%--                    <input type="button" value="检测可用性" id="sub-portrait" name="sub-portrait" onclick="addP()">--%>
                    <button class="btn btn-success" type="button" id="addP" style="margin-left: 37px;">检测头像可用性</button>
                </form>
                <iframe id="form" name="form" style="display: none"></iframe>

            </div>
            <div class="modal-footer">
                <%--点击保存按钮时，隐藏模态窗口并调用js文件中的borrow()方法--%>
                <button class="btn btn-success" data-dismiss="modal" aria-hidden="true"
                        id="editRes" onclick="addKids()">保存
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
    marriedVO.PID = "${married.PID}"
    marriedVO.ownName = "${married.ownName}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>