# Login
用户登录的简单实现

在用户的登陆的时候，无论用户名和密码是否正确，先进行验证码的核对，验证码的文本信息保存在session中。

如果验证码有误，在index.jsp进行提示

如果验证码输入正确，进行用户名密码的核对，如果用户名密码正确，使用sendRedirect进行302重定向到成功页面。

如果用户名和密码不正确在index.jsp的页面上显示提示

登陆成功之后，将用户名保存在Cookie中，用户下次登陆的时候自动填充用户名

在用户没有登陆的时候访问成功界面会跳转到index.jsp，使用getRequestDispatcher().forward()进行转发

里面还有验证码的图片生成类，可以生成4位数字字母的验证码。

供我以后查看。
