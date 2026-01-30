package org.example.module3.layered.service.brand;
import org.example.module3.layered.dto.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getBrands();

    BrandDto getBrandById(Long id);

    void addBrand(BrandDto brandDto);

    void updateBrand(Long id, BrandDto brandDto);

    void deleteBrandById(Long id);
}
