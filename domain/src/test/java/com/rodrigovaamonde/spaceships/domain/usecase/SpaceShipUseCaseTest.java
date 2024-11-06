package com.rodrigovaamonde.spaceships.domain.usecase;

import com.rodrigovaamonde.spaceships.domain.exception.InvalidInputException;
import com.rodrigovaamonde.spaceships.domain.exception.ResourceNotFoundException;
import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
import com.rodrigovaamonde.spaceships.domain.port.infrastructure.SpaceShipDatabasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpaceShipUseCaseTest {
  @Mock private SpaceShipDatabasePort spaceShipDatabasePort;
  @InjectMocks private SpaceShipUseCase spaceShipUseCase;

  private SpaceShip spaceShip;

  @BeforeEach
  void setUp() {
    spaceShip = SpaceShip.builder().build();
    spaceShip.setId(1L);
    spaceShip.setName("Enterprise");
    spaceShip.setDescription("A starship");
    spaceShip.setSource("Star Trek");
  }

  @Test
  void findAllReturnsPageOfSpaceShips() {
    Pageable pageable = PageRequest.of(0, 10);
    Page<SpaceShip> page = new PageImpl<>(Collections.singletonList(spaceShip));
    when(spaceShipDatabasePort.findAll(pageable)).thenReturn(page);

    Page<SpaceShip> result = spaceShipUseCase.findAll(0, 10);

    assertEquals(1, result.getTotalElements());
    verify(spaceShipDatabasePort, times(1)).findAll(pageable);
  }

  @Test
  void findAllThrowsInvalidInputExceptionForInvalidPageAndSize() {
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.findAll(-1, 10));
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.findAll(0, 0));
  }

  @Test
  void findByIdReturnsSpaceShip() {
    when(spaceShipDatabasePort.findById(1L)).thenReturn(spaceShip);

    SpaceShip result = spaceShipUseCase.findById(1L);

    assertNotNull(result);
    assertEquals("Enterprise", result.getName());
    verify(spaceShipDatabasePort, times(1)).findById(1L);
  }

  @Test
  void findByIdThrowsInvalidInputExceptionForInvalidId() {
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.findById(0L));
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.findById(null));
  }

  @Test
  void findByIdThrowsResourceNotFoundExceptionForNonExistentId() {
    when(spaceShipDatabasePort.findById(1L)).thenReturn(null);

    assertThrows(ResourceNotFoundException.class, () -> spaceShipUseCase.findById(1L));
  }

  @Test
  void findByNameReturnsPageOfSpaceShips() {
    Pageable pageable = PageRequest.of(0, 10);
    Page<SpaceShip> page = new PageImpl<>(Collections.singletonList(spaceShip));
    when(spaceShipDatabasePort.findByName("Enterprise", pageable)).thenReturn(page);

    Page<SpaceShip> result = spaceShipUseCase.findByName("Enterprise", 0, 10);

    assertEquals(1, result.getTotalElements());
    verify(spaceShipDatabasePort, times(1)).findByName("Enterprise", pageable);
  }

  @Test
  void findByNameThrowsInvalidInputExceptionForInvalidNamePageAndSize() {
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.findByName("", 0, 10));
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.findByName("Enterprise", -1, 10));
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.findByName("Enterprise", 0, 0));
  }

  @Test
  void createReturnsSavedSpaceShip() {
    when(spaceShipDatabasePort.save(spaceShip)).thenReturn(spaceShip);

    SpaceShip result = spaceShipUseCase.create(spaceShip);

    assertNotNull(result);
    assertEquals("Enterprise", result.getName());
    verify(spaceShipDatabasePort, times(1)).save(spaceShip);
  }

  @Test
  void createThrowsInvalidInputExceptionForNullSpaceShip() {
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.create(null));
  }

  @Test
  void updateReturnsUpdatedSpaceShip() {
    when(spaceShipDatabasePort.findById(1L)).thenReturn(spaceShip);
    when(spaceShipDatabasePort.save(spaceShip)).thenReturn(spaceShip);

    SpaceShip updatedSpaceShip = SpaceShip.builder().build();
    updatedSpaceShip.setName("Voyager");
    updatedSpaceShip.setDescription("Another starship");
    updatedSpaceShip.setSource("Star Trek");

    SpaceShip result = spaceShipUseCase.update(1L, updatedSpaceShip);

    assertNotNull(result);
    assertEquals("Voyager", result.getName());
    verify(spaceShipDatabasePort, times(1)).findById(1L);
    verify(spaceShipDatabasePort, times(1)).save(spaceShip);
  }

  @Test
  void updateThrowsInvalidInputExceptionForInvalidIdOrNullSpaceShip() {
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.update(0L, spaceShip));
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.update(1L, null));
  }

  @Test
  void deleteRemovesSpaceShip() {
    doNothing().when(spaceShipDatabasePort).delete(1L);

    spaceShipUseCase.delete(1L);

    verify(spaceShipDatabasePort, times(1)).delete(1L);
  }

  @Test
  void deleteThrowsInvalidInputExceptionForInvalidId() {
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.delete(0L));
    assertThrows(InvalidInputException.class, () -> spaceShipUseCase.delete(null));
  }
}
