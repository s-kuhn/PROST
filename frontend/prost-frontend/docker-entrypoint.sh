#!/bin/sh

# Set default values if not provided
export BACKEND_HOSTNAME=${BACKEND_HOSTNAME:-backend}
export KEYCLOAK_HOSTNAME=${KEYCLOAK_HOSTNAME:-localhost}
export FRONTEND_HOSTNAME=${FRONTEND_HOSTNAME:-localhost:80}

# Generate nginx.conf from template
envsubst '${BACKEND_HOSTNAME} ${KEYCLOAK_HOSTNAME} ${FRONTEND_HOSTNAME}' < /etc/nginx/nginx.conf.template > /etc/nginx/nginx.conf

echo "Generated nginx.conf with:"
echo "  BACKEND_HOSTNAME=${BACKEND_HOSTNAME}"
echo "  KEYCLOAK_HOSTNAME=${KEYCLOAK_HOSTNAME}"
echo "  FRONTEND_HOSTNAME=${FRONTEND_HOSTNAME}"
echo "Environment variables replaced in Angular build"

# Start nginx
nginx -g "daemon off;"
