<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>

    <title>质心教育</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <!--  <meta name="description" content="质心教育是一个专注分享全国高中奥林匹克竞赛、高考自主招生资讯的网站，最新的竞赛资讯，竞赛自招的学习知识，竞赛自招的免费视频。这里有竞赛和自招的一切。">
    <meta name="keywords" content="质心,质心教育,物理竞赛,生物竞赛,自主招生,物理竞赛辅导,生物竞赛辅导,物理竞赛试题及答案,生物竞赛试题及答案"><meta name="author" content="质心教育">
    <meta name="author" content="质心教育">-->
    <meta name="renderer" content="webkit">
    <link rel="apple-touch-icon" href="https://cdn.eduzhixin.cn/cdn/img/logo-sm-883ab938.png">

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="https://cdn.eduzhixin.cn/cdn/css/libs/bootstrap/bootstrap.min-8b95c7fe.css" type="text/css">

    <!-- Custom Fonts -->
    <link rel="stylesheet" href="https://cdn.eduzhixin.cn/cdn/css/custom-font-7d5dcd71.css" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="https://cdn.eduzhixin.cn/cdn/css/libs/swiper.min-2603e9c2.css" type="text/css">
 
    <!-- Custom CSS -->
    <link rel="stylesheet" href="https://cdn.eduzhixin.cn/cdn/css/new_welcome-de1c0692.css" type="text/css">

    
    <script>
        if(window.location.host == 'www.eduzhixin.com'){
            var _hmt = _hmt || [];
            (function() {
                var hm = document.createElement("script");
                hm.src = '//hm.baidu.com/hm.js?5d007535db1222bf87bc19953f5ce283';
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();
        }
    </script>
    <script type="text/javascript">
        var isOpen = true;
        if (isOpen) {
            window.zhuge = window.zhuge || [];window.zhuge.methods = "_init debug identify track trackLink trackForm page".split(" ");
            window.zhuge.factory = function(b) {return function() {var a = Array.prototype.slice.call(arguments);a.unshift(b);
            window.zhuge.push(a);return window.zhuge;}};for (var i = 0; i < window.zhuge.methods.length; i++) {
            var key = window.zhuge.methods[i];window.zhuge[key] = window.zhuge.factory(key);}window.zhuge.load = function(b, x) {
            if (!document.getElementById("zhuge-js")) {var a = document.createElement("script");var verDate = new Date();
            var verStr = verDate.getFullYear().toString()+ verDate.getMonth().toString() + verDate.getDate().toString();
            a.type = "text/javascript";a.id = "zhuge-js";a.async = !0;a.src = (location.protocol == 'http:' ? "http://sdk.zhugeio.com/zhuge.min.js?v=" : 'https://zgsdk.zhugeio.com/zhuge.min.js?v=') + verStr;
            a.onerror = function(){window.zhuge.identify = window.zhuge.track = function(ename, props, callback){if(callback && Object.prototype.toString.call(callback) === '[object Function]')callback();};};
            var c = document.getElementsByTagName("script")[0];c.parentNode.insertBefore(a, c);window.zhuge._init(b, x)}};
            if (window.location.host.toLowerCase()==='www.eduzhixin.com') {
                window.zhuge.load('bf00b5fe397a402abc0d9b4824c1659e', {visualizer: false, redirectAfterTrack: false,});
            }else{
                window.zhuge.load('1d22a4b6a7e9458f86ab904b6cf7ec09', {visualizer: false, redirectAfterTrack: false, debug: true});
            }
        }else {
            window.zhuge = window.zhuge || [];
            window.zhuge.track = function (argument) {};
            window.zhuge.identify = function (argument) {};
        }
    </script>
</head>
<body>

<!-- Navigation -->
 <nav class="navbar navbar-default navbar-fixed-top print-hide" id="zhixin-nav">
    <div class="navbar-top ">
        <div class="logo-wrap">
            <a class="navbar-brand" href="/">
                <div class="icon-brand">
                    <svg class="icon icon-logo" style="width:16px;height:16px;">
                        <use xlink:href="#icon-logo"></use>
                        <image src="https://cdn.eduzhixin.cn/cdn/img/icons/logo-f5d7cc1e.png" class="nav-icon" style="width:16px;height:16px;"/>
                    </svg>
                </div>
            </a>
        </div>
         <div class="container" style="max-width: 1200px;">
            <!--  <div class="nav navbar-nav navbar-right pull-right visible-ipad" style="margin-right: -15px;">
                <div class="nav-subject pull-left" data-type="PHY">
                    <a>物理</a>
                </div>
                <div class="nav-subject pull-left" data-type="BIO">
                    <a>生物</a>
                </div>
                <div class="nav-subject pull-right" data-type="CHEM">
                    <a>化学</a>
                </div>
            </div>-->
            <!--  <div class="navbar-left">
                <ul class="nav navbar-nav navbar-left hidden-xs">
                    <li class="article_phy_nav">
                        <a href="http://cpho.eduzhixin.com" target="_blank" style="margin-left: 0;">
                                物竞新闻
                        </a>
                    </li>
                    <li class="article_bio_nav">
                        <a href="http://cbo.eduzhixin.com" target="_blank">
                                生竞新闻
                        </a>
                    </li>
                    <li class="article_chem_nav">
                        <a href="http://ccho.eduzhixin.com/" target="_blank">
                                化竞新闻
                        </a>
                    </li>
                    <li class="course_learn_nav">
                        <a href="https://market.eduzhixin.com/learning/" target="_blank">
                                课程试听
                        </a>
                    </li>
                    <li class="forum_nav">
                        <a href="//forum.eduzhixin.com/" target="_blank">
                                质心论坛
                        </a>
                    </li>
                    <li class="app_nav btn-qr">
                        <div></div>
                        <a href="" target="_blank">
                            手机客户端
                        </a>
                    </li>                  
                </ul>
            </div>-->
        </div>
    </div>
    <div class="container" style="max-width: 1200px;margin-top: 15px;">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header" style="display:inline-block;margin-bottom: -5px;">
            <!-- <button type="button" class="navbar-toggle collapsed" style="margin: 5px 0 0 15px; float: left; border: none;"
                    aria-expanded="false" onclick="$('#zhixin-side-nav').toggleClass('folded')"> -->
            <button type="button" class="visible-xs" id="zx-nav-toggle" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="sr-only">Toggle navigation</span>
            </button>
            <div id="navbar-text" class="visible-xs"></div>
        </div>
               <div  id="not-login-nav" class="nav navbar-nav navbar-right pull-right" style="margin-right: 0px;">
                <div>
                    <a class="btn btn-success login" href="https://passport.eduzhixin.com/Login">登录</a>
                    <!--  <a class="btn btn-success register" href="https://passport.eduzhixin.com/Register">注册</a>-->
                </div>
            </div>
            <div class="nav navbar-nav navbar-left hidden-ipad" style="">
              <div class="nav-subject pull-left" data-type="PHY" style="margin-right: 3px;">
                <button class="btn">生物</button>
            </div>
            <div class="nav-subject pull-left" data-type="BIO" style="margin-left: 3px;">
                <button class="btn">物理</button>
            </div>
             <div class="nav-subject pull-left" data-type="CHEM" style="margin-left: 3px;">
                <button class="btn">化学</button>
            </div>
        </div>
        <!--<ul class="nav navbar-nav navbar-left hidden-xs ">
            <li role="separator" class="divider-verticle hidden-ipad"></li>
            <li class="normal live_nav">
                <a href="/?from=welcome#livereg">
                    <span>
                        直播
                    </span>
                    <!-- <span style="color:red;position: absolute;font-size: 11px;top: -2px;left: 48px;">NEW!</span> -->
                <!--  </a>
            </li>
            <li class="normal courses_nav">
                <a href='/?from=welcome#courses'>
                    <span>
                       知识点
                    </span>
                </a>
            </li>
                                    <li class="normal quiz_nav">
                <a href="/?from=welcome#quiz">
                    <span>
                        刷题
                    </span>
                </a>
            </li>
            <li class="normal exam_nav">
                <a href="/?from=welcome#exam">
                    <span>
                        比赛
                    </span>
                </a>
            </li>
            <li class="normal download_nav">
                <a href="/?from=welcome#download">
                    <span>
                        资料
                    </span>
                </a>
            </li>
            <li class="normal center_nav">
                <a href="/?from=welcome#publicize">
                    <span>
                        课程
                    </span>
                    <label class="badge nav-badge"><img src="https://cdn.eduzhixin.cn/cdn/img/icons/new-44b6696d.png" /></label>
                </a>
            </li>           
            <li class="normal dly_nav noMargin">
                <a href="/?from=welcome#register">
                    <span>
                        冬令营报名
                    </span>
                    <label class="badge nav-badge"><img src="https://cdn.eduzhixin.cn/cdn/img/icons/hot-fe08b793.png" /></label>
                </a>
            </li>
        </ul>-->
        <!--  <div id="zhixin-side-nav" class="visible-xs folded" style="overflow: hidden">
            <ul class="nav ">
                <li class="side-normal courses_nav">
                    <a href="/?from=welcome#courses">
                        <span>
                            知识点
                        </span>
                    </a>
                </li>
                                                <li class="side-normal quiz_nav">
                    <a href="/?from=welcome#quiz">
                        <span>
                            刷题
                        </span>
                    </a>
                </li>
                <li class="side-normal exam_nav">
                    <a href="/?from=welcome#exam">
                        <span>
                            比赛
                        </span>
                    </a>
                </li>
                <li class="side-normal live_nav">
                    <a href="/?from=welcome#livereg" >
                        <span>
                            直播
                        </span>
                    </a>
                </li>
                <li class="side-normal download_nav">
                    <a href="/?from=welcome#download">
                        <span>
                            资料
                        </span>
                    </a>
                </li>
                <li class="side-normal center_nav">
                    <a href="/?from=welcome#publicize">
                    <span>
                        课程
                    </span>
                    <label class="badge nav-badge" style="top: 10px;"><img src="https://cdn.eduzhixin.cn/cdn/img/icons/new-44b6696d.png" /></label>
                    </a>
                </li>
                <li class="side-normal dly_nav" >
                    <a href="/?from=welcome#register">
                    <span>
                        冬令营报名
                    </span>
                    <label class="badge nav-badge" style="top: 10px;"><img src="https://cdn.eduzhixin.cn/cdn/img/icons/hot-fe08b793.png" /></label>
                    </a>
                </li>
                                <li class="side-normal zchem_nav">
                    <a href="/?from=welcome#zchem">
                        <span>
                             ZCHEM
                        </span>
                        <label class="badge nav-badge" style="top: 10px;"><img src="https://cdn.eduzhixin.cn/cdn/img/icons/hot-fe08b793.png" /></label>
                    </a>
                </li>
                                <li class="divider"></li>
                <li class="article_phy_nav">
                    <a href="http://cpho.eduzhixin.com" target="_blank">
                            物竞新闻
                    </a>
                </li>
                <li class="article_bio_nav">
                    <a href="http://cbo.eduzhixin.com" target="_blank">
                            生竞新闻
                    </a>
                </li>
                <li class="article_chem_nav">
                    <a href="http://ccho.eduzhixin.com/" target="_blank">
                            化竞新闻
                    </a>
                </li>
                <li class="course_learn_nav">
                    <a href="https://market.eduzhixin.com/learning/" target="_blank">
                            课程试听
                    </a>
                </li>
                <li class="forum_nav">
                    <a href="//forum.eduzhixin.com/" target="_blank">
                            质心论坛
                    </a>
                </li>
                <li class="app_nav btn-qr">
                    <a href="" target="_blank">
                        手机客户端
                    </a>
                </li>
            </ul>
            <div class="back-drop"></div>
        </div>-->
    </div>
    <!-- /.container-fluid -->
</nav>
<div id="navbar-shadow"></div>
    <div class="slide-nav slide-fixed-nav container hidden-xs">
        <ul>
            <!--  <li><a href="">冬/夏令营</a></li>-->
                    <li><a href="">质心名师</a></li>
                    <li><a href="">质心学员</a></li>
                    <li><a href="">知识点</a></li>
                    <!--  <li><a href="">题库</a></li>-->
                    <li><a href="">在线课程</a></li>
                    <!--  <li><a href="">竞赛学科</a></li>-->
                    <!--  <li><a href="">新手指引</a></li>-->
        </ul>
    </div>
    <section class="section-banner">
        <div class="single-container">
            <img src="Images/class.png" width="95%" class="hidden-xs" style="margin: 0 auto;">
            <!--  <div class="camp-links">
                <div class="links-title">
                    <span>招生简章</span>
                </div>
                <div class="links-group">
                    <a href="https://market.eduzhixin.com/campinfo/201801/phy/" class="phy-link">物理营</a>
                    <a href="https://market.eduzhixin.com/campinfo/201801/bio/" class="bio-link">生物营</a>
                    <a href="https://market.eduzhixin.com/campinfo/201801/chem/" class="chem-link">化学营</a>
                </div>
            </div>-->
            <!-- <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/mobile-banner-camp-237ad8c3.png" width="100%" class="visible-xs"> -->
            <div class="slide-nav container hidden-xs">
                <ul>
                    <!--  <li><a href="">冬/夏令营</a></li>-->
                    <li><a href="">质心名师</a></li>
                    <li><a href="">质心学员</a></li>
                    <li><a href="">知识点</a></li>
                    <!--  <li><a href="">题库</a></li>-->
                    <li><a href="">在线课程</a></li>
                    <!--  <li><a href="">竞赛学科</a></li>-->
                    <!--  <li><a href="">新手指引</a></li>-->
                </ul>
            </div>
        </div>
    </section>
    <!--  <section class="section-camp">
                <div class="single-container">
                    <div class="content-wrap">
                        <div class="content-box">
                            <p class="title">质心冬/夏令营</p>
                            <p class="title-detail" style="margin: 30px 0;">名师授课，营地封闭管理，72.5%的CPhO国奖大神都曾在质心营学习</p>                                                        
                        </div>
                        <p style="margin-bottom:57px;margin-top:57px;">
                            <a href="http://cpho.eduzhixin.com/archives/category/2017%E8%B4%A8%E5%BF%83%E5%A4%8F%E4%BB%A4%E8%90%A5%E5%9B%BE%E9%9B%86" class="link-btn first-btn">查看更多</a>
                            <a href="/?from=welcome#register" class="link-btn second-btn">立即报名</a>
                        </p>
                        <div class="swiper-container swiper-pic2">
                            <div class="swiper-wrapper">
                                <div class="swiper-slide">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/camp_1-3792ab67.png">                                                                         
                                </div>
                                <div class="swiper-slide">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/camp_2-23d07d47.png">                                                                                                                   
                                </div>
                                <div class="swiper-slide">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/camp_3-b8783139.png">                                                                                                              
                                </div>
                            </div>
                        </div>
                        <div class="swiper-pagination pic2-pagination"></div>                            
                    </div>
                </div>
    </section>-->
    <section class="section-teacher">
                <div class="single-container">
                    <div class="content-wrap" style="width:100%;">
                        <p class="title">质心名师</p>
                        <div class="container teacher-intro"  style="padding: 0 5px;">
                            <div style="overflow:hidden">
                                <div class="col-xs-12 col-sm-4 col-lg-4">
                                <div class="xly-teacher">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/caizixing-9a977daa.png" alt="">
                                    <p style="text-align: center;margin: 30px 0;font-weight: bold;font-size: 20px;line-height: 1;">蔡子星</p>
                                    <p>
                                        毕业于北京大学物理学院，2005年获亚洲物理奥林匹克竞赛银牌保送北大。数学功底深厚，讲解深入浅出。从事物理竞赛教学多年，期间培养了包括胥晓宇在内的国际物理奥林匹克竞赛/亚洲物理奥林匹克竞赛金牌10人，全国中学生物理竞赛金银铜牌不计其数。编写大量原创竞赛题目，原创题集正在出版过程中。
                                    </p>
                                </div>
                                </div>
                                <div class="col-xs-12 col-sm-4 col-lg-4">
                                <div class="xly-teacher">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/huangqiao-a1a1eddd.png" alt="">
                                    <p style="text-align: center;margin: 30px 0;font-weight: bold;font-size: 20px;line-height: 1;">黄俏</p>
                                    <p>
                                        毕业于清华大学物理系，2006年获全国中学生物理竞赛银牌保送清华。讲课风格精准而不失幽默，举一反三循循善诱。具有丰富的竞赛/自主招生教学经验，培养了大量全国中学生物理竞赛金银铜牌，学生中包括2015年北京状元刘智昕等诸多人进入清华北大就读。善于把生活中的一切变成物理竞赛题目，激发学生探索学习的热情。
                                    </p>
                                </div>
                                </div>
                                <div class="col-xs-12 col-sm-4 col-lg-4">
                                <div class="xly-teacher">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/tangpeng-e18dabae.png" alt="">
                                    <p style="text-align: center;margin: 30px 0;font-weight: bold;font-size: 20px;line-height: 1;">唐鹏</p>
                                    <p>
                                        毕业于北京大学物理学院，2008年获亚洲物理奥林匹克竞赛金牌保送北大。毕业后开始从事物理竞赛教学工作，参与编写大量竞赛原创题目。授课风格风趣幽默，通俗易懂，擅长用学生常用的语言讲解物理概念，线上和线下的课程受到各地同学的广泛欢迎。培养大量的学生通过竞赛/自主招生进入北大清华。
                                    </p>
                                </div>
                                </div>
                            </div>
                            <div style="overflow:hidden">
                                <div class="col-xs-12 col-sm-4 col-lg-4">
                                <div class="xly-teacher">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/xly/zhubin-95671338.png" alt="" style="width:47%;">
                                    <p style="text-align: center;margin: 30px 0;font-weight: bold;font-size: 20px;line-height: 1;">朱斌</p>
                                    <p>
                                        毕业于北京大学化学与分子工程学院，2001年以全国第一名的成绩获得全国中学生生物竞赛金牌保送北大。授课富有激情，力求展现生命科学的真正魅力。从事科学研究和生物竞赛教学多年，很多学生保送进入清华北大等国内外一流名校。翻译大量的国际生物试题，解析理念生物竞赛真题。参与生物竞赛国家队集训工作，为国家队的集训供题。
                                    </p>
                                </div>
                                </div>
                                <div class="col-xs-12 col-sm-4 col-lg-4">
                                <div class="xly-teacher">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/duxiaoyu-1fd5e1e0.png" alt="">
                                    <p style="text-align: center;margin: 30px 0;font-weight: bold;font-size: 20px;line-height: 1;">杜啸宇</p>
                                    <p>
                                        毕业于北京大学物理学院，2009年获全国中学生物理竞赛银牌保送北大。从事物理竞赛/自招/竞赛实验/IYPT/CYPT/理科留学课程教学多年，具有丰富的教学产品研发和授课经验。授课风格认真细致，教授理论课的同时负责质心的竞赛实验教学。有大量来自全国各地的同学，通过杜老师的竞赛实验辅导进入决赛获奖，成功进入北大清华等国内外一流名校。
                                    </p>
                                </div>
                                </div>
                                <div class="col-xs-12 col-sm-4 col-lg-4">
                                <div class="xly-teacher">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/sunpeng-817ebdbe.png" alt="">
                                    <p style="text-align: center;margin: 30px 0;font-weight: bold;font-size: 20px;line-height: 1;">孙鹏</p>
                                    <p>
                                        毕业于北京大学物理学院，2003年获全国中学生物理竞赛铜牌保送北大。授课旁征博引，帮助学生建立对物理概念的深入理解。从事物理竞赛/自招/高考/理科留学课程教学研究工作多年，多数学生进入北大清华/普林斯顿/杜克大学/圣母大学等国内外知名高校。具备国际化的竞赛视野，翻译大量美国和东欧国家物理竞赛题目。
                                    </p>
                                </div>
                                </div>
                            </div>
                        </div> 
                        <!--  <div class="zhihu container">
                            <p><a href="https://www.zhihu.com/question/60572474" target="_blank">如何看待近期对质心教育的质疑？ >></a></p>
                            <p><a href="https://www.zhihu.com/question/53792566" target="_blank">质心教育的俏哥有什么好玩的梗？ >></a></p>
                        </div> -->                         
                    </div>                 
                </section>
    </section>
    <section class="section-student">
                <div class="single-container">
                    <div class="content-wrap" style="padding-top:1px;">
                        <p style="font-size: 27px;font-weight: bold;color: #5a5d66;margin-bottom:38px;margin-top:38px;">第34届全国中学生物理竞赛</p>
                        <p style="font-size: 20px;font-weight: bold;color: #5a5d66;">共 364 人获得国奖：一等奖 100 人，二等奖 120 人，三等奖 144 人</p>
                        <p style="font-size: 16px;font-weight: bold;color: #5a5d66;margin-top:40px;">质心教育学员成绩优异</p>
                        <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/score-b2359c0e.png"  class="hidden-xs score">
                        <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/score-min-fcefb62c.png"  class="visible-xs score">
                    </div>                    
                </div>
    </section>
    <section class="section-knowledge">
        <div class="single-container">
            <div class="content-wrap">
                <div class="num">300+</div>
                <div class="content-box">
                    <p class="title">知识点小视频</p>
                    <p class="title-detail">顶级竞赛名师录制，精讲竞赛核心知识点。</p>
                    <p class="title-detail">适合萌新做入坑前的准备</p>
                    <div class="swiper-container swiper-video1">
                        <div class="swiper-wrapper">
                            <div class="swiper-slide">
                                <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/knowledge_1-b579cf92.png" width="100%">                            
                                <video data-name="角速度线速度(下)" loop="loop" controls="controls"  preload="auto" playsinline webkit-playsinline src="" data-src="http://zhixin-static.oss-cn-beijing.aliyuncs.com/videos/welcome-page/%E8%A7%92%E9%80%9F%E5%BA%A6%E7%BA%BF%E9%80%9F%E5%BA%A6%EF%BC%88%E4%B8%8B%EF%BC%89-%E9%BB%84%E4%BF%8F.mp4">您的浏览器不支持h5视频
                                </video>
                            </div>
                            <div class="swiper-slide">
                                <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/knowledge_2-6f27d533.png" width="100%"> 
                                <video data-name="测量光栅常数和观察光谱" loop="loop" controls="controls" preload="auto" playsinline webkit-playsinline src="" data-src="http://zhixin-static.oss-cn-beijing.aliyuncs.com/videos/welcome-page/%E8%B5%B5%E9%B9%8F-%E6%B5%8B%E9%87%8F%E5%85%89%E6%A0%85%E5%B8%B8%E6%95%B0%E5%92%8C%E8%A7%82%E5%AF%9F%E5%85%89%E8%B0%B1.mp4">您的浏览器不支持h5视频
                                </video>                                    
                            </div>
                            <div class="swiper-slide">
                                <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/knowledge_3-91ca11e2.png" width="100%"> 
                                <video data-name="生物化学——单糖(1)" loop="loop" controls="controls" preload="auto" playsinline webkit-playsinline src="" data-src="http://zhixin-static.oss-cn-beijing.aliyuncs.com/videos/welcome-page/%E6%9C%B1%E6%96%8C-%E5%8D%95%E7%B3%96.mp4">您的浏览器不支持h5视频
                                </video>
                            </div>
                        </div>
                        <div class="swiper-button-prev video-slide-btn"></div>
                        <div class="swiper-button-next video-slide-btn"></div>
                        <div class="play-btn"></div>
                    </div>
                    <div class="shadow-bottom"></div>                    
                </div>
               <!--   <a href="/?from=welcome#courses" class="link-text">查看更多 <span class="more"></span></a> -->                                            
            </div>
        </div>                
    </section>
    <!--  <section class="section-quiz">
                <div class="single-container">
                    <div class="content-wrap">
                        <div class="num">3000+</div> 
                        <div class="content-box">
                            <p class="title">质心竞赛题库</p>
                            <p class="title-detail">经典竞赛题+质心原创题+国外题目翻译</p>
                            <p class="title-detail">+详细题目解析</p>
                        </div>
                        <div class="swiper-container swiper-pic1">
                            <div class="swiper-wrapper">
                                <div class="swiper-slide">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/quiz_1-c75025a3.png">
                                </div>
                                <div class="swiper-slide">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/quiz_2-719b3cba.png">                                      
                                </div>
                                <div class="swiper-slide">
                                    <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/quiz_3-df3085b4.png">                                       
                                </div>
                            </div>
                            <div class="swiper-pagination pic1-pagination"></div>
                            <div class="swiper-button-prev"></div>
                            <div class="swiper-button-next"></div>                             
                        </div>                       
                        <div class="shadow-bottom"></div> 
                        <a href="/?from=welcome#quiz" class="link-text">查看更多 <span class="more"></span></a>                                                                                         
                    </div>
                </div>              
    </section>-->
    <section class="section-live">
                <div class="single-container">
                    <div class="content-wrap">
                        <div class="num">400+</div>                    
                        <div class="content-box">
                            <p class="title">在线课程</p>
                            <p class="title-detail">不在北京没关系，人大附同学能上的竞赛课程，你也想学就学</p>
                            <div class="swiper-container swiper-video2">
                                <div class="swiper-wrapper">
                                    <div class="swiper-slide">
                                        <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/live_3-0de7b531.png" width="100%">
                                        <video data-name="运动的关联" loop="loop" controls="controls" preload="auto" playsinline webkit-playsinline src="" data-src="http://zhixin-static.oss-cn-beijing.aliyuncs.com/videos/welcome-page/%E6%9D%9C%E5%95%B8%E5%AE%87%20-%20%E8%BF%90%E5%8A%A8%E7%9A%84%E5%85%B3%E8%81%94%20-%20%E8%8A%82%E9%80%89%E7%89%87%E6%AE%B5.mp4">您的浏览器不支持h5视频
                                        </video>                                    
                                    </div>
                                    <div class="swiper-slide">
                                        <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/live_2-3ef8c432.png" width="100%">                                        
                                        <video data-name="电磁感应第1讲" loop="loop" controls="controls" preload="auto" playsinline webkit-playsinline src="" data-src="http://zhixin-static.oss-cn-beijing.aliyuncs.com/videos/welcome-page/%E9%BB%84%E4%BF%8F%20-%20%E7%94%B5%E7%A3%81%E6%84%9F%E5%BA%941%20-%20%E8%8A%82%E9%80%89%E7%89%87%E6%AE%B5.mp4">您的浏览器不支持h5视频
                                        </video>
                                    </div>
                                    <div class="swiper-slide">
                                        <img src="https://cdn.eduzhixin.cn/cdn/img/welcome/live_1-a9861f53.png" width="100%">
                                        <video data-name="基因与染色体" loop="loop" controls="controls" preload="auto" playsinline webkit-playsinline src="" data-src="http://zhixin-static.oss-cn-beijing.aliyuncs.com/videos/welcome-page/%E6%9C%B1%E6%96%8C%20-%20%E5%9F%BA%E5%9B%A0%E4%B8%8E%E6%9F%93%E8%89%B2%E4%BD%93%20-%20%E8%8A%82%E9%80%89%E7%89%87%E6%AE%B5.mp4">您的浏览器不支持h5视频
                                        </video>
                                    </div>
                                </div>
                                <div class="swiper-button-prev video-slide-btn"></div>
                                <div class="swiper-button-next video-slide-btn"></div>
                                <div class="play-btn"></div>                                
                            </div>
                        <div class="shadow-bottom"></div>                                                
                        </div>
                       <!--  <a href="/?from=welcome#recentLives" class="link-text">查看更多 <span class="more"></span></a>-->                                                  
                    </div>
                </div>            
    </section>
    <!--  <section class="section-subject" style="background:#fff;">
        <div class="single-container">
            <div class="content-wrap">
                <p class="title">质心开设的竞赛学科</p>
                <p class="title-detail">数学是火，点亮物理的灯</p>
                <p class="title-detail">物理是灯，照亮化学的路</p>
                <p class="title-detail">化学是路，通向生物的坑</p>
                <img class="subject-img" src="https://cdn.eduzhixin.cn/cdn/img/welcome/subject-intro-39265572.png">
                <p style="font-size:20px;margin-top:40px;">在质心，灯已点亮，坑已挖好，正在铺路化学，敬请期待......</p>
            </div>
        </div>
    </section>-->
    <!-- <section class="section-question">
                <div class="single-container">
                    <div class="content-wrap">
                        <div class="content-box">
                            <p class="title">如何学竞赛</p>
                            <p class="title-detail">看质心竞赛名师的竞赛指导，听竞赛大神们的学习经验</p>
                            <div class="tablists">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li role="presentation" class="active col-md-3 col-sm-3 col-xs-3"><a href="#phy" aria-controls="phy" role="tab" data-toggle="tab">物理竞赛</a></li>
                                    <li role="presentation" class="col-md-3 col-sm-3 col-xs-3"><a href="#bio" aria-controls="bio" role="tab" data-toggle="tab">生物竞赛</a></li>
                                    <li role="presentation" class="col-md-3 col-sm-3 col-xs-3"><a href="#chem" aria-controls="chem" role="tab" data-toggle="tab">化学竞赛</a></li>
                                    <li role="presentation" class="col-md-3 col-sm-3 col-xs-3"><a href="#recruit" aria-controls="recruit" role="tab" data-toggle="tab">自主招生</a></li>
                                </ul>                    
                            </div>                                                    
                        </div>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="phy">
                                <div class="question-group">
                                    <p class="questions">纵观近几年竞赛，为什么越来越多的同学开始提前学习微积分？</p>
                                    <p class="answer">
                                    11月1日，34届物理竞赛决赛圆满结束，该获奖的获奖，该保送的也已经保送。纵观近几年，竞赛虽然在思维量上并没有增加，但计算量却在增加，微积分在竞赛中的应用也变得越来越常规……
                                    <a href="http://mp.weixin.qq.com/s/xd8fBsklc9nsKgmClSCw5A" target="_blank">阅读全文></a>
                                    </p>
                                </div>
                                <div class="question-group">
                                    <p class="questions">入选国集，保送北大，什么成就了他的今天？</p>
                                    <p class="answer">
                                    起初在开始学习竞赛时，我的一部分阻力是来自于父母的。由于我的学习重心慢慢向竞赛移动，课内成绩自然也在渐渐下降。父母毕竟会带有一些功利色彩，会考虑我们的升学前景，有时他们的唠叨会使我难受……
                                    <a href="http://mp.weixin.qq.com/s/dHe09zkbWbH19g7nhxPPoA" target="_blank">阅读全文></a>
                                    </p>
                                </div>
                                <div class="question-group">
                                    <p class="questions">想要保送清华北大，物竞党必参考的学习路径推荐！</p>
                                    <p class="answer">
                                    又是一年开学季，又有许多萌新入坑物竞，大家怀着对物竞的兴趣探索如何学习物竞，什么时间看什么书刷什么题，质心姐姐“搬来”了蔡神的帖子告诉大家“通用的” 物竞学习路径供大家参考……
                                    <a href="https://mp.weixin.qq.com/s/gt-RwJZdsTZAKi3UdrQGpA" target="_blank">阅读全文></a>
                                    </p>
                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="bio">
                                <div class="question-group">
                                    <p class="questions">如果你已入生竞坑，如何拿省奖冲金牌？</p>
                                    <p class="answer">
                                    最近一段时间质心姐姐收到一些关于生竞“基础问题”，比如说：生物竞赛考试范围是什么？考试时间每年都一样吗？要拿奖是不是要看很多书？T值是什么鬼？鉴于又有一批入坑的萌新和关心生物竞赛的家长……
                                    <a href="http://mp.weixin.qq.com/s/4vOSkAsT20BTPfLC0-g9Xg" target="_blank">阅读全文></a>
                                    </p>
                                </div>
                                <div class="question-group">
                                    <p class="questions">从生竞萌新到国集大佬，他总结了5条建议和8条学习经验！</p>
                                    <p class="answer">
                                    质心姐姐一直在想，萌新们在看大佬经验帖时究竟在看什么，是他们面对挫折时的坚毅？他们踩过的坑总结的学习技巧？还是仅仅是看一个故事？我希望你能从这些大佬的经验中收获一丝“经验”……
                                    <a href="http://mp.weixin.qq.com/s/hIIEojmAGlHV653vu9CY4w" target="_blank">阅读全文></a>
                                    </p>
                                </div>
                                <div class="question-group">
                                    <p class="questions">麦子老师：想冲击生物竞赛全国金牌，你该读点啥？</p>
                                    <p class="answer">
                                    麦子老师已经为大家分享了一篇在时间较短的情况下如何速刷生物竞赛省奖的文章。今天，麦子老师又来给想要冲击国家级奖项的同学们分享推荐书单啦……
                                    <a href="http://cbo.eduzhixin.com/archives/3569" target="_blank">阅读全文></a>
                                    </p>
                                </div>                            
                            </div>
                            <div role="tabpanel" class="tab-pane" id="chem">
                                <div class="question-group">
                                    <p class="questions">保送清华北大？93%的化竞大神都用这份书单！</p>
                                    <p class="answer">
                                    这是“化学竞赛”微信平台的第一篇文章，我们希望通过这篇书目推荐，帮助还不知如何学习化竞的同学尽快找到努力的方向。这是一篇将近5000字的长文，阅读完会花费你十分钟，但这十分钟将使你受益三年……
                                    <a href="http://mp.weixin.qq.com/s/9zsRb2RfQ55lOdlQEUGqMA" target="_blank">阅读全文></a>
                                    </p>
                                </div>
                                <div class="question-group">
                                    <p class="questions">国集大佬：考好化学竞赛，靠的不是谁入门早，而是谁下的功夫多！</p>
                                    <p class="answer">
                                    质心姐姐一直在想，萌新们在看大佬经验帖时究竟在看什么，是他们面对挫折时的坚毅？他们踩过的坑总结的学习技巧？还是仅仅是看一个故事？我希望你能从这些大佬的经验中收获一丝“经验”……
                                    <a href="http://mp.weixin.qq.com/s/q1KCv6s8dj54d8m3sQr4sQ" target="_blank">阅读全文></a>
                                    </p>
                                </div>
                                <div class="question-group">
                                    <p class="questions">北大清华化学冬令营招生提前开始，高一高二生该如何规划？</p>
                                    <p class="answer">
                                    本文作者是陈思聪，高中毕业于江苏金陵中学，在2013年中国化学奥林匹克（决赛）中获得全国第十名，进入国家集训队，并保送至清华大学。他详细的分享了自己是如何规划学习化学竞赛的……
                                    <a href="http://mp.weixin.qq.com/s/bdVbyyPQGSKqlLUx74c40A" target="_blank">阅读全文></a>
                                    </p>
                                </div>                             
                            </div>
                            <div role="tabpanel" class="tab-pane" id="recruit">
                                <div class="question-group">
                                    <p class="questions">自主招生究竟有何优势？如何获取自招优惠？</p>
                                    <p class="answer">
                                    2017年招简陆续发出，何时报名，有何要求，信息纷杂哪些对我最有用，怎样从激烈的自招竞争中脱颖而出，下面小编来详细的介绍一下自主招生……
                                    <a href="http://cpho.eduzhixin.com/archives/11331" target="_blank">阅读全文></a>
                                    </p>
                                </div>
                                <div class="question-group">
                                    <p class="questions">如何快速突击自主招生并完美拿到高分优惠？</p>
                                    <p class="answer">
                                    历年来都有很多家长等到孩子高三了甚至考前，才开始操心自主招生的问题，比如曾经有家长找俏哥、胖鹏补习，说：“我家孩子早上7点上到晚上9点，你从晚上9点开始给他上到2点，你看这样一周能行么？”……
                                    <a href="https://mp.weixin.qq.com/s/uCVarfDfig35hwdAmdOAZg" target="_blank">阅读全文></a>
                                    </p>
                                </div>
                                <div class="question-group">
                                    <p class="questions">2017自主招生自荐信应该怎么写？</p>
                                    <p class="answer">
                                    常规自荐信内容主要包括自我介绍、课内学习情况、学科竞赛获奖情况、课外活动情况、性格、兴趣爱好等等方面。但是想要包含以上所有内容，一般来讲肯定需要非常大的篇幅来描述……
                                    <a href="http://cpho.eduzhixin.com/archives/10087" target="_blank">阅读全文></a>
                                    </p>
                                </div>                             
                            </div>
                        </div>                                            
                    </div>
                </div> 
    </section>-->
    <footer class="print-hide" id="footer">

    <!-- Footer -->
    <div class="container clearfix">
        <div class="icon">
            <a href="tel:010-53932402" class="fa fa-phone-square fa-rotate-180" style="font-size: 16px;"></a>
            <span><a href="tel:010-53932402">010-53932402</a> / <a href="tel:010-80455397">010-80455397</a></span>
            <div class="footer-hover">
                <p style="margin: 10px;">工作日<br> 10:00-19:00</p>
            </div>
        </div>
        <div class="icon hidden-xs">
            <a href="mailto:service@eduzhixin.com" class="fa fa-envelope"></a>
            <span class="hidden-xs"><a href="mailto:service@eduzhixin.com">service@eduzhixin.com</a></span>
        </div>

        <div class="icon hidden-xs">
            <a href="#contact" class="fa fa-weixin"></a>
            <span class="hidden-xs">物理竞赛</span>
            <div class="footer-hover">
                <img src="https://cdn.eduzhixin.cn/cdn/img/barcode-612ec756.jpg" alt="质心教育物理竞赛" style="width: 150px;"/>
            </div>
        </div>
        <div class="icon hidden-xs">
            <a href="#contact" class="fa fa-weixin"></a>
            <span class="hidden-xs">自主招生</span>
            <div class="footer-hover">
                <img src="https://cdn.eduzhixin.cn/cdn/img/q-zizhao-41e5fcba.jpg" alt="质心教育自招" style="width: 150px;"/>

            </div>
        </div>
        <div class="icon hidden-xs">
            <a href="#contact" class="fa fa-weixin"></a>
            <span class="hidden-xs">生物竞赛</span>
            <div class="footer-hover">
                <img src="https://cdn.eduzhixin.cn/cdn/img/q-bio-7856b51a.jpg" alt="质心教育生物竞赛" style="width: 150px;"/>
            </div>
        </div>
        <div class="icon hidden-xs">
            <a href="#contact" class="fa fa-weixin"></a>
            <span class="hidden-xs">化学竞赛</span>
            <div class="footer-hover">
                <img src="https://cdn.eduzhixin.cn/cdn/img/chem-qr-374daa59.jpg" alt="质心教育化学竞赛" style="width: 150px;"/>
            </div>
        </div>
        <p class="cpy-right-container">
        <a href="https://www.eduzhixin.com/About" target="_blank" style="color: rgba(255,255,255,0.8);">关于我们</a>  |  
        <a href="https://zt.eduzhixin.com/terms/agreement/201806" target="_blank" style="color: rgba(255,255,255,0.8);">用户协议</a>  |  
        <a href="https://zt.eduzhixin.com/terms/privacy/201806" target="_blank" style="color: rgba(255,255,255,0.8);">隐私政策</a>
        </p>
        <p class="cpy-right-container">
            Copyright &copy;2015-2018 质心教育
            <a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备15041693号</a>
            <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010802025472"
               style="display:inline-block;text-decoration:none;">
                <img src="https://cdn.eduzhixin.cn/cdn/img/icons/record-icon-232e4706.png" width="18" height="18" style="vertical-align: top;"/>
                <span style="display: inline-block;height:20px;line-height:20px; margin: 0 0 0 5px; color:#939393;">
                    京公网安备 11010802025472号
                </span>
            </a>
        </p>
    </div>
</footer>

   
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="//cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
        <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Custom Theme JavaScript -->
    <script data-main="https://cdn.eduzhixin.cn/cdn/js/welcome-d7409c8f.js" src="https://cdn.eduzhixin.cn/cdn/js/libs/require/require-0d35a695.js" defer async="true"></script>
	<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<input type="button" id="btn" value="获得选中的所有值">

<br>

<input type="checkbox" class="text_box" value='3' />3<br>

<input type="checkbox" class="text_box" value='4' />4<br>

<input type="checkbox" class="text_box" value='5' />5<br>

<input type="checkbox" class="text_box" value='6' />6<br>

<input type="text" id="dd" value=''/>
</body>
<script type="text/javascript">

$(function(){ 

 alert("+++++++");   

$(".text_box").click(function(){
alert("+++++++");
var val=0;

          $("[class='text_box']:checked").each(function(){

        val+=parseInt($(this).val());

        alert(val);

          })

          $("#dd").val(val);

    });

})  

</script>    
</html>
