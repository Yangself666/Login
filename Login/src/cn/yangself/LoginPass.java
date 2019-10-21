package cn.yangself;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginPass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String vcode = (String)req.getSession().getAttribute("vcode");
        String userCode = req.getParameter("verityCode");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (vcode.equalsIgnoreCase(userCode)){//如果验证码正确进行密码判断
            if ("xujiaqi".equalsIgnoreCase(username)&&"1234".equals(password)){//账户密码正确进行302重定向
                Cookie userCookie = new Cookie("username",username);
                resp.addCookie(userCookie);
                userCookie.setMaxAge(3600);
                req.getSession().setAttribute("LoginUser",username);
                resp.sendRedirect("/Login/success/s1.jsp");//重定向到成功界面
            }else{//密码错误登陆失败
                req.setAttribute("msg","用户名或者密码错误，请重试！");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);//转发请求到首页
            }
        }else{//验证码填写错误
            req.setAttribute("msg","验证码输入错误，请重试！");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
