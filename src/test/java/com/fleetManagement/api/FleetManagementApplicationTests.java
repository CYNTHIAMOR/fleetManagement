package com.fleetManagement.api;

import com.fleetManagement.api.controllers.TrajectoryControllers;
import com.fleetManagement.api.repositories.TaxiRepository;
import com.fleetManagement.api.repositories.TrajectoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FleetManagementApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TaxiRepository taxiRepository;

    @Test
    @DisplayName("mi primer tests")

    void contextLoads() throws Exception {
        mockMvc.perform(get("/api/taxis")).andExpect(status().isOk());

    }
    @Test
    @DisplayName("Testing the first endpoint - taxis")
    void taxisContextLoads() throws Exception {
        mockMvc.perform(get("/api/taxis?page=0&size=10")).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[0].id").exists())
                .andExpect(jsonPath("$.content[0].plate").exists());
    }
            @Test
            @DisplayName("verifica si el controlador de trayectorias responde correctamente a una solicitud GET con parámetros especificados")
            void testGetTrajectory() throws Exception {
                mockMvc.perform(get("/trajectories/by-taxi")
                                .param("taxiId", "6418")
                                .param("startDate", "2008-02-02")
                                .param("page", "0")
                                .param("size", "10"))
                        .andExpect(status().isOk());
            }

        @Autowired
        private TrajectoryRepository trajectoryRepository;

        @Test
        @DisplayName("Testing the second endpoint - trajectories by taxi")
        void trajectoriesByTaxiContextLoads() throws Exception {
            mockMvc.perform(get("/trajectories/by-taxi?taxiId=6418&startDate=2008-02-02&pageNumber=0&quantitySize=10"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.content").isArray())
                    .andExpect(jsonPath("$.content[0].date").exists())
                    .andExpect(jsonPath("$.content[0].latitude").exists())
                    .andExpect(jsonPath("$.content[0].longitude").exists());
        }

        @Test
        @DisplayName("Testing the third endpoint - last trajectories for each taxi")
        void lastTrajectoriesContextLoads() throws Exception {
            mockMvc.perform(get("/last-trajectories/for-each-taxi?pageNumber=0&quantitySize=10"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.content").isNotEmpty())
                    .andExpect(jsonPath("$.content").isArray())
                    .andExpect(jsonPath("$.content[0].taxi.id").exists())
                    .andExpect(jsonPath("$.content[0].taxi.plate").exists())
                    .andExpect(jsonPath("$.content[0].date").exists())
                    .andExpect(jsonPath("$.content[0].latitude").exists())
                    .andExpect(jsonPath("$.content[0].longitude").exists());
        }

    }

