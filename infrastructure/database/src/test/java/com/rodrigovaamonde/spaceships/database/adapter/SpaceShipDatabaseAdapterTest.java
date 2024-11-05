package com.rodrigovaamonde.spaceships.database.adapter;

import com.rodrigovaamonde.spaceships.database.mapper.SpaceShipDatabaseMapper;
import com.rodrigovaamonde.spaceships.database.model.SpaceShipMO;
import com.rodrigovaamonde.spaceships.database.repository.SpaceShipRepository;
import com.rodrigovaamonde.spaceships.domain.model.SpaceShip;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SpaceShipDatabaseAdapterTest {

  @Mock private SpaceShipRepository spaceShipRepository;

  @Mock private SpaceShipDatabaseMapper spaceShipDatabaseMapper;

  @InjectMocks private SpaceShipDatabaseAdapter spaceShipDatabaseAdapter;

  private SpaceShip spaceShip;
  private SpaceShipMO spaceShipMO;
  private Pageable pageable;

  @BeforeEach
  void setUp() {
    spaceShip = SpaceShip.builder().build();
    spaceShipMO = SpaceShipMO.builder().build();
    pageable = PageRequest.of(0, 10);
  }

  @Test
  void findAllReturnsPageOfSpaceShips() {
    Page<SpaceShipMO> spaceShipMOPage = new PageImpl<>(Collections.singletonList(spaceShipMO));
    when(spaceShipRepository.findAll(pageable)).thenReturn(spaceShipMOPage);
    when(spaceShipDatabaseMapper.toDomain(spaceShipMO)).thenReturn(spaceShip);

    Page<SpaceShip> result = spaceShipDatabaseAdapter.findAll(pageable);

    assertNotNull(result);
    assertEquals(1, result.getTotalElements());
    assertEquals(spaceShip, result.getContent().getFirst());
  }

  @Test
  void findByIdReturnsSpaceShipWhenFound() {
    when(spaceShipRepository.findById(1L)).thenReturn(Optional.of(spaceShipMO));
    when(spaceShipDatabaseMapper.toDomain(spaceShipMO)).thenReturn(spaceShip);

    SpaceShip result = spaceShipDatabaseAdapter.findById(1L);

    assertNotNull(result);
    assertEquals(spaceShip, result);
  }

  @Test
  void findByIdReturnsNullWhenNotFound() {
    when(spaceShipRepository.findById(1L)).thenReturn(Optional.empty());

    SpaceShip result = spaceShipDatabaseAdapter.findById(1L);

    assertNull(result);
  }

  @Test
  void findByNameReturnsPageOfSpaceShips() {
    Page<SpaceShipMO> spaceShipMOPage = new PageImpl<>(Collections.singletonList(spaceShipMO));
    when(spaceShipRepository.findByNameContainingIgnoreCase("name", pageable))
        .thenReturn(spaceShipMOPage);
    when(spaceShipDatabaseMapper.toDomain(spaceShipMO)).thenReturn(spaceShip);

    Page<SpaceShip> result = spaceShipDatabaseAdapter.findByName("name", pageable);

    assertNotNull(result);
    assertEquals(1, result.getTotalElements());
    assertEquals(spaceShip, result.getContent().getFirst());
  }

  @Test
  void saveReturnsSavedSpaceShip() {
    when(spaceShipDatabaseMapper.toMO(spaceShip)).thenReturn(spaceShipMO);
    when(spaceShipRepository.save(spaceShipMO)).thenReturn(spaceShipMO);
    when(spaceShipDatabaseMapper.toDomain(spaceShipMO)).thenReturn(spaceShip);

    SpaceShip result = spaceShipDatabaseAdapter.save(spaceShip);

    assertNotNull(result);
    assertEquals(spaceShip, result);
  }

  @Test
  void deleteRemovesSpaceShip() {
    doNothing().when(spaceShipRepository).deleteById(1L);

    spaceShipDatabaseAdapter.delete(1L);

    verify(spaceShipRepository, times(1)).deleteById(1L);
  }
}
