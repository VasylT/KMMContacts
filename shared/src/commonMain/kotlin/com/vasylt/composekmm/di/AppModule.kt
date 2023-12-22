package com.vasylt.composekmm.di

import com.vasylt.composekmm.contacts.domain.ContactDataSource

expect class AppModule {
    val contactDataSource: ContactDataSource
}