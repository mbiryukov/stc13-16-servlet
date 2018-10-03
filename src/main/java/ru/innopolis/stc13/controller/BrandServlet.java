package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.pojo.Brand;
import ru.innopolis.stc13.service.BrandService;
import ru.innopolis.stc13.service.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BrandServlet extends HttpServlet {
    BrandService brandService;

    public BrandServlet() {
        brandService = new BrandServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> res = brandService.getBrandList();
        req.setAttribute("brands", res);
        req.getRequestDispatcher("/brands.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String country = req.getParameter("country");
        brandService.insert(name, country);
        this.doGet(req, resp);
    }
}
