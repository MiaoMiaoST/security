package com.boot.service;

import com.boot.annotation.LogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Date:2017/3/1 9:01
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
@Service
public class AopTestService {
    private Logger logger = LoggerFactory.getLogger(AopTestService.class);

    @LogAspect("Service层调用")
    public String testAop(){
        logger.info("Service层总不会返回页面出问题了吧");
        return "success";
    }
}
