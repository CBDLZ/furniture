package com.cy.store.util;

import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.util.List;

public class DeleteFile {
    String parent;
    public DeleteFile() {

    }

    public Boolean delete(String parent){
        File delfile = new File(parent);
        System.out.println(parent);
        if (delfile.exists()) {
            FileSystemUtils.deleteRecursively(delfile);
            System.out.println("===========删除成功=================");
            return true;
        } else {
            System.out.println("===============删除失败==============");
            return false;
        }
    }

    public Boolean delete(List<String> parent){
        Boolean isSuccess = true;
        for (String res : parent){
            File delfile = new File(res);
            System.out.println(parent);
            if (delfile.exists()) {
                FileSystemUtils.deleteRecursively(delfile);
                System.out.println("===========删除成功=================");

            } else {
                System.out.println("===============删除失败==============");
                isSuccess = false;
            }
        }
        return isSuccess;
    }

}
