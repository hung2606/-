package com.carbon.system.controller;

import com.carbon.system.domain.SysUser;
import com.carbon.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin; // <--- Nhớ import cái này
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin // <--- THÊM DÒNG NÀY (Cho phép mọi nơi truy cập vào API này)
public class TestController {

    @Autowired
    private SysUserMapper userMapper;

    @GetMapping("/test/users")
    public List<SysUser> list() {
        return userMapper.selectList(null);
    }
}
