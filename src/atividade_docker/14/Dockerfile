# Usa imagem base do Ubuntu
FROM ubuntu:22.04

# Desativa prompts interativos e atualiza pacotes
ENV DEBIAN_FRONTEND=noninteractive

# Instala Python e pip
RUN apt-get update && \
    apt-get install -y python3 python3-pip && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Cria diretório de trabalho
WORKDIR /app

# Copia o script process.py para dentro do container
COPY process.py .

# (Opcional) Instala biblioteca necessária, como pandas
RUN pip3 install pandas

# Executa o script
CMD ["python3", "process.py"]