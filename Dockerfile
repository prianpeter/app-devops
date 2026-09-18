# Stage 1 : Construction et tests
FROM node:20-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm test

# Stage 2 : Image finale de production (légère et sécurisée)
FROM node:20-alpine
WORKDIR /app
COPY package*.json ./
RUN npm install --only=production
COPY server.js ./

# Bonne pratique de sécurité : ne pas tourner en tant que root
USER node

EXPOSE 3000
CMD ["node", "server.js"]
