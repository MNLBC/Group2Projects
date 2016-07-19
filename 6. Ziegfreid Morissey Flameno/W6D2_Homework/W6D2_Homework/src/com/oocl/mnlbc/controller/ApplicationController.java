package com.oocl.mnlbc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application Controller used to run embedded server
 * 
 * @author flamezi2
 * @since 2016-07-19
 */
@SpringBootApplication
public class ApplicationController {

   public static void main(String[] args) {
      SpringApplication.run(ApplicationController.class, args);
   }
}
