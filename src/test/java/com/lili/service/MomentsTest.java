package com.lili.service;

import com.lili.Application;
import com.lili.core.Page;
import com.lili.core.PageForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liqiao on 2018/12/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class MomentsTest {
    @Autowired
    private MomentsService momentsService;
    @Test
    public void testQueryAll() {
        PageForm pageForm = new PageForm();
        pageForm.setCurrentPage(1);
        pageForm.setPageSize(2);
        Page page = momentsService.queryAll(pageForm);
        System.out.println(page.getTotalRecordCount());
    }
}
