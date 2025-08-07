# Multi-stage build for Angular Frontend
FROM node:20-alpine AS build

# Set working directory
WORKDIR /app

# Copy package files
COPY package*.json ./

# Install dependencies (including devDependencies for Angular CLI)
RUN npm ci

# Copy source code
COPY . .

# Build the application - defaults to prod but can be overridden
ARG BUILD_CONFIGURATION=prod
RUN npm run build:${BUILD_CONFIGURATION}

# Production stage with Nginx
FROM nginx:alpine

# Install envsubst (gettext package for environment variable substitution)
RUN apk add --no-cache gettext

# Copy nginx template
COPY nginx.conf.template /etc/nginx/nginx.conf.template

# Copy built application - Angular 20 puts files in browser/ subdirectory
COPY --from=build /app/dist/prost-frontend/browser/ /usr/share/nginx/html

# Copy and make executable the entrypoint script
COPY docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod +x /docker-entrypoint.sh

# Expose port
EXPOSE 80

# Use custom entrypoint
ENTRYPOINT ["/docker-entrypoint.sh"]
