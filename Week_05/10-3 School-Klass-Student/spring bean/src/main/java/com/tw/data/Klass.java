package com.tw.data;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 61404
 */
@Data
@Component
public class Klass { 
    
    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}
