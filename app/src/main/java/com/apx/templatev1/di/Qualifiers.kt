package com.apx.templatev1.di

import javax.inject.Qualifier

/* HttpClients*/
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MongooseHttpClient


/**
 * @Related
 * Dispatchers
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainDispatcher