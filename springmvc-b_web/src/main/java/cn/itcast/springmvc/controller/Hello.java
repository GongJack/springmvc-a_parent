package cn.itcast.springmvc.controller;

import cn.itcast.springmvc.pojo.User;
import cn.itcast.springmvc.pojo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gh102 on 2017-08-04.
 */
@Controller
@RequestMapping("hello")
public class Hello  {

    @RequestMapping("test")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","第一个springmvc程序");

        return mv;
    }

    @RequestMapping("test1/{name}/{id}")            //占位符映射
    public ModelAndView test1(@PathVariable("name")String name , @PathVariable("id")Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg",name+"第一个springmvc程序"+id);

        return mv;
    }

    @RequestMapping(value="test2",method = RequestMethod.GET)            //限定请求方法
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","限定请求方法");

        return mv;
    }

    @RequestMapping(value="test3")            //接受参数请求
    public ModelAndView test3(@CookieValue("loginName") String loginName, @RequestParam(value = "id",required = true)String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","接受参数请求"+id+"  "+loginName);

        return mv;
    }

    @RequestMapping(value="test4")            //接受pojo类
    public String test4(User user, Model model) {
        model.addAttribute("msg","接受pojo类"+user.toString());
        return "hello";
    }

    @RequestMapping(value="test5")            //接收集合封装成对象
    public String test5(UserVO userVO, Model model) {
        System.out.println(userVO.getUsers());
        model.addAttribute("userVO",userVO);
        return "users";
    }

    @RequestMapping("test6")
    @ResponseBody
    public List<User> test6(){
        List<User> list = new ArrayList<User>();
        for(int i=0;i<10;i++){
            User user = new User();
            user.setAge(20*i+5*i/3);
            user.setName("li"+i);
            user.setId(i+1);
            list.add(user);
        }
        return list;
    }
}
