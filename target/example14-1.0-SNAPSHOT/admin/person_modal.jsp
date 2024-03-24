<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 图书借阅信息的模态窗口，默认是隐藏的 -->
<div class="modal fade" id="searModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 id="myModalLabel" style="font-size: 35px; float: left; margin-top: 50px;margin-left: 150px">居民信息</h3>
                <img src="../img/fbb1.png" width="100px" height="130px" style="float: right; margin-right: 50px">
            </div>
            <div class="modal-body">
                <form id="borrowBook">
                    <table class="table table-bordered table-striped" width="800px">
                        <%--身份证号，不展示在页面--%>
                        <span><input type="hidden" id="seridcard" name="seridcard"></span>
                        <tr>
                            <td>姓名</td>
                            <td><input class="form-control" readonly name="sername" id="sername"></td>
                            <td>性别</td>
                            <td><input class="form-control" readonly name="sersex" id="sersex"></td>
                        </tr>
                        <tr>
                            <td>出生日期</td>
                            <td><input class="form-control" readonly name="serbirth" id="serbirth"></td>
                            <td>常用住址</td>
                            <td><input class="form-control" readonly name="seraddress" id="seraddress"></td>
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
