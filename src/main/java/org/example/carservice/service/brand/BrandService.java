package org.example.carservice.service.brand;
import org.example.carservice.dto.cars.dto.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getBrands();

    BrandDto getBrandById(Long id);

    void addBrand(BrandDto brandDto);

    void updateBrand(Long id, BrandDto brandDto);

    void deleteBrandById(Long id);
}
