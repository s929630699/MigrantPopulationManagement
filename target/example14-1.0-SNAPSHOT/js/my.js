//借阅窗口中时间标签的内容改变时执行
function cg() {
    $("#savemsg").attr("disabled", false);
    var rt = $("#time").val().split("-");
    var ny = new Date().getFullYear();
    var nm = new Date().getMonth() + 1;
    var nd = new Date().getDate();
    if (rt[0] < ny) {
        alert("日期不能早于今天")
        $("#savemsg").attr("disabled", true);
    } else if (rt[0] == ny) {
        if (rt[1] < nm) {
            alert("日期不能早于今天")
            $("#savemsg").attr("disabled", true);
        } else if (rt[1] == nm) {
            if (rt[2] < nd) {
                alert("日期不能早于今天")
                $("#savemsg").attr("disabled", true);
            } else {
                $("#savemsg").attr("disabled", false);
            }
        }
    }
}
//点击借阅图书时执行
function borrow() {
    var url = getProjectPath()+ "/book/borrowBook";
    $.post(url, $("#borrowBook").serialize(), function (response) {
        alert(response.message)
        if (response.success == true) {
            window.location.href = getProjectPath()+"/book/search";
        }
    })
}

//重置添加和编辑窗口中输入框的内容
function resetFrom() {
    $("#aoe").attr("disabled",true)
    var $vals=$("#addOrEditBook input");
    $vals.each(function(){
        $(this).attr("style","").val("")
    });
}
//重置添加和编辑窗口中输入框的样式
function resetStyle() {
    $("#aoe").attr("disabled",false)
    var $vals=$("#addOrEditBook input");
    $vals.each(function(){
        $(this).attr("style","")
    });
}
//查询id对应的图书信息，并将图书信息回显到编辑或借阅的窗口中
function findPersonByIDCard(id,doname) {
    resetStyle()
    var url = getProjectPath()+"/findByIDCard?IDCard=" + id;
    console.log(url)
    $.get(url, function (response) {
        //如果是编辑图书，将获取的图书信息回显到编辑的窗口中
        if(doname=='edit'){
            $("#warName").val(response.data.name);
            $("#warID").val(response.data.IDCard);
            $("#warSex").val(response.data.sex);
            $("#warBirth").val(response.data.birth);
            $("#warAddress").val(response.data.address);
            $("#warType").val(response.data.warn_type);
        }
        //如果是查看信息，将获取的个人信息回显到信息的窗口中
        if(doname=='search'){
            $("#savemsg").attr("disabled",true)
            $("#seridcard").val(response.data.IDCard);
            console.log(response.data.IDCard)
            $("#sername").val(response.data.name);
            $("#sersex").val(response.data.sex);
            $("#serbirth").val(response.data.birth);
            $("#seraddress").val(response.data.address);
        }
    })
}
function findWarningPersonByIDCard(id,doname) {
    resetStyle()
    var url = getProjectPath()+"/findWarningPeopleByID?IDCard=" + id;
    console.log(url)
    $.get(url, function (response) {
        //如果是编辑图书，将获取的图书信息回显到编辑的窗口中
        if(doname=='searchWarning'){
            $("#warName").val(response.data.name);
            $("#warID").val(response.data.IDCard);
            $("#warSex").val(response.data.sex);
            $("#warBirth").val(response.data.birth);
            $("#warAddress").val(response.data.address);
            $("#warType").val(response.data.warn_type);
        }
        //如果是查看信息，将获取的个人信息回显到信息的窗口中
        if(doname=='edit'){
            $("#savemsg").attr("disabled",true)
            $("#uWarID").val(response.data.IDCard);
            $("#uWarName").val(response.data.name);
            $("#uWarBirth").val(response.data.birth);
            $("#uWarSex").val(response.data.sex);
            $("#uWarAddress").val(response.data.address);
            $("#uWarType").val(response.data.warn_type);
        }
    })
}

