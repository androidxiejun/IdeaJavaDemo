package com.example.demo.test.controller;

import com.example.demo.test.model.User;
import com.example.demo.test.service.UserService;
import com.example.demo.test.util.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @RequestBody RegisterRequest register) {
        return "!!!";
    }

    /**
     * 查询所有的数据内容*
     *
     * @return
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String list(String name, Model model) {
        List<User> person = userService.findByName(name);
        model.addAttribute("person", person);
        return "index";
    }

    /**
     * 通过地址查询
     *
     * @return
     */
    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    public String findByName(String name) {
        List<User> users = userService.findByName(name);
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users) {
            stringBuilder.append(user.getName());
        }
        return "data:" + stringBuilder;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String findAllUser() {
        List<User> allUser = userService.getAllUser();
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : allUser) {
            stringBuilder.append(user.getName() + "\n");
        }
        return "data:" + stringBuilder;
    }

//    /**
//     * 查询的另外一种方式
//     * @param name
//     * @param address
//     * @return
//     */
//    @RequestMapping(value = "/Na_Add",method = RequestMethod.GET)
//    public String withNameAndAddressQuery(String name,String address,Model model){
//        List<User> person=userService.withNameAndAddressQuery(name,address);
//        model.addAttribute("person",person);
//        return "index";
//    }

    /**
     * 删除
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteByName(String name) {
        int a = userService.deleteByName(name);
        return "index";
    }

    /**
     * 增加一行数据
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String Add(String name, String age) {
        int a = userService.Add(name, age);
        return a > 0 ? "add success" : "add failed";
    }

    /**
     * 修改一行数据
     *
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String modify(String oldName, String newName) {
        int a = userService.modify(oldName, newName);
        return a > 0 ? "update success" : "update failed";
    }

}
