package com.imooc.mall.service.impl;

import com.imooc.mall.exception.ImoocMallException;
import com.imooc.mall.exception.ImoocMallExceptionEnum;
import com.imooc.mall.model.dao.UserMapper;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import com.imooc.mall.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * @author honggw
 * @create 2021-09-07 12:01
 *
 */

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public void register(String userName, String password) throws ImoocMallException {
        //查询不能重名
        User result = userMapper.selectByName(userName);
        if(result != null){
             throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXISTED);
        }
        User user = new User();
        user.setUsername(userName);
        //user.setPassword(password); 要对数据库的密码进行加密
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        int count = userMapper.insertSelective(user);
        if(count == 0){
            throw new ImoocMallException(ImoocMallExceptionEnum.INSERT_FAILED);
        }

    }

    @Override
    public User login(String userName, String password) throws ImoocMallException {
        String md5Password = null;
        try {
            md5Password = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = userMapper.selectLogin(userName, md5Password);//这一块传入的参数是需要注意的，一定要是经过md5之后的密码，不是password这种
//        if(user == null){
//            try {
//                throw new ImoocMallException(ImoocMallExceptionEnum.WRONG_PASSWORD);
//            } catch (ImoocMallException e) {
//                e.printStackTrace();
//            }
//        }
        if(user == null){
            throw new ImoocMallException(ImoocMallExceptionEnum.WRONG_PASSWORD);
        }
        return user;
    }
    @Override
    public void updateInformation(User user) throws ImoocMallException {
        //更新个性签名
        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if(updateCount > 1){
            throw new ImoocMallException(ImoocMallExceptionEnum.UPDATE_FAILED);
        }
    }
    @Override
    public boolean checkAdminRole(User user){
        return user.getRole().equals(2);
    }

}
