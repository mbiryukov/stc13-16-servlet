package ru.innopolis.stc13.service;

import ru.innopolis.stc13.pojo.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getBrandList();
    int insert(String name, String country);
}
