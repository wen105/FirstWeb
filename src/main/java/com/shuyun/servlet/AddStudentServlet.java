package com.shuyun.servlet;

import com.shuyun.dao.StudentDao;
import com.shuyun.dao.imply.StudentDaoImply;
import com.shuyun.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * Created by shuyun on 2016/8/3.
 * StudentServlet
 */
@WebServlet(name = "StudentServlet")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDao studentDao = new StudentDaoImply();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int stuId = Integer.parseInt(request.getParameter("stuId"));
        String stuName = request.getParameter("stuName");
        String mark=request.getParameter("mark");
//        //得到cookie
//        Cookie[] cookies = request.getCookies();
//        for (int i = 0; i < cookies.length; i++) {
//            System.out.println(cookies[i].getName()+"***********************************"+cookies[i].getValue());
//        }
//        //得到header
//        System.out.println("输出cookie");
//        String cookie = request.getHeader("cookie");
//        System.out.println(cookie);
//        //得到所有请求头的信息
//        System.out.println("输出所有header");
//        String header = null;
//        Enumeration<String> e = request.getHeaderNames();
//        while (e.hasMoreElements()) {
//            header = e.nextElement();
//            if (header != null) {
//                System.out.println(header);
//                System.out.println(request.getHeader(header));
//            }
//        }
//        //获取请求的URI
//        String requestURI = request.getRequestURI();
//        System.out.println("输出请求的URI" + requestURI);
//
//        HttpSession httpSession = request.getSession();
//        System.out.println("sessionId:" + httpSession.getId());


        Student student = new Student(stuId, stuName);
        int m = studentDao.addStudent(student);

        if("mark".equals(mark)){
            Cookie autoCookie=null;
                Cookie cookies[]=request.getCookies();
            for(Cookie cookie:cookies){
                //判断是否存在自动登录
                if("autologin".equals(cookie.getName())){
                    String newValue=stuId+stuName;
                    autoCookie.setValue(newValue);
                }else{
                    String cookieValue=stuId+stuName;
                    autoCookie=new Cookie("autologin",cookieValue);
                }
            }
            //设置cookie路径
            assert autoCookie != null;
            autoCookie.setPath("/com.shuyun");
            //添加cookie
            response.addCookie(autoCookie);
        }
//        // admin存入到session
//        request.getSession().setAttribute("admin", entity);
//        // 成功登陆后的操作
//        request.getRequestDispatcher("./sc.jsp").forward(request,
//                response);


        //请求转发
        if (m < 1) {
            request.getRequestDispatcher("addStudent.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("findAllStudent").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
