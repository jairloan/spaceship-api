package com.example.spaceshipapi.aspect;

import org.aspectj.lang.annotation.After;

public class SpaceshipAspect {

  @After("execution(* com.example.spaceshipapi.controller.SpaceshipController.getSpaceshipById(..)) && args(id)")
  public void logIfIdIsNegative(Long id){
    if(id < 0){
      System.out.println("Attemped to fetch a spaceship with a negative ID: " + id);
    }
  }
}
