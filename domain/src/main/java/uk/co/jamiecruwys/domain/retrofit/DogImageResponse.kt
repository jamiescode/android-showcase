package uk.co.jamiecruwys.domain.retrofit

typealias DogImageResponse = List<String>

internal fun DogImageResponse.toDomainModel(): uk.co.jamiecruwys.domain.model.DogImageDomainModel {
    // Data source comes back with .mp4 and .webm which isn't supported by Glide.
    // Let's filter the data to only have entries that we can display
    val filteredItems =
        this.filter {
            it.endsWith(".png") || it.endsWith(".jpg") || it.endsWith(".jpeg") || it.endsWith(".gif")
        }
    return uk.co.jamiecruwys.domain.model.DogImageDomainModel(imageUrl = "https://random.dog/" + filteredItems.random())
}
