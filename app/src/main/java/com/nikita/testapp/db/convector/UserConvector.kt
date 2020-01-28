package com.nikita.testapp.db.convector

import com.nikita.testapp.db.dto.UserDto
import com.nikita.testapp.db.model.UserModel.UserModel

object UserConvector {

    fun convert(userDto: UserDto): UserModel {
        return UserModel(
            userDto.toString(),
            userDto.gender,
            userDto.name,
            userDto.email,
            userDto.phone,
            userDto.cell,
            userDto.picture
        )
    }

    fun convert(userDtos: List<UserDto>): List<UserModel> {
        val data = ArrayList<UserModel>()
        for (userDto in userDtos) {
            data.add(convert(userDto))
        }
        return data
    }

}