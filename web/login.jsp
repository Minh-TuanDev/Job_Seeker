<%-- 
    Document   : login.jsp
    Created on : Mar 9, 2024, 4:20:02 PM
    Author     : lpdie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="assets/css/login.css">
    <title>PHPJabbers.com | Free Job Agency Website Template</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/owl.css">
  </head>
    <body style="padding: 0">
        <jsp:include page="header.html"></jsp:include>
         <ul class="nav">
            <li onclick="showLogin()">Login</li>
            <li onclick="showSignup()">Sign up</li>
            <li onclick="showForgotPassword()">Forgot password</li>
            <li onclick="showSubscribe()">Subscribe</li>
            <li onclick="showContactUs()">Contact us</li>
        </ul>
        <div class="wrapper">
            <div class="rec-prism">
                <div class="face face-top">
                    <div class="content">
                        <h2>Subscribe</h2>
                        <small>Enter your email so we can send you the latest updates!</small>
                        <form onsubmit="event.preventDefault()">
                            <div class="field-wrapper">
                                <input type="text" name="email" placeholder="email">
                                <label>e-mail</label>
                            </div>
                            <div class="field-wrapper">
                                <input type="submit" onclick="showThankYou()">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="face face-front">
                    <div class="content">
                        <h2>Sign in</h2>
                        <form onsubmit="event.preventDefault()">
                            <div class="field-wrapper">
                                <input type="text" name="username" placeholder="username">
                                <label>username</label>
                            </div>
                            <div class="field-wrapper">
                                <input type="password" name="password" placeholder="password" autocomplete="new-password">
                                <label>password</label>
                            </div>
                            <div class="field-wrapper">
                                <input type="submit" onclick="showThankYou()">
                            </div>
                            <span class="psw" onclick="showForgotPassword()">Forgot Password? </span>
                            <span class="signup" onclick="showSignup()">Not a user? Sign up</span>
                        </form>
                    </div>
                </div>
                <div class="face face-back">
                    <div class="content">
                        <h2>Forgot your password?</h2>
                        <small>Enter your email so we can send you a reset link for your password</small>
                        <form onsubmit="event.preventDefault()">
                            <div class="field-wrapper">
                                <input type="text" name="email" placeholder="email">
                                <label>e-mail</label>
                            </div>
                            <div class="field-wrapper">
                                <input type="submit" onclick="showThankYou()">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="face face-right">
                    <div class="content">
                        <h2>Sign up</h2>
                        <form onsubmit="event.preventDefault()">
                            <div class="field-wrapper">
                                <input type="text" name="email" placeholder="email">
                                <label>e-mail</label>
                            </div>
                            <div class="field-wrapper">
                                <input type="password" name="password" placeholder="password" autocomplete="new-password">
                                <label>password</label>
                            </div>
                            <div class="field-wrapper">
                                <input type="password" name="password2" placeholder="password" autocomplete="new-password">
                                <label>re-enter password</label>
                            </div>
                            <div class="field-wrapper">
                                <input type="submit" onclick="showThankYou()">
                            </div>
                            <span class="singin" onclick="showLogin()">Already a user? Sign in</span>
                        </form>
                    </div>
                </div>
                <div class="face face-left">
                    <div class="content">
                        <h2>Contact us</h2>
                        <form onsubmit="event.preventDefault()">
                            <div class="field-wrapper">
                                <input type="text" name="name" placeholder="name">
                                <label>Name</label>
                            </div>
                            <div class="field-wrapper">
                                <input type="text" name="email" placeholder="email">
                                <label>e-mail</label>
                            </div>
                            <div class="field-wrapper">
                                <textarea placeholder="your message"></textarea>
                                <label>your message</label>
                            </div>
                            <div class="field-wrapper">
                                <input type="submit" onclick="showThankYou()">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="face face-bottom">
                    <div class="content">
                        <div class="thank-you-msg">
                            Thank you!
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.html"></jsp:include>
                <script src="assets/js/login.js"></script>

    </body>
</html>
