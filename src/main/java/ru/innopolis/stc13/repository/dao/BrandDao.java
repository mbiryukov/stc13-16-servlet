package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.pojo.Brand;

import java.util.List;

public interface BrandDao {
    List<Brand> getBrandList();
    int insert(Brand brand);
}
