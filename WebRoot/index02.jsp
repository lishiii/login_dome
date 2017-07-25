<%@ page language="java" import="java.util.*,javax.servlet.http.*,web.entity.*,java.net.URLDecoder" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>CDU_yzh</title>
    <link rel="stylesheet" type="text/css" href="./css/common.css">
    <link rel="stylesheet" type="text/css" href="./css/reset.css">
    <link rel="stylesheet" type="text/css" href="./css/index.css">
    <script type="text/javascript" src="http://livejs.com/live.js"></script>
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="jquery.goup.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {

            $.goup({
                trigger: 100,
                bottomOffset: 150,
                locationOffset: 100,
                title: '回到最顶',
                titleAsText: true
            });

        });
    </script>
</head>

<body>
    <!--å¤´-->
    <div class="public-container">
        <div class="public-header">
            <div class="header-logo">
                <a href=""><img src="./images/index-header-logo.png" alt=""></a>
            </div>
            <div class="header-nav">
                <ul>
                    <li class="item">Our story</li>
                    <li class="item">Menu</li>
                    <li class="item">Reservasion</li>
                    <li class="item">News</li>
                    <li class="item">Reviews</li>
                </ul>
            </div>
            <div class="index-login" >
                <a style="float: left;" >你好，
                <%
				Cookie cookies[]=request.getCookies(); //读出用户硬盘上的Cookie，并将所有的Cookie放到一个cookie对象数组里面
				Cookie sCookie=null; 
				for(int i=0;i<cookies.length-1;i++){    //用一个循环语句遍历刚才建立的Cookie对象数组
				sCookie=cookies[i];   //取出数组中的一个Cookie对象
				if(sCookie!=null){
     			if(("admin").equals(sCookie.getName())){  
		        out.println(URLDecoder.decode(sCookie.getValue(), "UTF-8"));
		      		}
		  		 }
		  	 }
				%> 
				</a>
           		<a style="float: left;" href="#">进入个人中心</a>
           		<a style="float: left;"> | </a>  
           		<a  style="float: left;" href="${pageContext.request.contextPath }/login.jsp">注销</a>
            </div>
        </div>
    </div>
    
    <div class="index-banner">
        <div class="index-banner-bg">
            <img src="./images/index-bg-img.jpg" alt="">
            <div class="index-banner-text">
                <img src="./images/index-bg-logo.png" alt="">
                <a class="text-info">
                    <div class="line-l"></div> resto restaurant home page website template
                    <div class="line-r"></div>
                </a>
            </div>
        </div>
    </div>
    
    <div class="index-menu clearfloat">
        <div class="menu-txt">
            The Menu
        </div>
        <div class="public-container index-list">
            <ul>
                <li class=" menu-item">
                    <a class="menu-title">Voluptate cillum fugiat. <br>
                    <p class="common"> Cheesess, tomato, mushrooms, onions.</p>
                    </a>
                    <div class="menu-price">$50
                    </div>
                    <div class="menu-line">
                    </div>
                </li>
            </ul>
            <ul>
                <li class=" menu-item">
                    <a class="menu-title">Voluptate cillum fugiat. <br>
                    <p class="common"> Cheese, tomato, mushrooms, onions.</p>
                    </a>
                    <div class="menu-price">$50
                    </div>
                    <div class="menu-line">
                    </div>
                </li>
            </ul>
            <ul>
                <li class=" menu-item">
                    <a class="menu-title">Voluptate cillum fugiat. <br>
                    <p class="common"> Cheese, tomato, mushrooms, onions.</p>
                    </a>
                    <div class="menu-price">$50
                    </div>
                    <div class="menu-line">
                    </div>
                </li>
            </ul>
            <ul>
                <li class=" menu-item">
                    <a class="menu-title">Voluptate cillum fugiat. <br>
                    <p class="common"> Cheese, tomato, mushrooms, onions.</p>
                    </a>
                    <div class="menu-price">$50
                    </div>
                    <div class="menu-line">
                    </div>
                </li>
            </ul>
            <ul>
                <li class=" menu-item">
                    <a class="menu-title">Voluptate cillum fugiat. <br>
                    <p class="common"> Cheese, tomato, mushrooms, onions.</p>
                    </a>
                    <div class="menu-price">$50
                    </div>
                    <div class="menu-line">
                    </div>
                </li>
            </ul>
            <ul>
                <li class=" menu-item">
                    <a class="menu-title">Voluptate cillum fugiat. <br>
                    <p class="common"> Cheese, tomato, mushrooms, onions.</p>
                    </a>
                    <div class="menu-price">$50
                    </div>
                    <div class="menu-line">
                    </div>
                </li>
            </ul>
            <ul>
                <li class=" menu-item">
                    <a class="menu-title">Voluptate cillum fugiat. <br>
                    <p class="common"> Cheese, tomato, mushrooms, onions.</p>
                    </a>
                    <div class="menu-price">$50
                    </div>
                    <div class="menu-line">
                    </div>
                </li>
            </ul>
            <ul>
                <li class=" menu-item">
                    <a class="menu-title">Voluptate cillum fugiat. <br>
                    <p class="common"> Cheese, tomato, mushrooms, onions.</p>
                    </a>
                    <div class="menu-price">$50
                    </div>
                    <div class="menu-line">
                    </div>
                </li>
            </ul>
        </div>
        <div class="loadmore">
            <a class="loadmore-txt">load more | â¨</a>
        </div>
    </div>
    <!--èåå¾æ-->
    <div class="public-container index-dishmenu">
        <span class="index-dish-tittle">
            <h2 class="dish-tittle">Featured Dishes</h2>
            <i class="index-dish-line"></i>
        </span>
        <ul>

            <li class="index-dish clearfloat">
                <div class="index-dish-img">
                    <img src="./images/dish1.png" alt="">
                </div>
                <p class="dish-txt">Fugiat nulla sint</p>
                <p class="dish-price">$50</p>
                <div class="index-dish-mark clearfloat">
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-off.png" alt=""></i>
                </div>
            </li>
            <li class="index-dish clearfloat">
                <div class="index-dish-img">
                    <img src="./images/dish1.png" alt="">
                </div>
                <p class="dish-txt">Fugiat nulla sint</p>
                <p class="dish-price">$50</p>
                <div class="index-dish-mark clearfloat">
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-off.png" alt=""></i>
                </div>
            </li>
            <li class="index-dish clearfloat">
                <div class="index-dish-img">
                    <img src="./images/dish1.png" alt="">
                </div>
                <p class="dish-txt">Fugiat nulla sint</p>
                <p class="dish-price">$50</p>
                <div class="index-dish-mark clearfloat">
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-off.png" alt=""></i>
                </div>
            </li>
            <li class="index-dish clearfloat">
                <div class="index-dish-img">
                    <img src="./images/dish1.png" alt="">
                </div>
                <p class="dish-txt">Fugiat nulla sint</p>
                <p class="dish-price">$50</p>
                <div class="index-dish-mark clearfloat">
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-on.png" alt=""></i>
                    <i class="index-dish-star"><img src="./images/star-off.png" alt=""></i>
                </div>
            </li>
        </ul>
    </div>
    <!--èåå¾çå±ç¤º-->
    <div class="public-container">
        <span class="index-photo-tittle">
            <h2>The Gallery</h2> <i class="index-tittle-line"></i>
        </span>
        <ul class="index-photo ">
            <li class="index-photo-float "><img src="./images/photo1.png " alt=" "></li>
            <li class="index-photo-float "><img src="./images/photo2.png " alt=" ">
                <img src="./images/photo3.png " alt=" ">
            </li>
            <li class="index-photo-float "><img src="./images/photo4.png " alt=" "></li>
        </ul>

    </div>
    <!--å°¾-->
    <div class="public-footer ">
        <div class="public-container ">
            <div class="footer-col ">
                <p>New York <br> Restaurant 3926<br> Anmoore Road New York, NY 10014 <br>718-749-1714
                </p>
            </div>
            <div class="footer-col ">
                <p>France Restaurant
                    <br>68, rue de la Couronne<br> 75002 PARIS <br>02.94.23.69.56
                </p>
            </div>
            <div class="footer-col ">
                <p>Blog
                    <br>Careers<br> Privacy Policy <br>Contact
                </p>
            </div>

            <div class="footer-col-indepent ">
                <img src="./images/index-logo-white.png " alt=" ">
                <p class="footer-wri-indepent ">Â© All Rights Reserved 2014.<br>Find More at Pixelhint.com
                </p>
            </div>
        </div>
    </div>
</body>

</html>