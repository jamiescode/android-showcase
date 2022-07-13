package uk.co.jamiecruwys.showcase

import androidx.fragment.app.Fragment
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.DI
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.scoped
import org.kodein.di.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.jamiecruwys.showcase.data.repository.DogImageRepositoryImpl
import uk.co.jamiecruwys.showcase.data.retrofit.service.DogImageRetrofitService
import uk.co.jamiecruwys.showcase.domain.repository.DogImageRepository
import uk.co.jamiecruwys.showcase.domain.usecase.GetDogImageUseCase
import uk.co.jamiecruwys.showcase.presentation.MainViewModel

val mainModule = DI.Module("MainModule") {
    bind<MainViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
//        KotlinViewModelProvider.of(context) {
        MainViewModel(instance(), instance())
//        }
    }

    bind<GetDogImageUseCase>() with singleton {
        GetDogImageUseCase(instance())
    }

    bind<DogImageRepository>() with singleton { DogImageRepositoryImpl(instance()) }

    bind() from singleton { instance<Retrofit>().create(DogImageRetrofitService::class.java) }

    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>()
            .baseUrl("https://random.dog/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(instance())
            .build()
    }

    bind<Retrofit.Builder>() with singleton { Retrofit.Builder() }

    bind<OkHttpClient>() with singleton {
        instance<OkHttpClient.Builder>().addInterceptor(instance<HttpLoggingInterceptor>()).build()
    }

    bind<OkHttpClient.Builder>() with singleton {
        OkHttpClient.Builder()
    }

    bind<HttpLoggingInterceptor>() with singleton {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}
