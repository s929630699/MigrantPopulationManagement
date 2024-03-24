<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>大数据分析</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>

</head>

<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->
<div class="box-header with-border">
    <h3 class="box-title">数据分析</h3>
</div>
<div class="box-body">

    <form>
        <select id="toggle" click style="width: 300px; height: 50px;font-size: 20px;padding-left: 10px">
            <option value="" >请选择统计数据类型</option>
            <option value="人口">外来人口户籍地</option>
            <option value="薪资">工资水平分布</option>
            <option value="就业">外来人口就业率</option>
        </select>
    </form>
    <h1 style="text-align: center; margin-bottom: -100px;margin-top: 50px" id="title" ></h1>
    <!-- 为 ECharts 准备一个定义了宽高的 DOM -->
    <div id="main" style="width: 1000px;height:600px; margin: 100px auto "></div>


</div>
<!-- /.box-body -->

</body>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    function show(opt){
        console.log(opt)


        // 指定图表的配置项和数据
        option = {
            title:{
                text:'人口工资分布情况图',
                textStyle:{
                    fontSize:50,
                },
                x:'center',
            },
            series:[
                {
                    type:'pie',
                    data:[
                        {value:34,name:'星期一'},
                        {value:26,name:'星期二'},
                        {value:19,name:'星期三'},
                    ],"label": {
                        "normal": {
                            "show": true,
                            formatter: '{b}: {c}({d}%)',
                            "textStyle": {
                                "fontSize": 18
                            }
                        },
                        "emphasis": {
                            "show": true
                        }
                    },
                }
            ],
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
    let arr = []
    $("#toggle").change(function(){


        if (document.getElementById("toggle").value == "人口"){
            var url1 = "${pageContext.request.contextPath}/big/findAllCome"
        $.ajax({
            url: url1,
            type: "post",
            data: JSON,
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function (response) {
                let tit = document.getElementById("title")
                tit.innerText ="外来人口户籍地统计图"
                console.log(response.data)
                myChart.setOption({
                    title:{
                        text:'',

                        textStyle:{
                            fontSize:30,
                        },
                        x:'center',
                        padding:[10,20,30,40],
                        top:'0%',
                        bottom:
                        "10%"
                    },
                    series:[
                        {
                            type:'pie',
                            data:response.data,"label": {
                                "normal": {
                                    "show": true,
                                    formatter: '{b}: {c}({d}%)',
                                    // position: "inside",
                                    "textStyle": {
                                        "fontSize": 18
                                    }
                                },
                                "emphasis": {
                                    "show": true
                                }
                            },
                        }
                    ],
                })
            },
        })}
        else if(document.getElementById("toggle").value == "薪资"){
            var url1 = "${pageContext.request.contextPath}/big/findAllSalary"
            $.ajax({
                url: url1,
                type: "post",
                data: JSON,
                contentType: "application/json;charset=UTF-8",
                dataType: "json",
                success: function (response) {
                    let tit = document.getElementById("title")
                    tit.innerText ="外来人口薪资分布统计图"
                    console.log(response.data)
                    myChart.setOption({
                        title:{
                            text:'',

                            textStyle:{
                                fontSize:30,
                            },
                            x:'center',
                            padding:[10,20,30,40],
                            top:'0%',
                            bottom:
                                "10%"
                        },
                        series:[
                            {
                                type:'pie',
                                data:response.data,"label": {
                                    "normal": {
                                        "show": true,
                                        formatter: '{b}: {c}({d}%)',
                                        // position: "inside",
                                        "textStyle": {
                                            "fontSize": 18
                                        }
                                    },
                                    "emphasis": {
                                        "show": true
                                    }
                                },
                            }
                        ],
                    })
                },
            })
        }
        else if(document.getElementById("toggle").value == "就业"){
            var url1 = "${pageContext.request.contextPath}/big/findAllEmployeeStatus"
            $.ajax({
                url: url1,
                type: "post",
                data: JSON,
                contentType: "application/json;charset=UTF-8",
                dataType: "json",
                success: function (response) {
                    let tit = document.getElementById("title")
                    tit.innerText ="外来人口就业情况统计图"
                    console.log(response.data)
                    myChart.setOption({
                        title:{
                            text:'',

                            textStyle:{
                                fontSize:30,
                            },
                            x:'center',
                            padding:[10,20,30,40],
                            top:'0%',
                            bottom:
                                "10%"
                        },
                        series:[
                            {
                                type:'pie',
                                data:response.data,"label": {
                                    "normal": {
                                        "show": true,
                                        formatter: '{b}: {c}({d}%)',
                                        // position: "inside",
                                        "textStyle": {
                                            "fontSize": 18
                                        }
                                    },
                                    "emphasis": {
                                        "show": true
                                    }
                                },
                            }
                        ],
                    })
                },
            })
        }

    });

</script>
</html>