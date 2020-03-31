package com.example.demo.test.service;

import com.example.demo.test.model.User;
import com.example.demo.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    /**
     * 通过姓名查询
     *
     * @param name
     * @return
     */
    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

//    /**
//     * 通过地址查询
//     *
//     * @param address
//     * @return
//     */
//    public List<User> findByAddress(String address) {
//        return userDao.findByAddress(address);
//    }
//
//    /**
//     * 通过姓名和地址查询
//     *
//     * @param name
//     * @param address
//     * @return
//     */
//    public List<User> withNameAndAddressQuery(String name, String address) {
//        return userDao.withNameAndAddressQuery(name, address);
//    }

    /**
     * 删除一行
     *
     * @param name
     * @return
     */
    public int deleteByName(String name) {
        return userDao.deleteByName(name);
    }

    /**
     * 新增方法
     *
     * @param name
     * @param age
     * @return
     */
    public int Add(String name, String age) {
        return userDao.Add(name, age);
    }

    /**
     * 更改数据库中的一行
     *
     * @return
     */
    public int modify(String oldName, String newName) {
        return userDao.modify(oldName, newName);
    }

    /**
     * 获取所有用户数据
     *
     * @return
     */
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

}
