package com


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.safetyText)

        RetrofitClient.api.getSafety(12.97, 77.59)
            .enqueue(object : Callback<SafetyResponse> {
                override fun onResponse(
                    call: Call<SafetyResponse>,
                    response: Response<SafetyResponse>
                ) {
                    val score = response.body()?.score ?: 0
                    text.text = "Safety Score: $score / 5"
                }

                override fun onFailure(call: Call<SafetyResponse>, t: Throwable) {
                    text.text = "Error connecting to server"
                }
            })
    }
}


