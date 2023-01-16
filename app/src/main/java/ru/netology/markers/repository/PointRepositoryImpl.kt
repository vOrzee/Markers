package ru.netology.markers.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import ru.netology.markers.dao.PointDao
import ru.netology.markers.dao.PointMapEntity
import ru.netology.markers.dao.toDto
import ru.netology.markers.dto.PointMap
import javax.inject.Inject

class PointRepositoryImpl @Inject constructor(
    private val dao: PointDao,
) : PointRepository {
    override val data: Flow<List<PointMap>>
        get() = dao.getAll()
            .map(List<PointMapEntity>::toDto)
            .flowOn(Dispatchers.Default)

    override suspend fun edit(pointMap: PointMap) {

    }

    override suspend fun removeById(id: Int) {
        dao.removeById(id)
    }

    override suspend fun save(pointMap: PointMap) {
        dao.insert(PointMapEntity.fromDto(pointMap))
    }
}