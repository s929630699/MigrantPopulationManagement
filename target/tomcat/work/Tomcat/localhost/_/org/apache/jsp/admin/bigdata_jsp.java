/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-24 07:55:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bigdata_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>大数据分析</title>\n");
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
      out.write("    <script src=\"https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"hold-transition skin-red sidebar-mini\">\n");
      out.write("<!-- .box-body -->\n");
      out.write("<div class=\"box-header with-border\">\n");
      out.write("    <h3 class=\"box-title\">数据分析</h3>\n");
      out.write("</div>\n");
      out.write("<div class=\"box-body\">\n");
      out.write("\n");
      out.write("    <form>\n");
      out.write("        <select id=\"toggle\" click style=\"width: 300px; height: 50px;font-size: 20px;padding-left: 10px\">\n");
      out.write("            <option value=\"\" >请选择统计数据类型</option>\n");
      out.write("            <option value=\"人口\">外来人口户籍地</option>\n");
      out.write("            <option value=\"薪资\">工资水平分布</option>\n");
      out.write("            <option value=\"就业\">外来人口就业率</option>\n");
      out.write("        </select>\n");
      out.write("    </form>\n");
      out.write("    <h1 style=\"text-align: center; margin-bottom: -100px;margin-top: 50px\" id=\"title\" ></h1>\n");
      out.write("    <!-- 为 ECharts 准备一个定义了宽高的 DOM -->\n");
      out.write("    <div id=\"main\" style=\"width: 1000px;height:600px; margin: 100px auto \"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- /.box-body -->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    // 基于准备好的dom，初始化echarts实例\n");
      out.write("    var myChart = echarts.init(document.getElementById('main'));\n");
      out.write("    function show(opt){\n");
      out.write("        console.log(opt)\n");
      out.write("\n");
      out.write("\n");
      out.write("        // 指定图表的配置项和数据\n");
      out.write("        option = {\n");
      out.write("            title:{\n");
      out.write("                text:'人口工资分布情况图',\n");
      out.write("                textStyle:{\n");
      out.write("                    fontSize:50,\n");
      out.write("                },\n");
      out.write("                x:'center',\n");
      out.write("            },\n");
      out.write("            series:[\n");
      out.write("                {\n");
      out.write("                    type:'pie',\n");
      out.write("                    data:[\n");
      out.write("                        {value:34,name:'星期一'},\n");
      out.write("                        {value:26,name:'星期二'},\n");
      out.write("                        {value:19,name:'星期三'},\n");
      out.write("                    ],\"label\": {\n");
      out.write("                        \"normal\": {\n");
      out.write("                            \"show\": true,\n");
      out.write("                            formatter: '{b}: {c}({d}%)',\n");
      out.write("                            \"textStyle\": {\n");
      out.write("                                \"fontSize\": 18\n");
      out.write("                            }\n");
      out.write("                        },\n");
      out.write("                        \"emphasis\": {\n");
      out.write("                            \"show\": true\n");
      out.write("                        }\n");
      out.write("                    },\n");
      out.write("                }\n");
      out.write("            ],\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        // 使用刚指定的配置项和数据显示图表。\n");
      out.write("        myChart.setOption(option);\n");
      out.write("    }\n");
      out.write("    let arr = []\n");
      out.write("    $(\"#toggle\").change(function(){\n");
      out.write("\n");
      out.write("\n");
      out.write("        if (document.getElementById(\"toggle\").value == \"人口\"){\n");
      out.write("            var url1 = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/big/findAllCome\"\n");
      out.write("        $.ajax({\n");
      out.write("            url: url1,\n");
      out.write("            type: \"post\",\n");
      out.write("            data: JSON,\n");
      out.write("            contentType: \"application/json;charset=UTF-8\",\n");
      out.write("            dataType: \"json\",\n");
      out.write("            success: function (response) {\n");
      out.write("                let tit = document.getElementById(\"title\")\n");
      out.write("                tit.innerText =\"外来人口户籍地统计图\"\n");
      out.write("                console.log(response.data)\n");
      out.write("                myChart.setOption({\n");
      out.write("                    title:{\n");
      out.write("                        text:'',\n");
      out.write("\n");
      out.write("                        textStyle:{\n");
      out.write("                            fontSize:30,\n");
      out.write("                        },\n");
      out.write("                        x:'center',\n");
      out.write("                        padding:[10,20,30,40],\n");
      out.write("                        top:'0%',\n");
      out.write("                        bottom:\n");
      out.write("                        \"10%\"\n");
      out.write("                    },\n");
      out.write("                    series:[\n");
      out.write("                        {\n");
      out.write("                            type:'pie',\n");
      out.write("                            data:response.data,\"label\": {\n");
      out.write("                                \"normal\": {\n");
      out.write("                                    \"show\": true,\n");
      out.write("                                    formatter: '{b}: {c}({d}%)',\n");
      out.write("                                    // position: \"inside\",\n");
      out.write("                                    \"textStyle\": {\n");
      out.write("                                        \"fontSize\": 18\n");
      out.write("                                    }\n");
      out.write("                                },\n");
      out.write("                                \"emphasis\": {\n");
      out.write("                                    \"show\": true\n");
      out.write("                                }\n");
      out.write("                            },\n");
      out.write("                        }\n");
      out.write("                    ],\n");
      out.write("                })\n");
      out.write("            },\n");
      out.write("        })}\n");
      out.write("        else if(document.getElementById(\"toggle\").value == \"薪资\"){\n");
      out.write("            var url1 = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/big/findAllSalary\"\n");
      out.write("            $.ajax({\n");
      out.write("                url: url1,\n");
      out.write("                type: \"post\",\n");
      out.write("                data: JSON,\n");
      out.write("                contentType: \"application/json;charset=UTF-8\",\n");
      out.write("                dataType: \"json\",\n");
      out.write("                success: function (response) {\n");
      out.write("                    let tit = document.getElementById(\"title\")\n");
      out.write("                    tit.innerText =\"外来人口薪资分布统计图\"\n");
      out.write("                    console.log(response.data)\n");
      out.write("                    myChart.setOption({\n");
      out.write("                        title:{\n");
      out.write("                            text:'',\n");
      out.write("\n");
      out.write("                            textStyle:{\n");
      out.write("                                fontSize:30,\n");
      out.write("                            },\n");
      out.write("                            x:'center',\n");
      out.write("                            padding:[10,20,30,40],\n");
      out.write("                            top:'0%',\n");
      out.write("                            bottom:\n");
      out.write("                                \"10%\"\n");
      out.write("                        },\n");
      out.write("                        series:[\n");
      out.write("                            {\n");
      out.write("                                type:'pie',\n");
      out.write("                                data:response.data,\"label\": {\n");
      out.write("                                    \"normal\": {\n");
      out.write("                                        \"show\": true,\n");
      out.write("                                        formatter: '{b}: {c}({d}%)',\n");
      out.write("                                        // position: \"inside\",\n");
      out.write("                                        \"textStyle\": {\n");
      out.write("                                            \"fontSize\": 18\n");
      out.write("                                        }\n");
      out.write("                                    },\n");
      out.write("                                    \"emphasis\": {\n");
      out.write("                                        \"show\": true\n");
      out.write("                                    }\n");
      out.write("                                },\n");
      out.write("                            }\n");
      out.write("                        ],\n");
      out.write("                    })\n");
      out.write("                },\n");
      out.write("            })\n");
      out.write("        }\n");
      out.write("        else if(document.getElementById(\"toggle\").value == \"就业\"){\n");
      out.write("            var url1 = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/big/findAllEmployeeStatus\"\n");
      out.write("            $.ajax({\n");
      out.write("                url: url1,\n");
      out.write("                type: \"post\",\n");
      out.write("                data: JSON,\n");
      out.write("                contentType: \"application/json;charset=UTF-8\",\n");
      out.write("                dataType: \"json\",\n");
      out.write("                success: function (response) {\n");
      out.write("                    let tit = document.getElementById(\"title\")\n");
      out.write("                    tit.innerText =\"外来人口就业情况统计图\"\n");
      out.write("                    console.log(response.data)\n");
      out.write("                    myChart.setOption({\n");
      out.write("                        title:{\n");
      out.write("                            text:'',\n");
      out.write("\n");
      out.write("                            textStyle:{\n");
      out.write("                                fontSize:30,\n");
      out.write("                            },\n");
      out.write("                            x:'center',\n");
      out.write("                            padding:[10,20,30,40],\n");
      out.write("                            top:'0%',\n");
      out.write("                            bottom:\n");
      out.write("                                \"10%\"\n");
      out.write("                        },\n");
      out.write("                        series:[\n");
      out.write("                            {\n");
      out.write("                                type:'pie',\n");
      out.write("                                data:response.data,\"label\": {\n");
      out.write("                                    \"normal\": {\n");
      out.write("                                        \"show\": true,\n");
      out.write("                                        formatter: '{b}: {c}({d}%)',\n");
      out.write("                                        // position: \"inside\",\n");
      out.write("                                        \"textStyle\": {\n");
      out.write("                                            \"fontSize\": 18\n");
      out.write("                                        }\n");
      out.write("                                    },\n");
      out.write("                                    \"emphasis\": {\n");
      out.write("                                        \"show\": true\n");
      out.write("                                    }\n");
      out.write("                                },\n");
      out.write("                            }\n");
      out.write("                        ],\n");
      out.write("                    })\n");
      out.write("                },\n");
      out.write("            })\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    });\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</html>");
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