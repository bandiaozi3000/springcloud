package com.atguigu.springcloud.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private List<User> userList;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();

        userList.add(new User("jourwon",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        userList.add(new User("andy",password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        userList.add(new User("mark",password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }

    /**
     *为什么一个账号登录第二次会失败:
     * 原因:该方法执行完毕后,后续执行会将该对象的密码给清空,由于本文是用list保存的对象,所以下次在获取密码为null,所以此时无法登录.
     * 如果是从数据库每次都获取一个新对象的话,理应不会出现该问题.
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> findUserList = userList.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            User user = findUserList.get(0);
            return user;
        } else {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
    }

}
