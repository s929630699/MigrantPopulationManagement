/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-24 08:24:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class person_005fmodal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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

      out.write("\r\n");
      out.write("<!-- 图书借阅信息的模态窗口，默认是隐藏的 -->\r\n");
      out.write("<div class=\"modal fade\" id=\"searModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h3 id=\"myModalLabel\" style=\"font-size: 35px; float: left; margin-top: 50px;margin-left: 150px\">居民信息</h3>\r\n");
      out.write("                <img src=\"../img/user.jpg\" id=\"portrait\" width=\"100px\" height=\"130px\" style=\"float: right; margin-right: 50px\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <form id=\"editResident\">\r\n");
      out.write("                    <table class=\"table table-bordered table-striped\" width=\"800px\">\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>姓名</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"name\" id=\"name\"></td>\r\n");
      out.write("                            <td>身份证</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"IDCard\" id=\"IDCard\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>性别</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"sex\" id=\"sex\"></td>\r\n");
      out.write("                            <td>生日</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"birth\" id=\"birth\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>电话号码</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"tel\" id=\"tel\"></td>\r\n");
      out.write("                            <td>民族</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"nation\" id=\"nation\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>地址</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"address\" id=\"address\"></td>\r\n");
      out.write("                            <td>宗教信仰</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"religion\" id=\"religion\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>邮箱</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"email\" id=\"email\"></td>\r\n");
      out.write("                            <td>学历</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"education\" id=\"education\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>政治面貌</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"political\" id=\"political\"></td>\r\n");
      out.write("                            <td>婚姻状况</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"isMarry\" id=\"isMarry\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>年龄</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"age\" id=\"age\"></td>\r\n");
      out.write("                            <td>户籍地址</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"domicileplace\" id=\"domicileplace\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <button class=\"btn btn-success\" data-dismiss=\"modal\" aria-hidden=\"true\"\r\n");
      out.write("                        disabled id=\"editRes\" onclick=\"saveRes()\">保存\r\n");
      out.write("                </button>\r\n");
      out.write("\r\n");
      out.write("                <button class=\"btn btn-default\" data-dismiss=\"modal\" aria-hidden=\"true\">关闭</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"modal fade\" id=\"addWarnModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h3 id=\"addWarnModalLabel\" style=\"font-size: 35px; float: left; margin-top: 50px;margin-left: 150px\">居民信息</h3>\r\n");
      out.write("                <img src=\"../img/user.jpg\" id=\"addPortrait\" width=\"100px\" height=\"130px\" style=\"float: right; margin-right: 50px\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <form id=\"addWarn\">\r\n");
      out.write("                    <table class=\"table table-bordered table-striped\" width=\"800px\">\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>姓名</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"name\" id=\"addName\"></td>\r\n");
      out.write("                            <td>身份证</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"IDCard\" id=\"addIDCard\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>性别</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"sex\" id=\"addSex\"></td>\r\n");
      out.write("                            <td>生日</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"birth\" id=\"addBirth\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>电话号码</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"tel\" id=\"addTel\"></td>\r\n");
      out.write("                            <td>民族</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"nation\" id=\"addNation\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>地址</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"address\" id=\"addAddress\"></td>\r\n");
      out.write("                            <td>携带人</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"carriedID\" id=\"addCarriedID\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>邮箱</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"email\" id=\"addEmail\"></td>\r\n");
      out.write("                            <td>学历</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"education\" id=\"addEducation\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>政治面貌</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"political\" id=\"addPolitical\"></td>\r\n");
      out.write("                            <td>婚姻状况</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"isMarry\" id=\"addIsMarry\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>年龄</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"age\" id=\"addAge\"></td>\r\n");
      out.write("                            <td>户籍地址</td>\r\n");
      out.write("                            <td><input class=\"form-control\" readonly name=\"domicileplace\" id=\"addDomicileplace\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        <tr id=\"type\" style=\"display: none\">\r\n");
      out.write("                            <td colspan=\"2\"> 预警人员类型</td>\r\n");
      out.write("                            <td colspan=\"2\"><input class=\"form-control\" placeholder=\"预警人员类型\" name=\"warn_type\" id=\"warnType\"></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <button class=\"btn btn-success\" data-dismiss=\"modal\" aria-hidden=\"true\"\r\n");
      out.write("                        disabled id=\"addBtn\" onclick=\"saveNewWarn()\">保存\r\n");
      out.write("                </button>\r\n");
      out.write("\r\n");
      out.write("                <button class=\"btn btn-default\" data-dismiss=\"modal\" aria-hidden=\"true\">关闭</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
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
}
