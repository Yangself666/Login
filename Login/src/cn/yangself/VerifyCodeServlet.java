package cn.yangself;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImageUtil imageUtil = new ImageUtil();
        BufferedImage bi = imageUtil.getImage();
        String vcode = imageUtil.getText();
        req.getSession().setAttribute("vcode",vcode);
        imageUtil.getImageOutput(resp.getOutputStream());
    }
}
