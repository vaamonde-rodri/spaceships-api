package com.rodrigovaamonde.spaceships.domain.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SpaceShipAspect {

  @Pointcut(
      "execution(* com.rodrigovaamonde.spaceships.domain.port.application.SpaceShipPort.findById(Long)) && args(id)")
  public void findById(Long id) {}

  @Before(value = "findById(id)", argNames = "id")
  public void beforeFindById(Long id) {
    if (id < 0) {
      log.error("Request to find a SpaceShip with a negative id: {}", id);
    }
  }
}
