package com.rodrigovaamonde.spaceships.controllers.api;

import com.rodrigovaamonde.spaceships.controllers.dto.ErrorResource;
import com.rodrigovaamonde.spaceships.controllers.dto.SpaceShipDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Validated
@Tag(name = "SpaceShip", description = "SpaceShip API")
public interface SpaceShipApi {

  @Operation(
      operationId = "createSpaceShip",
      summary = "Create a new SpaceShip",
      description = "Create a new SpaceShip",
      tags = {"SpaceShips"},
      responses = {
        @ApiResponse(
            responseCode = "201",
            description = "SpaceShip created",
            content = @Content(schema = @Schema(implementation = SpaceShipDTO.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid input",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            }),
        @ApiResponse(
            responseCode = "403",
            description = "Forbidden",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            })
      })
  @RequestMapping(
      method = RequestMethod.POST,
      value = "/spaceship",
      produces = {"application/json"},
      consumes = {"application/json"})
  default ResponseEntity<SpaceShipDTO> createSpaceShip(
      @Parameter(
              name = "SpaceShipDTO",
              description = "SpaceShipDTO object that needs to be created",
              required = true)
          @RequestBody
          @Valid
          SpaceShipDTO spaceShipDTO) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @Operation(
      operationId = "updateSpaceShip",
      summary = "Update an existing SpaceShip",
      description = "Update an existing SpaceShip",
      tags = {"SpaceShips"},
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "SpaceShip updated",
            content = @Content(schema = @Schema(implementation = SpaceShipDTO.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid input",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            }),
        @ApiResponse(
            responseCode = "403",
            description = "Forbidden",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "SpaceShip not found",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            })
      })
  @RequestMapping(
      method = RequestMethod.PUT,
      value = "/spaceship/{id}",
      produces = {"application/json"},
      consumes = {"application/json"})
  default ResponseEntity<SpaceShipDTO> updateSpaceShip(
      @Parameter(
              name = "id",
              description = "ID of the SpaceShip that needs to be updated",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("id")
          Long id,
      @Parameter(
              name = "SpaceShipDTO",
              description = "SpaceShipDTO object that needs to be updated",
              required = true)
          @RequestBody
          @Valid
          SpaceShipDTO spaceShipDTO) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  @Operation(
      operationId = "getSpaceShip",
      summary = "Get a SpaceShip by ID",
      description = "Get a SpaceShip by ID",
      tags = {"SpaceShips"},
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "SpaceShip found",
            content = @Content(schema = @Schema(implementation = SpaceShipDTO.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid input",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            }),
        @ApiResponse(
            responseCode = "403",
            description = "Forbidden",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "SpaceShip not found",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            }),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ErrorResource.class))
            })
      })
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/spaceship/{id}",
      produces = {"application/json"})
  default ResponseEntity<SpaceShipDTO> getSpaceShip(
      @Parameter(
              name = "id",
              description = "ID of the SpaceShip that needs to be retrieved",
              required = true,
              in = ParameterIn.PATH)
          @PathVariable("id")
          Long id) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
