<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>官方主页</title>
	
    <!-- load stylesheets -->
    <link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css">                <!-- Font Awesome -->
    <link rel="stylesheet" href="css/bootstrap.min.css">                                      <!-- Bootstrap style -->
    <link rel="stylesheet" href="css/hero-slider-style.css">                                  <!-- Hero slider style -->
    <link rel="stylesheet" href="css/templatemo-style.css">                                   <!-- Templatemo style -->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
</head>
	
    <body>
        <section class="cd-hero">
            <ul class="cd-hero-slider autoplay">  
            <!-- 
            	<ul class="cd-hero-slider autoplay"> for slider auto play 
                <ul class="cd-hero-slider"> for disabled auto play
            -->
                <li class="selected">
                    <div class="cd-full-width">
                        <div class="tm-slide-content-div">
                            <form action="index.html" id="search-form">
                                <i class="fa fa-cogs tm-slide-icon"></i>
                                <h2 class="text-uppercase">客户登录</h2>
                                <p class="m-b-mid">本窗口用于客户登录(会员和非会员)</p>
                                <div class="form-group">
                                    <input name="username" type="text" class="form-control center-block tm-max-w-400" id="input1" placeholder="请输入您的用户名...">
                                    <input name="password" type="password" class="form-control center-block tm-max-w-400" id="input1" placeholder="请输入您的密码...">
                              </div>                                
                                <button type="submit" class="cd-btn">登录</button>
                                
                            </form>                            
                        </div>                        
                    </div> <!-- .cd-full-width -->
                </li>

                <li>
                    <div class="cd-full-width">
                        <div class="tm-slide-content-div">
                            <form action="index.html">
                                <i class="fa fa-compass tm-slide-icon"></i>
                                <h2 class="text-uppercase">注册用户</h2>
                                <p>游客可通过此界面注册为本站专用账户——也能以游客身份浏览本站部分信息</p>                                            
                                <a href="index.html#1" class="cd-btn">注册用户页面</a>
                                <a href="index.html#1" class="cd-btn">游客入口</a>
                                
                            </form>                           
                        </div>                        
                    </div> <!-- .cd-full-width -->
                </li>

                <li>
                    <div class="cd-full-width">
                        <div class="tm-slide-content-div">
                            <form action="index.html" id="newsletter">
                                <i class="fa fa-cloud tm-slide-icon"></i>
                                <h2 class="text-uppercase">管理员登录入口</h2>
                                <p class="tm-site-description">该入口为本站管理员或公司管理人员账户登录入口</p>
                                <div class="form-group">
                                    <input type="text" class="form-control center-block tm-max-w-400" id="input3" placeholder="Enter your username...">
                                    <input type="password" class="form-control center-block tm-max-w-400" id="input3" placeholder="check your password...">
                                </div>                                
                                <button type="submit" class="cd-btn">登录</button>
                                
                            </form>                            
                        </div>                        
                    </div> <!-- .cd-full-width -->
                </li>
            </ul> <!-- .cd-hero-slider -->

            <div class="cd-slider-nav">
                <nav>
                    <span class="cd-marker item-1"></span>
                    
                    <ul>
                        <li class="selected"><a href="#0"></a></li>
                        <li><a href="#0"></a></li>
                        <li><a href="#0"></a></li>                        
                    </ul>
                </nav> 
            </div> <!-- .cd-slider-nav -->
        </section> <!-- .cd-hero -->

        <!-- load JS files -->
        <script src="js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
        <script src="js/tether.min.js"></script> <!-- Tether for Bootstrap (http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h) --> 
        <script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap js (v4-alpha.getbootstrap.com/) -->
        <script src="js/hero-slider-script.js"></script>            <!-- Hero slider (https://codyhouse.co/gem/hero-slider/) -->
        <script src="js/jquery.touchSwipe.min.js"></script>         <!-- http://labs.rampinteractive.co.uk/touchSwipe/demos/ -->
        <script>     
       
            $(document).ready(function(){

                /* Auto play bootstrap carousel 
                * http://stackoverflow.com/questions/13525258/twitter-bootstrap-carousel-autoplay-on-load
                -----------------------------------------------------------------------------------------*/                
                $('.carousel').carousel({
                  interval: 3000
                })

                /* Enable swiping carousel for tablets and mobile
                 * http://lazcreative.com/blog/adding-swipe-support-to-bootstrap-carousel-3-0/
                 ---------------------------------------------------------------------------------*/
                if($(window).width() <= 991) {
                    $(".carousel-inner").swipe( {
                        //Generic swipe handler for all directions
                        swipeLeft:function(event, direction, distance, duration, fingerCount) {
                            $(this).parent().carousel('next'); 
                        },
                        swipeRight: function() {
                            $(this).parent().carousel('prev'); 
                        },
                        //Default is 75px, set to 0 for demo so any distance triggers swipe
                        threshold:0
                    });
                }  

                /* Handle window resize */
                $(window).resize(function(){
                    if($(window).width() <= 991) {
                        $(".carousel-inner").swipe( {
                            //Generic swipe handler for all directions
                            swipeLeft:function(event, direction, distance, duration, fingerCount) {
                                $(this).parent().carousel('next'); 
                            },
                            swipeRight: function() {
                                $(this).parent().carousel('prev'); 
                            },
                            //Default is 75px, set to 0 for demo so any distance triggers swipe
                            threshold:0
                        });
                     }
                });                             
            });

        </script>             

</body>
</html>