<%-- 
    Document   : index
    Created on : Nov 29, 2012, 12:11:52 AM
    Author     : RjDavis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->

<!--[if gt IE 8]><!--> <html class="no-js" lang="en"> <!--<![endif]-->

    <head>
        <meta charset="UTF-8">

        <!-- Remove this line if you use the .htaccess -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

        <meta name="viewport" content="width=device-width">

        <meta name="description" content="Designa Studio, a HTML5 / CSS3 template.">
        <meta name="author" content="Sylvain Lafitte, Web Designer, sylvainlafitte.com">

        <title>DirectElect - Log In</title>

        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
        <link rel="shortcut icon" type="image/png" href="favicon.png">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/style.css">

        <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>

    <body>
        <!-- Prompt IE 7 users to install Chrome Frame -->
        <!--[if lt IE 8]><p class=chromeframe>Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

        <div class="container">

            <header id="navtop">
                <a href="index.jsp" class="logo fleft">
                    <img src="images/logo.png" alt="Designa Studio">
                </a>


            </header>


	<div class="vote-page main grid-wrap">

		<header class="grid col-full">
			<hr>
			<p class="fleft">Login</p>
		</header>


		<aside class="grid col-one-quarter mq2-col-full">
			<h4>Instructions</h4>
			<p class="mbottom">
                            Enter your username, password, and fill in the CAPTCHA to continue.
                        </p>
			

		</aside>
                <section class="grid col-three-quarters mq2-col-full">

                    <div class="grid col-full" style="padding-left: 0px;">
                        <h2>Login to DirectElect</h2>
                        <form action="" method="post">
                            <span class="grid col-full" style="padding-left: 0px;">Username: <input type="text" name="user" style="padding: .5em;"></span>
                            <span class="grid col-full" style="padding-left: 0px;">Password: <input type="password" name="password" style="padding: .5em;"></span>
                            <span class="grid col-full" style="padding-left: 0px;">
                                <script type="text/javascript"
                                        src="http://www.google.com/recaptcha/api/challenge?k=6LcNu9kSAAAAAPfYkox8lPktHWV_MdrnWT2UvMac">
                                </script>
                                <noscript>
                                <iframe src="http://www.google.com/recaptcha/api/noscript?k=6LcNu9kSAAAAAPfYkox8lPktHWV_MdrnWT2UvMac"
                                        height="300" width="500" frameborder="0"></iframe><br>
                                <textarea name="recaptcha_challenge_field" rows="3" cols="40">
                                </textarea>
                                <input type="hidden" name="recaptcha_response_field"
                                       value="manual_challenge">
                                </noscript>
                            </span>
                            <span class="grid col-full" style="padding: 1em 0em;">
                                <a class="button" href="register.html">Register</a>
                                &nbsp;
                                <a class="button" href="home.html">Login</a>
                            </span>
                        </form>
                    </div>

                </section>
            </div> <!--main-->

            <div class="divide-top">
                <footer class="grid-wrap">
                    <div class="up grid col-one-half ">
                        <a href="#navtop" title="Go back up">&uarr;</a>
                    </div>

                    <nav class="grid col-one-half ">

                    </nav>
                </footer>
            </div>

        </div>

        <!-- Javascript - jQuery -->
        <script src="http://code.jquery.com/jquery.js"></script>
        <script>window.jQuery || document.write('<script src="js/jquery-1.8.3.js"><\/script>')</script>

        <!--[if (gte IE 6)&(lte IE 8)]>
        <script src="js/selectivizr.js"></script>
        <![endif]-->

        <script src="js/scripts.js"></script>

    </body>
</html>