package com.shuyun.servlet;

import com.shuyun.dao.StudentDao;
import com.shuyun.dao.imply.StudentDaoImply;
import com.shuyun.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by shuyun on 2016/8/3.
 * 显示所有学生servlet
 */
@WebServlet(name = "FindStudentServlet")
public class FindStudentServlet extends HttpServlet {
    private StudentDao studentDao=new StudentDaoImply();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        List<Student> studentList=studentDao.findAllStudent();
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("listAllStudents.jsp").forward(request,response);
    }
}
