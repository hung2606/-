package com.carbon.system.controller;

import com.carbon.system.domain.CarbonAsset;
import com.carbon.system.mapper.CarbonAssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/asset")
@CrossOrigin
public class CarbonAssetController {

    @Autowired
    private CarbonAssetMapper assetMapper;

    // 1. Lấy danh sách
    @GetMapping("/list")
    public List<CarbonAsset> list() {
        return assetMapper.selectList(null);
    }

    // 2. [MỚI] Thêm mới tài sản (Nhận dữ liệu từ Frontend gửi lên)
    @PostMapping("/create")
    public String create(@RequestBody CarbonAsset asset) {
        // Tự động điền ngày tạo và trạng thái
        asset.setCreateTime(new Date());
        asset.setStatus("0"); // Mặc định là Chờ duyệt
        if (asset.getOwnerId() == null) {
            asset.setOwnerId(1L); // Mặc định gán cho admin nếu không chọn
        }

        assetMapper.insert(asset);
        return "Thêm thành công!";
    }
}
