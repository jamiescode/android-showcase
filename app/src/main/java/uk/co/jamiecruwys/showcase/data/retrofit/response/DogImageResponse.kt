package uk.co.jamiecruwys.showcase.data.retrofit.response

import uk.co.jamiecruwys.showcase.domain.model.DogImageDomainModel

typealias DogImageResponse = List<String>

internal fun DogImageResponse.toDomainModel(): DogImageDomainModel {
    // Data source comes back with .mp4 and .webm which isn't supported by Glide.
    // Let's filter the data to only have entries that we can display
    val filteredItems =
        this.filter {
            it.endsWith(".png") || it.endsWith(".jpg") || it.endsWith(".jpeg") || it.endsWith(".gif")
        }
    return DogImageDomainModel(imageUrl = "https://random.dog/" + filteredItems.random())
}
