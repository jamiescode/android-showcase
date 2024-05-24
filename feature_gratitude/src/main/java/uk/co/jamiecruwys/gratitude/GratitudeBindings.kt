package uk.co.jamiecruwys.gratitude

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.jamiecruwys.gratitude.data.GratitudeRepository
import uk.co.jamiecruwys.gratitude.data.GratitudeRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface GratitudeBindings {
    @Binds
    fun gratitudeRepository(impl: GratitudeRepositoryImpl): GratitudeRepository
}
