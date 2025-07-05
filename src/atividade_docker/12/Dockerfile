# Usa imagem oficial do Python
FROM python:3.11-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o app.py para dentro do container
COPY app.py .

# Instala o Flask
RUN pip install --no-cache-dir flask

# Expõe a porta 5000
EXPOSE 5000

# Comando para iniciar o app Flask
CMD ["python", "app.py"]