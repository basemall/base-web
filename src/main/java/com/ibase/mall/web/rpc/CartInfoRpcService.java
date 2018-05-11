package com.ibase.mall.web.rpc;

import com.ibase.mall.cart.response.QueryCartInforResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName CartInfoRpcService
 * @Description TODO
 * @Autor liaoxiongjian
 * @Date 2018/5/11 18:09
 * @Version 1.0
 */
@FeignClient("base-cart-rpc")
public interface CartInfoRpcService {
    @GetMapping(value = "/cart/getCartInfo")
    QueryCartInforResp getCartInfoByUserId(Long userId);
}
