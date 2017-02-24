package com.boot.controller;

import com.boot.entity.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date:2017/2/24 15:47
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
@Controller
@RequestMapping("home")
public class HomeController {
    @RequestMapping("/test")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
}
