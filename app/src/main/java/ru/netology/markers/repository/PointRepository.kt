package ru.netology.markers.repository

import kotlinx.coroutines.flow.Flow
import ru.netology.markers.dto.PointMap

interface PointRepository {
    val data: Flow<List<PointMap>>
    suspend fun edit(pointMap: PointMap)
    suspend fun removeById(id: Int)
    suspend fun save(pointMap: PointMap)
}