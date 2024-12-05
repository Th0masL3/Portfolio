FROM node:18-alpine as builder
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:alpine
WORKDIR /usr/share/nginx/html
COPY --from=builder /usr/src/app/build .
EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]
