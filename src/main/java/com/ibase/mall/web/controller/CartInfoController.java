package com.ibase.mall.web.controller;

import com.alibaba.fastjson.JSON;
import com.ibase.mall.cart.response.QueryCartInforResp;
import com.ibase.mall.web.rpc.CartInfoRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 购物袋核心业务处理入口类
 * Created by huixiong on 2018/1/4.
 */
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartInfoController {

    private static final Logger logger = LoggerFactory.getLogger(CartInfoController.class);

    @Autowired
    private CartInfoRpcService cartInfoRpcService;

    @Autowired
    protected RedisTemplate redisTemplate;

    @RequestMapping(value = "/getCartInfo", method = RequestMethod.GET)
    public QueryCartInforResp getCartInfo(@RequestParam("userId") Long userId){

        redisTemplate.opsForValue().set("userId",userId);
        System.out.println("input param "+userId);

        Object result = redisTemplate.opsForValue().get("userId");
        logger.info("getRedis output result："+result);

        QueryCartInforResp resp = cartInfoRpcService.getCartInfoByUserId(userId);
        logger.info("getCartInfoByUserId output result："+JSON.toJSONString(resp));
        return resp;
    }
}
