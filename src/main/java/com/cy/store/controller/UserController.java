package com.cy.store.controller;

import com.cy.store.controller.ex.*;


import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.PasswordNotMatchException;
import com.cy.store.service.ex.UserNotFoundException;
import com.cy.store.service.ex.UsernameDuplicateException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;


    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        // 调用业务对象执行注册
        userService.reg(user);
        // 返回
        return new JsonResult<Void>(OK, CODE);
    }

    @RequestMapping("findAll")
    public JsonResult<List<User>> findAll(HttpSession session) {
        // 调用业务对象执行注册
        List<User> data = userService.findAll(getUidFromSession(session));
        // 返回
        return new JsonResult<List<User>>(OK, CODE, data);
    }


    @RequestMapping("delete/{delUid}")
    public JsonResult<Void> deleteByPrimaryKey(@PathVariable("delUid") Integer delUid,HttpSession session) {
        // 调用业务对象执行注册
        Integer data = userService.deleteByPrimaryKey(delUid, getUidFromSession(session));
        // 返回
        return new JsonResult<Void>(OK, CODE);
    }
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        // 调用业务对象的方法执行登录，并获取返回值
        User data = userService.login(username, password);

        //登录成功后，将uid和username存入到HttpSession中
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
         System.out.println("Session中的uid=" + getUidFromSession(session));
         System.out.println("Session中的username=" + getUsernameFromSession(session));

        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<User>(OK, CODE, data);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        // 调用session.getAttribute("")获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行修改密码
        userService.changePassword(uid, username, oldPassword, newPassword);
        // 返回成功
        return new JsonResult<Void>(OK, CODE);
    }

    @GetMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        // 从HttpSession对象中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行获取数据
        User data = userService.getByUid(uid);
        // 响应成功和数据
        return new JsonResult<User>(OK, CODE, data);
    }
    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        // 从HttpSession对象中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行修改用户资料
        userService.changeInfo(uid, username, user);
        // 响应成功
        return new JsonResult<Void>(OK, CODE);
    }

    /** 头像文件大小的上限值(10MB) */
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    /** 允许上传的头像的文件类型 */
    public static final List<String> AVATAR_TYPES = new ArrayList<String>();

    /** 初始化允许上传的头像的文件类型 */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }


    String filePath = "/Users/xyh/Downloads/JAVA_learn/store/store/src/main/resources/static/avatars";
    @PostMapping("change_avatar")
    public JsonResult<String> changeAvatar(@RequestParam("file") MultipartFile file, HttpSession session) {
        // 判断上传的文件是否为空
        if (file.isEmpty()) {
            // 是：抛出异常
            throw new FileEmptyException("上传的头像文件不允许为空");
        }

        // 判断上传的文件大小是否超出限制值
        if (file.getSize() > AVATAR_MAX_SIZE) { // getSize()：返回文件的大小，以字节为单位
            // 是：抛出异常
            throw new FileSizeException("不允许上传超过" + (AVATAR_MAX_SIZE / 1024) + "KB的头像文件");
        }
        System.out.println(file.getOriginalFilename());
        // 判断上传的文件类型是否超出限制
        String contentType = file.getContentType();
        // public boolean list.contains(Object o)：当前列表若包含某元素，返回结果为true；若不包含该元素，返回结果为false。
        if (!AVATAR_TYPES.contains(contentType)) {
            // 是：抛出异常
            throw new FileTypeException("不支持使用该类型的文件作为头像，允许的文件类型：\n" + AVATAR_TYPES);
        }

        // 获取当前项目的绝对磁盘路径
//        String parent = session.getServletContext().getRealPath("upload");
        String parent = filePath;
        // 保存头像文件的文件夹
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 保存的头像文件的文件名
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        int beginIndex = originalFilename.lastIndexOf(".");
        System.out.println("beginIndex:"+beginIndex);
        if (beginIndex > 0) {
            suffix = originalFilename.substring(beginIndex);
            System.out.println("suffix"+suffix);
        }
        String filename = UUID.randomUUID().toString() + suffix;

        // 创建文件对象，表示保存的头像文件
        File dest = new File(dir, filename);
        // 执行保存头像文件
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            // 抛出异常
            throw new FileStateException("文件状态异常，可能文件已被移动或删除");
        } catch (IOException e) {
            // 抛出异常
            throw new FileUploadIOException("上传文件时读写错误，请稍后重尝试");
        }

        // 头像路径
        String avatar = filename;
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

//        上传新头像时自动删除旧头像
//        File delfile = new File(filePath+"/"+userService.getByUid(uid).getAvatar());
//        System.out.println(filePath+"/"+userService.getByUid(uid).getAvatar());
//        if (delfile.exists()) {
//            delfile.delete();
//            System.out.println("===========删除成功=================");
//
//        } else {
//            System.out.println("===============删除失败==============");
//
//        }
        // 将头像写入到数据库中
        userService.changeAvatar(uid, username, avatar);



        // 返回成功头像路径
        return new JsonResult<String>(OK, CODE, avatar);
    }


}
