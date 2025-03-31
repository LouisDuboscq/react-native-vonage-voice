package com.vonagevoice.di

import org.koin.dsl.module

val vonageModule = module {
  singleOf(::CallControllerImpl) bind CallController::class
  singleOf(::TelecomHelper)
  single { VoiceClient(get(), VGClientInitConfig(loggingLevel = LoggingLevel.Error)) }
}
