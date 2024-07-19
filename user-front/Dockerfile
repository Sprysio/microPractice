FROM node:14-alpine AS build

RUN apk add --update curl && \
    rm -rf /var/cache/apk/*

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .
     
RUN npm run build



FROM nginx:mainline-alpine

COPY --from=build /app/build /usr/share/nginx/html

COPY nginx/nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]