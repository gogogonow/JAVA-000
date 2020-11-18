package com.tw;

import com.tw.config.SchoolConfig;
import com.tw.data.School;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 61404
 */
@ContextConfiguration(classes = SchoolConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringMain {

    @Autowired
    private School school;

    @Test
    public void main() {

        school.ding();
    }
}