//点击编辑的窗口的确定按钮时，提交预警人员信息
function Edit() {
        var url = getProjectPath()+"/warning/editWarning";
        $.post(url, $("#addOrEditBook").serialize(), function (response) {
            alert(response.message)
            if (response.success == true) {
                window.location.href = getProjectPath()+"/book/search";
            }
        })
}
//归还图书时执行
function returnBook(bid) {
    var r = confirm("确定归还图书?");
    if (r) {
        var url = getProjectPath()+"/book/returnBook?id=" + bid;
        $.get(url, function (response) {
            alert(response.message)
            //还书成功时，刷新当前借阅的列表数据
            if (response.success == true) {
                window.location.href = getProjectPath()+"/book/searchBorrowed";
            }
        })
    }
}
//确认图书已经归还
function returnConfirm(bid) {
    var r = confirm("确定图书已归还?");
    if (r) {
        var url = getProjectPath()+"/book/returnConfirm?id=" + bid;
        $.get(url, function (response) {
            alert(response.message)
            //还书确认成功时，刷新当前借阅的列表数据
            if (response.success == true) {
                window.location.href = getProjectPath()+"/book/searchBorrowed";
            }
        })
    }
}
//检查图书信息的窗口中，图书信息填写是否完整
function checkval(){
    var $inputs=$("#addOrEditTab input")
    var count=0;
    $inputs.each(function () {
        if($(this).val()==''||$(this).val()=="不能为空！"){
            count+=1;
        }
    })
    //如果全部输入框都填写完整，解除确认按钮的禁用状态
    if(count==0){
        $("#aoe").attr("disabled",false)
    }
}
//页面加载完成后，给图书模态窗口的输入框绑定失去焦点和获取焦点事件
$(function() {
    var $inputs=$("#addOrEditBook input")
    var eisbn="";
    $inputs.each(function () {
        //给输入框绑定失去焦点事件
        $(this).blur(function () {
            if($(this).val()==''){
                $("#aoe").attr("disabled",true)
                $(this).attr("style","color:red").val("不能为空！")
            }
            else if($(this).attr("name")=="isbn"&&eisbn!==$(this).val()){
                if($(this).val().length!=13){
                    $("#aoe").attr("disabled",true)
                    alert("必须为13位数的标准ISBN，请重新输入！")
                    $(this).val("")
                }
            }else{
                checkval()
            }
        }).focus(function () {
            if($(this).val()=='不能为空！'){
                $(this).attr("style","").val("")
            }else{
                $(this).attr("style","")
            }
            if($(this).attr("name")=="isbn"){
                eisbn=$(this).val();
            }
        })
    })
});
//获取当前项目的名称
function getProjectPath() {
    //获取主机地址之后的目录，如： cloudlibrary/admin/people.jsp
    var pathName = window.document.location.pathname;
    //获取带"/"的项目名，如：/cloudlibrary
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return  projectName;
}

/**
 * 数据展示页面分页插件的参数
 * cur 当前页
 * total 总页数
 * len   显示多少页数
 * pagesize 1页显示多少条数据
 * gourl 页码变化时 跳转的路径
 * targetId 分页插件作用的id
 */
var pageargs = {
    cur: 1,
    total: 0,
    len: 5,
    pagesize:10,
    gourl:"",
    targetId: 'pagination',
    callback: function (total) {
        var oPages = document.getElementsByClassName('page-index');
        for (var i = 0; i < oPages.length; i++) {
            oPages[i].onclick = function () {
                changePage(this.getAttribute('data-index'), pageargs.pagesize);
            }
        }
        var goPage = document.getElementById('go-search');
        goPage.onclick = function () {
            var index = document.getElementById('yeshu').value;
            if (!index || (+index > total) || (+index < 1)) {
                return;
            }
            changePage(index, pageargs.pagesize);
        }
    }
}

var personVO = {
    IDCard:'',
    name:'',
    sex:'',
    birth:'',
    address:'',
    warn_type:''
}
/**
 *借阅记录查询栏的查询参数
 * name 图书名称
 * borrower 借阅人
 */
var recordVO={
    bookname:'',
    borrower:''
}
//数据展示页面分页插件的页码发送变化时执行
function changePage(pageNo,pageSize) {
    pageargs.cur=pageNo;
    pageargs.pagesize=pageSize;
    document.write("<form action="+pageargs.gourl +" method=post name=form1 style='display:none'>");
    document.write("<input type=hidden name='pageNum' value="+pageargs.cur+" >");
    document.write("<input type=hidden name='pageSize' value="+pageargs.pagesize+" >");
    //如果跳转的是图书信息查询的相关链接，提交图书查询栏中的参数
    if(pageargs.gourl.indexOf("book")>=0){
        document.write("<input type=hidden name='name' value="+bookVO.name+" >");
        document.write("<input type=hidden name='author' value="+bookVO.author+" >");
        document.write("<input type=hidden name='press' value="+bookVO.press+" >");
    }
    //如果跳转的是图书记录查询的相关链接，提交图书记录查询栏中的参数
    if(pageargs.gourl.indexOf("record")>=0){
        document.write("<input type=hidden name='bookname' value="+recordVO.bookname+" >");
        document.write("<input type=hidden name='borrower' value="+recordVO.borrower+" >");
    }
    document.write("</form>");
    document.form1.submit();
    pagination(pageargs);
}

