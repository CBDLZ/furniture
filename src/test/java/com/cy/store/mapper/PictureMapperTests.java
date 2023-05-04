package com.cy.store.mapper;

import com.cy.store.entity.Picture;
import com.cy.store.entity.Products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PictureMapperTests {
    @Autowired
    private PictureMapper pictureMapper;

    @Test
    public void insert() {
        Picture picture = new Picture();
        picture.setProductId(1);
        picture.setKind(1);

        Integer rows = pictureMapper.insert(picture);
        System.out.println("rows=" + rows);
    }

    @Test
    public void selectByProductId(){
        List<Picture> picture = pictureMapper.selectByProductId(1);
        System.out.println(picture);
        for (Picture item : picture) {
            System.out.println(item);
        }
    }

    @Test
    public void selectTitlePart(){
        List<Picture> picture = pictureMapper.selectByProductIdAndKind(1,1);

        for (Picture item : picture) {
            System.out.println(item);
        }
    }

}
