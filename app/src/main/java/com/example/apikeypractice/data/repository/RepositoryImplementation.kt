package com.example.apikeypractice.data.repository

import com.example.apikeypractice.data.model.searchusers.ItemModel
import com.example.apikeypractice.data.model.searchusers.SearchItemModel
import com.example.apikeypractice.data.model.users.UserModel
import com.example.apikeypractice.data.remote.ApiEndpoint
import retrofit2.Response
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val service: ApiEndpoint
) : Repository {


    override suspend fun getPeopleInfo(): Response<ArrayList<UserModel>> {
        return service.getPeopleInfo()
    }

    override suspend fun setSearch(q: String): Response<SearchItemModel> {
        return service.setSearch(q)
    }

}