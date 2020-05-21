package com.kk.controller;

import com.kk.domain.User;
import com.kk.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultFallBack")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    UserService userService;

    @RequestMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "queryByIdFallBack")
    @HystrixCommand
    public String QueryById(@PathVariable Integer id) throws Exception {
/*        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
         String url = String.format("http://%s:%s/user/getUser?id="+id,host,port);
        System.out.println("ConsumerController.QueryById");*/
        String url = "http://user-service/user/getUser?id=" + id;
        if (id == 1) {
            System.out.println("ConsumerController.QueryById");
            throw new Exception(String.valueOf(1111));
        }
        String jsonResult = restTemplate.getForObject(url, String.class);
        return jsonResult;
    }

    @RequestMapping("/all")
    @HystrixCommand
    public String QueryAll() {
        String url = "http://user-service/user/getUserAll";
        String jsonResult = restTemplate.getForObject(url, String.class);
        return jsonResult;
    }

    public String queryByIdFallBack(Integer id) {
        return "对不起网络繁忙";
    }

    public String defaultFallBack() {
        return "默认网络错误提示！！！";
    }

    @RequestMapping("/feignconsumer/{id}")
     public User helloFeign(@PathVariable Integer id) {
        User user = userService.getUserById222(id);
        return user;
    }
}
