/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-06-01 01:10:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class resident_005fmanage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>居民信息管理</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/AdminLTE.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/pagination.css\">\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/pagination.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/my.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body class=\"hold-transition skin-red sidebar-mini\">\n");
      out.write("<!--数据展示头部-->\n");
      out.write("<div class=\"box-header with-border\">\n");
      out.write("    <h3 class=\"box-title\">居民信息管理</h3>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!--数据展示头部-->\n");
      out.write("<!--数据展示内容区-->\n");
      out.write("<div class=\"box-body\">\n");
      out.write("    <div class=\"pull-left\">\n");
      out.write("        <div class=\"form-group form-inline\">\n");
      out.write("            <div class=\"btn-group\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" title=\"新建\" data-toggle=\"modal\"\n");
      out.write("                        data-target=\"#addOrEditModal\" onclick=\"resetFrom()\"> 新增居民信息\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--工具栏 数据搜索 -->\n");
      out.write("    <div class=\"box-tools pull-right\">\n");
      out.write("        <div class=\"has-feedback\">\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resident/searchResident\" method=\"post\">\n");
      out.write("                姓名：<input name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${search.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">&nbsp&nbsp&nbsp&nbsp\n");
      out.write("                身份证号：<input name=\"IDCard\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${search.IDCard}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">&nbsp&nbsp&nbsp&nbsp\n");
      out.write("                <input class=\"btn btn-default\" type=\"submit\" value=\"查询\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- 数据表格 -->\n");
      out.write("    <table id=\"dataList\" class=\"table table-bordered table-striped table-hover dataTable text-center\">\n");
      out.write("        <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th class=\"sorting_asc\">身份证号</th>\n");
      out.write("            <th class=\"sorting\">姓名</th>\n");
      out.write("            <th class=\"sorting\">性别</th>\n");
      out.write("            <th class=\"sorting\">出生日期</th>\n");
      out.write("            <th class=\"text-center\">常用住址</th>\n");
      out.write("            <th class=\"text-center\" colspan=\"4\">操作</th>\n");
      out.write("        </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("        ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    <div id = \"pagination\" class=\"pagination\"></div>\n");
      out.write("    <!-- 数据表格 /-->\n");
      out.write("</div>\n");
      out.write("<!-- 数据展示内容区/ -->\n");
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/admin/person_modal.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("<script>\n");
      out.write("    /*分页插件展示的总页数*/\n");
      out.write("    pageargs.total = Math.ceil(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageResult.total}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/pageargs.pagesize);\n");
      out.write("    /*分页插件当前的页码*/\n");
      out.write("    pageargs.cur = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("        /*分页插件页码变化时将跳转到的服务器端的路径*/\n");
      out.write("        pageargs.gourl = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gourl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\n");
      out.write("    /*保存搜索框中的搜索条件，页码变化时携带之前的搜索条件*/\n");
      out.write("    personVO.name = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\n");
      out.write("    /*分页效果*/\n");
      out.write("    pagination(pageargs);\n");
      out.write("</script>\n");
      out.write("<!-- 添加和编辑居民信息的模态窗口 -->\n");
      out.write("<div class=\"modal fade\" id=\"addOrEditModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\"\n");
      out.write("     aria-hidden=\"true\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <h3 id=\"myModalLabel\">居民信息</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <form id=\"addOrEditBook\">\n");
      out.write("                    <table id=\"addTab\" class=\"table table-bordered table-striped\" width=\"800px\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td>姓名</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"姓名\" name=\"name\" id=\"name\"></td>\n");
      out.write("                            <td>身份证号</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"身份证号\" name=\"IDCard\" id=\"IDCard\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>性别</td>\n");
      out.write("                            <td><select name=\"sex\" class=\"form-control\">\n");
      out.write("                                <option value=\"男\">男</option>\n");
      out.write("                                <option value=\"女\">女</option>\n");
      out.write("                            </select></td>\n");
      out.write("                            <td>生日</td>\n");
      out.write("                            <td><input class=\"form-control\" readonly placeholder=\"生日\" name=\"birth\" id=\"bir\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>电话号码</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"电话号码\" name=\"tel\" id=\"tel\"></td>\n");
      out.write("                            <td>民族</td>\n");
      out.write("                            <td><select name=\"nation\" class=\"form-control\">\n");
      out.write("                                <option value=\"汉族\">汉族</option>\n");
      out.write("                                <option value=\"土家族\">土家族</option>\n");
      out.write("                                <option value=\"壮族\">壮族</option>\n");
      out.write("                                <option value=\"回族\">回族</option>\n");
      out.write("                            </select></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>地址</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"地址\" name=\"address\" id=\"address\"></td>\n");
      out.write("                            <td>宗教信仰</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"宗教信仰\" name=\"religion\" id=\"religion\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>邮箱</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"邮箱\" name=\"email\" id=\"email\"></td>\n");
      out.write("                            <td>学历</td>\n");
      out.write("                            <td>\n");
      out.write("                                <select class=\"form-control\" name=\"education\" id=\"education\">\n");
      out.write("                                    <option value=\"小学\">小学</option>\n");
      out.write("                                    <option value=\"初中\">初中</option>\n");
      out.write("                                    <option value=\"高中\">高中</option>\n");
      out.write("                                    <option value=\"大专\">大专</option>\n");
      out.write("                                    <option value=\"本科\">本科</option>\n");
      out.write("                                    <option value=\"研究生\">研究生</option>\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>政治面貌</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"政治面貌\" name=\"political\" id=\"political\"></td>\n");
      out.write("                            <td>婚姻状况</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"婚姻状况\" name=\"isMarry\" id=\"isMarry\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>年龄</td>\n");
      out.write("                            <td><input class=\"form-control\" readonly placeholder=\"年龄\" name=\"age\" id=\"age1\"></td>\n");
      out.write("                            <td>户籍地址</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"户籍地址\" name=\"domicileplace\" id=\"domicileplace\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"portrait-sty\" style=\"padding-left: 25px\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <form target=\"form\" id=\"addPortrait\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                    <span style=\"float: left;font-size: 15px;\" >头像:&nbsp;&nbsp;&nbsp;</span>\n");
      out.write("                    <input style=\"float: left\" type=\"file\" name=\"photo_url\" id=\"photo_url\">\n");
      out.write("                    <input class=\"btn btn-success\" type=\"reset\" value=\"清空\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    <button class=\"btn btn-success\" type=\"button\" id=\"addP\" style=\"margin-left: 37px;\">检测头像可用性</button>\n");
      out.write("                </form>\n");
      out.write("                <iframe id=\"form\" name=\"form\" style=\"display: none\"></iframe>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button class=\"btn btn-success\" data-dismiss=\"modal\" aria-hidden=\"true\" id=\"aoe\" disabled onclick=\"addOrEdit()\">保存\n");
      out.write("                </button>\n");
      out.write("                <button class=\"btn btn-default\" data-dismiss=\"modal\" aria-hidden=\"true\">关闭</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<div class=\"modal fade\" id=\"addWarningModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\"\n");
      out.write("     aria-hidden=\"true\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <h3 id=\"addModalLabel\">居民信息</h3>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                <form id=\"addWarning\">\n");
      out.write("                    <table id=\"addWarnTab\" class=\"table table-bordered table-striped\" width=\"800px\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td>姓名</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"姓名\" name=\"name\" id=\"wName\"></td>\n");
      out.write("                            <td>身份证号</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"身份证号\" name=\"IDCard\" id=\"wIDCard\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>性别</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"性别\" name=\"sex\" id=\"wSex\"></td>\n");
      out.write("                            <td>生日</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"生日\" name=\"birth\" id=\"wBirth\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>电话号码</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"电话号码\" name=\"tel\" id=\"wTel\"></td>\n");
      out.write("                            <td>民族</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"民族\" name=\"nation\" id=\"wNation\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>地址</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"地址\" name=\"address\" id=\"wAddress\"></td>\n");
      out.write("                            <td>携带人</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"携带人身份证号\" name=\"carriedID\" id=\"wCarriedID\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>邮箱</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"邮箱\" name=\"email\" id=\"wEmail\"></td>\n");
      out.write("                            <td>学历</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"学历\" name=\"education\" id=\"wEducation\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>政治面貌</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"政治面貌\" name=\"political\" id=\"wPolitical\"></td>\n");
      out.write("                            <td>婚姻状况</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"婚姻状况\" name=\"isMarry\" id=\"wIsMarry\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>年龄</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"年龄\" name=\"age\" id=\"wAge\"></td>\n");
      out.write("                            <td>户籍地址</td>\n");
      out.write("                            <td><input class=\"form-control\" placeholder=\"户籍地址\" name=\"domicileplace\" id=\"wDomicileplace\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr style=\"display: none\">\n");
      out.write("                            <td colspan=\"2\">预警人员类型</td>\n");
      out.write("                            <td colspan=\"2\"><input class=\"form-control\" placeholder=\"预警人员类型\" name=\"warn_type\" id=\"warn_type\"></td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"portrait-sty\" style=\"padding-left: 25px\">\n");
      out.write("\n");
      out.write("                ");
      out.write("\n");
      out.write("                <form target=\"form\" id=\"addPortrait\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                    <span style=\"float: left;font-size: 15px;\" >头像:&nbsp;&nbsp;&nbsp;</span>\n");
      out.write("                    <input style=\"float: left\" type=\"file\" name=\"photo_url\" id=\"photo_url\">\n");
      out.write("                    <input class=\"btn btn-success\" type=\"reset\" value=\"清空\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("                    <button class=\"btn btn-success\" type=\"button\" id=\"addP\" style=\"margin-left: 37px;\">检测头像可用性</button>\n");
      out.write("                </form>\n");
      out.write("                <iframe id=\"form\" name=\"form\" style=\"display: none\"></iframe>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("                <button class=\"btn btn-success\" data-dismiss=\"modal\" aria-hidden=\"true\" id=\"add-btn\" disabled onclick=\"addWarning()\">保存\n");
      out.write("                </button>\n");
      out.write("                <button class=\"btn btn-default\" data-dismiss=\"modal\" aria-hidden=\"true\">关闭</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /admin/resident_manage.jsp(56,8) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/admin/resident_manage.jsp(56,8) '${pageResult.rows}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageResult.rows}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /admin/resident_manage.jsp(56,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("person");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            <tr>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.IDCard}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.sex}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.birth}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\n");
          out.write("                <td class=\"text-center\">\n");
          out.write("                        ");
          out.write("\n");
          out.write("                    <button type=\"button\" class=\"btn bg-olive btn-xs\" data-toggle=\"modal\" data-target=\"#searModal\"\n");
          out.write("                            onclick=\"findPersonByIDCard2('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.IDCard}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("','search')\"> 查看\n");
          out.write("                    </button>\n");
          out.write("\n");
          out.write("                        ");
          out.write("\n");
          out.write("                    <button type=\"button\" class=\"btn bg-olive btn-xs\" data-toggle=\"modal\" data-target=\"#searModal\"\n");
          out.write("                            onclick=\"findPersonByIDCard2('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.IDCard}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("','edit')\"> 编辑\n");
          out.write("                    </button>\n");
          out.write("                        ");
          out.write("\n");
          out.write("                    <button type=\"button\" class=\"btn bg-olive btn-xs\" data-toggle=\"modal\" data-target=\"#addWarnModal\"\n");
          out.write("                            onclick=\"addWarningById('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.IDCard}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("')\"> 设为预警\n");
          out.write("                    </button>\n");
          out.write("                        ");
          out.write("\n");
          out.write("                    <button type=\"button\" class=\"btn bg-olive btn-xs\"\n");
          out.write("                            onclick=\"deleteResident('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.IDCard}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("')\"> 删除\n");
          out.write("                    </button>\n");
          out.write("                </td>\n");
          out.write("            </tr>\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
