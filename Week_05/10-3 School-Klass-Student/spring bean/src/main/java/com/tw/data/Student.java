package com.tw.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;


/**
 * @author 61404
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component(value = "student100")
public class Student implements Serializable {
    
    private int id;
    private String name;
    
    public void init(){
        System.out.println("hello...........");
    }
    
    public Student create(){
        return new Student(101,"KK101");
    }
}
