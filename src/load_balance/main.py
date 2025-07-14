from typing import Union
from fastapi import FastAPI
import socket

# uvicorn main:app --reload
app = FastAPI()


@app.get("/")
def read_root():
    hostname = socket.gethostname()
    return {"container": hostname}