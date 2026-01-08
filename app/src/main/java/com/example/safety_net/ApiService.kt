import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

data class SafetyResponse(
    val score: Int,
    val cached: Boolean
)

interface ApiService {
    @GET("safety")
    fun getSafety(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Call<SafetyResponse>
}


