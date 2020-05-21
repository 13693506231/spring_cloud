package com.kk.service;

import com.kk.config.FeignConfiguration;
import com.kk.domain.User;
import com.kk.service.impl.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="user-service"
           ,fallback = UserServiceFallback.class
           ,configuration= FeignConfiguration.class
)
public interface UserService {
    @RequestMapping("/user/getUser")
    User getUserById222(@RequestParam("id") Integer id);
}
