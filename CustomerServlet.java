package com.codegym.controller;

import com.codegym.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers", ""})
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "images/avatar1.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Đức Giang", "images/avatar2.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "images/avatar3.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "images/avatar4.jpg"));
        customerList.add(new Customer("Nguyễn Khánh Thi", "1983-08-19", "Hà Nội", "images/avatar5.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
