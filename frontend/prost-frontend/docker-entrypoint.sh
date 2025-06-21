#!/bin/sh

# Set default values if not provided
export BACKEND_HOST=${BACKEND_HOST:-backend}
export BACKEND_PORT=${BACKEND_PORT:-8080}
export KEYCLOAK_HOST=${KEYCLOAK_HOST:-keycloak}
export KEYCLOAK_PORT=${KEYCLOAK_PORT:-8081}

# Replace environment variables in built Angular files
find /usr/share/nginx/html -name "*.js" -exec sed -i "s|__API_URL__|${API_URL}|g" {} \;
find /usr/share/nginx/html -name "*.js" -exec sed -i "s|__KEYCLOAK_URL__|${KEYCLOAK_URL}|g" {} \;
find /usr/share/nginx/html -name "*.js" -exec sed -i "s|__KEYCLOAK_REALM__|${KEYCLOAK_REALM}|g" {} \;
find /usr/share/nginx/html -name "*.js" -exec sed -i "s|__KEYCLOAK_CLIENT_ID__|${KEYCLOAK_CLIENT_ID}|g" {} \;
find /usr/share/nginx/html -name "*.js" -exec sed -i "s|__VERSION__|${VERSION}|g" {} \;

# Generate nginx.conf from template
envsubst '${BACKEND_HOST} ${BACKEND_PORT} ${KEYCLOAK_HOST} ${KEYCLOAK_PORT}' < /etc/nginx/nginx.conf.template > /etc/nginx/nginx.conf

echo "Generated nginx.conf with:"
echo "  BACKEND_HOST=${BACKEND_HOST}:${BACKEND_PORT}"
echo "  KEYCLOAK_HOST=${KEYCLOAK_HOST}:${KEYCLOAK_PORT}"
echo "Environment variables replaced in Angular build"

# Start nginx
nginx -g "daemon off;"
