package com.github.goresttest.model.mappers

import com.github.goresttest.model.retrofit.PostItemNetwork
import com.github.goresttest.model.room.PostRoom
import com.github.goresttest.util.EntityMapper
import javax.inject.Inject

class NetworkToRoomMapper @Inject constructor() : EntityMapper<PostItemNetwork, PostRoom> {
    override fun mapFromEntity(entity: PostItemNetwork): PostRoom =
        PostRoom(entity.title, entity.body)

    override fun mapToEntity(domainModel: PostRoom): PostItemNetwork =
        PostItemNetwork("", 0, "", 0)
}