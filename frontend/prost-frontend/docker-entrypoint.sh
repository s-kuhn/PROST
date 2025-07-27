#!/bin/sh

# Set default values if not provided
export BACKEND_HOST=${BACKEND_HOST:-backend:8080}
export KEYCLOAK_HOST=${KEYCLOAK_HOST:-keycloak:8081}

# Replace environment variables in built Angular files
find /usr/share/nginx/html -name "*.js" -exec sed -i "s|__API_URL__|${API_URL}|g" {} \;
find /usr/share/nginx/html -name "*.js" -exec sed -i "s|__KEYCLOAK_URL__|${KEYCLOAK_URL}|g" {} \;
find /usr/share/nginx/html -name "*.js" -exec sed -i "s|__KEYCLOAK_REALM__|${KEYCLOAK_REALM}|g" {} \;
find /usr/share/nginx/html -name "*.js" -exec sed -i "s|__KEYCLOAK_CLIENT_ID__|${KEYCLOAK_CLIENT_ID}|g" {} \;

# Generate nginx.conf from template
envsubst '${BACKEND_HOST} ${KEYCLOAK_HOST}' < /etc/nginx/nginx.conf.template > /etc/nginx/nginx.conf

echo "Generated nginx.conf with:"
echo "  BACKEND_HOST=${BACKEND_HOST}"
echo "  KEYCLOAK_HOST=${KEYCLOAK_HOST}"
echo "Environment variables replaced in Angular build"

# Start nginx
nginx -g "daemon off;"
