package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.entity.Picture;
import com.cy.store.entity.Products;
import com.cy.store.entity.User;
import com.cy.store.service.IPictureService;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("picture")
public class PictureController extends BaseController{
    @Autowired
    private IPictureService pictureService;


    /** 头像文件大小的上限值(100MB) */
    public static final int AVATAR_MAX_SIZE = 30 * 1024 * 1024;
    /** 允许上传的头像的文件类型 */
    public static final List<String> AVATAR_TYPES = new ArrayList<String>();

    /** 初始化允许上传的头像的文件类型 */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
        AVATAR_TYPES.add("image/avif");
        AVATAR_TYPES.add("image/webp");
    }


    String filePath = "/Users/xyh/Downloads/毕设/开发/pic";
    @PostMapping("{productId}/{kind}")
    public JsonResult<String> uploadPic(@RequestParam("file") MultipartFile file, @PathVariable("productId") Integer productId, @PathVariable("kind") Integer kind, HttpSession session) {
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
        String parent = "";
        String folder = "";
        if (kind == 0){
            parent = filePath + '/' + productId + "_title_part";
            folder = "_title_part";
        }else if(kind == 1){
            parent = filePath + '/' + productId + "_preview";
            folder = "_preview";
        }else if(kind == 2){
            parent = filePath + '/' + productId + "_details";
            folder = "_details";
        }

        // 保存图片文件的文件夹
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }else {
            //        若存在删除文件夹并新建
//            File delfile = new File(parent);
//            System.out.println(parent);
//            if (delfile.exists()) {
//                FileSystemUtils.deleteRecursively(delfile);
//                System.out.println("===========删除成功=================");
//                dir.mkdirs();
//            } else {
//                System.out.println("===============删除失败==============");
//
//            }
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
        System.out.println("filename:"+filename);
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

        // 图片路径
        String path = productId + folder + "/" + filename;
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

        // 将头像写入到数据库中
        Picture picture = new Picture();
        picture.setProductId(productId);
        picture.setKind(kind);
        System.out.println("kind"+kind);
        picture.setPath(path);
        pictureService.insert(picture);


        // 返回成功头像路径
        return new JsonResult<String>(OK, CODE, path);
    }

    @PostMapping("change/{productId}/{kind}")
    public JsonResult<String> changePic(@RequestParam("file") MultipartFile file, @PathVariable("productId") Integer productId, @PathVariable("kind") Integer kind, HttpSession session) {
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
        String parent = "";
        String folder = "";
        if (kind == 0){
            parent = filePath + '/' + productId + "_title_part";
            folder = "_title_part";
        }else if(kind == 1){
            parent = filePath + '/' + productId + "_preview";
            folder = "_preview";
        }else if(kind == 2){
            parent = filePath + '/' + productId + "_details";
            folder = "_details";
        }

        // 保存图片文件的文件夹
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }else {
//            //        上传新头像时自动删除旧头像
//            File delfile = new File(parent);
//            System.out.println(parent);
//            if (delfile.exists()) {
////                delfile.delete();
//                FileSystemUtils.deleteRecursively(delfile);
//                System.out.println("===========删除成功=================");
//                dir.mkdirs();
//            } else {
//                System.out.println("===============删除失败==============");
//
//            }
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
        System.out.println("filename:"+filename);
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

        // 图片路径
        String path = productId + folder + "/" + filename;
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);


        // 将头像写入到数据库中
        Picture picture = new Picture();
        picture.setProductId(productId);
        picture.setPath(path);
        picture.setKind(kind);
        System.out.println("kind"+kind);
        pictureService.insert(picture);


        // 返回成功头像路径
        return new JsonResult<String>(OK, CODE, path);
    }

    @GetMapping("{pid}/get_picture")
    public JsonResult<List<Picture>> getByProductId(@PathVariable("pid") Integer pid) {
        // 调用业务对象执行获取数据
        List<Picture> data = pictureService.selectByProductId(pid);
        System.out.println(data);
        // 返回成功和数据
        return new JsonResult<List<Picture>>(OK, CODE, data);
    }

    @RequestMapping("{pid}/delete")
    public JsonResult<Void> deleteByProductId(@PathVariable("pid") Integer pid) {
        List<String> parent = new ArrayList<>();

        parent.add(filePath + '/' + pid + "_title_part");

        parent.add(filePath + '/' + pid + "_preview");

        parent.add(filePath + '/' + pid + "_details");

        pictureService.deleteFolder(parent);
        pictureService.deletePicDatabase(pid);


        // 返回成功和数据
        return new JsonResult<Void>(OK, CODE);
    }

    @RequestMapping("{productId}/{kind}/find_pics")
    public JsonResult<List<Picture>> findPics(@PathVariable("productId") Integer productId, @PathVariable("kind") Integer kind){
        List<Picture> data = pictureService.findPic(productId,kind);


        // 返回成功和数据
        return new JsonResult<List<Picture>>(OK, CODE, data);
    }

}
