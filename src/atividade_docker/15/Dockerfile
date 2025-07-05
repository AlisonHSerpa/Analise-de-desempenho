# Usa imagem oficial do NGINX
FROM nginx:alpine

# Define o diretório padrão onde os arquivos serão servidos
WORKDIR /usr/share/nginx/html

# Remove o index.html padrão do NGINX
RUN rm -f index.html

# Copia seu index.html personalizado para dentro do container
COPY index.html .

# Expõe a porta 80
EXPOSE 80