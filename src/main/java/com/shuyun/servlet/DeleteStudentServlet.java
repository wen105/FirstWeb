package com.shuyun.servlet;

import com.shuyun.dao.StudentDao;
import com.shuyun.dao.imply.StudentDaoImply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shuyun on 2016/8/3.
 */
@WebServlet(name = "DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImply();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int stuId = Integer.parseInt(request.getParameter("stuId"));
        int m = studentDao.deleteStudent(stuId);
        request.getRequestDispatcher("findAllStudent").forward(request, response);
    }
}
