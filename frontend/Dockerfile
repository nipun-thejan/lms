FROM node:18.14.0-alpine
WORKDIR '/app'
COPY package.json .
RUN npm install -g npm@9.6.1
COPY . .
CMD ["npm", "start"]