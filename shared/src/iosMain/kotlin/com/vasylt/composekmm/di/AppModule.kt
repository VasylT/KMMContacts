package com.vasylt.composekmm.di

import com.vasylt.composekmm.contacts.data.SqlDelightContactDataSource
import com.vasylt.composekmm.contacts.domain.ContactDataSource
import com.vasylt.composekmm.core.data.DatabaseDriverFactory
import com.vasylt.composekmm.core.data.ImageStorage
import com.vasylt.composekmm.database.ContactDatabase

actual class AppModule {

    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory().create()
            ),
            imageStorage = ImageStorage()
        )
    }
}