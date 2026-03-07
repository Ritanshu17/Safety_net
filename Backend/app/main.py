from fastapi import FastAPI
import redis
import time
import random
import pandas 


app = FastAPI()

# Connect Redis
cache = redis.Redis(host='localhost', port=6379, decode_responses=True)

@app.get("/safety")
def get_safety(lat: float, lon: float):
    key = f"{lat}:{lon}"

    # Check Redis cache
    if cache.exists(key):
        return {
            "score": cache.get(key),
            "cached": True
        }

    # Fake crime logic (replace with real API later)
    time.sleep(1)
    score = random.randint(1, 5)

    cache.setex(key, 3600, score)

    return {
        "score": score,
        "cached": False
    }

