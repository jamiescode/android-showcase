package uk.co.jamiecruwys.dog.data.datasource.api.response

import uk.co.jamiecruwys.dog.domain.model.DogImage

typealias DogImageResponse = List<String>

internal fun DogImageResponse.toDomainModel(): DogImage {
    // Data source comes back with .mp4 and .webm which isn't supported by Glide.
    // Let's filter the data to only have entries that we can display
    val filteredItems =
        this.filter {
            it.endsWith(".png") || it.endsWith(".jpg") || it.endsWith(".jpeg") || it.endsWith(".gif")
        }
    return DogImage(imageUrl = "https://random.dog/" + filteredItems.random())
}