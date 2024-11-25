# Stage 1: Build the frontend
FROM node:18-alpine as builder

# Set the working directory
WORKDIR /usr/src/app

# Copy package.json and package-lock.json for dependency installation
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the entire frontend source code
COPY . .

# Build the frontend for production
RUN npm run build

# Stage 2: Serve the frontend
FROM nginx:alpine

# Set the working directory for Nginx
WORKDIR /usr/share/nginx/html

# Copy the built frontend files from the builder stage
COPY --from=builder /usr/src/app/build .

# Expose port 80 for serving the frontend
EXPOSE 80

# Start Nginx
ENTRYPOINT ["nginx", "-g", "daemon off;"]
