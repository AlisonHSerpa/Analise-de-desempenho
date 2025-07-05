# Usa imagem oficial do Node.js
FROM node:18-alpine

# Instala o Git (necessário para clonar o repositório)
RUN apk add --no-cache git

# Cria um diretório de trabalho dentro do container
WORKDIR /app

# Clona o repositório diretamente do GitHub
RUN git clone https://github.com/eMahtab/node-express-hello-world.git .

# Instala as dependências
RUN npm install

# Expõe a porta 3000
EXPOSE 3000

# Comando para iniciar o servidor
CMD ["npm", "start"]