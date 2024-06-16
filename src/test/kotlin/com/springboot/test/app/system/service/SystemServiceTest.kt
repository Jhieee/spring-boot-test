//package com.springboot.test.app.system.service
//
//import com.springboot.test.app.system.dto.SystemDto
//import com.springboot.test.app.system.dto.SystemPermissionDto
//import com.springboot.test.core.db.entity.SystemMetaEntity
//import com.springboot.test.core.db.entity.SystemPermissionEntity
//import com.springboot.test.core.db.repository.SystemPermissionRepository
//import com.springboot.test.core.db.repository.SystemRepository
//import com.springboot.test.core.type.TargetType
//import org.aspectj.lang.annotation.Before
//
//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test
//
//import org.mockito.InjectMocks
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.MockitoAnnotations
//import org.mockito.junit.MockitoJUnitRunner
//
//@RunWith(MockitoJUnitRunner::class)
//class SystemServiceTest {
//
//    @InjectMocks
//    private lateinit var systemService: SystemService
//
//    @Mock
//    private lateinit var systemRepository: SystemRepository
//
//    @Mock
//    private lateinit var systemPermissionRepository: SystemPermissionRepository
//
//    @Before
//    fun setup() {
//        // Initialize mocks
//        MockitoAnnotations.initMocks(this)
//    }
//
//    @Test
//    fun testGetSystemAll() {
//        // Arrange
//        val systemEntities = listOf(SystemMetaEntity())
//        Mockito.`when`(systemRepository.findAllBy()).thenReturn(systemEntities)
//
//        // Act
//        val result = systemService.getSystemAll()
//
//        // Assert
//        Mockito.verify(systemRepository).findAllBy()
//        assertEquals(systemEntities, result)
//    }
//
//    @Test
//    fun testAddSystem() {
//        // Arrange
//        val systemDto = SystemDto(
//            systemName = "TEST",
//            ownerTargetId = 1,
//            ownerTargetType = TargetType.User
//        )
//        val systemEntity = SystemDto.toEntity(systemDto)
//        Mockito.`when`(SystemDto.toEntity(systemDto)).thenReturn(systemEntity)
//        Mockito.`when`(systemRepository.save(systemEntity)).thenReturn(systemEntity)
//
//        // Act
//        val result = systemService.addSystem(systemDto)
//
//        // Assert
//        Mockito.verify(systemRepository).save(systemEntity)
//        assertEquals(systemEntity, result)
//    }
//
//    @Test
//    fun testAddSystemPermission() {
//        // Arrange
//        val systemId = 1L
//        val systemPermissionDto = SystemPermissionDto(
//
//        )
//        val systemEntity = SystemMetaEntity()
//        Mockito.`when`(systemRepository.findBySystemId(systemId)).thenReturn(systemEntity)
//        Mockito.`when`(SystemPermissionDto.toEntity(systemPermissionDto)).thenReturn(SystemPermissionEntity())
//        Mockito.`when`(systemRepository.save(systemEntity)).thenReturn(systemEntity)
//
//        // Act
//        val result = systemService.addSystemPermission(systemId, systemPermissionDto)
//
//        // Assert
//        Mockito.verify(systemRepository).save(systemEntity)
//        assertEquals(systemEntity, result)
//    }
//}