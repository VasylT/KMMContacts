package com.vasylt.composekmm.contacts.data

import com.vasylt.composekmm.contacts.domain.Contact
import com.vasylt.composekmm.core.data.ImageStorage
import database.ContactEntity

suspend fun ContactEntity.toContact(imageStorage: ImageStorage): Contact {
    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phoneNumber,
        photoBytes = imagePath?.let { imageStorage.getImage(it) }
    )
}