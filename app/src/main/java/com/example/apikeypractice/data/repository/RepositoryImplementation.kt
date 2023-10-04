package com.example.apikeypractice.data.repository

import com.example.apikeypractice.data.remote.ApiEndpoint
import retrofit2.Response
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val service: ApiEndpoint
) : Repository {


//    override suspend fun getPeopleInfo(): Response<ArrayList<PeopleInfoItemModel>> {
//        return service.getPeopleInfo()
//    }
//
//
//    override suspend fun getRoomDetails(): Response<ArrayList<RoomDetailsItemModel>> {
//        return service.getRoomDetails()
//    }
}